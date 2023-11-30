package matthew;

import junit.framework.TestCase;

public class PublicationTest extends TestCase {

	// test number:1
	// test obj:Test case for valid title
	// inputs: "News Article"
	// ex output: true
	// output: true
	public void testValidateTitle001() {
		try {
			assertTrue(Publication.validateTitle("News Article"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// test number:2
	// test obj:Test case for empty title
	// inputs: ""
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateTitle002() {
		try {
			assertFalse(Publication.validateTitle(""));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("Please enter a valid title.", e.getMessage());
		}
	}

	// test number:3
	// test obj:Test case for too short title
	// inputs: "A"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateTitle003() {
		try {
			assertFalse(Publication.validateTitle("A"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The title is invalid. Please enter a title between 3 and 20 characters.", e.getMessage());
		}
	}

	// test number:4
	// test obj:Test case for too long title
	// inputs: "ThisIsAVeryLongNewsArticleTitle"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateTitle004() {
		try {
			assertFalse(Publication.validateTitle("ThisIsAVeryLongNewsArticleTitle"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The title is invalid. Please enter a title between 3 and 20 characters.", e.getMessage());
		}
	}

	// test number:5
	// test obj:Test case for title within boundry
	// inputs: "ABC"
	// ex output: true
	// output: true
	public void testValidateTitle005() {
		try {
			assertTrue(Publication.validateTitle("ABC"));
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
			assertTrue(Publication.validatePublicationID("12345"));
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
			assertFalse(Publication.validatePublicationID(""));
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
			assertFalse(Publication.validatePublicationID("abcde"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.",
					e.getMessage());
		}
	}

	// test number:4
	// test obj:Test case for PublicationID too short
	// inputs: "1234"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidatePublicationID004() {
		try {
			assertFalse(Publication.validatePublicationID("1234"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The publication ID is invalid. Please enter a correct 5-digit publication ID.",
					e.getMessage());
		}
	}

	// test number:5
	// test obj:Test case for PublicationID too long
	// inputs: "123456"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidatePublicationID005() {
		try {
			assertFalse(Publication.validatePublicationID("123456"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The publication ID is invalid. Please enter a correct 5-digit publication ID.",
					e.getMessage());
		}
	}

	// test number:6
	// test obj:Test case for PublicationID within boundry
	// inputs: "123456"
	// ex output: true
	// output: true
	public void testValidatePublicationID006() {
		try {
			assertTrue(Publication.validatePublicationID("56789"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// test number:1
	// test obj:Test case for price valid
	// inputs: "12.34"
	// ex output: true
	// output: true
	public void testValidatePrice001() {
		try {
			assertTrue(Publication.validatePrice("12.34"));
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
			assertFalse(Publication.validatePrice(""));
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
			assertFalse(Publication.validatePrice("abc"));
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
			assertFalse(Publication.validatePrice("0.99"));
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
			assertFalse(Publication.validatePrice("1000.00"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The Price is invalid. Please enter a correct Price between 1.00 and 99.99.", e.getMessage());
		}
	}

	// test number:6
	// test obj:Test case for price wthin boundry
	// inputs: "1000.00"
	// ex output: true
	// output: true
	public void testValidatePrice006() {
		try {
			assertTrue(Publication.validatePrice("23.40"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// test number:1
	// test obj:Test case for valid Quantity
	// inputs: "12"
	// ex output: true
	// output: true
	public void testValidateQuantity001() {
		try {
			assertTrue(Publication.validateQuantity("12"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// test number:2
	// test obj:Test case for Empty Quanity
	// inputs: ""
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateQuantity002() {
		try {
			assertFalse(Publication.validateQuantity(""));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("Please enter a valid Quantity.", e.getMessage());
		}
	}

	// test number:3
	// test obj:Test case for not numeric Quanity
	// inputs: "ab"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateQuantity003() {
		try {
			assertFalse(Publication.validateQuantity("ab"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The Quantity is not a valid integer. Please enter a correct Quantity.", e.getMessage());
		}
	}

	// test number:4
	// test obj:Test case for Quanity too low
	// inputs: "0"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateQuantity004() {
		try {
			assertFalse(Publication.validateQuantity("0"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The Quantity is invalid. Please enter a correct Quantity between 1 and 99.", e.getMessage());
		}
	}

	// test number:5
	// test obj:Test case for Quanity too high
	// inputs: "100"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateQuantity005() {
		try {
			assertFalse(Publication.validateQuantity("100"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The Quantity is invalid. Please enter a correct Quantity between 1 and 99.", e.getMessage());
		}
	}

	// test number:6
	// test obj:Test case for Quanity within boundry
	// inputs: "9"
	// ex output: true
	// output: true
	public void testValidateQuantity006() {
		try {
			assertTrue(Publication.validateQuantity("9"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// test number:1
	// test obj:Test case for Frequency is valid
	// inputs: "Weekly"
	// ex output: true
	// output: true
	public void testValidateFrequency001() {
		try {
			assertTrue(Publication.validateFrequency("Weekly"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	// test number:2
	// test obj:Test case for empty Frequency
	// inputs: ""
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateFrequency002() {
		try {
			assertFalse(Publication.validateFrequency(""));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("Please enter a valid Frequency.", e.getMessage());
		}
	}

	// test number:3
	// test obj:Test case for Frequency too short
	// inputs: "Dai"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateFrequency003() {
		try {
			assertFalse(Publication.validateFrequency("Dai"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The Frequency is invalid. Please enter a Frequency between 5 and 20 characters.",
					e.getMessage());
		}
	}

	// test number:4
	// test obj:Test case for Frequency too long
	// inputs: "DailyPublicationFrequencyIsTooLong"
	// ex output: ex message thrown
	// output: ex message thrown
	public void testValidateFrequency004() {
		try {
			assertFalse(Publication.validateFrequency("DailyPublicationFrequencyIsTooLong"));
		} catch (NewsAgentExceptionHandler e) {
			assertEquals("The Frequency is invalid. Please enter a Frequency between 5 and 20 characters.",
					e.getMessage());
		}
	}

	// test number:5
	// test obj:Test case for Frequency within boundry
	// inputs: "WeeklyFrequency"
	// ex output: true
	// output: true
	public void testValidateFrequencyBoundary() {
		try {
			assertTrue(Publication.validateFrequency("WeeklyFrequency"));
		} catch (NewsAgentExceptionHandler e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

}
