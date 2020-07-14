package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum JuridicForm {
    SARL, SAS, SA, SC, SNC, SCA, SCS;


    public static String getvalueByindex(int n) {
        return JuridicForm.values()[n].name();
    }
    public static int getindexByname(String name) {
        return JuridicForm.valueOf(name).ordinal();
    }
    public static String getjuridicformByname(String name) {
        return JuridicForm.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> ijuridicforms = new ArrayList<String>();
        for (JuridicForm juridicform : JuridicForm.values()) {
            ijuridicforms.add(juridicform.name());
        }
        return ijuridicforms;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> ijuridicforms = new ArrayList<Hashtable>();
        int i=1;
        for (JuridicForm juridicform : JuridicForm.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", juridicform);
            ijuridicforms.add(cl);
            i+=i;
        }
        return ijuridicforms;
    }

}