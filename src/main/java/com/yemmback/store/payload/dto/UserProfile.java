package com.yemmback.store.payload.dto;



import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private Long id;
    private String username;
    private String email;
    private int flaguser;
    private Instant joinedAt;
  //  private Employee employee;

    public UserProfile(Long id, String username, String email, Instant joinedAt/*, Employee employee*/) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.joinedAt = joinedAt;
       // this.employee = employee;
    }

    // private List<Operation> operations = new ArrayList<>();
/*
    public UserProfile(Long id, String username, String email, Instant joinedAt, List<Operation> operations, Employee employee) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.joinedAt = joinedAt;
        this.operations = operations;
        this.employee = employee;
    }
    public UserProfile(Long id, String username, String email, int flaguser, Instant joinedAt, List<Operation> operationCount, Employee employee) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.flaguser=flaguser;
        this.joinedAt = joinedAt;
        this.operations = operationCount;
        this.employee = employee;
    }
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFlaguser() {
        return flaguser;
    }

    public void setFlaguser(int flaguser) {
        this.flaguser = flaguser;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }
/*
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

 */
}
