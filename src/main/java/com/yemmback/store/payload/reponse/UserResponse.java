package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.colections.Role;

import java.time.Instant;

public class UserResponse {
    private long id;
    private String username;
    private String email;
    private int flaguser;
    private Role role = Role.ROLE_USER;
    private Instant createdAt;

    public UserResponse() {
    }

    public UserResponse(long id, String username, String email, int flaguser, Role role, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.flaguser = flaguser;
        this.role = role;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
