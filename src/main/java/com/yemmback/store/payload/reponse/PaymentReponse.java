package com.yemmback.store.payload.reponse;


import java.util.Date;

/**
 * Created by dialrock361 on 01/08/20.
 */

public class PaymentReponse {
    private Long id;
    private String subject;
    private Date paymentdate;
    private Date deadline;
    private Double amount;
    private Double rest;
    private int part;
    private Long operationid;

    public PaymentReponse() {
    }

    public PaymentReponse(Long id, String subject, Date paymentdate, Date deadline, Double amount, Double rest, int part, Long operationid) {
        this.id = id;
        this.subject = subject;
        this.deadline = deadline;
        this.amount = amount;
        this.rest = rest;
        this.part = part;
        this.paymentdate = paymentdate;
        this.operationid = operationid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRest() {
        return rest;
    }

    public void setRest(Double rest) {
        this.rest = rest;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public Long getOperationid() {
        return operationid;
    }

    public void setOperationid(Long operationid) {
        this.operationid = operationid;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }
}
