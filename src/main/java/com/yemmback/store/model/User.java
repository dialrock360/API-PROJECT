package com.yemmback.store.model;

import com.yemmback.store.model.audit.DateAudit;
import com.yemmback.store.model.colections.Target;
import lombok.Builder;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.yemmback.store.model.colections.Role;

/**
 * Created by dialrock361 on 01/08/20.
 */

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;
    private int flag;


    @Builder.Default
    private Role role = Role.ROLE_USER;
    @Builder.Default
    private Target target = Target.employee;

    private Long peopleid;

    public User() {

    }

    public User(Long id, @NotBlank @Size(max = 40) String username, @NotBlank @Size(max = 40) @Email String email, int flag, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.flag = flag;
        this.role = role;
    }

    public User(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.flag = 0;
    }

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.flag = 0;
        this.role = role;

    }

    public User(Long id, int flag) {
        this.id = id;
        this.flag = flag;
    }

    public User(Long id, @NotBlank @Size(max = 40) String username, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, int flag) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.flag = flag;
        }

    public User(Long id, @NotBlank @Size(max = 40) String username, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, int flag, Role role, Target target, Long peopleid) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.flag = flag;
        this.role = role;
        this.target = target;
        this.peopleid = peopleid;
    }

    public User(String username, String email, String password, int i, Role role, Target target, Long peopleid) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.flag = i;
        this.role = role;
        this.target = target;
        this.peopleid = peopleid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getFlaguser() {
        return flag;
    }

    public void setFlaguser(int flag) {
        this.flag = flag;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Long getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(Long peopleid) {
        this.peopleid = peopleid;
    }
}