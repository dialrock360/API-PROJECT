package com.yemmback.store.payload.reponse;


import com.yemmback.store.model.Product;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */

public class ConditioningReponse {
    private Long id;
    private String conditioningname;
    private int nbrproducts;
    private List<Hashtable> products = new ArrayList<>();


    public ConditioningReponse() {
    }

    public ConditioningReponse(Long id, String conditioningname, List<Product> products) {
        this.id = id;
        this.conditioningname = conditioningname;
        this.nbrproducts = products.size();
        this.products = this.formatProducts(products);
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

    public List<Hashtable> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = this.formatProducts(products);
    }

    private  List<Hashtable> formatProducts(List<Product> products){
        List<Hashtable> iproducts = new ArrayList<Hashtable>();
        int i=1;
            for (Product p : products) {
                Hashtable cl = new Hashtable();
                cl.put("id", p.getId());
                cl.put("productname", p.getProductname());
                iproducts.add(cl);
            }
        return iproducts;
    }

    public int getNbrproducts() {
        return nbrproducts=products.size();
    }

    public void setNbrproducts(int nbrproducts) {
        this.nbrproducts = nbrproducts;
    }
}
