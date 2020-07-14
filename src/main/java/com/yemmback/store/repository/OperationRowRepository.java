/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.repository;

import com.yemmback.store.model.Operation;
import com.yemmback.store.model.OperationRow;
import com.yemmback.store.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */

@Repository
public interface  OperationRowRepository extends JpaRepository<OperationRow, Long> {

    @Query("SELECT v FROM OperationRow v where v.operation.id = :OperationId")
    List<OperationRow> findByOperation(@Param("OperationId") Long OperationId);

    List<OperationRow> findOperationRowsByOperation(Operation operation);

}

 