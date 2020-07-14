package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Target {
    employee, client, sadmin;

    public static String getvalueByindex(int n) {
        return Target.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Target.valueOf(name).ordinal();
    }
    public static String gettargetByname(String name) {
        return Target.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> itargets = new ArrayList<String>();
        for (Target target : Target.values()) {
            itargets.add(target.name());
        }
        return itargets;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> itargets = new ArrayList<Hashtable>();
        int i=1;
        for (Target target : Target.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", target);
            itargets.add(cl);
            i+=i;
        }
        return itargets;
    }

}