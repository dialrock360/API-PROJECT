/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yemmback.store.repository;

import com.yemmback.store.model.Employee;
import com.yemmback.store.model.Employee;
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
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT v FROM Employee v where v.flag = :flag ")
    List<Employee> findEmployees(@Param("flag") int flag);

    Long countEmployeeByFlag(int flag);
    Employee findEmployeeByTel(String tel);
    Employee findEmployeeByMatricul(String Matricul);
    Boolean existsEmployeesByTel(String tel);
    Boolean existsEmployeesByMatricul(String Matricul);
    Boolean existsEmployeeByEmail(String Matricul);
    Boolean existsEmployeeByNumpiece(String Matricul);

    @Query("SELECT v FROM Employee v where v.tel = :val or v.email = :val or v.matricul = :val or v.numpiece = :val or v.firstname = :val")
    Employee findEmployeeByAny(@Param("val") String val);

}
 
