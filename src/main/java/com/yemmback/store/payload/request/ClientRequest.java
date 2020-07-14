/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.request;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.colections.Gender;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dialrock 360
 */

public class ClientRequest extends DateAudit {

    private Long id;
    private String clientname;
    private Gender nature = Gender.homme;
    private String tel;
    private String email;
    private String adress;
    private String detail;
    private int flagclient;
    private List<Operation> operations = new ArrayList<>();



    public ClientRequest() {
    }

    public ClientRequest(Long id, @NotNull @Size(min = 1, max = 255) String clientname, Gender nature, @NotNull @Size(min = 1, max = 50) String tel, @Size(max = 255) String email, @Size(max = 255) String adress, String detail, int flagclient, List<Operation> operations) {
        this.id = id;
        this.clientname = clientname;
        this.nature = nature;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
        this.detail = detail;
        this.flagclient = flagclient;
        this.operations = operations;
    }



    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public int getFlag() {
        return flagclient;
    }

    public void setFlag(int flagclient) {
        this.flagclient = flagclient;
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

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }


}
