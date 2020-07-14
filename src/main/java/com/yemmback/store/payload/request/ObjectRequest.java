package com.yemmback.store.payload.request;

public class ObjectRequest {


    private BankStateRequest bankStateRequest;
    private CategoryRequest categoryRequest;
    private ClientRequest clientRequest;
    private ConditioningRequest conditioningRequest;
    private OparionStateRequest oparionStateRequest;
    private EmployeeRequest employeeRequest;
    private OperationRequest operationRequest;
    private OperationRowRequest operationRowRequest;
    private PaymentRequest paymentRequest;
    private ProductRequest productRequest;
    private StocktakingRequest stocktakingRequest;

    public ObjectRequest() {
    }

    public BankStateRequest getBankStateRequest() {
        return bankStateRequest;
    }

    public void setBankStateRequest(BankStateRequest bankStateRequest) {
        this.bankStateRequest = bankStateRequest;
    }

    public CategoryRequest getCategoryRequest() {
        return categoryRequest;
    }

    public void setCategoryRequest(CategoryRequest categoryRequest) {
        this.categoryRequest = categoryRequest;
    }

    public ClientRequest getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    public ConditioningRequest getConditioningRequest() {
        return conditioningRequest;
    }

    public void setConditioningRequest(ConditioningRequest conditioningRequest) {
        this.conditioningRequest = conditioningRequest;
    }

    public OparionStateRequest getOparionStateRequest() {
        return oparionStateRequest;
    }

    public void setOparionStateRequest(OparionStateRequest oparionStateRequest) {
        this.oparionStateRequest = oparionStateRequest;
    }

    public EmployeeRequest getEmployeeRequest() {
        return employeeRequest;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }

    public OperationRequest getOperationRequest() {
        return operationRequest;
    }

    public void setOperationRequest(OperationRequest operationRequest) {
        this.operationRequest = operationRequest;
    }

    public OperationRowRequest getOperationRowRequest() {
        return operationRowRequest;
    }

    public void setOperationRowRequest(OperationRowRequest operationRowRequest) {
        this.operationRowRequest = operationRowRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    public ProductRequest getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(ProductRequest productRequest) {
        this.productRequest = productRequest;
    }

    public StocktakingRequest getStocktakingRequest() {
        return stocktakingRequest;
    }

    public void setStocktakingRequest(StocktakingRequest stocktakingRequest) {
        this.stocktakingRequest = stocktakingRequest;
    }
}
