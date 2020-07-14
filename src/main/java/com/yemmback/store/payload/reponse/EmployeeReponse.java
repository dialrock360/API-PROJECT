/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.Product;
import com.yemmback.store.model.audit.UserDateAudit;
import com.yemmback.store.model.colections.Gender;
import com.yemmback.store.model.colections.PieceName;
import com.yemmback.store.model.colections.Post;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author dialrock 360
 */


public class EmployeeReponse   {

    private Long id;
    private String matricul;
    private String firstname;
    private String lastname;
    private Gender gender = Gender.homme;
    private Post post = Post.commercial;
    private Date brday;
    private String tel;
    private String email;
    private String adress;
    private PieceName piece = PieceName.nil;
    private String numpiece;
    private List<Hashtable> operations = new ArrayList<>();
    private int nbroperations;

    public EmployeeReponse() {
    }


    public EmployeeReponse(Long id, String matricul, String firstname, String lastname, Gender gender, String tel, Post post, Date brday, String tel1, String email, String adress, PieceName piece, String numpiece, List<Operation> operations) {
        this.id = id;
        this.matricul = matricul;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.post = post;
        this.brday = brday;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
        this.piece = piece;
        this.numpiece = numpiece;
        this.operations = this.formatOperations(operations);
        this.nbroperations = operations.size();

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

    public List<Hashtable> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = this.formatOperations(operations);
    }

    public int getNbroperations() {
        return nbroperations=operations.size();
    }

    public void setNbroperations(int nbroperations) {
        this.nbroperations = nbroperations;
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

    public String creatematricul(long lasid){
        Instant date = Instant.now();
        Format formatter = new SimpleDateFormat("ddMMyyyy");
        return "Emp"+formatter.format(date)+String.valueOf(lasid+1);
    }
}
