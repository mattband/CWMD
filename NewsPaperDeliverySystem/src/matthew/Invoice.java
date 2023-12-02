package matthew;

public class Invoice {

	private String invoiceID;
	private String customerID;
	private String publicationID; 
	private String orderID; 
	private String invoiceMessage; 
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
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

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getInvoiceMessage() {
		return invoiceMessage;
	}

	public void setInvoiceMessage(String invoiceMessage) {
		this.invoiceMessage = invoiceMessage;
	}

	public Invoice(String invoiceID, String customerID, String publicationID, String orderID, String invoiceMessage,String price) {
		super();
		this.invoiceID = invoiceID;
		this.customerID = customerID;
		this.publicationID = publicationID;
		this.orderID = orderID;
		this.invoiceMessage = invoiceMessage;
		this.price = price;
	}

	public Invoice() {
	}

	  // method that will check if validate that the invoiceID is valid
    public static boolean validateinvoiceID(String invoiceID) throws NewsAgentExceptionHandler {
        // Check if invoiceID is empty
        if (invoiceID.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid invoiceID.");
        }

        // Try to parse the publicationID as an integer
        try {
            int invoiceIDTest = Integer.parseInt(invoiceID);

            // Check if the parsed integer is a 5-digit number
            if (invoiceIDTest < 10000 || invoiceIDTest > 99999) {
                throw new NewsAgentExceptionHandler("The invoice ID is invalid. Please enter a correct 5-digit invoice ID.");
            }

        } catch (NumberFormatException e) {
            // Handle the case where invoiceID is not a valid integer
            throw new NewsAgentExceptionHandler("The invoice ID is not a valid integer. Please enter a correct 5-digit invoice ID.");
        }

        // Returning true if the publicationID is within the valid ranges
        return invoiceID.length() == 5;
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

	    // Returning true if the customerID is within the valid ranges
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
            int publicationIDTest = Integer.parseInt(publicationID);

            // Check if the parsed integer is a 5-digit number
            if (publicationIDTest < 10000 || publicationIDTest > 99999) {
                throw new NewsAgentExceptionHandler("The publication ID is invalid. Please enter a correct 5-digit publication ID.");
            }

        } catch (NumberFormatException e) {
            // Handle the case where publicationID is not a valid integer
            throw new NewsAgentExceptionHandler("The publication ID is not a valid integer. Please enter a correct 5-digit publication ID.");
        }

        // Returning true if the publicationID is within the valid ranges
        return publicationID.length() == 5;
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
	
    // method that will check if validate that the invoiceMessage is valid
    public static boolean validateInvoiceMessage(String invoiceMessage) throws NewsAgentExceptionHandler {
        // Check if invoiceMessage is empty
        if ( invoiceMessage.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid invoiceMessage.");
        }

        // Check if invoiceMessage length is within the valid range (10 to 100 characters)
        if (invoiceMessage.length() < 10 || invoiceMessage.length() > 100) {
            throw new NewsAgentExceptionHandler("The invoiceMessage is invalid. Please enter a message between 10 and 100 characters.");
        }

        // Returning true if the invoiceMessage is within the valid range
        return invoiceMessage.length() >= 10 && invoiceMessage.length() <=100;
    }
    
    // method that will check if validate that the Price is valid
    public static boolean validatePrice(String price) throws NewsAgentExceptionHandler {
        // Check if Price is empty
        if ( price.isEmpty()) {
            throw new NewsAgentExceptionHandler("Please enter a valid Price.");
        }

        // Try to parse the Price as a double
        try {
            double priceTest = Double.parseDouble(price);

            // Check if the parsed double is in the valid range
            if (priceTest < 1.00 || priceTest > 99.99) {
                throw new NewsAgentExceptionHandler("The Price is invalid. Please enter a correct Price between 1.00 and 99.99.");
            }

        } catch (NumberFormatException e) {
            // Handle the case where Price is not a valid double
            throw new NewsAgentExceptionHandler("The Price is not a valid double. Please enter a correct Price.");
        }

        // Returning true if the Price is within the valid ranges
        return price.length() == 4 || price.length() == 5;
    }

	
}
