package com.yemmback.store.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dialrock361 on 01/08/20.
 */

@Entity
@Table(name = "conditioning", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "conditioningname"
        })
})

public class Conditioning implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(max = 100)
    @Column(name = "conditioningname")
    private String conditioningname;
    @Column(name = "flag")
    private int flag; 

    @OneToMany(targetEntity=Product.class, mappedBy="conditioning",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();


    public Conditioning() {
    }

    public Conditioning(Long id, @NotNull @Size(max = 100) String conditioningname, int flag, List<Product> products) {
        this.id = id;
        this.conditioningname = conditioningname;
        this.flag = flag;
        this.products = products;
    }

    public Conditioning(Long id) {
        this.id = id;
    }

    public Conditioning(@NotNull @Size(max = 100) String conditioningname, int flag, List<Product> products) {
        this.conditioningname = conditioningname;
        this.flag = flag;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditioningname() {
        return conditioningname;
    }

    public void setConditioningname(String conditioningname) {
        this.conditioningname = conditioningname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
