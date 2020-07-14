/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.Category;

import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author d
 */
public class OparionStateReponse {

    private Long id;
    private Double spent;
    private Double gain;
    private Double checkout;
    private Date dateState;
     private Hashtable category ;

    public OparionStateReponse() {
    }

    public OparionStateReponse(Long id, Double spent, Double gain, Double checkout, Date dateState, Category category) {
        this.id = id;
        this.spent = spent;
        this.gain = gain;
        this.checkout = checkout;
        this.dateState = dateState;
        this.category = this.formatCategory(category);;
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
