/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.request;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.colections.Gender;
import com.yemmback.store.model.colections.PieceName;
import com.yemmback.store.model.colections.Post;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dialrock 360
 */


public class EmployeeRequest   {

    private Long id;

    private String matricul;
    private String firstname;
    private String lastname;
    private Gender gender = Gender.homme;
    private Date brday;
    private String tel;
    private String email;
    private String adress;
    private PieceName piece = PieceName.nil;
    private String numpiece;
    private int flag;
    @Builder.Default
    private Post post = Post.commercial;


    public EmployeeRequest() {
    }

    public EmployeeRequest(Long id) {
        this.id = id;
    }

    public EmployeeRequest(Long id, String matricul, String firstname, String lastname, Gender gender, Date brday, String tel, String email, String adress, PieceName piece, String numpiece, int flag, Post post) {
        this.id = id;
        this.matricul = matricul;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.brday = brday;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
        this.piece = piece;
        this.numpiece = numpiece;
        this.flag = flag;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricul() {
        return matricul;
    }

    public void setMatricul(String matricul) {
        this.matricul = matricul;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBrday() {
        return brday;
    }

    public void setBrday(Date brday) {
        this.brday = brday;
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


    public PieceName getPiece() {
        return piece;
    }

    public void setPiece(PieceName piece) {
        this.piece = piece;
    }

    public String getNumpiece() {
        return numpiece;
    }

    public void setNumpiece(String numpiece) {
        this.numpiece = numpiece;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public String creatematricul(long lasid){
        Instant date = Instant.now();
        Format formatter = new SimpleDateFormat("ddMMyyyy");
        return "Emp"+formatter.format(date)+String.valueOf(lasid+1);
    }
}
