package matthew;

public class Customer {

	/*
	 * setting up a product skeleton for orderbook creating empty methods then
	 * develope testcases for those methods ie. boundrey value analisis. etcetera
	 * will be about 30 -35 tests total for hole class working on intergration with
	 * command line next the variables are subject to change. then database.
	 */

	// initializing variables
	private String customerID; // length 5
	private String customerName; // length 1 - 20
	private String addressStreet; // same as customer ID
	private String phoneNumber;// length 10
	private Publication publicationID; // same as customerid

                public Customer(String customerId) {
                        this.customerID = customerId;
                }

	// getters and setters for all variables within the customer class.
	public String getCustomerID() {
		return customerID;
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

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Publication getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(Publication PublicationID) {
		publicationID = PublicationID;
	}

	// constructor for cerating customer and validating that all elements are
	// legal.
	public Customer(String customerID, String customerName, String addressStreet, String phoneNumber,
			Publication PublicationID) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.addressStreet = addressStreet;
		this.phoneNumber = phoneNumber;
		publicationID = PublicationID;
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

	        // Check if the parsed integer is a 5-digit number
	        if (customerID.length() < 5 || customerID.length() > 5) {
	            throw new NewsAgentExceptionHandler("The customer ID is invalid. Please enter a valid range.");
	        }

		} catch (NumberFormatException e) {
			// Handle the case where customerID is not a valid integer
			throw new NewsAgentExceptionHandler(
					"The customer ID is not a valid integer. Please enter a correct 5-digit customer ID.");
		}
	    // Returning true if the customerID is within the valid ranges
	    return customerID.length() < 5;
	}

	// method that will check if validate that the publicationID is valid
	public static boolean validatePublicationID(String publicationID) throws NewsAgentExceptionHandler {
		// Check if publicationID is empty
		if (publicationID.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid publicationID.");
		}
	    // Try to parse the publicationID as an integer
	    try {
	        // Check if the parsed integer is a 5-digit number
	        if (publicationID.length() < 5 || publicationID.length() > 5) {
	            throw new NewsAgentExceptionHandler("The publication ID is invalid. Please enter a correct 5-digit publication ID.");
	        }

		} catch (NumberFormatException e) {
			// Handle the case where publicationID is not a valid integer
			throw new NewsAgentExceptionHandler(
					"The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.");
		}

		// Returning true if the orderID is within the valid ranges
		return publicationID.length() == 5;
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
		return customerName.length() < 1 && customerName.length() <= 20;
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
	
	// method that will check if validate that the addressID is valid	
	public static boolean validateAddressID(String addressStreet) throws NewsAgentExceptionHandler {
	    // Check if addressID is empty
	    if (addressStreet.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid addressID.");
	    }

	    // Try to parse the addressID as an integer
	    try {

	        // Check if the parsed integer is a 5-digit number
	        if (addressStreet.length() < 0) {
	            throw new NewsAgentExceptionHandler("The address ID is invalid. Please enter a correct 5-digit address ID.");
	        }

		} catch (NumberFormatException e) {
			// Handle the case where customerID is not a valid integer
			throw new NewsAgentExceptionHandler(
					"The address ID is not a valid integer. Please enter a correct 5-digit address ID.");
		}
	    // Returning true if the addressID is within the valid ranges
	    return addressStreet.length() > 0;
	}

}
