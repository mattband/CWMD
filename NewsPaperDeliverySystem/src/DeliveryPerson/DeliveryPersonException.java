package DeliveryPerson;

public class DeliveryPersonException extends Exception{
    String message;
    
    public DeliveryPersonException(String error_message){
        message = error_message;
    }
    
    public String getMessage(){
        return message;
    }
}
