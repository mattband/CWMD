package matthew;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	
	
	/*
	 * junit 3 im using. advised not to code until the product skeleton and junit
	 * testcases for each methods are set up for your classes.
	 */
	
	
	// test number:1
	// test obj: Test case for valid Customer ID
	// inputs: "12345"
	// ex output: true
	// output: true
    public void testValidateCustomerID001() {
        try {
            boolean result = Customer.validateCustomerID("12345");
            assertTrue(result);
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
	// test number:2
	// test obj:Test case for invalid customer ID (not a number)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateCustomerID002() {
        try {
            Customer.validateCustomerID("abcde");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is not a valid integer. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }
	// test number:3
	// test obj:Test case for invalid Customer ID (not 5 digits)
	// inputs: "123456"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateCustomerID003() {
        try {
            Customer.validateCustomerID("123456");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is invalid. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }
	// test number:4
	// test obj:Test case for invalid Customer ID (empty)
	// inputs: ""
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateCustomerID004() {
        try {
            Customer.validateCustomerID("");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid customerID.", e.getMessage());
        }
    }
	// test number:1
	// test obj: Test case for valid publication ID
	// inputs: "12345"
	// ex output: true
	// output: true
    public void testValidatePublicationID001() {
        try {
            boolean result = Customer.validatePublicationID("12345");
            assertTrue(result);
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

	// test number:2
	// test obj:Test case for invalid Publication ID (not a number)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidatePublicationID002() {
        try {
            Customer.validatePublicationID("abcde");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.", e.getMessage());
        }
    }
	// test number:3
	// test obj:Test case for invalid publication ID (not 5 digits)
	// inputs: "123456"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidatePublicationID003() {
        try {
            Customer.validatePublicationID("123456");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The publication ID is invalid. Please enter a correct 5-digit publication ID.", e.getMessage());
        }
    }
	// test number:4
	// test obj:Test case for invalid publication ID (empty)
	// inputs: ""
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidatePublicationID004() {
        try {
            Customer.validatePublicationID("");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid publicationID.", e.getMessage());
        }
    }
    
    // test number:1
    // test obj:Test case for valid Name
    // inputs: "john Doe"
    // ex output: true
    // output: true
    public void testValidateCustomerName001() {
        try {
            assertTrue(Customer.validateCustomerName("John Doe"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    // test number:2
    // test obj:Test case for Name Empty
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerName002() {
        try {
            assertFalse(Customer.validateCustomerName(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid customerName.", e.getMessage());
        }
    }

    // test number:4
    // test obj:Test case for Name too short
    // inputs: "A"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerName004() {
        try {
            assertFalse(Customer.validateCustomerName("A"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customerName is invalid. Please enter a name between 1 and 20 characters.", e.getMessage());
        }
    }
    // test number:5
    // test obj:Test case for Name too long
    // inputs: "ThisIsAVeryLongCustomerName"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerName005() {
        try {
            assertFalse(Customer.validateCustomerName("ThisIsAVeryLongCustomerName"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customerName is invalid. Please enter a name between 1 and 20 characters.", e.getMessage());
        }
    }
    // test number:6
    // test obj:Test case for Name Boundary
    // inputs: "John"
    // ex output: true
    // output: true
    public void testValidateCustomerNameBoundary() {
        try {
            assertTrue(Customer.validateCustomerName("John"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    // test number:1
    // test obj:Test case for valid phone number
    // inputs: "1234567890"
    // ex output: true
    // output: true
    public void testValidatePhoneNumber001() {
        try {
            assertTrue(Customer.validatePhoneNumber("1234567890"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    // test number:2
    // test obj:Test case for empty phone number value
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePhoneNumber002() {
        try {
            assertFalse(Customer.validatePhoneNumber(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid phoneNumber.", e.getMessage());
        }
    }

    // test number:3
    // test obj:Test case for phone number too short
    // inputs: "12345"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePhoneNumber003() {
        try {
            assertFalse(Customer.validatePhoneNumber("12345"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The phoneNumber is invalid. Please enter a 10-digit phone number.", e.getMessage());
        }
    }
    // test number:4
    // test obj:Test case for phone number too long
    // inputs: "12345678901"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePhoneNumber004() {
        try {
            assertFalse(Customer.validatePhoneNumber("12345678901"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The phoneNumber is invalid. Please enter a 10-digit phone number.", e.getMessage());
        }
    }
    // test number:5
    // test obj:Test case for phone number not numeric
    // inputs: "1234abc567"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePhoneNumber005() {
        try {
            assertFalse(Customer.validatePhoneNumber("1234abc567"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The phoneNumber is invalid. Please enter a valid numeric phone number.", e.getMessage());
        }
    }
    // test number:6
    // test obj:Test case for phone number within boundary
    // inputs: "9876543210"
    // ex output: true
    // output: true
    public void testValidatePhoneNumberBoundary() {
        try {
            assertTrue(Customer.validatePhoneNumber("9876543210"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    

}
