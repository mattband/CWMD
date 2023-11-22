package orderBook_Matt;

import java.sql.Connection;
import java.sql.PreparedStatement;


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
	private double orderPrice;
	private String publicationID;
	private String orderSchedule;
	static String idPatton = "D\\d{5}";
	private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
	private String user = "nbuser";
	private String password = "nbuser";
	private Connection conn;
	private PreparedStatement preparedStatement = null;

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
	
	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	// constructor for cerating order book and validating that all elements are
	// legal.
	public OrderBook(String orderID, String customerID, String publicationID, String orderShedule,double orderPrice)
			throws NewsAgentExceptionHandler {
		try {
			validateOrderID(orderID);
			validateCustomerID(customerID);
			validatePublicationID(publicationID);
			validateOrderShedule(orderShedule);
			validateOrderPrice(orderPrice);



		} catch (NewsAgentExceptionHandler e) {

			throw new NewsAgentExceptionHandler("constructor failed to collect all validated values");
		}
	}

	// empty constructor
	public OrderBook() {

	}



	// method that will check if validate that the orderID is valid
	public static boolean validateOrderID(String orderID) throws NewsAgentExceptionHandler {

		if (orderID.length() != 5) {
			throw new NewsAgentExceptionHandler("The Order id is invalid. Please enter a correct orderID.");
		}
		if(orderID.equals(idPatton)) {
			throw new NewsAgentExceptionHandler("The Order id is invalid. Please enter a correct orderID.");
		}
		// checks if orderID is empty range.
		if (orderID.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid Order ID. of 5 in length.");
		}
		// returning boolean. if the orderID is within the ranges
		return orderID.length() == 5;

	}

	// method that will check if validate that the customerID is valid
	public static boolean validateCustomerID(String customerID) throws NewsAgentExceptionHandler {
		if (customerID.length() != 5) {
			throw new NewsAgentExceptionHandler("The customerID id is invalid. Please enter a correct customerID.");
		}
		if(customerID.matches(idPatton)) {
			throw new NewsAgentExceptionHandler("The customerID id is invalid. Please enter a correct customerID.");
		}
		// checks if customerID is empty range.
		if ( customerID.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid Order ID. of 5 in length.");
		}
		// returning boolean. if the customerID is within the ranges
		return customerID.length() == 5;

	}

	// method that will check if validate that the publicationID is valid
	public static boolean validatePublicationID(String publicationID) throws NewsAgentExceptionHandler {
		if (publicationID.length() != 5) {
			throw new NewsAgentExceptionHandler("The publicationID id is invalid. Please enter a correct publicationID.");
		}
		if(publicationID.matches(idPatton)) {
			throw new NewsAgentExceptionHandler("The publicationID id is invalid. Please enter a correct publicationID.");
		}
		// checks if customerID is empty range.
		if ( publicationID.isEmpty()) {
			throw new NewsAgentExceptionHandler("Please enter a valid Order ID. of 5 in length.");
		}
		// returning boolean. if the customerID is within the ranges
		return publicationID.length() == 5;
	}
	
	
	// method that will check if validate that the orderPrice is valid
	public static boolean validateOrderPrice(double orderPrice) throws NewsAgentExceptionHandler {
		// checks if orderPrice is below range.
		if (orderPrice < 1.0) {
			throw new NewsAgentExceptionHandler("Negative number not allowed for price");
		}
		// checks if orderPrice is above range.
		if (orderPrice > 100.0) {
			throw new NewsAgentExceptionHandler("amount above price cap");
		}
		// returning boolean. if the orderPrice is within the ranges
		return orderPrice <= 100.0 && orderPrice >= 1.0;
	}

	// method that will check if validate that the orderShedule is valid
	public static boolean validateOrderShedule(String orderShedule) throws NewsAgentExceptionHandler {
		// checks if orderShedule is empty or null.
		if (orderShedule.isEmpty()) {
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


	// crud methods:
	
	
	public boolean insertOrderBook(OrderBook orderbook) {
		boolean insertSuccessfull = true;
		
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ORDERBOOK VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, orderbook.getOrderID());  
			preparedStatement.setString(2, orderbook.getCustomerID()); 
			preparedStatement.setString(3, orderbook.getPublicationID());
			preparedStatement.setString(5, orderbook.getOrderSchedule());
			preparedStatement.setDouble(5, orderbook.getOrderPrice());
		}catch(Exception e) {
			insertSuccessfull = false;
		}
		
		return insertSuccessfull;
	}


	/*
	 * method that will update the elements within the orderbook database by ID test
	 * cases to check the return output
	 */
    public boolean updateOrderBook(OrderBook orderbook) {
        boolean updateSuccessful = true;

        try {
            preparedStatement = conn.prepareStatement("UPDATE ORDERBOOK SET CUSTOMERID=?, PUBLICATIONID=?, ORDERSCHEDULE=?, ORDERPRICE=? WHERE ORDERID=?");
            preparedStatement.setString(1, orderbook.getCustomerID());
            preparedStatement.setString(2, orderbook.getPublicationID());
            preparedStatement.setString(3, orderbook.getOrderSchedule());
            preparedStatement.setDouble(4, orderbook.getOrderPrice());
            preparedStatement.setString(5, orderbook.getOrderID());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            updateSuccessful = false;
            e.printStackTrace();  // Add proper error handling/logging
        }

        return updateSuccessful;
    }

	/*
	 * method that will delete the elements from within the orderbook database. test
	 * cases to check the return output
	 */
    public boolean deleteOrderBook(String orderID) {
        boolean deleteSuccessful = true;

        try {
            preparedStatement = conn.prepareStatement("DELETE FROM ORDERBOOK WHERE ORDERID=?");
            preparedStatement.setString(1, orderID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            deleteSuccessful = false;
            e.printStackTrace();  // Add proper error handling/logging
        }

        return deleteSuccessful;
    }

	/*
	 * method that will display the elements within the orderbook database to
	 * command line using toString test cases to check the return output
	 */
	public static void readOrderBook() {

	}

	/*
	 * method that will display the elements within the orderbook by ID database to
	 * command line using toString test cases to check the return output
	 */
	public static void readOrderBookByID() {
	}

}
