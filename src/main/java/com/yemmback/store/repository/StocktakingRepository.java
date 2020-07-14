/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.repository;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.Payment;
import com.yemmback.store.model.Stocktaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *
 * @author d
 */

@Repository
public interface StocktakingRepository extends JpaRepository<Stocktaking, Long> {
    List<Stocktaking> findStocktakingsByDateStk(@NotNull Date dateStk);

    @Query("SELECT v FROM Stocktaking v where v.dateStk  BETWEEN :sdate and :edate")
    List<Stocktaking> findAllStocktakingbyRangeDate(@Param("sdate") Date sdate, @Param("edate") Date edate);
    Boolean existsStocktakingByDateStk(@NotNull Date dateStk);
 }
