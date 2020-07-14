package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.audit.UserDateAudit;
import com.yemmback.store.model.colections.OperationType;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */
@Entity
@Table(name = "operation")
public class Operation extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private OperationType operationtype = OperationType.commande;

    @Column(name = "operationdate")
    private Date operationdate;
    private boolean payable;
    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "objet")
    private String objet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tva")
    @NotNull
    private Double tva;
    @Column(name = "totalHt")
    private Double totalHt;
    @NotNull
    @Column(name = "totalTtc")
    private Double totalTtc;

    @Column(name = "status")
    private int status;

    @Column(name = "flag")
    private int flag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operationparent;

    @OneToMany(
            mappedBy = "operation",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<Payment> payments = new ArrayList<>();
    @OneToMany(
            mappedBy = "operation",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<OperationRow> operationrows = new ArrayList<>();

    @OneToMany(
            mappedBy = "operationparent",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    private List<Operation> operationchildren = new ArrayList<>();



    public Operation() {
    }

    public Operation(Long id, OperationType operationtype, Date operationdate, boolean payable, Date paymentDate, String objet, @NotNull Double tva, Double totalHt, @NotNull Double totalTtc, int status, int flag, Client client, Operation operationparent, List<Payment> payments, List<OperationRow> operationrows, List<Operation> operationchildren) {
        this.id = id;
        this.operationtype = operationtype;
        this.operationdate = operationdate;
        this.payable = payable;
        this.paymentDate = paymentDate;
        this.objet = objet;
        this.tva = tva;
        this.totalHt = totalHt;
        this.totalTtc = totalTtc;
        this.status = status;
        this.flag = flag;
        this.client = client;
        this.operationparent = operationparent;
        this.payments = payments;
        this.operationrows = operationrows;
        this.operationchildren = operationchildren;
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

    public OperationType getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(OperationType operationtype) {
        this.operationtype = operationtype;
    }

    public Date getOperationdate() {
        return operationdate;
    }

    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }

    public boolean isPayable() {
        return payable;
    }

    public void setPayable(boolean payable) {
        this.payable = payable;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Double getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(Double totalHt) {
        this.totalHt = totalHt;
    }

    public Double getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(Double totalTtc) {
        this.totalTtc = totalTtc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Operation getOperationparent() {
        return operationparent;
    }

    public void setOperationparent(Operation operationparent) {
        this.operationparent = operationparent;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<OperationRow> getOperationrows() {
        return operationrows;
    }

    public void setOperationrows(List<OperationRow> operationrows) {
        this.operationrows = operationrows;
    }

    public List<Operation> getOperationchildren() {
        return operationchildren;
    }

    public void setOperationchildren(List<Operation> operationchildren) {
        this.operationchildren = operationchildren;
    }
}
