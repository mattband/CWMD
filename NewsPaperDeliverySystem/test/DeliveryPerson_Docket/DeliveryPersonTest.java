package DeliveryPerson_Docket;

import DeliveryDocket.DeliveryDocket;
import DeliveryPerson.DeliveryPerson;
import DeliveryPerson.DeliveryPerson;
import User.User;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;


public class DeliveryPersonTest extends TestCase{
 
        //Test number: 1
        //Test object: creating new delivery person account
        //inputs: id="DP0001", phone number="0831769221", delivery docket id = 1, arae = "Athlone", user id = 1
        //expected output: success
        //output: true
        @Test
        public void testDeliveryMan_DP0001(){
                DeliveryPerson object;
                DeliveryDocket deliveryDocketId = null;
                User userId = null;
                try{
                        DeliveryDocket deliveryDocket = new DeliveryDocket("D0001");
                        User user = new User("U0001");
                        object = new DeliveryPerson("DP0001", "0831769221", deliveryDocket, "Athlone", user);

                        assertEquals("DP0001", object.getDeliveryManId());
                        assertEquals("0831769221", object.getPhoneNumber());
                        assertEquals("D0001", object.getDeliveryDocketId().getDeliveryDocketId());
                        assertEquals("Athlone", object.getArea());
                        assertEquals("U0001", object.getUserId().getUserId());

                }catch(Exception e){  
                        fail("Something went wrong: " + e.getMessage());
                }
        }
    
        //Test number: 2
        //Test object: invalid delivery man id 
        //inputs: id="DP001"
        //expected output: fail
        //output: true
        @Test
        public void testDeliveryManId_DP001(){
                try{
                        DeliveryPerson.validateDeliveryManId("DP001");
                        fail("Error expected");
                }catch(Exception e){
                        assertEquals("Delivery Person name does not meet minimum length requirements - 6", e.getMessage());	
                }
        }
        
        //Test number: 3
        //Test object: valid delivery man id 
        //inputs: id="DP0001"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManId_DP0001(){
                try{
                        DeliveryPerson.validateDeliveryManId("DP0001");
                        
                }catch(Exception e){
                        fail("Error message:" + e.getMessage());
                        assertEquals("Delivery Person id does not meet minimum length requirements - 6", e.getMessage());	
                }
        }
        
        //Test number: 4
        //Test object: invalid delivery man phone number
        //inputs: id="083123456"
        //expected output: fail
        //output: true
        @Test
        public void testDeliveryManPhoneNumberFail(){
                try{
                        DeliveryPerson.validateDeliveryManPhoneNumber("083123456");
                        fail("Fail expected");
                }catch(Exception e){
                        assertEquals("Delivery Person phone number: ", e.getMessage());	
                }
        }
        
        //Test number: 5
        //Test object: valid delivery man phone number
        //inputs: id="0831234567"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManPhoneNumberTrue(){
                try{
                        DeliveryPerson.validateDeliveryManPhoneNumber("0831234567");
                       
                }catch(Exception e){
                        assertEquals("Delivery Person phone number: ", e.getMessage());	
                }
        }
        
        //Test number: 6
        //Test object: valid delivery man docket id
        //inputs: id="D0001"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManDeliveryDocketIdTrue(){
                try{
                        DeliveryPerson.validateDeliveryManDeliveryDocket("D0001");
                       
                }catch(Exception e){
                        assertEquals("Delivery Person delivery docket id: ", e.getMessage());	
                }
        }
        
         //Test number: 7
        //Test object: invalid delivery man delivery docket id
        //inputs: id="D00001"
        //expected output: fail
        //output: true
        @Test
        public void testDeliveryManDeliveryDocketIdFalse(){
                try{
                        DeliveryPerson.validateDeliveryManDeliveryDocket("D00001");
                        fail("fail expected");
                }catch(Exception e){
                        assertEquals("Delivery Person deluvery docket id: ", e.getMessage());	
                }
        }
        
        //Test number: 8
        //Test object: valid delivery man area
        //inputs: id="dublin"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManArea(){
                try{
                        DeliveryPerson.validateDeliveryManArea("Dublin");
                        
                }catch(Exception e){
                        assertEquals("Delivery Person deluvery docket id: ", e.getMessage());	
                }
        }
        
        //Test number: 9
        //Test object: valid delivery man user id
        //inputs: id="U0001"
        //expected output: true
        //output: true
        @Test
        public void testDeliveryManUserId(){
                try{
                        DeliveryPerson.validateDeliveryManUserId("U0001");
                        
                }catch(Exception e){
                        assertEquals("Delivery Person deluvery docket id: ", e.getMessage());	
                }
        }
    
}
