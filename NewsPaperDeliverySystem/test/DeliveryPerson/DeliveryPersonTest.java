package DeliveryPerson;

import Entity.Deliverydocket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DeliveryPersonTest{
    
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

    @Test 
    //Test 1
    //Test if delivery is successful
    //expected to be successful
    //output = Successfuls
    public void deliveryStatus() {
        Deliverydocket deliverydocket = new Deliverydocket(1, "Successful");
       // Check if the deliverydocketids set correctly
        assertEquals(1, deliverydocket.getDeliverydocketid());

        // Check if the deliverystatus is set correctly
        assertEquals("Successful", deliverydocket.getDeliverystatus());
    }
    
    //Test 2
    //to check if theres no same data(e.g. Id)
    @Test
    public void testDeliverydocketEquals() {
        //same values
        Deliverydocket deliverydocket1 = new Deliverydocket(1, "Delivered");
        Deliverydocket deliverydocket2 = new Deliverydocket(1, "Delivered");

        //different value
        Deliverydocket deliverydocket3 = new Deliverydocket(2, "Calcel");

        //check if they are having the same values
        assertEquals(deliverydocket1, deliverydocket2);

        //check if this value is different
        assertNotEquals(deliverydocket1, deliverydocket3);
    }
    
}
