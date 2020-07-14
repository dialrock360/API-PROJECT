package com.yemmback.store.repository;


/**
 * Created by dialrock361 on 01/08/20.
 */

public  interface SysRepository {

     int deleteOrRestor(String tablename,String id,int flag,Boolean withflag);


}
