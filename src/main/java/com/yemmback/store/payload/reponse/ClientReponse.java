/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.audit.UserDateAudit;
import com.yemmback.store.model.colections.Gender;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author dialrock 360
 */


public class ClientReponse  {

    private Long id;
    private String clientname;
    private Gender nature = Gender.homme;
    private String tel;
    private String email;
    private String adress;
    private String detail;
    private List<Hashtable> operations = new ArrayList<Hashtable>();



    public ClientReponse() {
    }

    public ClientReponse(Long id, String clientname, Gender nature,  String tel, String email,   String adress, String detail,  List<Operation> operations) {
        this.id = id;
        this.clientname = clientname;
        this.nature = nature;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
        this.detail = detail;
        this.operations = this.formatOperations(operations);
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return clientname;
    }

    public void setFullName(String clientname) {
        this.clientname = clientname;
    }

    public Gender getNature() {
        return nature;
    }

    public void setNature(Gender nature) {
        this.nature = nature;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Hashtable> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = this.formatOperations(operations);
    }

    private  List<Hashtable> formatOperations(List<Operation> operations){
        List<Hashtable> ioperations = new ArrayList<Hashtable>();
        int i=1;
        for (Operation p : operations) {
            Hashtable cl = new Hashtable();
            cl.put("id", p.getId());
            cl.put("operationtype", p.getId());
            cl.put("date", p.getCreatedAt());
            ioperations.add(cl);
        }
        return ioperations;
    }
}
