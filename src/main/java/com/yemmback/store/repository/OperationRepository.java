package com.yemmback.store.repository;

import com.yemmback.store.model.Employee;
import com.yemmback.store.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("SELECT v FROM Operation v where v.client.id = :clientId and v.flag=0")
    List<Operation> findByClient(@Param("clientId") Long clientId);
    @Query("SELECT v FROM Operation v where v.createdBy = :EmployeeId and v.flag=0")
    List<Operation> findByEmployee(@Param("EmployeeId") Long EmployeeId);

    @Query("SELECT v FROM Operation v where v.client.id = :clientId and v.id = :OperationId")
    Operation findByClientIdAndOperationId(@Param("clientId") Long userId, @Param("OperationId") Long OperationId);

    @Query("SELECT v FROM Operation v where v.createdBy = :EmployeeId and v.id = :OperationId")
    Operation findByClientIdAndEmployeeId(@Param("EmployeeId") Long EmployeeId, @Param("EmployeeId") Long OperationId);

    @Query("SELECT v FROM Operation v where v.flag = :flagoperation ")
    List<Operation> findOperations(@Param("flagoperation") int flagoperation);

    @Query("SELECT v FROM Operation v where v.operationdate = :operationdate and v.flag = :flagoperation ")
    List<Operation> findOperationsByDate(@Param("operationdate") Date operationdate,@Param("flagoperation") int flagoperation);

    @Query("SELECT v FROM Operation v where v.operationdate  BETWEEN :sdate and :edate")
    List<Operation> findAlloperationsbyRangeDate(@Param("sdate") Date sdate,@Param("edate") Date edate);



    @Query("SELECT v FROM Operation v where v.client.id = :clientid ")
    List<Operation> findOperationsbyClientid(@Param("clientid") Long clientid);



    @Query("SELECT v FROM Operation v where v.createdAt = :id or v.client.id = :id ")
    List<Operation>  findOperationsByEmployeeIdOrClientId(@Param("id") Long id);
/*
    @Query("SELECT v FROM Operation v where v.flag = :flagoperation and v.operationparent.id = :OperationparentId ")
    List<Operation> findOperationsByOperationparentaAndFlag(@Param("OperationparentId") Long OperationparentId, @Param("flagoperation") int flagoperation);


 */
/*
    @Query("SELECT v FROM Operation v where v.client.id =:clientId")
    List<Operation> findOperationsByclientid(@Param("clientId") Long clientId);
    @Query("SELECT v FROM Operation v where v.employee.id =:clientId")
    List<Operation> findOperationsByEmployeeid(@Param("employee") Long employee);

 */
    List<Operation> findOperationsByOperationparentAndFlag(Operation operationparent, int flag);
    List<Operation> findOperationsByOperationparent(Operation operationparent);
    boolean existsOperationById(Long id);


}
