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
import java.util.Date;

/**
 *
 * @author d
 */
@Entity
@Table(name = "bankstate")
public class BankState extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "spent")
    private Double spent;
    @NotNull
    @Column(name = "gain")
    private Double gain;
    @NotNull
    @Column(name = "virtualBank")
    private Double virtualBank;
    @NotNull
    @Column(name = "realBank")
    private Double realBank;
    @NotBlank
    @Column(name = "dateState")
    private Date dateState;


    public BankState() {
    }

    public BankState(Long id, @NotNull Double spent, @NotNull Double gain, @NotNull Double virtualBank, @NotNull Double realBank, @NotBlank Date dateState) {
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
