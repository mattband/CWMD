package DeliveryPerson;

import DeliveryDocket.DeliveryDocket;
import DeliveryPerson.DeliveryPerson;
import User.User;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DeliveryPersonTest extends TestCase{
    
        public DeliveryPersonTest() {
        }

        @BeforeAll
        public static void setUpClass() {
        }

        @AfterAll
        public static void tearDownClass() {
        }

        @BeforeEach
        public void setUp() {
        }

        @AfterEach
        public void tearDown() {
        }


        //Test number: 1
        //Test object: creating new delivery person account
        //inputs: id="D00002", phone number="0831769221", delivery docket id = 1, arae = "Athlone", user id = 1
        //expected output: success
        //output: true
        @Test
        public void testDeliveryMan_D00001(){
                DeliveryPerson object;

                try{
                        DeliveryDocket deliveryDocket = new DeliveryDocket(1);
                        User user = new User(1);
                        object = new DeliveryPerson("D00002", "0831769221", deliveryDocket, "Athlone", user);

                        assertEquals("D00002", object.getDeliveryManId());
                        assertEquals("0831769221", object.getPhoneNumber());
                        assertEquals(1, object.getDeliveryDocketId().getDeliveryDocketId());
                        assertEquals("Athlone", object.getArea());
                        assertEquals(1, object.getUserId().getUserId());

                }catch(Exception e){  
                        fail("Something went wrong: " + e.getMessage());
                }
        }
    
        //Test number: 2
        //Test object: invalid delivery man id 
        //inputs: id="D0001"
        //expected output: fail
        //output: true
        @Test
        public void testDeliveryManId_D00001(){
                try{
                        DeliveryPerson.validateDeliveryManId("D0001");
                        fail("Error expected");
                }catch(Exception e){
                        assertEquals("Delivery Person name does not meet minimum length requirements - 6", e.getMessage());	
                }
        }
        
        
        
    
}
