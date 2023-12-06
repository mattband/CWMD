package DeliveryPerson;

import DeliveryDocket.DeliveryDocket;
import User.User;

public class DeliveryPerson {
    private String deliveryManId;
    private String phoneNumber;
    private DeliveryDocket deliveryDocketId;
    private String area;
    private User userId;

    
    public String getDeliveryManId() {
        return deliveryManId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public DeliveryDocket getDeliveryDocketId() {
        return deliveryDocketId;
    }

    public String getArea() {
        return area;
    }

    public User getUserId() {
        return userId;
    }
    
    public void setDeliverydocket(DeliveryDocket deliverydocket) {
        this.deliveryDocketId = deliverydocket;
    }
    
    
    public DeliveryPerson(String deliveryManId, String phoneNumber, DeliveryDocket deliveryDocket, String area, User userId){
        try{
            validateDeliveryManId(deliveryManId);
            
            this.deliveryManId = deliveryManId;
            this.phoneNumber = phoneNumber;
            this.deliveryDocketId = deliveryDocket;
            this.area = area;
            this.userId = userId;
            
        }catch(DeliveryPersonException e){
            e.printStackTrace();
        }
    }
    
    public static void validateDeliveryManId(String deliveryManId) throws DeliveryPersonException{
        if(deliveryManId.isEmpty()){
            throw new DeliveryPersonException("Delivery person's id is empty");
        }else if(deliveryManId.length() > 6){
            throw new DeliveryPersonException("Delivery person's id range is bigger than 6");
            
        }else if(deliveryManId.length() < 6){
            throw new DeliveryPersonException("Delivery person's id range is smaller than 6");
        }
        
    }
    
    public static void validateDeliveryManPhoneNumber(String phoneNumber) throws DeliveryPersonException{
        if(phoneNumber.isEmpty()){
            throw new DeliveryPersonException("Delivery person's phone number is empty");
        }else if(phoneNumber.length() < 10){
            throw new DeliveryPersonException("Delivery person's phone number range is smaller than 10");
            
        }else if(phoneNumber.length() > 15){
            throw new DeliveryPersonException("Delivery person's phone number range is bigger than 15");
        }
    }
    
    public static void validateDeliveryManDeliveryDocket(String deliveryDocket) throws DeliveryPersonException{
        if(deliveryDocket.isEmpty()){
            throw new DeliveryPersonException("Delivery person's has empty delivery docket");
        }else if(deliveryDocket.length() > 10){
            throw new DeliveryPersonException("Something went wrong");
        }
    }
    
    public static void validateDeliveryManArea(String area) throws DeliveryPersonException{
        if(area.isEmpty()){
            throw new DeliveryPersonException("Delivery person's has no assigned area");
        }
    }
    
    public static void validateDeliveryManUserId(String userId) throws DeliveryPersonException{
        if(userId.isEmpty()){
            throw new DeliveryPersonException("Delivery person's user id is empty");
        }else if(userId.length() < 5){
            throw new DeliveryPersonException("Delivery person's user id lesser than 5");
        }else if(userId.length() > 5){
            throw new DeliveryPersonException("Delivery person's user id is bigger than 5");
        }
    }
    
    public void updateDeliveryManId(String deliveryManId) throws DeliveryPersonException{
        try{
            validateDeliveryManId(deliveryManId);
        }catch(DeliveryPersonException e){
            throw new DeliveryPersonException("Fail to update delivery person's id");
        }
        
        this.deliveryManId = deliveryManId;
    }
    
    public void updatePhoneNumber(String phoneNumber) throws DeliveryPersonException{
        try{
            validateDeliveryManPhoneNumber(phoneNumber);
        }catch(DeliveryPersonException e){
            throw new DeliveryPersonException("Fail to update delivery person's phone number");
        }
        
        this.phoneNumber = phoneNumber;
    }
    
    public void updateDeliveryDocket(DeliveryDocket deliveryDocket) throws DeliveryPersonException{
        try{
            validateDeliveryManDeliveryDocket(deliveryDocket.getDeliveryDocketId());
        }catch(DeliveryPersonException e){
            throw new DeliveryPersonException("Fail to update delivery person's delivery docket");
        }
        
        this.deliveryDocketId = deliveryDocket;
    }
    
    public void updateDeliveryArea(String area) throws DeliveryPersonException{
        try{
            validateDeliveryManArea(area);
        }catch(DeliveryPersonException e){
            throw new DeliveryPersonException("Fail to update delivery person's area");
        }
        
        this.area = area;
    }
    
    public void updateDeliveryManUserId(User userId) throws DeliveryPersonException{
        try{
            validateDeliveryManUserId(userId.getUserId());
        }catch(DeliveryPersonException e){
            throw new DeliveryPersonException("Fail to update delivery person's user id");
        }
        
        this.userId = userId;
    }
    
}
