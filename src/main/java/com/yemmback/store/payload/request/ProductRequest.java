package com.yemmback.store.payload.request;

import com.yemmback.store.model.Category;
import com.yemmback.store.model.Conditioning;
import com.yemmback.store.model.OperationRow;
import com.yemmback.store.model.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRequest {


    private Long id;
    private Long categoryId;
    private Long conditioningId;
    private String productname;
    private Double purchasePrice;
    private Double salePrice;
    private Double minSalePrice;
    private Double qnt;
    private Category category;
    private int flagproduct;
    private Conditioning conditioning;

    public ProductRequest() {
    }

    public ProductRequest(Long id, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, Category category, Conditioning conditioning) {
        this.id = id;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.category = category;
        this.conditioning = conditioning;
    }

    public ProductRequest(Long id, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, Category category, int flagproduct) {
        this.id = id;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.category = category;
        this.flagproduct = flagproduct;
    }

    public ProductRequest(Long id, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, Category category, int flagproduct, Conditioning conditioning) {
        this.id = id;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.category = category;
        this.flagproduct = flagproduct;
        this.conditioning = conditioning;
    }

    public ProductRequest(Long id, Long categoryId, Long conditioningId, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, Category category, int flagproduct, Conditioning conditioning) {
        this.id = id;
        this.categoryId = categoryId;
        this.conditioningId = conditioningId;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.category = category;
        this.flagproduct = flagproduct;
        this.conditioning = conditioning;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getFlag() {
        return flagproduct;
    }

    public void setFlag(int flagproduct) {
        this.flagproduct = flagproduct;
    }

    public Conditioning getConditionings() {
        return conditioning;
    }

    public void setConditionings(Conditioning conditioning) {
        this.conditioning = conditioning;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getConditioningId() {
        return conditioningId;
    }

    public void setConditioningId(Long conditioningId) {
        this.conditioningId = conditioningId;
    }

    public Conditioning getConditioning() {
        return conditioning;
    }

    public void setConditioning(Conditioning conditioning) {
        this.conditioning = conditioning;
    }
}
