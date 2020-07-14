package com.yemmback.store.controller;

import com.yemmback.store.model.Client;
import com.yemmback.store.model.Employee;
import com.yemmback.store.model.Enterprise;
import com.yemmback.store.payload.reponse.ApiResponse;
import com.yemmback.store.payload.reponse.ClientReponse;
import com.yemmback.store.payload.reponse.EmployeeReponse;
import com.yemmback.store.repository.BankStateRepository;
import com.yemmback.store.repository.ClientRepository;
import com.yemmback.store.repository.EmployeeRepository;
import com.yemmback.store.repository.EnterpriseRepository;
import com.yemmback.store.service.EntrepriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.Min;
import java.util.List;
 
public class EntrepriseController {
  
 


    private static final Logger logger = LoggerFactory.getLogger(EntrepriseController.class);


    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private ClientRepository clientRepository;
    
    @Autowired private EnterpriseRepository enterpriseRepository;


    @Autowired private EntrepriseService entrepriseService;
 
    private static final ApiResponse apir = new ApiResponse();

    // Get All resources
    @GetMapping("/clients") List<ClientReponse> findAllclients() {
        return entrepriseService.getAllClients();
    }
    @GetMapping("/employees") List<EmployeeReponse> findAllemployees() { return entrepriseService.getAllEmployees(); }
    @GetMapping("/enterprises") List<Enterprise> findAllenterprises() { return enterpriseRepository.findAll(); }


    // Find by Id
    @GetMapping("/client/{id}") ClientReponse findOneclient(@PathVariable @Min(1) Long id) { return (id>0)?entrepriseService.getClient(id):null; }
    @GetMapping("/employee/{id}") EmployeeReponse findOneemployee(@PathVariable @Min(1) Long id) { return entrepriseService.getEmployee(id); }
    @GetMapping("/enterprise/{id}") Enterprise findOneenterprise(@PathVariable @Min(1) Long id) { return enterpriseRepository.getOne(id); }


    // Find by Id name
    @GetMapping("/client/{clientname}") ClientReponse findOneclient(@PathVariable String clientname) { return entrepriseService.findClient(clientname); }
    @GetMapping("/employee/{employeename}") EmployeeReponse findOneemployee(@PathVariable String employeename) { return entrepriseService.findEmployee(employeename); }




    // Save or update
    @PutMapping("/client") ResponseEntity<?> saveOrUpdateclient(@RequestBody ClientReponse newClient) { return entrepriseService.saveClient(newClient);}
    @PutMapping("/employee") ResponseEntity<?> saveOrUpdateemployee(@RequestBody EmployeeReponse newEmployee) { return entrepriseService.saveEmployee(newEmployee);}
    @PutMapping("/enterprise") ResponseEntity<?> saveOrUpdatedelenterprise(@RequestBody Enterprise newEnterprise) { return entrepriseService.saveEnterprise(newEnterprise);}




    // Delete resoureces
    @GetMapping("/delclient/{id}")
    ResponseEntity<?> delclient(@PathVariable @Min(1) Long id) {
        Client client=clientRepository.getOne(id);client.setFlag(1);
        return ResponseEntity.created(apir.location(clientRepository.save(client).getClientname(),"/delclient/{id}")).body(new ApiResponse(true, "Client "+String.valueOf(id)+" successfully deleted "));

    }

    @GetMapping("/delemployee/{id}")
    ResponseEntity<?> delemployee(@PathVariable @Min(1) Long id) {

        Employee employee=employeeRepository.getOne(id);employee.setFlag(1);
        return ResponseEntity.created(apir.location(employeeRepository.save(employee).getFirstname(),"/delemployee/{id}")).body(new ApiResponse(true, "Employee "+String.valueOf(id)+" successfully deleted "));

    }
    @GetMapping("/delenterprise/{id}")
    ResponseEntity<?> delenterprise(@PathVariable @Min(1) Long id) {
        Enterprise enterprise=enterpriseRepository.getOne(id); enterpriseRepository.delete(enterpriseRepository.getOne(id));
        return ResponseEntity.created(apir.location(enterprise.getName(),"/delenterprise/{id}")).body(new ApiResponse(true, "Enterprise "+String.valueOf(id)+" successfully deleted "));
    }


    @PutMapping("/testobject") Object saveOrUpdateemployeetest(@RequestBody Object newObject) { return this.apir.saveTest(newObject);}
}
