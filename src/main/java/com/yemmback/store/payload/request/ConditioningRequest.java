package com.yemmback.store.payload.request;


import com.yemmback.store.model.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */


public class ConditioningRequest   {

    private Long id;

    private String conditioningname;

    private int flag;

    public ConditioningRequest() {
    }

    public ConditioningRequest(Long id, String conditioningname, int flag) {
        this.id = id;
        this.conditioningname = conditioningname;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditioningname() {
        return conditioningname;
    }

    public void setConditioningname(String conditioningname) {
        this.conditioningname = conditioningname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
