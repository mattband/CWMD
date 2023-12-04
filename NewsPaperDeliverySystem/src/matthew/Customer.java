package matthew;


//developer. Matthew devlin

public class Customer {



	// initializing variables
	private String customerID; // length 5
	private String customerName; // length 1 - 20
	private String addressStreet; // 150 
	private String phoneNumber;// length 10
	private String publicationID; // same as customerid


	// getters and setters for all variables within the customer class.
	
	public String getCustomerID() {
		return customerID;
	}



	public String getAddressStreet() {
		return addressStreet;
	}



	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getPublicationID() {
		return publicationID;
	}



	public void setPublicationID(String publicationID) {
		this.publicationID = publicationID;
	}



	// constructor for cerating customer and validating that all elements are
	// legal.
	public Customer(String customerID, String customerName,  String phoneNumber, String addressStreet,String publicationID ) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.addressStreet = addressStreet;
		this.publicationID = publicationID;
	}

	// empty constructor
	public Customer() {

	}

	// method that will check if validate that the customerID is valid
	public static boolean validateCustomerID(String customerID) throws NewsAgentExceptionHandler {
		// Check if customerID is empty
		if (customerID.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid customerID.");
		}

		// Try to parse the customerID as an integer
		try {
			int customerIDTest = Integer.parseInt(customerID);

			// Check if the parsed integer is a 5-digit number
			if (customerIDTest < 10000 || customerIDTest > 99999) {
				throw new NewsAgentExceptionHandler(
						"The customer ID is invalid. Please enter a correct 5-digit customer ID.");
			}

		} catch (NumberFormatException e) {
			// Handle the case where customerID is not a valid integer
			throw new NewsAgentExceptionHandler(
					"The customer ID is not a valid integer. Please enter a correct 5-digit customer ID.");
		}

		// Returning true if the customerID is within the valid ranges
		return customerID.length() == 5;
	}


	// method that will check if validate that the customerName is valid
	public static boolean validateCustomerName(String customerName) throws NewsAgentExceptionHandler {
		// Check if customerName is empty
		if (customerName.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid customerName.");
		}

		// Check if customerName length is within the valid range (1 to 20 characters)
		if (customerName.length() <= 1 || customerName.length() > 20) {
			throw new NewsAgentExceptionHandler(
					"The customerName is invalid. Please enter a name between 1 and 20 characters.");
		}

		// Returning true if the customerName is within the valid range
		return customerName.length() > 1 && customerName.length() <= 20;
	}

	// method that will check if validate that the phoneNumber is valid
	public static boolean validatePhoneNumber(String phoneNumber) throws NewsAgentExceptionHandler {
		// Check if phoneNumber is empty
		if (phoneNumber.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid phoneNumber.");
		}

		// Check if phoneNumber length is exactly 10 characters
		if (phoneNumber.length() != 10) {
			throw new NewsAgentExceptionHandler("The phoneNumber is invalid. Please enter a 10-digit phone number.");
		}

		// Check if phoneNumber contains only digits
		if (!phoneNumber.matches("\\d+")) {
			throw new NewsAgentExceptionHandler(
					"The phoneNumber is invalid. Please enter a valid numeric phone number.");
		}

		// Returning true if the phoneNumber is valid
		return true;
	}

	// method that will check if validate that the address is valid
	public static boolean validateAddress(String addressStreet) throws NewsAgentExceptionHandler {
	    // Check if address is empty
	    if (addressStreet.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid address.");
	    }

	    // Check if address length is within the valid range (1 to 150 characters)
	    if (addressStreet.length() <= 1 || addressStreet.length() > 150) {
	        throw new NewsAgentExceptionHandler(
	                "The address is invalid. Please enter an address between 1 and 150 characters.");
	    }

	    // Returning true if the address is within the valid range
	    return addressStreet.length() > 1 && addressStreet.length() <= 150;
	}
	// method that will check if validate that the publicationID is valid
	public static boolean validatePublicationID(String publicationID) throws NewsAgentExceptionHandler {
		// Check if publicationID is empty
		if (publicationID.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid publicationID.");
		}

		// Try to parse the publicationID as an integer
		try {
			int publicationIDTest = Integer.parseInt(publicationID);

			// Check if the parsed integer is a 5-digit number
			if (publicationIDTest < 10000 || publicationIDTest > 99999) {
				throw new NewsAgentExceptionHandler(
						"The publication ID is invalid. Please enter a correct 5-digit publication ID.");
			}

		} catch (NumberFormatException e) {
			// Handle the case where publicationID is not a valid integer
			throw new NewsAgentExceptionHandler(
					"The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.");
		}

		// Returning true if the orderID is within the valid ranges
		return publicationID.length() == 5;
	}





}
