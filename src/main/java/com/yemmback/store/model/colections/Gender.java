package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Gender {
    homme, femme, societe, service, particulier;

    public static String getvalueByindex(int n) {
        return Gender.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Gender.valueOf(name).ordinal();
    }
    public static String getnatureByname(String name) {
        return Gender.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> inatures = new ArrayList<String>();
        for (Gender gender : Gender.values()) {
            inatures.add(gender.name());
        }
        return inatures;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> inatures = new ArrayList<Hashtable>();
        int i=1;
        for (Gender gender : Gender.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", gender);
            inatures.add(cl);
            i+=i;
        }
        return inatures;
    }

}