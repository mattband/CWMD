package matthew;

//developer. Matthew devlin

import junit.framework.TestCase;

public class InvoiceTest extends TestCase {
	
	
	   
    // test number:1
    // test obj:Test case for invoiceID Valid
    // inputs: "12345"
    // ex output: true
    // output: true
    public void testValidateInvoiceID001() {
        try {
            assertTrue(Invoice.validateinvoiceID("12345"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    // test number:2
    // test obj:Test case for empty invoiceID
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceID002() {
        try {
            assertFalse(Invoice.validateinvoiceID(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid invoiceID.", e.getMessage());
        }
    }
    
    
    // test number:3
    // test obj:Test case for none numeric invoiceID
    // inputs: "abcde"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceIDI003() {
        try {
            assertFalse(Invoice.validateinvoiceID("abcde"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The invoice ID is not a valid integer. Please enter a correct 5-digit invoice ID.", e.getMessage());
        }
    }

    
    // test number:4
    // test obj:Test case for invoiceID too short
    // inputs: "1234"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceID004() {
        try {
            assertFalse(Invoice.validateinvoiceID("1234"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The invoice ID is invalid. Please enter a correct 5-digit invoice ID.", e.getMessage());
        }
    }

    
    // test number:5
    // test obj:Test case for InvoiceID too long
    // inputs: "123456"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceID005() {
        try {
            assertFalse(Invoice.validateinvoiceID("123456"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The invoice ID is invalid. Please enter a correct 5-digit invoice ID.", e.getMessage());
        }
    }
    
    // test number:6
    // test obj:Test case for InvoiceID within boundry
    // inputs: "123456"
    // ex output: true
    // output: true
    public void testValidateInvoiceID006() {
        try {
            assertTrue(Invoice.validateinvoiceID("56789"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    // test number:1
    // test obj:Test case for CustomerID Valid
    // inputs: "12345"
    // ex output: true
    // output: true
    public void testValidateCustomerID001() {
        try {
            assertTrue(Invoice.validateCustomerID("12345"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    // test number:2
    // test obj:Test case for empty CustomerID
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerID002() {
        try {
            assertFalse(Invoice.validateCustomerID(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid customerID.", e.getMessage());
        }
    }
    
    
    // test number:3
    // test obj:Test case for none numeric CustomerID
    // inputs: "abcde"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerID003() {
        try {
            assertFalse(Invoice.validateCustomerID("abcde"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is not a valid integer. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }

    
    // test number:4
    // test obj:Test case for CustomerID too short
    // inputs: "1234"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerID004() {
        try {
            assertFalse(Invoice.validateCustomerID("1234"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is invalid. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }

    
    // test number:5
    // test obj:Test case for CustomerID too long
    // inputs: "123456"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateCustomerID005() {
        try {
            assertFalse(Invoice.validateCustomerID("123456"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is invalid. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }
    
    // test number:6
    // test obj:Test case for CustomerID within boundry
    // inputs: "56789"
    // ex output: true
    // output: true
    public void testValidateCustomerID006() {
        try {
            assertTrue(Invoice.validateCustomerID("56789"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    // test number:1
    // test obj:Test case for OrderID Valid
    // inputs: "12345"
    // ex output: true
    // output: true
    public void testValidateOrderIDID001() {
        try {
            assertTrue(Invoice.validateOrderID("12345"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    // test number:2
    // test obj:Test case for empty OrderID
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateOrderIDID002() {
        try {
            assertFalse(Invoice.validateOrderID(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid Order ID.", e.getMessage());
        }
    }
    
    
    // test number:3
    // test obj:Test case for none numeric OrderID
    // inputs: "abcde"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateOrderIDID003() {
        try {
            assertFalse(Invoice.validateOrderID("abcde"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Order ID is not a valid integer. Please enter a correct 5-digit Order ID.", e.getMessage());
        }
    }

    
    // test number:4
    // test obj:Test case for OrderID too short
    // inputs: "1234"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateOrderIDID004() {
        try {
            assertFalse(Invoice.validateOrderID("1234"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Order ID is invalid. Please enter a correct 5-digit Order ID.", e.getMessage());
        }
    }

    
    // test number:5
    // test obj:Test case for OrderID too long
    // inputs: "123456"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateOrderIDID005() {
        try {
            assertFalse(Invoice.validateOrderID("123456"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Order ID is invalid. Please enter a correct 5-digit Order ID.", e.getMessage());
        }
    }
    
    // test number:6
    // test obj:Test case for OrderID within boundry
    // inputs: "56789"
    // ex output: true
    // output: true
    public void testValidateOrderIDID006() {
        try {
            assertTrue(Invoice.validateOrderID("56789"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    // test number:1
    // test obj:Test case for PublicationID Valid
    // inputs: "12345"
    // ex output: true
    // output: true
    public void testValidatePublicationID001() {
        try {
            assertTrue(Invoice.validatePublicationID("12345"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    
    // test number:2
    // test obj:Test case for empty PublicationID
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePublicationID002() {
        try {
            assertFalse(Invoice.validatePublicationID(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid publicationID.", e.getMessage());
        }
    }
    
    
    // test number:3
    // test obj:Test case for none numeric PublicationID
    // inputs: "abcde"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePublicationI003() {
        try {
            assertFalse(Invoice.validatePublicationID("abcde"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.", e.getMessage());
        }
    }

    
    // test number:4
    // test obj:Test case for PublicationID too short
    // inputs: "1234"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePublicationID004() {
        try {
            assertFalse(Invoice.validatePublicationID("1234"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The publication ID is invalid. Please enter a correct 5-digit publication ID.", e.getMessage());
        }
    }

    
    // test number:5
    // test obj:Test case for PublicationID too long
    // inputs: "123456"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePublicationID005() {
        try {
            assertFalse(Invoice.validatePublicationID("123456"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The publication ID is invalid. Please enter a correct 5-digit publication ID.", e.getMessage());
        }
    }
    
    // test number:6
    // test obj:Test case for PublicationID within boundry
    // inputs: "56789"
    // ex output: true
    // output: true
    public void testValidatePublicationID006() {
        try {
            assertTrue(Invoice.validatePublicationID("56789"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    // test number:1
    // test obj:Test case for InvoiceMessage within boundry
    // inputs: "ValidMessage123"
    // ex output: true
    // output: true
    public void testValidateInvoiceMessage001() {
        try {
            assertTrue(Invoice.validateInvoiceMessage("ValidMessage123"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    // test number:2
    // test obj:Test case for InvoiceMessage Empty
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceMessage002() {
        try {
            Invoice.validateInvoiceMessage("");
            fail("Expected exception not thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid invoiceMessage.", e.getMessage());
        }
    }
    // test number:3
    // test obj:Test case for InvoiceMessage too short
    // inputs: "Short"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceMessage003() {
        try {
            Invoice.validateInvoiceMessage("Short");
            fail("Expected exception not thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The invoiceMessage is invalid. Please enter a message between 10 and 100 characters.", e.getMessage());
        }
    }
    // test number:4
    // test obj:Test case for InvoiceMessage too long
    // inputs: "ThisIsAReallyLongMessageThatExceedsTheMaximumLengthOfOneHundredCharactersInOrderToTriggerAnException1" // 101 length 
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidateInvoiceMessage004() {
        try {
            String longMessage = "ThisIsAReallyLongMessageThatExceedsTheMaximumLengthOfOneHundredCharactersInOrderToTriggerAnException150morecharacterstoaddtothelinefortesting1234567890";
            Invoice.validateInvoiceMessage(longMessage);
            fail("Expected exception not thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The invoiceMessage is invalid. Please enter a message between 10 and 100 characters.", e.getMessage());
        }
    }
    
    // test number:1
    // test obj:Test case for price valid
    // inputs: "12.34"
    // ex output: true
    // output: true
    public void testValidatePrice001() {
        try {
            assertTrue(Invoice.validatePrice("12.34"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    
    // test number:2
    // test obj:Test case for empty price
    // inputs: ""
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePrice002() {
        try {
            assertFalse(Invoice.validatePrice(""));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid Price.", e.getMessage());
        }
    }

    // test number:3
    // test obj:Test case for not numeric price
    // inputs: "abc"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePrice003() {
        try {
            assertFalse(Invoice.validatePrice("abc"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Price is not a valid double. Please enter a correct Price.", e.getMessage());
        }
    }
    
    
    // test number:4
    // test obj:Test case for price too low
    // inputs: "0.99"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePrice004() {
        try {
            assertFalse(Invoice.validatePrice("0.99"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Price is invalid. Please enter a correct Price between 1.00 and 99.99.", e.getMessage());
        }
    }

    // test number:5
    // test obj:Test case for price too high
    // inputs: "1000.00"
    // ex output: ex message thrown
    // output: ex message thrown
    public void testValidatePrice005() {
        try {
            assertFalse(Invoice.validatePrice("1000.00"));
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Price is invalid. Please enter a correct Price between 1.00 and 99.99.", e.getMessage());
        }
    }

    // test number:6
    // test obj:Test case for price wthin boundry
    // inputs: "23.40"
    // ex output: true
    // output: true
    public void testValidatePrice006() {
        try {
            assertTrue(Invoice.validatePrice("23.40"));
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
