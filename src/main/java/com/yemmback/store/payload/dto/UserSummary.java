package com.yemmback.store.payload.dto;

public class UserSummary {
    private Long id;
    private String username;
    private String name;
    private String email;
    private int flaguser;

    public UserSummary(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserSummary(Long id, String username, String email, int flaguser) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.flaguser = flaguser;
    }

    public UserSummary(Long id, String username,  String email,String name) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.flaguser = 0;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
