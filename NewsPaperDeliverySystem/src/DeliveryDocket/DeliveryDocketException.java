package DeliveryDocket;

public class DeliveryDocketException extends Exception{
    String message;
    
    public DeliveryDocketException(String error_message){
        message = error_message;
    }
    
    public String getMessage(){
        return message;
    }
}
