/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.request;

import com.yemmback.store.model.Product;
import com.yemmback.store.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class StocktakingRequest extends DateAudit {


    private Long id;

    private Date dateStk;

    private String stockState;


    private int flag;

    public StocktakingRequest() {
    }

    public StocktakingRequest(Long id, Date dateStk, String stockState, int flag) {
        this.id = id;
        this.dateStk = dateStk;
        this.stockState = stockState;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlagstockstate() {
        return flag;
    }

    public void setFlagstockstate(int flag) {
        this.flag = flag;
    }

    public Date getDateStk() {
        return dateStk;
    }

    public void setDateStk(Date dateStk) {
        this.dateStk = dateStk;
    }

    public String getStockState() {
        return stockState;
    }

    public void setStockState(List<Product> products) {
        this.stockState = this.ProductsToString(products);
    }
    public void setState(String products) {
        this.stockState = products;
    }

    private String ProductsToString(List<Product> products){
        String stockstate = " ";
        for (Product p : products) {
            stockstate = stockstate+"{"+"id:"+"\""+p.getId()+"\""+","+"productname:"+"\""+p.getProductname()+"\""+","+"qnt:"+"\""+p.getQnt()+"\""+"}";
        }
        return stockState;
    }

}
