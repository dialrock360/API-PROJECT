package com.yemmback.store.model;


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

@Entity
@Table(name = "payment")
public class Payment extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 255)
    @Column(name = "subject")
    private String subject;
    @NotBlank
    @Column(name = "deadline")
    private Date deadline;
    @NotBlank
    @Column(name = "paymentdate")
    private Date paymentdate;
    @NotNull
    @Column(name = "amount")
    private Double amount;
    @NotNull
    @Column(name = "rest")
    private Double rest;
    @Column(name = "part")
    private int part;
    @Builder.Default
    private PaymentState state = PaymentState.start;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    public Payment() {
    }

    public Payment(Long id, @Size(max = 255) String subject, @NotBlank Date paymentdate,@NotBlank Date deadline, @NotNull Double amount, @NotNull Double rest, int part, PaymentState state,Operation operation) {
        this.id = id;
        this.subject = subject;
        this.deadline = deadline;
        this.amount = amount;
        this.rest = rest;
        this.part = part;
        this.state = state;
        this.operation = operation;
        this.paymentdate = paymentdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
