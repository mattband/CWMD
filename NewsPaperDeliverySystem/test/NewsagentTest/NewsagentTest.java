package NewsagentTest;

import Newsagent.Newsagent;
import Newsagent.NewsagentExceptionHandler;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author cianf
 */
public class NewsagentTest extends TestCase{
    
    	//Testing newsagentPassword
	
	//Test #: 1
	//Objective: Testing valid String length between 5 and 12 characters for newsagentPassword
	//Inputs: String "fires"
	//Expected O/P: true
	@Test
	public void testvalidateNewsagentPassword001() {
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "fires";
			
			boolean results = newsagent.validateNewsagentPassword(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 2
	//Objective: Testing valid String length between 5 and 12 characters for newsagentPassword
	//Inputs: String "aaaaaaaaaaaa"
	//Expected O/P: true
	
	public void testvalidateNewsagentPassword002() {
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentUserId);
			String input = "aaaaaaaaaaaa";
			
			boolean results = newsagent.validateNewsagentPassword(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 3
	//Objective: Testing invalid empty String for newsagentPassword
	//Inputs: String ""
	//Expected O/P: "Newsagent password NOT specified"
	
	public void testvalidateNewsagentPassword003() {
		String expectOP = "Newsagent password NOT specified";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "";
			
			newsagent.validateNewsagentPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
		assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 4
	//Objective: Testing invalid String length under the minimum length of 5 characters for newsagentPassword
	//Inputs: String "sad"
	//Expected O/P: "Newsagent password does not meet minimum length requirements"
	
	public void testvalidateNewsagentPassword004() {
		String expectOP = "Newsagent password does not meet minimum length requirements";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "sad";
			
			newsagent.validateNewsagentPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 5
	//Objective: Testing invalid String length over the maximum length of 12 characters for newsagentPassword
	//Inputs: String "abbreviations"
	//Expected O/P: "Newsagent password does not meet maximum length requirements"
	
	public void testvalidateNewsagentPassword005() {
		String expectOP = "Newsagent password does not meet maximum length requirements";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "abbreviations";
			
			newsagent.validateNewsagentPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 6
	//Objective: Testing invalid String characters between 5 and 12 characters for newsagentPassword
	//Inputs: String "=-,#-.+-_}#;"
	//Expected O/P: "Newsagent password contains non-letter characters"
	
	public void testvalidateNewsagentPassword006() {
		String expectOP = "Newsagent password contains non-letter characters";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "=-,#-.+-_}#;";
			
			newsagent.validateNewsagentPassword(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Testing ID
	
	//Test #: 7
	//Objective: Testing valid String length between 3 and 5 characters for newsagentId
	//Inputs: String "1234"
	//Expected O/P: true
	
	public void testvalidateNewsagentID007() {
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "ggg";
			
			boolean results = newsagent.validateNewsagentID(input);
			assertEquals(true, results);
			
		} catch (NewsagentExceptionHandler e) {
			fail();
		}
	}
	
	//Test #: 8
	//Objective: Testing invalid int length under the minimum between 3 and 5 numbers for newsagentId
	//Inputs: String "12"
	//Expected O/P: "Newsagent ID does not meet minimum length requirements"
	
	public void testvalidateNewsagentID008() {
		String expectOP = "Newsagent ID does not meet minimum length requirements";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "12";
			
			newsagent.validateNewsagentID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 9
	//Objective: Testing invalid int length over the maximum between 3 and 5 numbers for newsagentId
	//Inputs: String "12345678"
	//Expected O/P: "Newsagent ID does not meet maximum length requirements"
	
	public void testvalidateNewsagentID009() {
		String expectOP = "Newsagent ID does not meet maximum length requirements";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "12345678";
			
			newsagent.validateNewsagentID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 10
	//Objective: Testing invalid empty int for newsagentId
	//Inputs: String ""
	//Expected O/P: "Newsagent ID NOT specified"
	
	public void testvalidateNewsagentID0010() {
		String expectOP = "Newsagent ID NOT specified";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "";
			
			newsagent.validateNewsagentID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP );

		}
	}
	
	//Test #: 11
	//Objective: Testing invalid character input for newsagentId
	//Inputs: String "7777"
	//Expected O/P: "Newsagent ID contains non-letter characters"
	
	public void testvalidateNewsagentID0011() {
		String expectOP = "Newsagent ID should not contain special characters";
		
		try {
			Newsagent newsagent = new Newsagent(newsagentIDInput, newAgentId);
			String input = "++++";
			
			newsagent.validateNewsagentID(input);
			fail();
			
		} catch (NewsagentExceptionHandler e) {
			assertEquals(e.getMessage(), expectOP);

		}
	}

}