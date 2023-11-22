package orderBook_Matt;

import junit.framework.TestCase;

public class OrderBookTest extends TestCase {

	/*
	 * junit 3 im using. advised not to code until the product skeleton and junit
	 * testcases for each methods are set up for your classes.
	 */

	// ValidateOrderID checking that 5 in length and numbers valid ==> else is invalid.
	// test number:1
	// test obj:valid input boundary value analysis
	// inputs: "0001"
	// ex output: true
	// output: true

	public void testvalidateOrderID001() {

		OrderBook in = new OrderBook();

		String input = "00001";
		try {
			boolean results = in.validateOrderID(input);
			assertEquals(true, results);
		} catch (Exception e) {
			fail("something went wrong");
		}
	}

	// test number:2
	// test obj: invalid input boundary value analysis
	// inputs: "123456789"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateOrderID002() {
		String output = "The Order id is invalid. Please enter a correct orderID.";
		OrderBook in = new OrderBook();

		String input = "123456789";

		try {
			boolean results = in.validateOrderID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:3
	// test obj: invalid input boundary value analysis
	// inputs: "0"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateOrderID003() {
		String output = "The Order id is invalid. Please enter a correct orderID.";
		OrderBook in = new OrderBook();

		String input = "0";

		try {
			boolean results = in.validateOrderID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:4
	// test obj: invalid input boundary value analysis
	// inputs: ""
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateOrderID004() {
		String output = "Please enter a valid Order ID. of 5 in length.";
		OrderBook in = new OrderBook();

		String input ="";

		try {
			boolean results = in.validateOrderID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:5
	// test obj:valid input boundary value analysis
	// inputs: "dvkje"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateOrderID005() {
		String output = "The Order id is invalid. Please enter a correct orderID.";
		OrderBook in = new OrderBook();

		String input ="dvkje";

		try {
			boolean results = in.validateOrderID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}
	// validateCustomerID checking that 5 in length and number valid ==> else is invalid.
	// test number:1
	// test obj:valid input boundary value analysis
	// inputs: "00001"
	// ex output: true
	// output: true

	public void testvalidateCustomerID001() {
		OrderBook in = new OrderBook();

		String input = "00001";
		try {
			boolean results = in.validateCustomerID(input);
			assertEquals(true, results);

		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");
		}
	}

	// test number:2
	// test obj: invalid input boundary value analysis
	// inputs: "123456789"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateCustomerID002() {
		String output = "The customerID id is invalid. Please enter a correct customerID.";
		OrderBook in = new OrderBook();

		String input = "123456789";
		try {
			boolean results = in.validateCustomerID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:3
	// test obj: invalid input boundary value analysis
	// inputs: "0"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateCustomerID003() {
		String output = "Negative number not allowed please enter a positive number";
		OrderBook in = new OrderBook();

		String input = "0";
		try {
			boolean results = in.validateCustomerID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:4
	// test obj: valid input boundary value analysis
	// inputs: ""
	// ex output: true
	// output: true

	public void testvalidateCustomerID004() {
		OrderBook in = new OrderBook();

		String input = "";
		try {
			boolean results = in.validateCustomerID(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:5
	// test obj: invalid input boundary value analysis
	// inputs: "ytgfe"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidateCustomerID005() {
		String output = "Please enter number equal or less than 400.";
		OrderBook in = new OrderBook();

		String input = "ytgfe";
		try {
			boolean results = in.validateCustomerID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);

		}
	}


	// above
	// test number:1
	// test obj: valid input boundary value analysis
	// inputs: " 50.00
	// ex output: true
	// output: true
	public void testvalidateOrderPrice001() {
		OrderBook in = new OrderBook();
		double input = 50.00;
		try {
			boolean results = in.validateOrderPrice(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:2
	// test obj: valid input boundary value analysis
	// inputs: " 1.0
	// ex output: true
	// output: true
	public void testvalidateOrderPrice002() {
		OrderBook in = new OrderBook();
		double input = 1.0;
		try {
			boolean results = in.validateOrderPrice(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:3
	// test obj: valid input boundary value analysis
	// inputs: " 100.00
	// ex output: true
	// output: true
	public void testvalidateOrderPrice003() {
		OrderBook in = new OrderBook();
		double input = 100.00;
		try {
			boolean results = in.validateOrderPrice(input);
			assertEquals(true, results);
		} catch (NewsAgentExceptionHandler e) {
			fail("something went wrong");

		}
	}

	// test number:4
	// test obj: invalid input boundary value analysis
	// inputs: " 101.00
	// ex output: ex message thrown
	// output: ex message thrown
	public void testvalidateOrderPrice004() {
		String output = "amount above price cap";
		OrderBook in = new OrderBook();
		double input = 101.00;
		try {
			boolean results = in.validateOrderPrice(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.message, output);

		}
	}

	// test number:5
	// test obj: invalid input boundary value analysis
	// inputs: " -1.00
	// ex output: ex message thrown
	// output: ex message thrown
	public void testvalidateOrderPrice005() {
		String output = "Negative number not allowed for price";
		OrderBook in = new OrderBook();
		double input = -1.00;
		try {
			boolean results = in.validateOrderPrice(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.message, output);

		}
	}

	// testvalidatePublicationID checking that 5 in length and numbers valid ==> else is invalid.
	// invalid.
	// test number:1
	// test obj:valid input boundary value analysis
	// inputs: "00001"
	// ex output: true
	// output: true

	public void testvalidatePublicationID001() {

		OrderBook in = new OrderBook();

		String input = "00001";
		try {
			boolean results = in.validatePublicationID(input);
			assertEquals(true, results);
		} catch (Exception e) {
			fail("something went wrong");
		}
	}

	// test number:2
	// test obj: invalid input boundary value analysis
	// inputs: "123456789"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidatePublicationID002() {
		String output = "Negative number not allowed please enter a positive number";
		OrderBook in = new OrderBook();

		String input = "123456789";

		try {
			boolean results = in.validatePublicationID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:3
	
	
	// test obj: invalid input boundary value analysis
	// inputs: "0"
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidatePublicationID003() {
		String output = "Negative number not allowed please enter a positive number";
		OrderBook in = new OrderBook();

		String input = "0";

		try {
			boolean results = in.validatePublicationID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:4
	// test obj: invalid input boundary value analysis
	// inputs: ""
	// ex output: ex message thrown
	// output: ex message thrown

	public void testvalidatePublicationID004() {
		String output = "Please enter number equal or less than 400.";
		OrderBook in = new OrderBook();

		String input = "";

		try {
			boolean results = in.validatePublicationID(input);
			fail("something went wrong");
		} catch (NewsAgentExceptionHandler e) {
			assertEquals(e.getMessage(), output);
		}
	}

	// test number:5
	// test obj:valid input boundary value analysis
	// inputs: "ndnid"
	// ex output: true
	// output: true

	public void testvalidatePublicationID005() {

		OrderBook in = new OrderBook();

		String input = "ndnid";
		try {
			boolean results = in.validatePublicationID(input);
			assertEquals(true, results);
		} catch (Exception e) {
			fail("something went wrong");
		}
	}
	// validateOrderSchedule min max of 15-50 valid ==> negative to 14 & +51 above
	// is
	// invalid.
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

}
