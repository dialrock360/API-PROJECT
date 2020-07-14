/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.audit.UserDateAudit;
import com.yemmback.store.model.colections.Gender;
import lombok.Builder;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dialrock 360
 */

@Entity
@Table(name = "client", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "tel"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Client extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "clientname")
    private String clientname;
    @Builder.Default
    private Gender nature = Gender.homme;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tel")
    private String tel;
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "adress")
    private String adress;
    private String detail;

    @Column(name = "flag")
    private int flag;



    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<Operation> operations = new ArrayList<>();



    public Client() {
    }

    public Client(Long id, @NotNull @Size(min = 1, max = 255) String clientname, Gender nature, @NotNull @Size(min = 1, max = 50) String tel, @Size(max = 255) String email, @Size(max = 255) String adress, String detail, int flag, List<Operation> operations) {
        this.id = id;
        this.clientname = clientname;
        this.nature = nature;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
        this.detail = detail;
        this.flag = flag;
        this.operations = operations;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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
