package DeliveryPerson_Docket;

import DeliveryDocket.DeliveryDocket;
import DeliveryPerson.DeliveryPerson;
import User.User;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import matthew.Customer;
import matthew.OrderBook;
import matthew.Publication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class deliveryDocketTest extends TestCase{
     //Test number: 1
        //Test object: creating new delivery docket 
        //inputs: id="12", publication id ="8", customer id = "C00005", order id = "O0005",delivery status = pending
        //expected output: success
        //output: true
        @Test
        public void testDeliverydocket(){
                DeliveryDocket object;
                
                try{
                    Publication publication = new Publication("P0001");
                    Customer customer = new Customer("C0001");
                    OrderBook orderBook = new OrderBook("O0001");
                    
                        object = new DeliveryDocket("D0001", publication, customer , orderBook,"pending");

                        assertEquals("D0001", object.getDeliveryDocketId());
                        assertEquals("P0001", object.getPublicationid().getPublicationID());
                        assertEquals("C0001", object.getCustomerid().getCustomerID());
                        assertEquals("O0001", object.getOrderid().getOrderID());
                        assertEquals("pending", object.getDeliverystatus());

                }catch(Exception e){  
                        fail("Something went wrong: " + e.getMessage());
                }
        }
    
        //Test number: 2
        //Test object: valid delivery docket id 
        //inputs: id= 7
        //expected output: true
        //output: true
        @Test
        public void testDeliveryDocketId_D0002(){
                try{
                        DeliveryDocket.validateDeliveryDocketId("D0002");
                }catch(Exception e){
                        assertEquals("Delivery Person name does not meet minimum length requirements - 6", e.getMessage());	
                }
        }
        
        //Test number: 3
        //Test object: invalid delivery docket id 
        //inputs: id="D000001"
        //expected output: fail
        //output: true
        @Test
        public void DeliveryDocketId_D00001(){
                try{
                        DeliveryDocket.validateDeliveryDocketId("D000001");
                        fail("Fail expected");
                        
                }catch(Exception e){
                        fail("Error message:" + e.getMessage());
                        assertEquals("Delivery docket id does not meet maximum length requirements - 6", e.getMessage());	
                }
        }
        
        //Test number: 4
        //Test object: valid publication id 
        //inputs: id="7"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryDocketPublicationId(){
                try{
                        DeliveryDocket.validateDeliveryDocketPublicationId("P0001");
                       
                }catch(Exception e){
                        assertEquals("Delivery Person customer id: ", e.getMessage());	
                }
        }
        
        //Test number: 5
        //Test object: valid delivery docket Customer id 
        //inputs: id="C0001"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManPhoneNumberTrue(){
                try{
                        DeliveryDocket.validateDeliveryDocketCustomerId("C0001");
                       
                }catch(Exception e){
                        assertEquals("Delivery docket customer id: ", e.getMessage());	
                }
        }
        
        //Test number: 6
        //Test object: invalid delivery docket customer id
        //inputs: id="C000004"
        //expected output: fail
        //output: true
        @Test
        public void testDeliveryManDeliveryDocketIdTrue(){
                try{
                        DeliveryDocket.validateDeliveryDocketCustomerId("C000004");
                        fail("Fail Expected");
                }catch(Exception e){
                        assertEquals("Delivery Person delivery docket id: ", e.getMessage());	
                }
        }
        
         //Test number: 7
        //Test object: valid delivery docket order book 
        //inputs: id="O0004"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManDeliveryDocketIdFalse(){
                try{
                        DeliveryDocket.validateDeliveryDocketOrderId("O0004");
                }catch(Exception e){
                        assertEquals("Delivery docket order id: ", e.getMessage());	
                }
        }
        
        //Test number: 8
        //Test object: invalid delivery docket order id
        //inputs: id="O00004"
        //expected output: fail
        //output: true
        @Test
        public void testDeliveryManArea(){
                try{
                        DeliveryDocket.validateDeliveryDocketOrderId("O00004");
                        fail("Fail expected");
                }catch(Exception e){
                        assertEquals("Delivery docket order id: ", e.getMessage());	
                }
        }
        
        //Test number: 9
        //Test object: valid delivery status
        //inputs: "pending"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryDocketStatus(){
                try{
                        DeliveryDocket.validateDeliveryDocketStatus("Pending");
                        
                }catch(Exception e){
                        assertEquals("Delivery docket delivery status: ", e.getMessage());	
                }
        }
    
}
