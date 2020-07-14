package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.audit.UserDateAudit;
import com.yemmback.store.model.colections.JuridicForm;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dialrock361 on 01/08/20.
 */
@Entity
@Table(name = "enterprise")
public class Enterprise extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 40)
    @Column(name = "enterprisename")
    private String enterprisename;
    @Builder.Default
    private JuridicForm juridicForm = JuridicForm.SARL;
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "phones")
    private String phones;
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "adress")
    private String adress;
    @Column(name = "rc")
    private String rc;
    @Column(name = "ninea")
    private String ninea;
    @NotNull
    @Column(name = "capital")
    private Double capital;

    public Enterprise() {
    }

    public Enterprise(Long id, @NotBlank @Size(max = 40) String name, JuridicForm juridicForm, @NotNull @Size(min = 1, max = 100) String phones, @Size(max = 255) String email, @Size(max = 255) String adress, String rc, String ninea, @NotNull Double capital) {
        this.id = id;
        this.enterprisename = name;
        this.juridicForm = juridicForm;
        this.phones = phones;
        this.email = email;
        this.adress = adress;
        this.rc = rc;
        this.ninea = ninea;
        this.capital = capital;
    }

    public Enterprise(@NotBlank @Size(max = 40) String enterprisename, JuridicForm juridicForm, @NotNull @Size(min = 1, max = 100) String phones, @Size(max = 255) String email, @Size(max = 255) String adress, String rc, String ninea, @NotNull Double capital) {
        this.enterprisename = enterprisename;
        this.juridicForm = juridicForm;
        this.phones = phones;
        this.email = email;
        this.adress = adress;
        this.rc = rc;
        this.ninea = ninea;
        this.capital = capital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return enterprisename;
    }

    public void setName(String name) {
        this.enterprisename = name;
    }

    public JuridicForm getJuridicForm() {
        return juridicForm;
    }

    public void setJuridicForm(JuridicForm juridicForm) {
        this.juridicForm = juridicForm;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
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

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }
}
