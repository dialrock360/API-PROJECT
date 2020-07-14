/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author d
 */
@Entity
@Table(name = "stocktaking", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "dateStk"
        })
})
public class Stocktaking extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Date dateStk;
    @NotBlank
    private String stockState;

    @Column(name = "flag")
    private int flag;

    public Stocktaking() {
    }

    public Stocktaking(Long id, @NotNull Date dateStk, List<Product> products) {
        this.id = id;
        this.dateStk = dateStk;
        this.stockState =  this.ProductsToString(products);
        this.flag = 0;
    }

    public Stocktaking(@NotNull Date dateStk,List<Product> products,int flag) {
        this.dateStk = dateStk;
        this.stockState = this.ProductsToString(products);
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
    public void setState(String products) {
        this.stockState = products;
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

    private String ProductsToString(List<Product> products){
        String stockstate = " ";
        for (Product p : products) {
            stockstate = stockstate+"{"+"id:"+"\""+p.getId()+"\""+","+"productname:"+"\""+p.getProductname()+"\""+","+"qnt:"+"\""+p.getQnt()+"\""+"}";
        }
        return stockState;
    }

}
