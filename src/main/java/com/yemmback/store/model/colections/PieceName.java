package com.yemmback.store.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum PieceName {
    cni, passeport, professionallcard, nil,  ninea, rc;

    public static String getvalueByindex(int n) {
        return PieceName.values()[n].name();
    }
    public static int getindexByname(String name) {
        return PieceName.valueOf(name).ordinal();
    }
    public static String getpieceByname(String name) {
        return PieceName.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> ipieces = new ArrayList<String>();
        for (PieceName piece : PieceName.values()) {
            ipieces.add(piece.name());
        }
        return ipieces;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> ipieces = new ArrayList<Hashtable>();
        int i=1;
        for (PieceName piece : PieceName.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", piece);
            ipieces.add(cl);
            i+=i;
        }
        return ipieces;
    }

}