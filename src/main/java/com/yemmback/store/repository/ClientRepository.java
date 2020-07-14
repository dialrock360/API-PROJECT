/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.repository;

import com.yemmback.store.model.Client;
import com.yemmback.store.model.Client;
import com.yemmback.store.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author dialrock 360
 */


    @Repository
    public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query("SELECT v FROM Client v where v.flag = :flagclient ")
    List<Client> findClients(@Param("flagclient") int flagclient);

    Client findClientByTel(String tel);
    Boolean existsClientByTel(String tel);
    Boolean existsClientByEmail(String tel);
    Boolean existsClientById(Long id);

    @Query("SELECT v FROM Client v where v.tel = :val or v.email = :val or v.clientname = :val ")
    Client findClientByAny(@Param("val") String val);
    
    }
