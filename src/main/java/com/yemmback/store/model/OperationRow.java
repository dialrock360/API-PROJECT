/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.model;

import com.yemmback.store.model.audit.UserDateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by dialrock361 on 01/08/20.
 */
@Entity
@Table(name = "operationrow")
public class OperationRow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "price")
    private Double price;
    @NotNull
    @Column(name = "quantity")
    private Double quantity;
    @NotNull
    @Column(name = "mount")
    private Double mount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private  Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

   // @JoinColumn(name="operation_id", referencedColumnName = "id", insertable = false, updatable = false)



    public OperationRow(Long id, @NotNull Double price, @NotNull Double quantity, @NotNull Double mount, Operation operation, Product product) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.mount = mount;
        this.operation = operation;
        this.product = product;
    }

    public OperationRow() {
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
