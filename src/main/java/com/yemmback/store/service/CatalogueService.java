package com.yemmback.store.service;

import com.yemmback.store.exception.BadRequestException;
import com.yemmback.store.exception.ResourceNotFoundException;
import com.yemmback.store.model.*;
import com.yemmback.store.payload.reponse.*;
import com.yemmback.store.payload.request.*;
import com.yemmback.store.payload.request.ProductRequest;
import com.yemmback.store.repository.CategoryRepository;
import com.yemmback.store.repository.ConditioningRepository;
import com.yemmback.store.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogueService {
    private Product product;
    private ProductRequest cr;
    private Conditioning conditioning;
    private Category category;
    private ResponseEntity responseEntity;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConditioningRepository conditioningRepository;


    private static final Logger logger = LoggerFactory.getLogger(CatalogueService.class);


    private static final ApiResponse apir = new ApiResponse();

    // Get Category resources
    public  List<CategoryReponse>  getAllCategorys() {

        // Retrieve Categorys
        List<Category> categorys = categoryRepository.findCategorys(0) ;
        List<CategoryReponse> ls = new ArrayList<CategoryReponse>();
        for (Category c : categorys) {
            ls.add(this.bindCategoryReponse(c));
        }


        return ls;
    }
    public CategoryReponse getCategory(Long id) {
        return this.bindCategoryReponse(categoryRepository.getOne(id));
    }
    public  CategoryReponse  findCategory(String categoryname) {
        return this.bindCategoryReponse(categoryRepository.findByname(categoryname));
    }


    // Get Product resources
    public  List<ProductReponse>  getAllProducts() {

        // Retrieve Products
        List<Product> products = productRepository.findProducts(0) ;
        List<ProductReponse> ls = new ArrayList<ProductReponse>();
        for (Product c : products) {  ls.add(this.bindProductReponse(c)); }


        return ls;
    }
    public  ProductReponse  getProduct(Long id) {         return this.bindProductReponse(productRepository.getOne(id)); }
    public  ProductReponse  findProduct(String id) {         return this.bindProductReponse(productRepository.findProducts(id)); }

    // Get Conditioning resources
    public List<ConditioningReponse> getAllConditionings() {


        List<Conditioning> Conditionings = conditioningRepository.findconditionings(0) ;
        List<ConditioningReponse> ls = new ArrayList<ConditioningReponse>();
        for (Conditioning c : Conditionings) {  ls.add(this.bindConditioningReponse(c)); }


        return ls;
    }
    public  ConditioningReponse  getConditioning(Long id) {         return this.bindConditioningReponse(conditioningRepository.getOne(id)); }
    public  ConditioningReponse  findConditioning(String id) {         return this.bindConditioningReponse(conditioningRepository.findconditioningname(id)); }


    // Make Persistance data resources
    public ResponseEntity<?> saveProduct(ProductRequest newProduct) {


       if(!categoryRepository.existsCategoriesById(newProduct.getCategoryId())) {
           return new ResponseEntity(new ApiResponse(false, "Categorie is not check!"),
                   HttpStatus.BAD_REQUEST);
       }

       if(!conditioningRepository.existsConditioningById(newProduct.getConditioningId())) {
           return new ResponseEntity(new ApiResponse(false, "Conditioning is not check!"),
                   HttpStatus.BAD_REQUEST);
       }

       Long productId = newProduct.getId();

       this.category = categoryRepository.getOne(newProduct.getCategoryId()) ;
       
       this.conditioning = conditioningRepository.getOne(newProduct.getConditioningId()) ;
     //  Category cat=new Category(this.category.getId(), this.category.getCategoryname(),this.category.getFlag(), null) ;
      // Conditioning cnd= new Conditioning(this.conditioning.getId(),this.conditioning.getConditioningname(),this.conditioning.getFlag(), null);


        if(newProduct.getId()==null){
            if(productRepository.existsByProductname(newProduct.getProductname().toLowerCase())) {
                return new ResponseEntity(new ApiResponse(false, "Productname is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }

            product = new Product(null,
                    newProduct.getProductname(),
                    newProduct.getPurchasePrice(),
                    newProduct.getSalePrice(),
                    newProduct.getMinSalePrice(),
                    newProduct.getQnt(),
                    0,
                    null,
                    this.category  , this.conditioning );
        }
        else {

            this.product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
            if(product.getId()>0){
                this.product.setProductname(newProduct.getProductname().toLowerCase());
                this.product.setPurchasePrice(newProduct.getPurchasePrice());
                this.product.setSalePrice(newProduct.getSalePrice());
                this.product.setMinSalePrice(newProduct.getMinSalePrice());
                this.product.setQnt(newProduct.getQnt());
                this.product.setConditioning(this.conditioning);
                this.product.setCategory(this.category);
            }
        }

       try {
           this.product = productRepository.save(this.product);
       } catch (DataIntegrityViolationException ex) {
           logger.info("Sorry {} has not save in Product {}", newProduct.getProductname(), this.product.getProductname());
           throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
       }



        return ResponseEntity.created(apir.location(this.product.getProductname(),"/product")).body(new ApiResponse(true, "Product saved successfully "+String.valueOf(product.getId())));

    }
    public  ResponseEntity<?>    saveConditioning(ConditioningRequest newConditioning) {
        // Retrieve Categorys

        if(newConditioning.getId()==null){
            if(conditioningRepository.existsConditioningByConditioningname(newConditioning.getConditioningname().toLowerCase())) {
                return new ResponseEntity(new ApiResponse(false, "Conditioning name is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }


            this.conditioning = new Conditioning(newConditioning.getConditioningname().toLowerCase(),0, null) ;
        }else {
            this.conditioning=conditioningRepository.getOne(newConditioning.getId());
            if(this.conditioning.getId()>0){
                this.conditioning.setConditioningname(newConditioning.getConditioningname().toLowerCase());
                this.conditioning.setFlag(newConditioning.getFlag());
            }
        }

        try {
            this.conditioning = conditioningRepository.save(this.conditioning);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Conditioning {}", newConditioning.getConditioningname(), this.conditioning.getConditioningname());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location(this.conditioning.getConditioningname(),"/conditioning")).body(new ApiResponse(true, "Conditioning saved successfully "+String.valueOf(conditioning.getId())));

    }
    public  ResponseEntity<?>    saveCategory(CategoryRequest newCategory) {

        if(newCategory.getId()==null){
            if(categoryRepository.existsByCategoryname(newCategory.getCategoryname().toLowerCase())) {
                return new ResponseEntity(new ApiResponse(false, "Categoryname is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }

            this.category = new Category(null, newCategory.getCategoryname(),0, null) ;
        }else {
            this.category=categoryRepository.getOne(newCategory.getId());
            if(this.category.getId()>0){
                this.category.setCategoryname(newCategory.getCategoryname().toLowerCase());
                this.category.setFlag(newCategory.getFlag());
            }
        }

        try {
            this.category = categoryRepository.save(this.category);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Category {}", newCategory.getCategoryname(), this.category.getCategoryname());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location(this.category.getCategoryname(),"/category")).body(new ApiResponse(true, "Category saved successfully "+String.valueOf(category.getId())));

    }


    public  ResponseEntity<?>    saveOrUpdate(ObjectRequest objectRequest,String target) {

        // init vars
        Long id=null;
        String name=null;
        String objTostr=null;

        try {

            switch(target) {
                case "conditioning":
                    // code block
                    ConditioningRequest  newConditioning=objectRequest.getConditioningRequest();
                      id=newConditioning.getId(); name= newConditioning.getConditioningname();objTostr= newConditioning.toString();
                    if(conditioningRepository.existsConditioningByConditioningname(newConditioning.getConditioningname().toLowerCase())) {
                        return new ResponseEntity(new ApiResponse(false, "Conditioning name is already taken!"),
                                HttpStatus.BAD_REQUEST);
                    }
                    this.setConditioningWithRequest(newConditioning);
                    this.conditioning = conditioningRepository.save(this.conditioning);

                    break;
                case "category":
                    // code block
                    break;
                case "pruduct":
                    // code block
                    break;
                default:
                    // code block
            }

        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in "+target+" {}", id, objTostr);
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location(name,"/"+target+"")).body(new ApiResponse(true, target.toUpperCase()+" saved successfully "+String.valueOf(id)));

    }

    // Set Mapping data resources
    public void setConditioningWithRequest(ConditioningRequest newConditioning){
          this.conditioning =((newConditioning.getId()==null) && conditioningRepository.existsConditioningByConditioningname(newConditioning.getConditioningname().toLowerCase()))?null: new Conditioning(((newConditioning.getId()==null)?null:newConditioning.getId()),newConditioning.getConditioningname().toLowerCase(),0, null) ;
     }








    // Get Mapping data resources
    public CategoryReponse bindCategoryReponse(Category c){
        List<Product> products = productRepository.findProductsByCategory(c.getId()) ;
       // List<ProductReponse> lspr = new ArrayList<ProductReponse>();
       //  for (Product p : products) {lspr.add(new ProductReponse(p.getId(), p.getProductname(), p.getPurchasePrice(), p.getSalePrice(), p.getMinSalePrice(), p.getQnt(), p.getConditioning().getConditioningname(), p.getCategory().getCategoryname(),p.getCategory().getId())); }
        // for (Product p : products) {lspr.add(new ProductReponse(p.getId(), p.getProductname(),p.getQnt(), p.getConditioning().getConditioningname())); }
        return new   CategoryReponse(c.getId(), c.getCategoryname(), products);
    }
    public ProductReponse bindProductReponse(Product p){
        return  new ProductReponse(p.getId(),p.getProductref(), p.getProductname(), p.getPurchasePrice(), p.getSalePrice(), p.getMinSalePrice(), p.getQnt(), p.getConditioning().getConditioningname(), p.getCategory());

    }
    public ConditioningReponse bindConditioningReponse(Conditioning c){
        return new ConditioningReponse(c.getId(), c.getConditioningname(), productRepository.findProductsByConditioningId(c.getId()));

    }


    // Rapide Mapping Product test
    public Product saveTest(ProductRequest newProduct) {

        this.category = categoryRepository.getOne((long) 1) ;

        this.conditioning = conditioningRepository.getOne((long) 1) ;
/*
        this.product = new Product(null,
                newProduct.getProductname(),
                newProduct.getPurchasePrice(),
                newProduct.getSalePrice(),
                newProduct.getMinSalePrice(),
                newProduct.getQnt(),
                0,
                null,
                this.category , this.conditioning);*/
        this.product = new Product(null,
                newProduct.getProductname(),
                newProduct.getPurchasePrice(),
                newProduct.getSalePrice(),
                newProduct.getMinSalePrice(),
                newProduct.getQnt(),
                0,
                null,
                new Category(this.category.getId(), this.category.getCategoryname(),0, null) ,
                new Conditioning(this.conditioning.getId(),this.conditioning.getConditioningname(),0, null));
         return this.product;
    }
}
