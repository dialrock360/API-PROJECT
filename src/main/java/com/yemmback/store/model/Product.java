package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import org.hibernate.internal.util.collections.Stack;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by dialrock361 on 01/08/20.
 */
@Entity
@Table(name = "product", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "productname"
        }),
        @UniqueConstraint(columnNames = {
                "productref"
        })
})
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "productref")
    private String productref;
    @Column(name = "productname")
    private String productname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchasePrice")
    private Double purchasePrice;
    @Column(name = "salePrice")
    private Double salePrice;
    @Column(name = "minSalePrice")
    private Double minSalePrice;
    @Column(name = "qnt")
    private Double qnt;
   /* @ManyToOne()
    @JoinColumn(name="category_id", referencedColumnName = "id", insertable = false,    updatable = false)
    private Category category;
    
    @ManyToOne()
    @JoinColumn(name="conditioning_id", referencedColumnName = "id", insertable = false,     updatable = false)
     private Conditioning conditioning;*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conditioning_id", nullable = false)
    private Conditioning conditioning;

    @Column(name = "flag")
    private int flag;


    @OneToMany(targetEntity=OperationRow.class, mappedBy="product",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OperationRow> operationrows = new ArrayList<>();


    public Product() {
    }

    public Product(Long id, String productname, Double purchasePrice, Double salePrice) {
        this.id = id;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    public Product(Long id, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, int flag, List<OperationRow> operationrows, Category category, Conditioning conditioning) {
        this.id = id;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.flag = flag;
        this.operationrows = operationrows;
        this.category = category;
        this.conditioning = conditioning;
    }

    public Product(Long id, String productref, String productname, Double purchasePrice, Double salePrice, Double minSalePrice, Double qnt, Category category, Conditioning conditioning, int flag, List<OperationRow> operationrows) {
        this.id = id;
        this.productref = productref;
        this.productname = productname;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.minSalePrice = minSalePrice;
        this.qnt = qnt;
        this.category = category;
        this.conditioning = conditioning;
        this.flag = flag;
        this.operationrows = operationrows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getMinSalePrice() {
        return minSalePrice;
    }

    public void setMinSalePrice(Double minSalePrice) {
        this.minSalePrice = minSalePrice;
    }

    public Double getQnt() {
        return qnt;
    }

    public void setQnt(Double qnt) {
        this.qnt = qnt;
    }

    public String getProductref() {
        return productref;
    }

    public void setProductref(String productref) {
        this.productref = productref;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<OperationRow> getOperationrows() {
        return operationrows;
    }

    public void setOperationrows(List<OperationRow> operationrows) {
        this.operationrows = operationrows;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Conditioning getConditioning() {
        return conditioning;
    }

    public void setConditioning(Conditioning conditioning) {
        this.conditioning = conditioning;
    }

    private void formatproductref(Long lastid){
        this.productref = "PR-00"+ String.valueOf(lastid+1)+String.valueOf(category.getId())+(new SimpleDateFormat("ddMMyyyy").format( new Date()));
    }

}
