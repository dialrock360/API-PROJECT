package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.*;
import com.yemmback.store.model.colections.OperationType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */
public class OperationReponse {
    private Long id;
    private OperationType operationtype = OperationType.commande;
    private String operationdate;
    private boolean payable;
    private String paymentDate;
    private String objet;
    private Double tva;
    private Double totalHt;
    private Double totalTtc;
    private int status;
    private int flag;
    private Hashtable client;
    private Hashtable employee;
    private Hashtable operationparent;
    private List<Hashtable> payments = new ArrayList<>();
    private List<Hashtable> operationrows = new ArrayList<>();
    private List<Hashtable> operationchildren = new ArrayList<>();

    public OperationReponse() {
    }

    public OperationReponse(Long id, OperationType operationtype, Date operationdate, boolean payable, Date paymentDate, String objet, Double tva, Double totalHt, Double totalTtc, int status,  Client client, Employee employee, Operation operationparent, List<Payment> payments, List<OperationRow> operationrows, List<Operation> operationchildren) {
        this.id = id;
        this.operationtype = operationtype;
        this.operationdate = this.formatdateString(operationdate);
        this.payable = payable;
        this.paymentDate = this.formatdateString(paymentDate);
        this.objet = objet;
        this.tva = tva;
        this.totalHt = totalHt;
        this.totalTtc = totalTtc;
        this.status = status;
        this.client =   this.formatOperationclient(client);
        this.employee = this.formatOperationemployee(employee);
        this.operationparent = this.formatOperationparent(operationparent);
        this.payments = this.formatPayments(payments);
        this.operationrows = this.formatOperationRows(operationrows);
        this.operationchildren = this.formatOperationschilds(operationchildren) ;
    }

    public OperationReponse(Long id, OperationType operationtype, Instant createdAt, boolean payable, Date paymentDate, String objet, Double tva, Double totalHt, Double totalTtc, int status, int flag, Client client, Employee employee, Operation operationparent, List<Payment> payments, List<OperationRow> operationrows, List<Operation> operationchildren) {


        this.id = id;
        this.operationtype = operationtype;
        this.operationdate = this.formatistantodateString(createdAt);
        this.payable = payable;
        this.paymentDate = this.formatdateString(paymentDate);
        this.objet = objet;
        this.tva = tva;
        this.totalHt = totalHt;
        this.totalTtc = totalTtc;
        this.status = status;
        this.client =   this.formatOperationclient(client);
        this.employee = this.formatOperationemployee(employee);
        this.operationparent = this.formatOperationparent(operationparent);
        this.payments = this.formatPayments(payments);
        this.operationrows = this.formatOperationRows(operationrows);
        this.operationchildren = this.formatOperationschilds(operationchildren) ;
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

    public String getOperationdate() {
        return operationdate;
    }

    public void setOperationdate(Instant operationdate) {
        this.operationdate =this.formatistantodateString(operationdate);
    }

    public boolean isPayable() {
        return payable;
    }

    public void setPayable(boolean payable) {
        this.payable = payable;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = this.formatdateString(paymentDate);
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

    public Hashtable getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = this.formatOperationclient(client);
    }

    public Hashtable getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = this.formatOperationemployee(employee);
    }

    public Hashtable getOperationparent() {
        return operationparent;
    }

    public void setOperationparent(Operation operationparent) {
        this.operationparent = this.formatOperationparent(operationparent);
    }

    public List<Hashtable> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = this.formatPayments(payments);
    }

    public List<Hashtable> getOperationrows() {
        return operationrows;
    }

    public void setOperationrows(List<OperationRow> operationrows) {
        this.operationrows =    this.formatOperationRows(operationrows);
    }

    public List<Hashtable> getOperationchildren() {
        return operationchildren;
    }

    public void setOperationchildren(List<Operation> operationchildren) {
        this.operationchildren = this.formatOperationschilds(operationchildren);
    }

    private  List<Hashtable> formatOperationschilds(List<Operation> operations){
        List<Hashtable> ioperations = new ArrayList<Hashtable>();
        int i=1;
        for (Operation p : operations) {
            Hashtable cl = new Hashtable();
            cl.put("id", p.getId());
            cl.put("operationtype", p.getOperationtype());
            cl.put("date", p.getCreatedAt());
            ioperations.add(cl);
        }
        return ioperations;
    }

    private  List<Hashtable> formatOperationRows(List<OperationRow> operationRows){
        List<Hashtable> ioperationRows = new ArrayList<Hashtable>();
        int i=1;
        for (OperationRow p : operationRows) {
            Hashtable cl = new Hashtable();
            cl.put("id", p.getId());
            cl.put("productname", p.getProduct().getProductname());
            cl.put("price", p.getPrice());
            cl.put("quantity", p.getQuantity());
            cl.put("mount", p.getMount());
            ioperationRows.add(cl);
        }
        return ioperationRows;
    }
    private  List<Hashtable> formatPayments(List<Payment> Payments){
        List<Hashtable> iPayments = new ArrayList<Hashtable>();
        int i=1;
        for (Payment p : Payments) {
            Hashtable cl = new Hashtable();
            cl.put("id", p.getId());
            cl.put("paymentdate", p.getCreatedAt());
            cl.put("amount", p.getAmount());
            cl.put("rest", p.getRest());
            cl.put("part", p.getPart());
            cl.put("deadline", p.getPart());
            iPayments.add(cl);
        }
        return iPayments;
    }
    private  Hashtable formatOperationparent(Operation p){

        Hashtable cl = new Hashtable();
        cl.put("id", p.getId());
        cl.put("operationtype", p.getOperationtype());
        cl.put("date", p.getCreatedAt());
        return cl;
    }

    private  Hashtable formatOperationclient(Client p){

        Hashtable cl = new Hashtable();
        cl.put("id", p.getId());
        cl.put("clientname", p.getFullName());
        cl.put("tel", p.getTel());
        cl.put("email", p.getEmail());
        return cl;
    }
    private  Hashtable formatOperationemployee(Employee p){

        Hashtable cl = new Hashtable();
        cl.put("id", p.getId());
        cl.put("employeename", p.getFirstname()+" "+p.getLastname());
        cl.put("matricul", p.getMatricul());
        return cl;
    }
    private  String formatistantodateString(Instant t) { return   new SimpleDateFormat("yyyy-MM-dd").format(Date.from(t)); }
    private  String formatdateString(Date t) { return   new SimpleDateFormat("yyyy-MM-dd").format(t); }

}
