/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.request;

import java.util.Date;

/**
 *
 * @author d
 */

public class BankStateRequest  {

    private Long id;
    private Double spent;
    private Double gain;
    private Double virtualBank;
    private Double realBank;
    private Date dateState;


    public BankStateRequest() {
    }


    public BankStateRequest(Long id, Double spent, Double gain, Double virtualBank, Double realBank, Date dateState) {
        this.id = id;
        this.spent = spent;
        this.gain = gain;
        this.virtualBank = virtualBank;
        this.realBank = realBank;
        this.dateState = dateState;
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

    public Double getVirtualBank() {
        return virtualBank;
    }

    public void setVirtualBank(Double virtualBank) {
        this.virtualBank = virtualBank;
    }

    public Double getRealBank() {
        return realBank;
    }

    public void setRealBank(Double realBank) {
        this.realBank = realBank;
    }

    public Date getDateState() {
        return dateState;
    }

    public void setDateState(Date dateState) {
        this.dateState = dateState;
    }
}
