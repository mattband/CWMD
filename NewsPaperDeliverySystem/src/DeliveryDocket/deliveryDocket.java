package DeliveryDocket;

import matthew.Customer;
import matthew.OrderBook;
import matthew.Publication;

public class DeliveryDocket {
    private String deliverydocketId;
    private String deliveryStatus;
    private Customer customerId;
    private OrderBook orderBookId;
    private Publication publicationId;
    
    public DeliveryDocket() {}
    
    public DeliveryDocket(String deliveryDocketId){
        this.deliverydocketId = deliveryDocketId;
    }
    
    public String getDeliveryDocketId(){
        return deliverydocketId;
    }

    public void setDeliverydocketid(String deliverydocketid) {
        this.deliverydocketId = deliverydocketid;
    }

    public String getDeliverystatus() {
        return deliveryStatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliveryStatus = deliverystatus;
    }

    public Customer getCustomerid() {
        return customerId;
    }

    public void setCustomerid(Customer customerid) {
        this.customerId = customerid;
    }

    public OrderBook getOrderid() {
        return orderBookId;
    }

    public void setOrderid(OrderBook orderid) {
        this.orderBookId = orderid;
    }

    public Publication getPublicationid() {
        return publicationId;
    }

    public void setPublicationid(Publication publicationid) {
        this.publicationId = publicationid;
    }

    public DeliveryDocket(String deliveryDocketId, Publication publicationId, Customer customerId, OrderBook orderBookId, String deliveryStatus) {
        try {
            validateDeliveryDocketId(deliveryDocketId);
            this.deliverydocketId = deliveryDocketId;
            this.publicationId = publicationId;
            this.customerId = customerId;
            this.orderBookId = orderBookId;
            this.deliveryStatus = deliveryStatus;
        } catch (DeliveryDocketException e) {
            e.printStackTrace();
        }
    }
    
    public DeliveryDocket(Publication publicationId, Customer customerId, OrderBook orderId, String deliveryStatus) {
        try {
            validateDeliveryDocketId(deliverydocketId);
            this.publicationId = publicationId;
            this.customerId = customerId;
            this.orderBookId = orderId;
            this.deliveryStatus = deliveryStatus;
        } catch (DeliveryDocketException e) {
            e.printStackTrace();
        }
    }

    
    public static void validateDeliveryDocketId(String deliveryDocketId) throws DeliveryDocketException{
        if(deliveryDocketId.isEmpty()){
            throw new DeliveryDocketException("Delivery docket's id is empty");
            
        }else if(deliveryDocketId.length() < 5){
            throw new DeliveryDocketException("Delivery docket's id range is smaller than 5");
        }else if(deliveryDocketId.length() > 5){
            throw new DeliveryDocketException("Delivery docket's id range is bigger than 5");
        }
        
    }
    
    public static void validateDeliveryDocketPublicationId(String deliveryDocketPublicationId) throws DeliveryDocketException{
        if(deliveryDocketPublicationId.isEmpty()){
            throw new DeliveryDocketException("Delivery docket's publication id is empty");
        }else if(deliveryDocketPublicationId.length() > 5){
            throw new DeliveryDocketException("Delivery docket's publication id range is bigger than 5");
        }
        else if(deliveryDocketPublicationId.length() < 5){
            throw new DeliveryDocketException("Delivery docket's publication id range is smaller than 5");
        }
        
    }
    
    public static void validateDeliveryDocketCustomerId(String customerId) throws DeliveryDocketException{
        if(customerId.isEmpty()){
            throw new DeliveryDocketException("Delivery docket's has empty customer id");
        }else if(customerId.length() < 5){
            throw new DeliveryDocketException("Customer id range is smaller than 5");
        }else if(customerId.length() > 5 ){
            throw new DeliveryDocketException("Customer id range is bigger than 5");
        }
    }
    
    public static void validateDeliveryDocketOrderId(String orderId) throws DeliveryDocketException{
        if(orderId.isEmpty()){
            throw new DeliveryDocketException("Delivery person's has no order id");
        }else if(orderId.length() > 5){
            throw new DeliveryDocketException("Order id is bigger than 5");
        }else if(orderId.length() < 5){
            throw new DeliveryDocketException("Order id is smaller than 5");
        }
    }
    
    public static void validateDeliveryDocketStatus(String deliveryStatus) throws DeliveryDocketException{
        if(deliveryStatus.isEmpty()){
            throw new DeliveryDocketException("Delivery status is empty");
        }else if(deliveryStatus.length() < 0){
            throw new DeliveryDocketException("Delivery person's delivery status id lesser than 0");
        }
    }
    
    public void updatePublicationId(Publication publicationId) throws DeliveryDocketException{
        try{
            validateDeliveryDocketPublicationId(publicationId.getPublicationID());
        }catch(DeliveryDocketException e){
            throw new DeliveryDocketException("Fail to update delivery docket's publication id");
        }
        
        this.publicationId = publicationId;
    }
    
    public void updateDeliveryDocketCustomerId(Customer customerId) throws DeliveryDocketException{
        try{
            validateDeliveryDocketCustomerId("C00001");
        }catch(DeliveryDocketException e){
            throw new DeliveryDocketException("Fail to update delivery docket's customer id");
        }
        
        this.customerId = customerId;
    }
    
    public void updateDeliveryDocketOrderId(OrderBook orderId) throws DeliveryDocketException{
        try{
            validateDeliveryDocketOrderId("O0001");
        }catch(DeliveryDocketException e){
            throw new DeliveryDocketException("Fail to update delivery docket's area");
        }
        
        this.orderBookId = orderId;
    }
    
    public void updateDeliveryDocketDeliveryStatus(String deliveryStatus) throws DeliveryDocketException{
        try{
            validateDeliveryDocketStatus(deliveryStatus);
        }catch(DeliveryDocketException e){
            throw new DeliveryDocketException("Fail to update delivery docket's delivery status");
        }
        
        this.deliveryStatus = deliveryStatus;
    }
    
}

