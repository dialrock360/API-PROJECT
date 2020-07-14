/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.audit.UserDateAudit;
import com.yemmback.store.model.colections.Gender;
import com.yemmback.store.model.colections.PieceName;
import com.yemmback.store.model.colections.Post;
import com.yemmback.store.model.colections.Target;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
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

@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "tel"
        }),
        @UniqueConstraint(columnNames = {
                "matricul"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        }),
        @UniqueConstraint(columnNames = {
                "numpiece"
        })
})
public class Employee  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "matricul")
    private String matricul;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Builder.Default
    private Gender gender = Gender.homme;
    @Builder.Default
    private Post post = Post.commercial;
    private Date brday;
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
    @Builder.Default
    private PieceName piece = PieceName.nil;
    @Column(name = "numpiece")
    private String numpiece;

    @Column(name = "flag")
    private int flag;


    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(Long id, @NotNull @Size(min = 1, max = 50) String matricul, @Size(max = 255) String firstname, @NotNull @Size(min = 3, max = 255) String lastname, Gender gender, Post post, Date brday, @NotNull @Size(min = 1, max = 50) String tel, @Size(max = 255) String email, @Size(max = 255) String adress, PieceName piece, String numpiece, int flag) {
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
        this.flag = flag;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private void formatmatricul(Long lastid){
        this.matricul = "EMP"+ String.valueOf(lastid+1)+(new SimpleDateFormat("ddMMyyyyHHmmss").format( new Date()));
    }
}
