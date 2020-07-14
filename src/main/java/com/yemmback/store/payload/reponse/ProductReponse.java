package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.Category;
import com.yemmback.store.model.Product;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ProductReponse {


    private Long id;
    private String productname;
    private Double purchasePrice;
    private Double salePrice;
    private Double minSalePrice;
    private Double qnt;
    private String conditioningname;
    private Hashtable category ;
    private String productref;

    public ProductReponse() {
    }

    public ProductReponse(Long id, String productref, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, String conditioningname, Category category) {
        this.id = id;
        this.productref = productref;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.conditioningname = conditioningname;
        this.category = this.formatCategory(category);
    }

    public ProductReponse(Long id, String productname, Double qnt, String conditioningname) {
        this.id = id;
        this.productname = productname;
        this.qnt = qnt;
        this.conditioningname = conditioningname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getMinSalePrice() {
        return minSalePrice;
    }

    public void setMinSalePrice(Double minSalePrice) {
        this.minSalePrice = minSalePrice;
    }

    public Double getQnt() {
        return qnt;
    }

    public void setQnt(Double qnt) {
        this.qnt = qnt;
    }

    public String getConditioningname() {
        return conditioningname;
    }

    public void setConditioningname(String conditioningname) {
        this.conditioningname = conditioningname;
    }

    public String getProductref() {
        return productref;
    }

    public void setProductref(String productref) {
        this.productref = productref;
    }

    public Hashtable getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = this.formatCategory(category);
    }

    private Hashtable formatCategory(Category p){
         Hashtable cl = new Hashtable();
        cl.put("id", p.getId());
        cl.put("categoryname", p.getCategoryname());
        return cl;
    }
}
