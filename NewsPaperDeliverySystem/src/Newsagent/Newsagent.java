/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Newsagent;

import User.User;
import java.util.Scanner;

/**
 *
 * @author cianf
 */
public class Newsagent {
	
	// CONSTANTS 
//	private final int MIN_USERNAME_LENGTH = 3;
//	private final int MAX_USERNAME_LENGTH = 60;
//
//	private final int MIN_PASSWORD_LENGTH = 5;
//	private final int MAX_PASSWORD_LENGTH = 12;
//	
//	private final int MIN_ID_LENGTH = 3;
//	private final int MAX_ID_LENGTH = 5;
	
	// instance vars
//	private String username;
	private User userId;
	private String id;
              private User newsAgentpassword;

	public Newsagent(String newsagentId, User userId) throws NewsagentExceptionHandler {
		try {
			validateNewsagentID(newsagentId);
		}catch(NewsagentExceptionHandler  e) {
			throw e;
		}
		
		this.id = newsagentId;
		this.userId = userId;
		
	}

    public Newsagent() {
      
    }
	
	//Newsagent username string must be a minimum of 3 characters and a maximum of 60 characters

//		public boolean validateNewsagentUsername(String newsagentUsername) throws NewsagentExceptionHandler {
//			
//			if (newsagentUsername.isEmpty() || newsagentUsername.isEmpty()) 
//				throw new NewsagentExceptionHandler ("Newsagent username NOT specified");
//			else if (newsagentUsername.length() < MIN_USERNAME_LENGTH)
//				throw new NewsagentExceptionHandler ("Newsagent username does not meet minimum length requirements");
//			else if (newsagentUsername.length() > MAX_USERNAME_LENGTH)
//				throw new NewsagentExceptionHandler ("Newsagent username does not meet maximum length requirements");
//			
////			if (!newsagentUsername.matches("[a-zA-Z]+")) {
////		        throw new NewsagentExceptionHandler ("Newsagent username contains non-letter characters");
////		    }
//			return newsagentUsername.length() >= MIN_USERNAME_LENGTH && newsagentUsername.length() <= MAX_USERNAME_LENGTH ;
//	}
		
		//Newsagent password string must be a minimum of 5 characters and a maximum of 12 characters

		public boolean validateNewsagentPassword(String newsAgentUserId) throws NewsagentExceptionHandler {
			
			if (newsAgentUserId.isEmpty()) 
				throw new NewsagentExceptionHandler ("Newsagent password NOT specified");
			else if (newsAgentUserId.length() < 5)
				throw new NewsagentExceptionHandler ("Newsagent password does not meet minimum length requirements");
			else if (newsAgentUserId.length() > 5)
				throw new NewsagentExceptionHandler ("Newsagent password does not meet maximum length requirements");
			
//			if (!newsAgentUserId.matches("[a-zA-Z]+")) {
//		        throw new NewsagentExceptionHandler ("Newsagent password contains non-letter characters");
//		    }
			return newsAgentUserId.length() == 6 ;	
		}

//		
//		public String getUsername() {
//			return username;
//		}
//
//		public void setUsername(String username) {
//			this.username = username;
//		}

		public User getUserId() {
			return userId;
		}

		public void setUserId(User userId) {
			this.userId = userId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		//Newsagent ID String must be a minimum of 3 numbers and a maximum of 5 numbers
		public boolean validateNewsagentID(String idNum) throws NewsagentExceptionHandler {
			
			if (idNum.isEmpty() || idNum.isEmpty()) 
				throw new NewsagentExceptionHandler ("Newsagent ID NOT specified");
			else if (idNum.length() < 6)
				throw new NewsagentExceptionHandler ("Newsagent ID does not meet minimum length requirements");
			else if (idNum.length() > 6)
				throw new NewsagentExceptionHandler ("Newsagent ID does not meet maximum length requirements");
			
			return idNum.length() == 6 ;
		}
                
                public  boolean createNewsagent(Newsagent newsagent) throws NewsagentExceptionHandler
                {
                    Scanner scanner = new Scanner(System.in);
                    boolean results = false;
                    System.out.println("Enter a valid id between 3-5");
                    String id = scanner.next();
                    newsagent.validateNewsagentID(id);
                    
                    
                return results;

                }

}
