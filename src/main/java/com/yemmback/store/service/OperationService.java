package com.yemmback.store.service;

import com.yemmback.store.exception.BadRequestException;
import com.yemmback.store.exception.ResourceNotFoundException;
import com.yemmback.store.model.*;
import com.yemmback.store.model.colections.OperationType;
import com.yemmback.store.payload.reponse.*;
import com.yemmback.store.payload.request.*;
import com.yemmback.store.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperationService {
    private List<OperationReponse> operationResponse = new ArrayList<>();
    private Operation operation;
    private OparionState oparionstate;
    private OperationRow operationrow;
    private Payment payment;
    private Stocktaking stocktaking;
    private BankState bankState;

    private static final Logger logger = LoggerFactory.getLogger(OperationService.class);


    private static final ApiResponse apir = new ApiResponse();

    @Autowired private OperationRepository operationRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private OperationRowRepository operationRowRepository;
    @Autowired private OparionStateRepository oparionStateRepository;
    @Autowired private BankStateRepository  bankStateRepository;
    @Autowired private StocktakingRepository  stocktakingRepository;
    @Autowired private CategoryRepository  categoryRepository;
    @Autowired private EmployeeRepository  employeeRepository;
    @Autowired  private ProductRepository productRepository;
    @Autowired  private ClientRepository clientRepository;

 

    // Get All  resources


    public List<OperationReponse> findAlloperations() {
        List<OperationReponse> ls = new ArrayList<OperationReponse>();
        for (Operation c : operationRepository.findOperations(0)) {  ls.add(this.bindOperationReponse(c)); }
        return ls;
    }
    public List<BankStateReponse> findAllbankstates() {
        List<BankStateReponse> ls = new ArrayList<BankStateReponse>();
        for (BankState c : bankStateRepository.findAll()) {  ls.add(this.bindBankStateReponse(c)); }
        return ls;
    }
    public List<Stocktaking> findAllstocktakings() {
        return  stocktakingRepository.findAll();
    }
    public List<PaymentReponse> findAllPayments() {
        List<PaymentReponse> ls = new ArrayList<PaymentReponse>();
        for (Payment c : paymentRepository.findAll()) {  ls.add(this.bindPaymentReponse(c)); }
        return ls;
    }
    public List<OparionStateReponse> findAllOparionStates() {
        List<OparionStateReponse> ls = new ArrayList<OparionStateReponse>();
        for (OparionState c : oparionStateRepository.findAll()) {  ls.add(this.bindOparionStateReponse(c)); }
        return ls;
    }

    // Get All  resources by id
    public OperationReponse getOperation(Long id) { return this.bindOperationReponse(operationRepository.getOne(id)); }
    public BankStateReponse getBankstate(Long id) { return this.bindBankStateReponse(bankStateRepository.getOne(id)); }
    public Stocktaking getStocktaking(Long id) { return stocktakingRepository.getOne(id); }
    public PaymentReponse getPayment(Long id) { return this.bindPaymentReponse(paymentRepository.getOne(id)); }
    public OparionStateReponse getOparionState(Long id) { return this.bindOparionStateReponse(oparionStateRepository.getOne(id)); }

    public List<OperationReponse> findAlloperationsbyDate(String operationdate) {
         Date d = this.formatstringtoDate(operationdate);
        List<OperationReponse> ls = new ArrayList<OperationReponse>();
        for (Operation c : operationRepository.findOperationsByDate(d,0)) {  ls.add(this.bindOperationReponse(c)); }
        return ls;
    }


    public List<OperationReponse> findAlloperationsbyRangeDate(String stardate, String enddate) {
        Date sdate = this.formatstringtoDate(stardate);
        Date edate = this.formatstringtoDate(enddate);
        List<OperationReponse> ls = new ArrayList<OperationReponse>();
        for (Operation c : operationRepository.findAlloperationsbyRangeDate(sdate,edate)) {  ls.add(this.bindOperationReponse(c)); }
        return ls;
    }

    public List<OperationReponse> findAlloperationsbyEmployeeReponse(Long employeeid) {

        List<OperationReponse> ls = new ArrayList<OperationReponse>();
        for (Operation c : operationRepository.findByEmployee(employeeid)) {  ls.add(this.bindOperationReponse(c)); }
        return ls;
    }

    public List<OperationReponse> findAlloperationsbyClientReponse(Long clientid) {
        List<OperationReponse> ls = new ArrayList<OperationReponse>();
        for (Operation c : operationRepository.findOperationsbyClientid(clientid)) {  ls.add(this.bindOperationReponse(c)); }
        return ls;
    }

    public List<PaymentReponse> getPaymentReponsebyoperationid(Long operationid) {
        List<PaymentReponse> ls = new ArrayList<PaymentReponse>();
        for (Payment c : paymentRepository.findPaymentsByOperation(operationRepository.getOne(operationid))) {  ls.add(this.bindPaymentReponse(c)); }
        return ls;
    }
    public List<OparionStateReponse> getOparionstatesReponsebyoperationid(Long operationid) {
        List<OparionStateReponse> ls = new ArrayList<OparionStateReponse>();
        for (OparionState c : oparionStateRepository.findOparionStatesByOperation(operationRepository.getOne(operationid))) {  ls.add(this.bindOparionStateReponse(c)); }
        return ls;
    }

    public List<OparionStateReponse> getOparionstatesReponsebycategoryid(Long categoryid) {
        List<OparionStateReponse> ls = new ArrayList<OparionStateReponse>();
        for (OparionState c : oparionStateRepository.findOparionStatesByCategory(categoryRepository.getOne(categoryid))) {  ls.add(this.bindOparionStateReponse(c)); }
        return ls;
    }

    public List<Stocktaking> findAllStocktakingbyDate(String stocktakingdate) {
        Date d = this.formatstringtoDate(stocktakingdate);
     return stocktakingRepository.findStocktakingsByDateStk(d);
    }


    public List<Stocktaking> findAllStocktakingbyRangeDate(String stardate, String enddate) {
        Date sdate = this.formatstringtoDate(stardate);
        Date edate = this.formatstringtoDate(enddate);
        return stocktakingRepository.findAllStocktakingbyRangeDate(sdate,edate);
    }

    public OperationReponse bindOperationReponse(Operation o){
        List<Operation> operationchildren =(o.getOperationparent()!=null)? operationRepository.findOperationsByOperationparent(o) :null;
        List<Payment> payments = paymentRepository.findPaymentsByOperation(o) ;
        List<OperationRow> operationrows = operationRowRepository.findOperationRowsByOperation(o) ;
        Employee employee = (o.getCreatedBy()!=null && o.getCreatedBy()>0)?employeeRepository.getOne(o.getCreatedBy()) : new Employee();

        return  new OperationReponse(o.getId(), o.getOperationtype(), o.getCreatedAt(),o.isPayable(), o.getPaymentDate(), o.getObjet(),
                o.getTva(), o.getTotalHt(), o.getTotalTtc(), o.getStatus(), o.getFlag(), o.getClient(),employee, o.getOperationparent(),
                payments, operationrows, operationchildren);
     }
    private BankStateReponse bindBankStateReponse(BankState c) {
        return new BankStateReponse(c.getId(), c.getSpent() ,   c.getGain() ,   c.getVirtualBank() ,  c.getRealBank() ,  c.getDateState() );
    }
    private PaymentReponse bindPaymentReponse(Payment c) {
        return  new PaymentReponse(c.getId(), c.getSubject(), c.getPaymentdate(),c.getDeadline(), c.getAmount(), c.getRest(), c.getPart(), c.getOperation().getId()  );
    }
    private OparionStateReponse bindOparionStateReponse(OparionState c) {
        return  new OparionStateReponse(c.getId(), c.getSpent(), c.getGain(), c.getCheckout(), c.getDateState(), c.getCategory()) ;
    }
    private Date formatstringtoDate(String sdate){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
         return null;
    }


    public ResponseEntity<?> saveOrUpdatebankstate(BankStateRequest newObject) {
        if(newObject.getId()>0){ 
            this.bankState = bankStateRepository.findById(newObject.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bankstate", "id", newObject.getId()));
            if(newObject.getId()>0){
                this.bankState.setUpdatedAt((Instant.now()));
                this.bankState.setSpent(newObject.getSpent());
                this.bankState.setDateState(newObject.getDateState());
                this.bankState.setGain(newObject.getGain());
                this.bankState.setRealBank(newObject.getRealBank());
                this.bankState.setVirtualBank(newObject.getVirtualBank());
            }
        }else {

            if(bankStateRepository.existsBankStateBySpentAndGainAndDateStateAndRealBankAndVirtualBank(newObject.getSpent(), newObject.getGain(), newObject.getDateState(), newObject.getRealBank(), newObject.getVirtualBank())) {
                return new ResponseEntity(new ApiResponse(false, "BankState name is already exist!"),
                        HttpStatus.BAD_REQUEST);
            }

            this.bankState = new BankState(null, newObject.getSpent(),newObject.getGain(), newObject.getVirtualBank(), newObject.getRealBank(), newObject.getDateState()) ;
        }
        try {
            this.bankState = bankStateRepository.save(this.bankState);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Bankstate {}", newObject.getDateState(), this.bankState.getVirtualBank());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location( String.valueOf(this.bankState.getVirtualBank()),"/newObject")).body(new ApiResponse(true, "Bankstate saved successfully "+String.valueOf(newObject.getId())));


    }

    public ResponseEntity<?> saveOrUpdatestocktaking(StocktakingRequest newObject) {

        if(newObject.getId()>0){ 

            this.stocktaking = stocktakingRepository.findById(newObject.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Stocktaking", "id", newObject.getId()));
            if(stocktaking.getId()>0){
                this.stocktaking.setDateStk(newObject.getDateStk());
                this.stocktaking.setState(newObject.getStockState());
                this.stocktaking.setUpdatedAt(Instant.now());
            }
        }else {

            if(stocktakingRepository.existsStocktakingByDateStk(newObject.getDateStk())) {
                return new ResponseEntity(new ApiResponse(false, "This Stocktaking is already exist please delete before!"),
                        HttpStatus.BAD_REQUEST);
            }

            this.stocktaking = new Stocktaking(null, newObject.getDateStk(), productRepository.findAll()) ;
        }
        try {
            this.stocktaking = stocktakingRepository.save(this.stocktaking);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in  StockState {}", newObject.getDateStk(), this.stocktaking.getStockState());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location( this.stocktaking.getDateStk().toString(),"/stocktaking")).body(new ApiResponse(true, "StockState saved successfully "+String.valueOf(stocktaking.getId())));

    }

    public ResponseEntity<?> saveOrUpdatepayment(PaymentRequest newObject) {
        if(!operationRepository.existsOperationById(newObject.getOperationid())) {
            return new ResponseEntity(new ApiResponse(false, "Operation is not check!"),
                    HttpStatus.BAD_REQUEST);
        }


        if(newObject.getId()>0){ 

            this.payment = paymentRepository.findById(newObject.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", newObject.getId()));
            if(newObject.getId()>0){
                this.payment.setRest(newObject.getRest());
                this.payment.setPaymentdate(newObject.getPaymentdate());
                this.payment.setAmount(newObject.getAmount());
                this.payment.setDeadline(newObject.getDeadline());
                this.payment.setPart(newObject.getPart());
                this.payment.setSubject(newObject.getSubject());
            }
        }else {

            if(paymentRepository.countPaymentByAmountAndRestAndPartAndDeadlineAndPaymentdate(newObject.getAmount(),newObject.getRest(),newObject.getPart(),newObject.getDeadline(),newObject.getPaymentdate())) {
                return new ResponseEntity(new ApiResponse(false, "Payment name is already existe!"),
                        HttpStatus.BAD_REQUEST);
            }
            Operation operation= operationRepository.getOne(newObject.getOperationid());
            this.payment = new Payment(null, newObject.getSubject(), newObject.getDeadline(),newObject.getPaymentdate(), newObject.getAmount(), newObject.getRest(), (paymentRepository.countPaymentByOperation(operation)+1), newObject.getState(), operation) ;

        }
        try {
            this.payment = paymentRepository.save(this.payment);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Payment {}", newObject.getSubject(), this.payment.toString());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location( this.payment.getSubject(),"/payment")).body(new ApiResponse(true, "Payment saved successfully "+String.valueOf(newObject.getId())));


    }

    public ResponseEntity<?> saveOrUpdateOperationRow(OperationRowRequest newObject) {

        if(!operationRepository.existsOperationById(newObject.getOperationid())) {
            return new ResponseEntity(new ApiResponse(false, "Operation is not check!"),
                    HttpStatus.BAD_REQUEST);
        }
        if(!productRepository.existsProductById(newObject.getProductid())) {
            return new ResponseEntity(new ApiResponse(false, "Operation is not check!"),
                    HttpStatus.BAD_REQUEST);
        }
          this.operation=operationRepository.getOne(newObject.getOperationid());
        Product product =productRepository.getOne(newObject.getProductid());

        if(newObject.getId()>0){ 

            this.operationrow = operationRowRepository.findById(newObject.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("OperationRow", "id", newObject.getId()));
            if(newObject.getId()>0){
                this.operationrow.setMount(newObject.getMount());
                this.operationrow.setPrice(newObject.getPrice());
                this.operationrow.setQuantity(newObject.getQuantity());
                this.operationrow.setOperation(this.operation);
                this.operationrow.setProduct(product);
            }
        }else {

            this.operationrow = new OperationRow(null,newObject.getPrice(),newObject.getQuantity(), newObject.getMount(), this.operation, product) ;
        }
        try {
            this.operationrow = operationRowRepository.save(this.operationrow);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in OperationRow {}", newObject.getId(), this.operationrow.toString());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location( this.operationrow.toString(),"/operationrow")).body(new ApiResponse(true, "OperationRow saved successfully "+String.valueOf(newObject.getId())));


    }

    public ResponseEntity<?> saveOrUpdateoparionstate(OparionStateRequest newObject) {
        Category category =categoryRepository.getOne(newObject.getCategoryid());
        Operation operation=operationRepository.getOne(newObject.getOperationid());
        if(newObject.getId()>0){

            this.oparionstate= oparionStateRepository.findById(  newObject.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Oparion State", "id", newObject.getId()));
            if(newObject.getId()>0){
                this.oparionstate.setCategory(category);
                this.oparionstate.setOperation(operation);
                this.oparionstate.setSpent(newObject.getSpent());
                this.oparionstate.setGain(newObject.getGain());
                this.oparionstate.setCheckout(newObject.getCheckout());
            }
        }else {

            if(oparionStateRepository.existsOparionStateBySpentAndGainAndCheckoutAndDateStateAndCategoryAndOperation(newObject.getSpent(), newObject.getGain(),newObject.getCheckout(), newObject.getDateState(),category,operation)) {
                return new ResponseEntity(new ApiResponse(false, "Oparion State   is already seted!"),
                        HttpStatus.BAD_REQUEST);
            }

            this.oparionstate= new OparionState(null, newObject.getSpent(), newObject.getGain(), newObject.getCheckout(), newObject.getDateState(),category,operation) ;
        }
        try {
            this.oparionstate= oparionStateRepository.save( this.oparionstate);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in OparionState {}", newObject.getId(),  this.oparionstate.toString());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location( this.oparionstate.toString(),"/oparionstate")).body(new ApiResponse(true, "Oparion State saved successfully "+String.valueOf(newObject.getId())));


    }

    public ResponseEntity<?> saveOrUpdateoperation(OperationRequest newObject) {

        if(!clientRepository.existsClientById(newObject.getClientid())) {
            return new ResponseEntity(new ApiResponse(false, "Client is not check!"),
                    HttpStatus.BAD_REQUEST);
        }
        Client client = clientRepository.getOne(newObject.getClientid());
        Operation operationparent =(operationRepository.existsById((newObject.getIdoperationparent()>0)?newObject.getIdoperationparent():0))? operationRepository.getOne(newObject.getIdoperationparent()):null;
        if(newObject.getId()>0){

            this. operation =  operationRepository.findById(newObject.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Operation", "id", newObject.getId()));
            if( operation.getId()>0){
                this. operation.setOperationparent(operationparent);
                this. operation.setPayable(newObject.isPayable());
                this. operation.setOperationdate(newObject.getOperationdate());
                this. operation.setPaymentDate(newObject.getPaymentDate());
                this. operation.setObjet(newObject.getObjet());
                this. operation.setTva(newObject.getTva());
                this. operation.setTotalHt(newObject.getTotalHt());
                this. operation.setTotalHt(newObject.getTotalTtc());
                this. operation.setStatus(newObject.getStatus());
            }

        }else {
/*
            if( operationRepository.existsConditioningByConditioningname(newObject.getConditioningname())) {
                return new ResponseEntity(new ApiResponse(false, "Conditioning name is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }
*/
            this. operation = new  Operation(null, newObject.getOperationtype(), newObject.getPaymentDate(),
            newObject.isPayable(), newObject.getPaymentDate(),newObject.getObjet(),newObject.getTva(),
                    newObject.getTotalTtc(), newObject.getTotalTtc(), newObject.getStatus(), 0,  client,  operationparent, null, null, null);

        }
        try {
            this. operation =  operationRepository.save(this. operation);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Sorry {} has not save in Conditioning {}", newObject.getId(), this. operation.toString());
            throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
        }
        return ResponseEntity.created(apir.location( this. operation.toString(),"/operation")).body(new ApiResponse(true, "Conditioning saved successfully "+String.valueOf( operation.getId())));


    }

}
