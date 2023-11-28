/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author cianf
 */

public class Admin {
	
	// CONSTANTS 
	private final int MIN_USERNAME_LENGTH = 3;
	private final int MAX_USERNAME_LENGTH = 60;

	private final int MIN_PASSWORD_LENGTH = 5;
	private final int MAX_PASSWORD_LENGTH = 12;
	
	private final int MIN_ID_LENGTH = 3;
	private final int MAX_ID_LENGTH = 5;
	
	// instance vars
	private String username;
	private String password;
	private String id;
	
	
	public Admin(String adminUsername, String adminPassword, String idNum) throws NewsagentExceptionHandler {
		try {
			validateAdminUsername(adminUsername);
			validateAdminPassword(adminPassword);
			validateAdminID(idNum);

		}catch(NewsagentExceptionHandler  e) {
			throw e;
		}
		
		username = adminUsername;
		password = adminPassword;
		id = idNum;
		
	}
	
	public Admin() throws NewsagentExceptionHandler {
		
	}
	
	//Admin username string must be a minimum of 3 characters and a maximum of 60 characters

	public boolean validateAdminUsername(String adminUsername) throws NewsagentExceptionHandler {
		
		if (adminUsername.isBlank() || adminUsername.isEmpty()) 
			throw new NewsagentExceptionHandler ("Admin username NOT specified");
		else if (adminUsername.length() < MIN_USERNAME_LENGTH)
			throw new NewsagentExceptionHandler ("Admin username does not meet minimum length requirements");
		else if (adminUsername.length() > MAX_USERNAME_LENGTH)
			throw new NewsagentExceptionHandler ("Admin username does not meet maximum length requirements");
		
		if (!adminUsername.matches("[a-zA-Z]+")) {
	        throw new NewsagentExceptionHandler ("Admin username contains non-letter characters");
	    }
		return adminUsername.length() >= MIN_USERNAME_LENGTH && adminUsername.length() <= MAX_USERNAME_LENGTH ;
}
	
	//Admin password string must be a minimum of 5 characters and a maximum of 12 characters

	public boolean validateAdminPassword(String adminPassword) throws NewsagentExceptionHandler {
		
		if (adminPassword.isBlank() || adminPassword.isEmpty()) 
			throw new NewsagentExceptionHandler ("Admin password NOT specified");
		else if (adminPassword.length() < MIN_PASSWORD_LENGTH)
			throw new NewsagentExceptionHandler ("Admin password does not meet minimum length requirements");
		else if (adminPassword.length() > MAX_PASSWORD_LENGTH)
			throw new NewsagentExceptionHandler ("Admin password does not meet maximum length requirements");
		
		if (!adminPassword.matches("[a-zA-Z]+")) {
	        throw new NewsagentExceptionHandler ("Admin password contains non-letter characters");
	    }
		return adminPassword.length() >= MIN_PASSWORD_LENGTH && adminPassword.length() <= MAX_PASSWORD_LENGTH ;	
	}

	
	//Admin ID String must be a minimum of 3 numbers and a maximum of 5 numbers
	public boolean validateAdminID(String idNum) throws NewsagentExceptionHandler {
		
		if (idNum.isBlank() || idNum.isEmpty()) 
			throw new NewsagentExceptionHandler ("Admin ID NOT specified");
		else if (idNum.length() < MIN_ID_LENGTH)
			throw new NewsagentExceptionHandler ("Admin ID does not meet minimum length requirements");
		else if (idNum.length() > MAX_ID_LENGTH)
			throw new NewsagentExceptionHandler ("Admin ID does not meet maximum length requirements");
		
	    if (!idNum.matches("^[a-zA-Z0-9]+$")) {
	        throw new NewsagentExceptionHandler ("Admin ID should not contain special characters");
	    }
		return idNum.length() >= MIN_ID_LENGTH && idNum.length() <= MAX_ID_LENGTH ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}