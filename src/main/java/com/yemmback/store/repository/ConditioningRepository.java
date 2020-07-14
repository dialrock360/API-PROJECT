package com.yemmback.store.repository;


import com.yemmback.store.model.Conditioning;
import com.yemmback.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */



    @Repository
    public interface ConditioningRepository extends JpaRepository<Conditioning, Long> {

    // MANY TO MAY SELECT QUERY
    /*@Query("SELECT c FROM Conditioning c  JOIN  c.products p where c.flagconditioning = 0 and p.id =:Productid")
    List<Conditioning> findconditioningsByProduct(@Param("categoryid") Long Productid);

     */

    @Query("SELECT v FROM Conditioning v where v.flag = :flagconditioning ")
    List<Conditioning> findconditionings(@Param("flagconditioning") int flagconditioning);

    @Query("SELECT v FROM Conditioning v where v.conditioningname = :conditioningname ")
    Conditioning findconditioningname(@Param("conditioningname") String conditioningname);

    @Query("SELECT v FROM Conditioning v where v.id = :id ")
    Conditioning findConditioningId(@Param("id") Long id);

    Boolean existsConditioningByConditioningname(String categoryname);
    Boolean existsConditioningById(Long id);

 }
 