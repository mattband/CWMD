package matthew;


// developer. Matthew devlin
public class OrderBook {


	// initializing variables
	private String orderID;
	private String customerID;
	private String orderPrice;
	private String publicationID;
	private String orderSchedule;



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
	public OrderBook(String orderID, String customerID, String publicationID, String orderPrice, String orderShedule)
			throws NewsAgentExceptionHandler {
		
		
		this.orderID = orderID;
		this.customerID = customerID;
		this.publicationID = publicationID;
		this.orderPrice = orderPrice;
		this.orderSchedule = orderShedule;

	}

	// empty constructor
	public OrderBook() {

	}


	// method that will check if validate that the orderID is valid
	public static boolean validateOrderID(String orderID) throws NewsAgentExceptionHandler {
	    // Check if orderID is empty
	    if (orderID.isBlank() || orderID.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid Order ID.");
	    }

	    // Try to parse the orderID as an integer
	    try {
	        int orderIDTest = Integer.parseInt(orderID);

	        // Check if the parsed integer is a 5-digit number
	        if (orderIDTest < 10000 || orderIDTest > 99999) {
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
	    if (customerID.isBlank() || customerID.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid customerID.");
	    }

	    // Try to parse the customerID as an integer
	    try {
	        int customerIDTest = Integer.parseInt(customerID);

	        // Check if the parsed integer is a 5-digit number
	        if (customerIDTest < 10000 || customerIDTest > 99999) {
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
	    if (publicationID.isBlank() || publicationID.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid publicationID.");
	    }

	    // Try to parse the publicationID as an integer
	    try {
	        int publicationIDTest = Integer.parseInt(publicationID);

	        // Check if the parsed integer is a 5-digit number
	        if (publicationIDTest < 10000 || publicationIDTest > 99999) {
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
	    if (orderPrice.isBlank() || orderPrice.isEmpty()) {
	        throw new NewsAgentExceptionHandler("Please enter a valid order Price.");
	    }

	    // Try to parse the orderPrice as an double
	    try {
	        double orderPriceTest = Double.parseDouble(orderPrice);

	        // Check if the parsed integer is a 5-digit number
	        if (orderPriceTest < 1.00 || orderPriceTest > 99.00) {
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
		if (orderShedule.isBlank() || orderShedule.isEmpty()) {
			throw new NewsAgentExceptionHandler("OrderShedule Needed...");
		}
		// checks if orderShedule length is below range.
		if (orderShedule.length() < 15) {
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
