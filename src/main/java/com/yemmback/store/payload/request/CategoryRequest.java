package com.yemmback.store.payload.request;

import com.yemmback.store.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryRequest {
    private Long id;
    private String categoryname;
    private int flagcategory;
    private List<Product> products = new ArrayList<>();

    public CategoryRequest() {
    }

    public CategoryRequest(Long id, String categoryname, int flagcategory, List<Product> products) {
        this.id = id;
        this.categoryname = categoryname;
        this.flagcategory = flagcategory;
        this.products = products;
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

    public int getFlag() {
        return flagcategory;
    }

    public void setFlag(int flagcategory) {
        this.flagcategory = flagcategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
