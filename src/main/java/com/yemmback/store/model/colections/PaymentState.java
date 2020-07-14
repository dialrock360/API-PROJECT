package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum PaymentState {
    start, complete, anulate, intermediary;

    public static String getvalueByindex(int n) {
        return PaymentState.values()[n].name();
    }
    public static int getindexByname(String name) {
        return PaymentState.valueOf(name).ordinal();
    }
    public static String getnatureByname(String name) {
        return PaymentState.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> inatures = new ArrayList<String>();
        for (PaymentState paymentState : PaymentState.values()) {
            inatures.add(paymentState.name());
        }
        return inatures;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> inatures = new ArrayList<Hashtable>();
        int i=1;
        for (PaymentState paymentState : PaymentState.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", paymentState);
            inatures.add(cl);
            i+=i;
        }
        return inatures;
    }

}