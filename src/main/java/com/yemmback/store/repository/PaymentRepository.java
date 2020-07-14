package com.yemmback.store.repository;


import com.yemmback.store.model.Operation;
import com.yemmback.store.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */


@Repository
public interface  PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT v FROM Payment v where v.operation.id = :OperationId")
    List<Payment> findByOperation(@Param("OperationId") Long OperationId);
    @Query("SELECT v FROM Payment v where v.createdAt = :createdAt")
    List<Payment> findBycreatedAt(@Param("createdAt") Date createdAt);

    List<Payment> findPaymentsByOperation(Operation operation);

    @Query("SELECT v FROM Payment v where v.createdAt = :createdAt")
    List<Payment> findBydate(@Param("createdAt") Date createdAt);

    boolean countPaymentByAmountAndRestAndPartAndDeadlineAndPaymentdate(@NotNull Double amount, @NotNull Double rest, int part, @NotBlank Date deadline, @NotBlank Date paymentdate);

    int countPaymentByOperation(Operation operation);
}
 