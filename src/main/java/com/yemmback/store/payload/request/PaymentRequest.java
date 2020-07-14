package com.yemmback.store.payload.request;


import com.yemmback.store.model.Operation;
import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.colections.PaymentState;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 * Created by dialrock361 on 01/08/20.
 */

public class PaymentRequest  {
    private Long id;

    private String subject;

    private Date deadline;

    private Date paymentdate;

    private Double amount;

    private Double rest;

    private int part;

    private PaymentState state = PaymentState.start;


    private Long operationid;

    public PaymentRequest() {
    }

    public PaymentRequest(Long id, String subject, Date deadline, Date paymentdate, Double amount, Double rest, int part, PaymentState state, Long operation) {
        this.id = id;
        this.subject = subject;
        this.deadline = deadline;
        this.paymentdate = paymentdate;
        this.amount = amount;
        this.rest = rest;
        this.part = part;
        this.state = state;
        this.operationid = operation;
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

    public PaymentState getState() {
        return state;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }
}
