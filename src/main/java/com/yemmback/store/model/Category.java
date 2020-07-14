package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */
@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "categoryname"
        })
})
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "categoryname")
    private String categoryname;
    @Column(name = "flag")
    private Integer flag;
/*
    @OneToMany(targetEntity=Product.class, mappedBy="category",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();


 */
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<Product> products = new ArrayList<>();



    public Category() {
    }

    public Category(Long id) {
        this.id = id;
    }

    public Category(Long id, @NotNull @Size(min = 1, max = 255) String categoryname, Integer flag, List<Product> products) {
        this.id = id;
        this.categoryname = categoryname;
        this.flag = flag;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String name) {
        this.categoryname = name;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
