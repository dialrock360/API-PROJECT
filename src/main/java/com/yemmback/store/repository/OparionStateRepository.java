/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.repository;

import com.yemmback.store.model.Category;
import com.yemmback.store.model.OparionState;
import com.yemmback.store.model.Operation;
import com.yemmback.store.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *
 * @author d
 */

@Repository
public interface OparionStateRepository extends JpaRepository<OparionState, Long> {

    List<OparionState> findOparionStatesByOperation(Operation operation);
    List<OparionState> findOparionStatesByCategory(Category category);

    boolean existsOparionStateBySpentAndGainAndCheckoutAndDateStateAndCategoryAndOperation(@NotNull Double spent, @NotNull Double gain, Double checkout, Date dateState, Category category, Operation operation);
}
 