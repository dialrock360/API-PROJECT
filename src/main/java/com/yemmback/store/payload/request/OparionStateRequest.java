/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.request;

import com.yemmback.store.model.Category;
import com.yemmback.store.model.Operation;

import java.util.Date;

/**
 *
 * @author d
 */
public class OparionStateRequest   {
    private Long id;

    private Double spent;
    private Double gain;
    private Double checkout;
    private Date dateState;
    private Long  categoryid;
    private Long operationid;

    public OparionStateRequest() {
    }

    public OparionStateRequest(Long id, Double spent, Double gain, Double checkout, Date dateState, Long  categoryid, Long operationid) {
        this.id = id;
        this.spent = spent;
        this.gain = gain;
        this.checkout = checkout;
        this.dateState = dateState;
        this. categoryid =  categoryid;
        this.operationid = operationid;
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

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getOperationid() {
        return operationid;
    }

    public void setOperationid(Long operationid) {
        this.operationid = operationid;
    }
}
