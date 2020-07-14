package com.yemmback.store.service;

import com.yemmback.store.exception.BadRequestException;
import com.yemmback.store.model.*;
import com.yemmback.store.model.colections.Gender;
import com.yemmback.store.model.colections.PieceName;
import com.yemmback.store.model.colections.Post;
import com.yemmback.store.payload.reponse.ApiResponse;
import com.yemmback.store.payload.reponse.ClientReponse;
import com.yemmback.store.payload.reponse.EmployeeReponse;
 import com.yemmback.store.repository.*;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EntrepriseService {
    private ClientReponse cr;
    private EmployeeReponse pr;
    private Enterprise enterprise ;
    private Employee employee;
    private Client client;
    private static final ApiResponse apir = new ApiResponse();



    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private ClientRepository clientRepository;

    @Autowired private EnterpriseRepository enterpriseRepository;
    @Autowired private OperationRepository operationRepository;
    @Autowired private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(EntrepriseService.class);

    // Get All resources
    
    public List<ClientReponse> getAllClients() {
        // Retrieve Clients
        List<ClientReponse> ls = new ArrayList<ClientReponse>();
        for (Client c : clientRepository.findClients(0)) {
            ls.add(this.bindClientReponse(c));
        }
        return ls;
    }

    public List<EmployeeReponse> getAllEmployees() {     // Retrieve Employees
        List<EmployeeReponse> ls = new ArrayList<EmployeeReponse>();
        for (Employee c : employeeRepository.findEmployees(0)) {
                ls.add(this.bindEmployeeReponse(c));

        }

        return ls;
    }

    public ClientReponse getClient(Long id){
       return this.bindClientReponse(clientRepository.getOne(id));
    }

    public EmployeeReponse getEmployee(Long id){ return this.bindEmployeeReponse(employeeRepository.getOne(id)); }

    public ClientReponse findClient(String tel){ return this.bindClientReponse(clientRepository.findClientByTel(tel)); }

    public EmployeeReponse findEmployee(String val){ return this.bindEmployeeReponse(employeeRepository.findEmployeeByAny(val)); }


    public ResponseEntity<?> saveEnterprise(Enterprise newEnterprise)  {
         // Retrieve Enterprises

        this.enterprise= new Enterprise();

        if(newEnterprise.getId()>0){
            this.enterprise = enterpriseRepository.getOne(newEnterprise.getId());
            if(this.enterprise.getId()>0){
                this.enterprise.setAdress(newEnterprise.getAdress().toLowerCase());
                this.enterprise.setCapital(newEnterprise.getCapital());
                this.enterprise.setEmail(newEnterprise.getEmail());
                this.enterprise.setName(newEnterprise.getName());
                this.enterprise.setJuridicForm(newEnterprise.getJuridicForm());
                this.enterprise.setNinea(newEnterprise.getNinea());
                this.enterprise.setPhones(newEnterprise.getPhones());
                this.enterprise.setRc(newEnterprise.getRc());
            }
        }else {
            this.enterprise = new  Enterprise( newEnterprise.getName(),newEnterprise.getJuridicForm(),newEnterprise.getPhones(),
                   newEnterprise.getEmail() , newEnterprise.getAdress(), newEnterprise.getRc(),newEnterprise.getNinea(),newEnterprise.getCapital()) ;
        }

        try {
            this.enterprise = enterpriseRepository.save(this.enterprise);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Enterprise {}", newEnterprise.getId(), this.enterprise.getId());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location(this.enterprise.getName(),"/enterprise")).body(new ApiResponse(true, "Enterprise saved successfully "+String.valueOf(enterprise.getId())));

    }


    public ResponseEntity<?> saveClient(ClientReponse c)  {
        // Retrieve Clients
        int ret;
        this.client= new Client();

        if(c.getId()==null){
            if(clientRepository.existsClientByTel(c.getTel().toLowerCase())) {
                return new ResponseEntity(new ApiResponse(false, "Client Tel is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }
            if(clientRepository.existsClientByEmail(c.getEmail())) {
                return new ResponseEntity(new ApiResponse(false, "Client Email is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }

            client = new Client(null, c.getClientname(),c.getNature(), c.getTel(), c.getEmail(), c.getAdress(), c.getDetail(),0, null);
        }else {
            client=clientRepository.getOne(c.getId());
            if(client.getId()>0){
                client.setClientname(c.getClientname());
                client.setNature(c.getNature());
                client.setTel(c.getTel().toLowerCase());
                client.setEmail(c.getEmail());
                client.setAdress(c.getAdress());
                client.setDetail(c.getDetail());
            }
        }
        try {
            this.client = clientRepository.save(this.client);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Client {}", c.getId(), this.client.getId());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location(this.client.getClientname(),"/client")).body(new ApiResponse(true, "Client saved successfully "+String.valueOf(client.getId())));

    }
    public ResponseEntity<?> saveEmployee(EmployeeReponse c)  {
        // Retrieve Clients
        int ret;

        if(c.getId()==null){
            if(employeeRepository.existsEmployeesByTel(c.getTel().toLowerCase())) {
                return new ResponseEntity(new ApiResponse(false, "Employee Tel is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }
            if(employeeRepository.existsEmployeeByNumpiece(c.getNumpiece())) {
                return new ResponseEntity(new ApiResponse(false, "Employee Num-piece is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }
            if(employeeRepository.existsEmployeesByMatricul(c.getMatricul())) {
                return new ResponseEntity(new ApiResponse(false, "Employee Matricul is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }
            if(employeeRepository.existsEmployeeByEmail(c.getEmail())) {
                return new ResponseEntity(new ApiResponse(false, "Employee Email is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }

             this.employee = new Employee(null, c.creatematricul(employeeRepository.count()), c.getFirstname(), c.getLastname(), c.getGender(), c.getPost(),
                     c.getBrday(),c.getTel(),c.getEmail(), c.getAdress(), c.getPiece() ,c.getNumpiece(),0);
        }else {
            this.employee=employeeRepository.getOne(c.getId());
            if(client.getId()>0){
                this.employee.setFirstname(c.getFirstname());
                this.employee.setLastname(c.getLastname());
                this.employee.setGender(c.getGender());
                this.employee.setPost(c.getPost());
                this.employee.setBrday(c.getBrday());
                this.employee.setEmail(c.getEmail());
                this.employee.setTel(c.getTel());
                this.employee.setPiece(c.getPiece());
                this.employee.setNumpiece(c.getNumpiece());
            }
        }

        try {
            this.employee = employeeRepository.save( this.employee);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Employee {}", c.getId(), this.employee.getId());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location(this.employee.getFirstname(),"/employee")).body(new ApiResponse(true, "Employee saved successfully "+String.valueOf(client.getId())));

    }
   /* */
/*



  
  */



    public ClientReponse bindClientReponse(Client c){
        return new  ClientReponse(c.getId(), c.getClientname(),c.getNature(), c.getTel(), c.getEmail(), c.getAdress(), c.getDetail(),operationRepository.findByClient(c.getId())) ;
     }

    private EmployeeReponse bindEmployeeReponse(Employee c){
        User u = userRepository.findUserByPeopleid(c.getId());
        return new  EmployeeReponse(c.getId(), c.getMatricul(), c.getFirstname(), c.getLastname(), c.getGender(),  c.getTel(),c.getPost(), c.getBrday(), c.getTel(), c.getEmail(), c.getAdress(), c.getPiece(), c.getNumpiece(), operationRepository.findByEmployee(u.getId()));
    }
}
