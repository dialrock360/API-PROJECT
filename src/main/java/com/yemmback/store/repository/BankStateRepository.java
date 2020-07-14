package com.yemmback.store.repository;

import com.yemmback.store.model.BankState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Repository
public interface BankStateRepository extends JpaRepository<BankState, Long> {


    Boolean existsBankStateBySpentAndGainAndDateStateAndRealBankAndVirtualBank(@NotNull Double spent, @NotNull Double gain, @NotBlank Date dateState, @NotNull Double realBank, @NotNull Double virtualBank);

}

