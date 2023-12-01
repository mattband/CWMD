package Admin;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author cianf
 */
public class AdminTest extends TestCase{
    
   //Testing adminUsername
	
	//Test #: 1
	//Objective: Testing valid String length between 3 and 60 characters for adminPassword
	//Inputs: String "joe"
	//Expected O/P: true
	
	public void testvalidateAdminUsername001() {
		try {
			Admin admin = new Admin();
			String input = "joe";
			
			boolean results = admin.validateAdminUsername(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 2
	//Objective: Testing valid String length of 60 characters for adminPassword
	//Inputs: String "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	//Expected O/P: true
	
	public void testvalidateAdminUsername002() {
		try {
			Admin admin = new Admin();
			String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			
			boolean results = admin.validateAdminUsername(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 3
	//Objective: Testing invalid empty String length
	//Inputs: String ""
	//Expected O/P: "Admin username NOT specified"
	
	public void testvalidateAdminUsername003() {
		String expectOP = "Admin username NOT specified";
		
		try {
			Admin admin = new Admin();
			String input = "";
			
			admin.validateAdminUsername(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 4
	//Objective: Testing invalid String characters
	//Inputs: String "83945"
	//Expected O/P: "Admin username contains non-letter characters"
	
	public void testvalidateAdminUsername004() {
		String expectOP = "Admin username contains non-letter characters";
		
		try {
			Admin admin = new Admin();
			String input = "83945";
			
			admin.validateAdminUsername(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 5
	//Objective: Testing invalid String characters
	//Inputs: String "#_))==+"
	//Expected O/P: "Admin username contains non-letter characters"
	
	public void testvalidateAdminUsername005() {
		String expectOP = "Admin username contains non-letter characters";
		
		try {
			Admin admin = new Admin();
			String input = "#_))==+";
			
			admin.validateAdminUsername(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 6
	//Objective: Testing invalid String length over the maximum length
	//Inputs: String "sgdususcgdusguisgcuisgcgicuiscgusgcscbsgcusgcusgcusigcsigcisgcuisgcuifgusifgusidguegwigfuiwagfxgcgduewfduewugfouwGQ"
	//Expected O/P: "Admin username does not meet maximum length requirements"
	
	public void testvalidateAdminUsername006() {
		String expectOP = "Admin username does not meet maximum length requirements";
		
		try {
			Admin admin = new Admin();
			String input = "sgdususcgdusguisgcuisgcgicuiscgusgcscbsgcusgcusgcusigcsigcisgcuisgcuifgusifgusidguegwigfuiwagfxgcgduewfduewugfouwGQ";
			
			admin.validateAdminUsername(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP);

		}
	}
	
	//Test #: 7
	//Objective: Testing invalid String characters between 3 and 60 characters for adminUsername
	//Inputs: String "hi"
	//Expected O/P: "Admin username does not meet minimum length requirements"
	
	public void testvalidateAdminUsername007() {
		String expectOP = "Admin username does not meet minimum length requirements";
		
		try {
			Admin admin = new Admin();
			String input = "hi";
			
			admin.validateAdminUsername(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Testing adminPassword
	
	//Test #: 8
	//Objective: Testing valid String length between 5 and 12 characters for adminPassword
	//Inputs: String "fires"
	//Expected O/P: true
	
	public void testvalidateAdminPassword008() {
		try {
			Admin admin = new Admin();
			String input = "fires";
			
			boolean results = admin.validateAdminPassword(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 9
	//Objective: Testing valid String length between 5 and 12 characters for adminPassword
	//Inputs: String "aaaaaaaaaaaa"
	//Expected O/P: true
	
	public void testvalidateAdminPassword009() {
		try {
			Admin admin = new Admin();
			String input = "aaaaaaaaaaaa";
			
			boolean results = admin.validateAdminPassword(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 10
	//Objective: Testing invalid empty String for adminPassword
	//Inputs: String ""
	//Expected O/P: "Admin password NOT specified"
	
	public void testvalidateAdminPassword0010() {
		String expectOP = "Admin password NOT specified";
		
		try {
			Admin admin = new Admin();
			String input = "";
			
			admin.validateAdminPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
		assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 11
	//Objective: Testing invalid String length under the minimum length of 5 characters for adminPassword
	//Inputs: String "sad"
	//Expected O/P: "Admin username does not meet minimum length requirements"
	
	public void testvalidateAdminPassword0011() {
		String expectOP = "Admin password does not meet minimum length requirements";
		
		try {
			Admin admin = new Admin();
			String input = "sad";
			
			admin.validateAdminPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 12
	//Objective: Testing invalid String length over the maximum length of 12 characters for adminPassword
	//Inputs: String "abbreviations"
	//Expected O/P: "Admin password does not meet maximum length requirements"
	
	public void testvalidateAdminPassword0012() {
		String expectOP = "Admin password does not meet maximum length requirements";
		
		try {
			Admin admin = new Admin();
			String input = "abbreviations";
			
			admin.validateAdminPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 13
	//Objective: Testing invalid String characters between 5 and 12 characters for adminPassword
	//Inputs: String "=-,#-.+-_}#;"
	//Expected O/P: "Admin password contains non-letter characters"
	
	public void testvalidateAdminPassword0013() {
		String expectOP = "Admin password contains non-letter characters";
		
		try {
			Admin admin = new Admin();
			String input = "=-,#-.+-_}#;";
			
			admin.validateAdminPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Testing ID
	
	//Test #: 14
	//Objective: Testing valid String length between 3 and 5 characters for idNum
	//Inputs: String "1234"
	//Expected O/P: true
	
	public void testvalidateAdminID0014() {
		try {
			Admin admin = new Admin();
			String input = "ggg";
			
			boolean results = admin.validateAdminID(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 15
	//Objective: Testing invalid int length under the minimum between 3 and 5 numbers for idNum
	//Inputs: String "12"
	//Expected O/P: "Admin ID does not meet minimum length requirements"
	
	public void testvalidateAdminID0015() {
		String expectOP = "Admin ID does not meet minimum length requirements";
		
		try {
			Admin admin = new Admin();
			String input = "12";
			
			admin.validateAdminID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 16
	//Objective: Testing invalid int length over the maximum between 3 and 5 numbers for idNum
	//Inputs: String "12345678"
	//Expected O/P: "Admin ID does not meet maximum length requirements"
	
	public void testvalidateAdminID0016() {
		String expectOP = "Admin ID does not meet maximum length requirements";
		
		try {
			Admin admin = new Admin();
			String input = "12345678";
			
			admin.validateAdminID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 17
	//Objective: Testing invalid empty int for adminID
	//Inputs: String ""
	//Expected O/P: "Admin ID NOT specified"
	
	public void testvalidateAdminID0017() {
		String expectOP = "Admin ID NOT specified";
		
		try {
			Admin admin = new Admin();
			String input = "";
			
			admin.validateAdminID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 18
	//Objective: Testing invalid character input for adminID
	//Inputs: String "7777"
	//Expected O/P: "Admin ID contains non-letter characters"
	
	public void testvalidateAdminID0018() {
		String expectOP = "Admin ID should not contain special characters";
		
		try {
			Admin admin = new Admin();
			String input = "++++";
			
			admin.validateAdminID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP);

		}
	}

}