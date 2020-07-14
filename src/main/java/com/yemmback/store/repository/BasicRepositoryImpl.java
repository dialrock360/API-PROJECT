package com.yemmback.store.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BasicRepositoryImpl implements BasicRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public int deleteOrRestor(String tablename,String id, int flag, Boolean withflag) {
         StringBuilder sb = new StringBuilder();
        sb.append((withflag==true)?"UPDATE "+tablename+" SET `flag`="+String.valueOf(flag)+"  WHERE id="+id:"DELETE FROM "+tablename+" WHERE id="+id);
        Query query = entityManager.createNativeQuery(sb.toString());

        return query.executeUpdate();
    }


}
