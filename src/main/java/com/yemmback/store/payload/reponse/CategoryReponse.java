package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.Product;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class CategoryReponse {
    private Long id;
    private String categoryname;
    private int nbrproducts;
    private List<Hashtable> products = new ArrayList<>();

    public CategoryReponse() {
    }

    public CategoryReponse(Long id, String categoryname, List<Product> products) {
        this.id = id;
        this.categoryname = categoryname;
        this.nbrproducts = products.size();
        this.products = this.formatProducts(products);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }


    public List<Hashtable> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = this.formatProducts(products);
    }

    public int getNbrproducts() {
        return nbrproducts=products.size();
    }

    public void setNbrproducts(int nbrproducts) {
        this.nbrproducts = nbrproducts;
    }

    private  List<Hashtable> formatProducts(List<Product> products){
        List<Hashtable> ioperations = new ArrayList<Hashtable>();
        int i=1;
        for (Product p : products) {
            Hashtable cl = new Hashtable();
            cl.put("id", p.getId());
            cl.put("productname", p.getProductname());
            cl.put("conditioning", p.getConditioning().getConditioningname());
            cl.put("qnt", p.getQnt());
            ioperations.add(cl);
        }
        return ioperations;
    }
}
