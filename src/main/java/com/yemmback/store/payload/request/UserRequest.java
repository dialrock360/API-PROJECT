package com.yemmback.store.payload.request;

import com.yemmback.store.model.Employee;
import com.yemmback.store.model.colections.Role;
import com.yemmback.store.model.colections.Target;
import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by dialrock360 on 06/07/20.
 */

public class UserRequest {

    private Long id;
    private String usernameOrEmail;
    private String username;
    private String email;
    private String password="passer";
    private int flaguser=0;
    private String rolename="ROLE_USER"; 
    private Employee employee=null;
    private String token=null;
    private String tokenType="Bearer";
    private Role role = Role.ROLE_USER;
    private Target target = Target.employee;
    private Long peopleid;


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

    public UserRequest() {
    }

    public UserRequest(@Size(min = 3, max = 15) String username, @Size(max = 40) @Email String email, @NotBlank @Size(min = 4, max = 100) String password, int flaguser, String token, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.flaguser = flaguser;
        this.token = token;
        this.role = role;
    }

    public UserRequest(Long id, @Size(min = 3, max = 15) String username, @Size(max = 40) @Email String email, Role role, int flaguser, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.flaguser = flaguser;
        this.tokenType = "Bearer";
        this.token = token;
    }
    public UserRequest(Long id, @Size(min = 3, max = 15) String username, @Size(max = 40) @Email String email, Role role, Target target, Long peopleid, int flaguser, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.target = target;
        this.peopleid = peopleid;
        this.flaguser = flaguser;
        this.tokenType = "Bearer";
        this.token = token;
    }

    public UserRequest(Long id, @Size(min = 3, max = 15) String username, @Size(max = 40) @Email String email, @NotBlank @Size(min = 4, max = 100) String password, int flaguser, String rolename, Long peopleid, Employee employee, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.flaguser = flaguser;
        this.rolename = rolename;
        this.peopleid = peopleid;
        this.employee = employee;
        this.role = role;
    }

    public UserRequest(Long id, String usernameOrEmail, @Size(min = 3, max = 15) String username, @Size(max = 40) @Email String email, @NotBlank @Size(min = 4, max = 100) String password, int flaguser, String rolename,  Employee employee, String token, String tokenType, Role role, Target target, Long peopleid) {
        this.id = id;
        this.usernameOrEmail = usernameOrEmail;
        this.username = username;
        this.email = email;
        this.password = password;
        this.flaguser = flaguser;
        this.rolename = rolename;
        this.employee = employee;
        this.token = token;
        this.tokenType = tokenType;
        this.role = role;
        this.target = target;
        this.peopleid = peopleid;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public int getFlaguser() {
        return flaguser;
    }

    public void setFlaguser(int flaguser) {
        this.flaguser = flaguser;
    }

    public String getRolename() {
        return rolename;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Long getEmployeeId() {
        return peopleid;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", usernameOrEmail='" + usernameOrEmail + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", flaguser=" + flaguser +
                ", rolename='" + rolename + '\'' +
                ", employee=" + employee +
                ", token='" + token + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", role=" + role +
                ", target=" + target +
                ", peopleid=" + peopleid +
                '}';
    }
}
