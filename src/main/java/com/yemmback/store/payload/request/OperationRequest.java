package com.yemmback.store.payload.request;

import com.yemmback.store.model.Client;
import com.yemmback.store.model.Operation;
import com.yemmback.store.model.colections.OperationType;

import java.util.Date;

public class OperationRequest {
    private Long id;
    private OperationType operationtype = OperationType.commande;
    private Date operationdate;
    private boolean payable;
    private Date paymentDate;
    private String objet;
    private Double tva;
    private Double totalHt;
    private Double totalTtc;
    private int status;
    private int flag;
    private Long clientid;
    private Long idoperationparent;

    public OperationRequest() {
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

    public OperationRequest(Long id, OperationType operationtype, Date operationdate, boolean payable, Date paymentDate, String objet, Double tva, Double totalHt, Double totalTtc, int status, int flag, Long client, Long idoperationparent) {
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
        this.clientid = client;
        this.idoperationparent = idoperationparent;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getIdoperationparent() {
        return idoperationparent;
    }

    public void setIdoperationparent(Long idoperationparent) {
        this.idoperationparent = idoperationparent;
    }
}
