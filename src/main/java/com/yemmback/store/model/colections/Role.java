package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Role {
    ROLE_USER, ROLE_ADMIN, ROLE_SUPER_ADMIN;

    public static String getvalueByindex(int n) {
        return Role.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Role.valueOf(name).ordinal();
    }
    public static String getroleByname(String name) {
        return Role.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> iroles = new ArrayList<String>();
        for (Role role : Role.values()) {
            iroles.add(role.name());
        }
        return iroles;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> iroles = new ArrayList<Hashtable>();
        int i=1;
        for (Role role : Role.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", role);
            iroles.add(cl);
            i+=i;
        }
        return iroles;
    }

}