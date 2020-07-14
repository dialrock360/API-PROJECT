package com.yemmback.store.controller;

import com.yemmback.store.model.*;
import com.yemmback.store.payload.reponse.*;
import com.yemmback.store.payload.request.*;
import com.yemmback.store.repository.*;
import com.yemmback.store.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */

@RestController
@RequestMapping("/api/polls")
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OperationRowRepository  operationRowRepository;
    
    @Autowired
    private BankStateRepository  bankStateRepository;
    
    @Autowired
    private EmployeeRepository  employeeRepository;

    @Autowired
    private OperationService operationService;

    private static final Logger logger = LoggerFactory.getLogger(OperationController.class);


    private static final ApiResponse apir = new ApiResponse();

    // Get All resources
    @GetMapping("/operations") List<OperationReponse> findAlloperations() { return operationService.findAlloperations(); }
    @GetMapping("/bankstates") List<BankStateReponse> findAllbankstates() { return operationService.findAllbankstates(); }
    @GetMapping("/stocktakings") List<Stocktaking> findAllstocktakings() { return operationService.findAllstocktakings(); }
    @GetMapping("/payments") List<PaymentReponse> findAllPayments() { return operationService.findAllPayments(); }
    @GetMapping("/oparionstates") List<OparionStateReponse> findAllOparionStates() { return operationService.findAllOparionStates(); }


    // Find by Id
    @GetMapping("/operation/{id}") OperationReponse getOperation(@PathVariable @Min(1) Long id) { return operationService.getOperation(id); }
    @GetMapping("/bankstate/{id}") BankStateReponse getBankstate(@PathVariable @Min(1) Long id) { return operationService.getBankstate(id); }
    @GetMapping("/stocktaking/{id}") Stocktaking getStocktaking(@PathVariable @Min(1) Long id) { return operationService.getStocktaking(id); }
    @GetMapping("/payment/{id}") PaymentReponse getPayment(@PathVariable @Min(1) Long id) { return operationService.getPayment(id); }
    @GetMapping("/oparionstate/{id}") OparionStateReponse getOparionState(@PathVariable @Min(1) Long id) { return operationService.getOparionState(id); }


    // Find resources by val
    @GetMapping("/operationsbydate/{dateoperation}") List<OperationReponse>  findAlloperationsbyDate(@PathVariable String operationdate) { return operationService.findAlloperationsbyDate(operationdate); }
    @GetMapping("/operationsbypaymentdate/{paymentDate}") List<OperationReponse>  findAlloperationsbyPaymentDate(@PathVariable String paymentDate) { return operationService.findAlloperationsbyDate(paymentDate); }
    @GetMapping("/operationsbyrangedate/{stardate}/{enddate}") List<OperationReponse>  findAlloperationsbyRangeDate(@PathVariable String stardate, @PathVariable String enddate ) { return operationService.findAlloperationsbyRangeDate(stardate,enddate); }
    @GetMapping("/operationsbyemployee/{employeeid}") List<OperationReponse>  findAlloperationsbyEmployeeReponse(@PathVariable Long employeeid) { return operationService.findAlloperationsbyEmployeeReponse(employeeid); }
    @GetMapping("/operationsbyclient/{clientid}") List<OperationReponse>  findAlloperationsbyClientReponse(@PathVariable Long clientid) { return operationService.findAlloperationsbyClientReponse(clientid); }
    @GetMapping("/operationsbyoperation/{operationReponse}") List<OperationReponse>  findAlloperationsbyoperationReponse(@PathVariable Long operationReponseid) { return operationService.findAlloperationsbyClientReponse(operationReponseid); }

    @GetMapping("/payments/{operationid}")  List<PaymentReponse>   getPaymentReponsebyoperationid(@PathVariable @Min(1) Long operationid) { return operationService.getPaymentReponsebyoperationid(operationid); }
    @GetMapping("/oparionstates/{operationid}")  List<OparionStateReponse>   getOparionstatesReponsebyoperationid(@PathVariable @Min(1) Long operationid) { return operationService.getOparionstatesReponsebyoperationid(operationid); }
    @GetMapping("/oparionstates/{categoryid}")  List<OparionStateReponse>   getOparionstatesReponsebycategoryid(@PathVariable @Min(1) Long categoryid) { return operationService.getOparionstatesReponsebycategoryid(categoryid); }

    @GetMapping("/stocktakingsbydate/{Stocktakingdate}") List<Stocktaking>  findAllStocktakingbyDate(@PathVariable String Stocktakingdate) { return operationService.findAllStocktakingbyDate(Stocktakingdate); }
    @GetMapping("/stocktakingsbyrangedate/{stardate}/{enddate}") List<Stocktaking>  findAllStocktakingbyRangeDate(@PathVariable String stardate, @PathVariable String enddate ) { return operationService.findAllStocktakingbyRangeDate(stardate,enddate); }





    // Save or update
    @PutMapping("/operation") ResponseEntity<?> saveOrUpdateoperation(@RequestBody OperationRequest newObject) { return operationService.saveOrUpdateoperation(newObject);}
    @PutMapping("/bankstate") ResponseEntity<?> saveOrUpdatebankstate(@RequestBody BankStateRequest newObject) { return operationService.saveOrUpdatebankstate(newObject);}
    @PutMapping("/stocktaking") ResponseEntity<?> saveOrUpdatestocktaking(@RequestBody StocktakingRequest newObject) { return operationService.saveOrUpdatestocktaking(newObject);}
    @PutMapping("/payment") ResponseEntity<?> saveOrUpdatepayment(@RequestBody PaymentRequest newObject) { return operationService.saveOrUpdatepayment(newObject);}
    @PutMapping("/oparionstate") ResponseEntity<?> saveOrUpdateoparionstate(@RequestBody OparionStateRequest newObject) { return operationService.saveOrUpdateoparionstate(newObject);}
    @PutMapping("/operationrow") ResponseEntity<?> saveOrUpdateOperationRow(@RequestBody OperationRowRequest newObject) { return operationService.saveOrUpdateOperationRow(newObject);}

    /*
    // Delete resoureces
    @GetMapping("/operation/{id}")
    ResponseEntity<?> deloperation(@PathVariable @Min(1) Long id) {
        Operation o=operationRepository.getOne(id);o.setFlag(1);
        return ResponseEntity.created(apir.location(operationRepository.save(o).getCategoryname(),"/operation/{id}")).body(new ApiResponse(true, "Operation "+String.valueOf(id)+" successfully deleted "));

    }
    @GetMapping("/bankstate/{id}")
    ResponseEntity<?> delbankstate(@PathVariable @Min(1) Long id) {
        BankState o=bankStateRepository.getOne(id);o.setFlag(1);
        return ResponseEntity.created(apir.location(operationRepository.save(o).getCategoryname(),"/operation/{id}")).body(new ApiResponse(true, "Operation "+String.valueOf(id)+" successfully deleted "));

    }


 */

}
