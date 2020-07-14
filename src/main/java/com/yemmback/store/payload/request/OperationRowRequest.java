/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.request;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.Product;


/**
 * Created by dialrock361 on 01/08/20.
 */
public class OperationRowRequest   {
    private Long id;
    private Double price;
    private Double quantity;
    private Double mount;
    private Long productid;
    private Long operationid;


    public OperationRowRequest() {
    }

    public OperationRowRequest(Long id, Double price, Double quantity, Double mount, Long productid, Long operationid) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.mount = mount;
        this.productid = productid;
        this.operationid = operationid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getMount() {
        return mount;
    }

    public void setMount(Double mount) {
        this.mount = mount;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getOperationid() {
        return operationid;
    }

    public void setOperationid(Long operationid) {
        this.operationid = operationid;
    }
}
