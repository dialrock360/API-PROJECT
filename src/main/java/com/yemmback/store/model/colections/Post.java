package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Post {
    directeur, comptable, caissier, magazinier, commercial, gardien;

    public static String getvalueByindex(int n) {
        return Post.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Post.valueOf(name).ordinal();
    }
    public static String getfunctionByname(String name) {
        return Post.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> ifunctions = new ArrayList<String>();
        for (Post function : Post.values()) {
            ifunctions.add(function.name());
        }
        return ifunctions;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> ifunctions = new ArrayList<Hashtable>();
        int i=1;
        for (Post function : Post.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", function);
            ifunctions.add(cl);
            i+=i;
        }
        return ifunctions;
    }

}