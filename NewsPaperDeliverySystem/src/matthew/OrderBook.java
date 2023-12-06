package matthew;


public class OrderBook {

	/*
	 * setting up a product skeleton for orderbook creating empty methods then
	 * develope testcases for those methods ie. boundrey value analisis. etcetera
	 * will be about 30 -35 tests total for hole class working on intergration with
	 * command line next the variables are subject to change. then database.
	 */

	// initializing variables
	private String orderID;
	private String customerID;
	private String orderPrice;
	private String publicationID;
	private String orderSchedule;

                public OrderBook(String orderId){
                    this.orderID = orderId;
                }

	// getters and setters for all variables within the orderbook class.
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(String publicationID) {
		this.publicationID = publicationID;
	}


	public String getOrderSchedule() {
		return orderSchedule;
	}

	public void setOrderSchedule(String orderSchedule) {
		this.orderSchedule = orderSchedule;
	}
	

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	// constructor for cerating order book and validating that all elements are
	// legal.
	public OrderBook(String orderID, String customerID, String publicationID, String orderPrice, String orderSchedule)
			throws NewsAgentExceptionHandler {
		
		
		this.orderID = orderID;
		this.customerID = customerID;
		this.publicationID = publicationID;
		this.orderSchedule = orderPrice;
		this.orderPrice = orderSchedule;
	}

	// empty constructor
	public OrderBook() {

	}


	// method that will check if validate that the orderID is valid
	public static boolean validateOrderID(String orderID) throws NewsAgentExceptionHandler {
	    // Check if orderID is empty
	    if (orderID.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid Order ID.");
	    }

	    // Try to parse the orderID as an integer
	    try {

	        // Check if the parsed integer is a 5-digit number
	        if (orderID.length() < 5 || orderID.length() > 5) {
	            throw new NewsAgentExceptionHandler("The Order ID is invalid. Please enter a correct 5-digit Order ID.");
	        }

	    } catch (NumberFormatException e) {
	        // Handle the case where orderID is not a valid integer
	        throw new NewsAgentExceptionHandler("The Order ID is not a valid integer. Please enter a correct 5-digit Order ID.");
	    }

	    // Returning true if the orderID is within the valid ranges
	    return orderID.length() == 5;
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
	        if (customerID.length() < 5|| customerID.length() > 5) {
	            throw new NewsAgentExceptionHandler("The customer ID is invalid. Please enter a correct 5-digit customer ID.");
	        }

	    } catch (NumberFormatException e) {
	        // Handle the case where customerID is not a valid integer
	        throw new NewsAgentExceptionHandler("The customer ID is not a valid integer. Please enter a correct 5-digit customer ID.");
	    }

	    // Returning true if the orderID is within the valid ranges
	    return customerID.length() == 5;
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
	        if (publicationID.length() < 5|| publicationID.length() > 5) {
	            throw new NewsAgentExceptionHandler("The publication ID is invalid. Please enter a correct 5-digit publication ID.");
	        }

	    } catch (NumberFormatException e) {
	        // Handle the case where customerID is not a valid integer
	        throw new NewsAgentExceptionHandler("The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.");
	    }

	    // Returning true if the orderID is within the valid ranges
	    return publicationID.length() == 5;
	}
	
	
	// method that will check if validate that the orderPrice is valid
	public static boolean validateOrderPrice(String orderPrice) throws NewsAgentExceptionHandler {
	    // Check if orderPrice is empty
	    if (orderPrice.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid order Price.");
	    }

	    // Try to parse the orderPrice as an double
	    try {

	        // Check if the parsed integer is a 5-digit number
	        if (orderPrice.length() < 1 || orderPrice.length() > 3) {
	            throw new NewsAgentExceptionHandler("The order Price is invalid. Please enter a correct 5-digit order Price.");
	        }

	    } catch (NumberFormatException e) {
	        // Handle the case where customerID is not a valid integer
	        throw new NewsAgentExceptionHandler("The order Price is not a valid integer. Please enter a price.");
	    }

	    // Returning true if the orderID is within the valid ranges
	    return orderPrice.length() == 5|| orderPrice.length() == 4;
	}

	// method that will check if validate that the orderShedule is valid
	public static boolean validateOrderShedule(String orderShedule) throws NewsAgentExceptionHandler {
		// checks if orderShedule is empty or null.
		if ( orderShedule.isEmpty()) {
			throw new NewsAgentExceptionHandler("OrderShedule Needed...");
		}
		// checks if orderShedule length is below range.
		if (orderShedule.length() < 5) {
			throw new NewsAgentExceptionHandler(
					"Please enter a correct time and date for the delivery within 15 to 50 characters");
		}
		// checks if orderShedule length is above range.
		if (orderShedule.length() > 50) {
			throw new NewsAgentExceptionHandler(
					"Please enter a correct time and date for the delivery within 15 to 50 characters");
		}
		// returning boolean. if the orderShedule length is within the ranges
		return orderShedule.length() <= 50 && orderShedule.length() >= 15;
	}

	public static boolean validateCustomerAndPublicationSame(String customerID, String publicationID) {
	    // Check if both customerID and publicationID are not null
	    if (customerID != null && publicationID != null) {
	        // Compare customerID and publicationID for equality
	        return customerID.equals(publicationID);
	    } else {
	        // If either customerID or publicationID is null, they can't be the same
	        return false;
	    }
	}


	

	
	
	


}
