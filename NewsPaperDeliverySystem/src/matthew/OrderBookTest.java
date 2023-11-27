package matthew;

import junit.framework.TestCase;

public class OrderBookTest extends TestCase {

	/*
	 * junit 3 im using. advised not to code until the product skeleton and junit
	 * testcases for each methods are set up for your classes.
	 */
	
	
	 
	// test number:1
	// test obj: Test case for valid Order ID
	// inputs: "12345"
	// ex output: true
	// output: true
    public void testValidateOrderID001() {
        try {
            boolean result = OrderBook.validateOrderID("12345");
            assertTrue(result);
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

	// test number:2
	// test obj:Test case for invalid Order ID (not a number)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderID002() {
        try {
            OrderBook.validateOrderID("abcde");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Order ID is not a valid integer. Please enter a correct 5-digit Order ID.", e.getMessage());
        }
    }
	// test number:3
	// test obj:Test case for invalid Order ID (not 5 digits)
	// inputs: "123456"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderID003() {
        try {
            OrderBook.validateOrderID("123456");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The Order ID is invalid. Please enter a correct 5-digit Order ID.", e.getMessage());
        }
    }
	// test number:4
	// test obj:Test case for invalid Order ID (empty)
	// inputs: ""
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderID004() {
        try {
            OrderBook.validateOrderID("");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid Order ID.", e.getMessage());
        }
    }


	// test number:1
	// test obj: Test case for valid customer ID
	// inputs: "12345"
	// ex output: true
	// output: true
    public void testValidateCustomerID001() {
        try {
            boolean result = OrderBook.validateCustomerID("12345");
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
            OrderBook.validateCustomerID("abcde");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is not a valid integer. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }
	// test number:3
	// test obj:Test case for invalid customer ID (not 5 digits)
	// inputs: "123456"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateCustomerID003() {
        try {
            OrderBook.validateCustomerID("123456");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The customer ID is invalid. Please enter a correct 5-digit customer ID.", e.getMessage());
        }
    }
	// test number:4
	// test obj:Test case for invalid customer ID (empty)
	// inputs: ""
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateCustomerID004() {
        try {
            OrderBook.validateCustomerID("");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid customerID.", e.getMessage());
        }
    }
    
	// test number:1
	// test obj: Test case for valid customer ID
	// inputs: "12345"
	// ex output: true
	// output: true
    public void testValidatePublicationID001() {
        try {
            boolean result = OrderBook.validatePublicationID("12345");
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
            OrderBook.validatePublicationID("abcde");
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
            OrderBook.validatePublicationID("123456");
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
            OrderBook.validatePublicationID("");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid publicationID.", e.getMessage());
        }
    }
	// test number:1
	// test obj:Test case for valid order Price
	// inputs: "15.50"
	// ex output: true
	// output: true
    public void testValidateOrderPrice001() {
        try {
            boolean result = OrderBook.validateOrderPrice("15.50");
            assertTrue(result);
        } catch (NewsAgentExceptionHandler e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
	// test number:2
	// test obj: Test case for invalid order Price (not a number)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderPrice002() {
        try {
            OrderBook.validateOrderPrice("abcde");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The order Price is not a valid integer. Please enter a price.", e.getMessage());
        }
    }
	// test number:3
	// test obj: Test case for invalid order Price (below range)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderPrice003() {
        try {
            OrderBook.validateOrderPrice("0.50");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The order Price is invalid. Please enter a correct 5-digit order Price.", e.getMessage());
        }
    }
	// test number:4
	// test obj: Test case for invalid order Price (above range)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderPrice004() {
        try {
            OrderBook.validateOrderPrice("100.00");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("The order Price is invalid. Please enter a correct 5-digit order Price.", e.getMessage());
        }
    }
	// test number:5
	// test obj: Test case for invalid order Price (empty)
	// inputs: "abcde"
	// ex output: ex thrown message
	// output: ex thrown message
    public void testValidateOrderPrice005() {
        try {
            OrderBook.validateOrderPrice("");
            fail("Expected NewsAgentExceptionHandler, but no exception was thrown.");
        } catch (NewsAgentExceptionHandler e) {
            assertEquals("Please enter a valid order Price.", e.getMessage());
        }
    }
    
	// test number:1
	// test obj: valid input boundary value analysis
	// inputs: "dog on a boat is yop" // 20 length
	// ex output: true
	// output: true

	public void testvalidateOrderSchedule001() {
		OrderBook in = new OrderBook();

		String input = "dog on a boat is yop";
		try {
			boolean results = in.validateOrderShedule(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:2
	// test obj: invalid input boundary value analysis
	// inputs: "dog0is0the0gro" // 14 length
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateOrderSchedule002() {
		OrderBook in = new OrderBook();
		String output = "Please enter a correct time and date for the delivery within 15 to 50 characters";
		String input = "dog is the gr0";
		try {
			boolean results = in.validateOrderShedule(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.message, output);

		}
	}

	// test number:3
	// test obj: valid input boundary value analysis
	// inputs: "dog is the gron" // 15 length
	// ex output: true
	// output: true

	public void testvalidateOrderSchedule003() {
		OrderBook in = new OrderBook();
		String input = "dog is the gron";
		try {
			boolean results = in.validateOrderShedule(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:4
	// test obj: valid input boundary value analysis
	// inputs:
	// "dog on a boat going mad on the water absolute ngl" // 50
	// // 50 length
	// ex output: true
	// output: true

	public void testvalidateOrderSchedule004() {
		OrderBook in = new OrderBook();
		String input = "dog on a boat going mad on the water absolute nglo";
		try {
			boolean results = in.validateOrderShedule(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:5
	// test obj: invalid input boundary value analysis
	// inputs:
	// "dog on a boat going mad on the water absolute ngly"
	// // 51 length
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateOrderSchedule005() {
		OrderBook in = new OrderBook();
		String output = "Please enter a correct time and date for the delivery within 15 to 50 characters";

		String input = "dog on a boat going mad on the water absolute ngly3";
		try {
			boolean results = in.validateOrderShedule(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.message, output);

		}
	}
	
	// write the test details. 
    public void testValidateCustomerAndPublicationSameBothNull() {
        boolean result = OrderBook.validateCustomerAndPublicationSame(null, null);
        assertFalse(result);
    }

    public void testValidateCustomerAndPublicationSameCustomerNull() {
        boolean result = OrderBook.validateCustomerAndPublicationSame(null, "12345");
        assertFalse(result);
    }

    public void testValidateCustomerAndPublicationSamePublicationNull() {
        boolean result = OrderBook.validateCustomerAndPublicationSame("12345", null);
        assertFalse(result);
    }

    public void testValidateCustomerAndPublicationSameDifferentValues() {
        boolean result = OrderBook.validateCustomerAndPublicationSame("12345", "67890");
        assertFalse(result);
    }

    public void testValidateCustomerAndPublicationSameSameValues() {
        boolean result = OrderBook.validateCustomerAndPublicationSame("12345", "12345");
        assertTrue(result);
    }
}
