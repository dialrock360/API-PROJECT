package com.yemmback.store.controller;

import com.yemmback.store.model.*;
import com.yemmback.store.payload.reponse.*;
import com.yemmback.store.payload.request.*;
import com.yemmback.store.repository.*;
import com.yemmback.store.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class CatalogueController {


    @Autowired    private CategoryRepository categoryRepository;

    @Autowired private ProductRepository productRepository;

    @Autowired private CatalogueService catalogueService;

    @Autowired private ConditioningRepository conditioningRepository;


    private static final Logger logger = LoggerFactory.getLogger(CatalogueController.class);
    private static final ApiResponse apir = new ApiResponse();
    private static final ObjectRequest objectRequest=new ObjectRequest();

    // Get All resources
    @GetMapping("/categorys") List<CategoryReponse> findAllcategorys() { return catalogueService.getAllCategorys(); }
    @GetMapping("/products") List<ProductReponse> findAllproducts() { return catalogueService.getAllProducts(); }
    @GetMapping("/conditionings") List<ConditioningReponse> findAllconditionings() { return catalogueService.getAllConditionings(); }


    // Find by Id
    @GetMapping("/category/{id}") CategoryReponse getOnecategory(@PathVariable @Min(1) Long id) { return (id>0)?catalogueService.getCategory(id):null; }
    @GetMapping("/product/{id}") ProductReponse getOneproduct(@PathVariable @Min(1) Long id) { return catalogueService.getProduct(id); }
    @GetMapping("/conditioning/{id}") ConditioningReponse getOneconditioning(@PathVariable @Min(1) Long id) { return catalogueService.getConditioning(id); }


    // Find by Id name
    @GetMapping("/findcategory/{categoryname}") CategoryReponse findOnecategory(@PathVariable String categoryname) { return catalogueService.findCategory(categoryname); }
    @GetMapping("/findproduct/{productname}") ProductReponse findOneproduct(@PathVariable String productname) { return catalogueService.findProduct(productname); }
    @GetMapping("/findconditioning/{conditioningname}") ConditioningReponse findOneconditioning(@PathVariable String conditioningname) { return catalogueService.findConditioning(conditioningname); }




    // Save or update
    @PutMapping("/category") ResponseEntity<?> saveOrUpdatecategory(@RequestBody CategoryRequest newCategory) { return catalogueService.saveCategory(newCategory);}
    @PutMapping("/product") ResponseEntity<?> saveOrUpdateproduct(@RequestBody ProductRequest newProduct) { return catalogueService.saveProduct(newProduct);}
    @PutMapping("/conditioning") ResponseEntity<?> saveOrUpdatedelconditioning(@RequestBody ConditioningRequest newConditioning) { return catalogueService.saveConditioning(newConditioning);}

    //@PutMapping("/conditioning") ResponseEntity<?> saveOrUpdate(@RequestBody ConditioningRequest newConditioning) {this.objectRequest.setConditioningRequest(newConditioning);  return catalogueService.saveOrUpdate(this.objectRequest,"conditioning");}




    // Delete resoureces
    @GetMapping("/delcategory/{id}")
    ResponseEntity<?> delcategory(@PathVariable @Min(1) Long id) {
        Category category=categoryRepository.getOne(id);category.setFlag(1);
        return ResponseEntity.created(apir.location(categoryRepository.save(category).getCategoryname(),"/delcategory/{id}")).body(new ApiResponse(true, "Category "+String.valueOf(id)+" successfully deleted "));

    }
    @GetMapping("/delproduct/{id}")
    ResponseEntity<?> delproduct(@PathVariable @Min(1) Long id) {

        Product product=productRepository.getOne(id);product.setFlag(1);
        return ResponseEntity.created(apir.location(productRepository.save(product).getProductname(),"/delproduct/{id}")).body(new ApiResponse(true, "Product "+String.valueOf(id)+" successfully deleted "));

    }
    @GetMapping("/delconditioning/{id}")
    ResponseEntity<?> delconditioning(@PathVariable @Min(1) Long id) {
        Conditioning conditioning=conditioningRepository.getOne(id);conditioning.setFlag(1);
        return ResponseEntity.created(apir.location(conditioningRepository.save(conditioning).getConditioningname(),"/delconditioning/{id}")).body(new ApiResponse(true, "Conditioning "+String.valueOf(id)+" successfully deleted "));
    }


    @PutMapping("/testobject") Object saveOrUpdateproducttest(@RequestBody Object newObject) { return this.apir.saveTest(newObject);}
    @PutMapping("/producttest") Product saveproducttest(@RequestBody ProductRequest newObject) { return catalogueService.saveTest(newObject);}


    /*
    ResponseEntity<?> saveOrUpdatep(@RequestBody ProductRequest newProduct) {

        Product product= new Product();

        if(newProduct.getId()==null){
            if(productRepository.existsByProductname(newProduct.getProductname())) {
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
                    newProduct.getCategory(), null);
        }else {
            product=productRepository.getOne(newProduct.getId());
            if(product.getId()>0){
                product.setProductname(newProduct.getProductname());
                product.setPurchasePrice(newProduct.getPurchasePrice());
                product.setSalePrice(newProduct.getSalePrice());
                product.setMinSalePrice(newProduct.getMinSalePrice());
                product.setQnt(newProduct.getQnt());
            }
        }

        return ResponseEntity.created(apir.location(productRepository.save(product).getProductname(),"/product")).body(new ApiResponse(true, "Product saved successfully "+String.valueOf(product.getId())));

    }
*/

}








