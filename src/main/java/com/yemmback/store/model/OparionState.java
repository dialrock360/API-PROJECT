/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author d
 */
@Entity
@Table(name = "oparionstate")
public class OparionState extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @NotNull
    @Column(name = "spent")
    private Double spent;
    @NotNull
    @Column(name = "gain")
    private Double gain;
    @Column(name = "checkout")
    private Double checkout;
    @Column(name = "dateState") 
    private Date dateState;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    public OparionState(Long id, @NotNull Double spent, @NotNull Double gain, Double checkout, Date dateState, Category category, Operation operation) {
        this.id = id;
        this.spent = spent;
        this.gain = gain;
        this.checkout = checkout;
        this.dateState = dateState;
        this.category = category;
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSpent() {
        return spent;
    }

    public void setSpent(Double spent) {
        this.spent = spent;
    }

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Double getCheckout() {
        return checkout;
    }

    public void setCheckout(Double checkout) {
        this.checkout = checkout;
    }

    public Date getDateState() {
        return dateState;
    }

    public void setDateState(Date dateState) {
        this.dateState = dateState;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
