package com.yemmback.store.payload.reponse;

import com.yemmback.store.model.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rajeevkumarsingh on 19/08/17.
 */
public class ApiResponse {
    private Boolean success;
    private String message;
    private User curenUser;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, User curenUser) {
        this.success = success;
        this.message = message;
        this.curenUser = curenUser;
    }

    public ApiResponse() {
    }

    public User getCurenUser() {
        return curenUser;
    }

    public void setCurenUser(User curenUser) {
        this.curenUser = curenUser;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public URI location(String val,String cPath){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath().path(cPath)
                .buildAndExpand(val).toUri();
    }
    public Object saveTest(Object newObject) { return newObject; }
    public Date formatDate(String sDate1) throws  Exception {

        try {
            //  String sDate1="31/12/1998";
            Date rdate=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            System.out.println(sDate1+"\t"+rdate);
            return rdate;

        }
        catch (Exception ex) {
            System.out.println("Something went wrong:       "+ex);
        }
        return null;
    }
}
