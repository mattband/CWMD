package matthew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class MySQLAccess
		implements OrderBookController, CustomerController, PublicationController, InvoiceController {
	// JDBC connection URL for the MySQL database
	// Database connection credentials
	private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
	private String user = "nbuser";
	private String password = "nbuser";
	private Connection connect;
	private PreparedStatement preparedStatement = null;

	// Constructor to establish a connection with the database
	public MySQLAccess() throws Exception {

		try {
			// Attempt to establish a connection to the database
			connect = DriverManager.getConnection(host, user, password);


		} catch (SQLException e) {
			// Handle any exceptions that occur during the connection process
			e.printStackTrace();
		}


	}

// ---------------------------------------------------------------- CRUD order book--------------------------------------------------------------------------------------------------
	// CRUD operations for OrderBook entity
	public boolean insertOrderBook(OrderBook orderbook) {
		// Inserts an OrderBook into the database
		// Returns true if the insertion is successful, false otherwise
		boolean insertSuccessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot insert.");
				return false;
			}

			// Check if the order ID already exists
			if (orderExists(orderbook.getOrderID())) {
				System.out.println("Order with ID " + orderbook.getOrderID() + " already exists. Not inserting.");
				return false;
			}

			preparedStatement = connect.prepareStatement("INSERT INTO ORDERBOOK VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, orderbook.getOrderID());
			preparedStatement.setString(2, orderbook.getCustomerID());
			preparedStatement.setString(3, orderbook.getPublicationID());
			preparedStatement.setString(4, orderbook.getOrderSchedule());
			preparedStatement.setString(5, orderbook.getOrderPrice());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
		}

		return insertSuccessful;
	}

	// Helper method to check if an order with the given ID already exists
	private boolean orderExists(String orderID) {
		try {
			preparedStatement = connect.prepareStatement("SELECT 1 FROM ORDERBOOK WHERE ORDERID = ?");
			preparedStatement.setString(1, orderID);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next(); // Returns true if the order ID exists in the database
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateOrderBook(OrderBook orderbook) {
		// Updates an existing OrderBook in the database
		// Returns true if the update is successful, false otherwise
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement(
					"UPDATE ORDERBOOK SET CUSTOMERID=?, PUBLICATIONID=?, ORDERSCHEDULE=?, ORDERPRICE=? WHERE ORDERID=?");
			preparedStatement.setString(1, orderbook.getCustomerID());
			preparedStatement.setString(2, orderbook.getPublicationID());
			preparedStatement.setString(3, orderbook.getOrderSchedule());
			preparedStatement.setString(4, orderbook.getOrderPrice());
			preparedStatement.setString(5, orderbook.getOrderID());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return updateSuccessful;
	}

	public void printAllOrderBooks() {
		// Prints all OrderBooks stored in the database
		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return;
			}

			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERBOOK");

			while (resultSet.next()) {
				String orderId = resultSet.getString("OrderID");
				String customerId = resultSet.getString("CustomerID");
				String publicationId = resultSet.getString("PublicationID");
				String orderSchedule = resultSet.getString("OrderSchedule"); // Corrected column name
				String orderPrice = resultSet.getString("OrderPrice"); // Corrected column name

				System.out.println("OrderID: " + orderId + ", CustomerID: " + customerId + ", PublicationID: "
						+ publicationId + ", OrderSchedule: " + orderSchedule + // Corrected column name
						", OrderPrice: " + orderPrice); // Corrected column name
			}

			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deleteOrderBook(String orderID) {
		// Deletes an OrderBook from the database based on the provided order ID
		// Returns true if the deletion is successful, false otherwise
		boolean deleteSuccessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot delete.");
				return false;
			}

			preparedStatement = connect.prepareStatement("DELETE FROM ORDERBOOK WHERE ORDERID=?");
			preparedStatement.setString(1, orderID);
			int rowsAffected = preparedStatement.executeUpdate();

			// Check if any rows were affected to determine if the deletion was successful
			deleteSuccessful = rowsAffected > 0;
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return deleteSuccessful;
	}

	public boolean getOrderBookById(String orderId) {
		// Retrieves and prints an OrderBook from the database based on the provided
		// order ID
		// Returns true if the retrieval is successful, false otherwise
		boolean getByIdSuccsessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return false;
			}

			preparedStatement = connect.prepareStatement("SELECT * FROM ORDERBOOK WHERE ORDERID = ?");
			preparedStatement.setString(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String customerId = resultSet.getString("CustomerId");
				String publicationId = resultSet.getString("PublicationId");
				String orderDate = resultSet.getString("OrderDate");
				String totalAmount = resultSet.getString("TotalAmount");

				System.out.println("OrderID: " + orderId + ", CustomerID: " + customerId + ", PublicationID: "
						+ publicationId + ", OrderDate: " + orderDate + ", TotalAmount: " + totalAmount);
			}

			resultSet.close();
		} catch (Exception e) {
			getByIdSuccsessful = false;

			e.printStackTrace();
		}
		return getByIdSuccsessful;

	}

//--------------------------------------------------------------------------------------Customer-CRUD -------------------------------------------------------------------------------------------------------

	// CRUD operations for Customer entity
	public boolean insertCustomer(Customer customer) {
                        boolean insertSuccessful = true;

                        try {
                            if (connect == null) {
                                System.out.println("Connection is null. Cannot insert.");
                                return false;
                            }

                            // Check if the publicationID exists in the Publication table
                            if (!publicationExists(customer.getPublicationID().getPublicationID())) {
                                System.out.println("Publication with ID " + customer.getPublicationID().getPublicationID() + " does not exist. Not inserting.");
                                return false;
                            }

                            // Check if a customer with the same publication ID already exists
                            if (customerExists(customer.getPublicationID().getPublicationID())) {
                                System.out.println("Customer with Publication ID " + customer.getPublicationID().getPublicationID() + " already exists. Not inserting.");
                                return false;
                            }

                            preparedStatement = connect.prepareStatement("INSERT INTO Customer VALUES (?, ?, ?, ?, ?)");
                            preparedStatement.setString(1, customer.getCustomerID());
                            preparedStatement.setString(2, customer.getCustomerName());
                            preparedStatement.setString(3, customer.getAddressStreet());
                            preparedStatement.setString(4, customer.getPhoneNumber());
                            preparedStatement.setString(5, customer.getPublicationID().getPublicationID());
                            preparedStatement.executeUpdate();
                            connect.commit();
                        } catch (Exception e) {
                            insertSuccessful = false;
                            e.printStackTrace();
                        }

                        return insertSuccessful;
                    }


	// Helper method to check if a customer with the given ID already exists
	@SuppressWarnings("unused")
	private boolean customerExists(String customerID) {
		try {
			preparedStatement = connect.prepareStatement("SELECT 1 FROM Customer WHERE CustomerId = ?");
			preparedStatement.setString(1, customerID);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next(); // Returns true if the customer ID exists in the database
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCustomer(Customer updateCustomer) {
		// Updates an existing Customer in the database
		// Returns true if the update is successful, false otherwise
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement(
					"UPDATE Customer SET CustomerId=?, CustomerName=?, AddressStreet=?, PhoneNumber=? , PublicationID = ? WHERE CustomerId=?");
			preparedStatement.setString(1, updateCustomer.getCustomerID());
			preparedStatement.setString(2, updateCustomer.getCustomerName());
			preparedStatement.setString(3, updateCustomer.getAddressStreet());
			preparedStatement.setString(4, updateCustomer.getPhoneNumber());
			preparedStatement.setString(5, updateCustomer.getPublicationID().getPublicationID());
			preparedStatement.setString(6, updateCustomer.getCustomerID());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return updateSuccessful;
	}

	public void printAllCustomers() {
		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return;
			}

			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer");

			while (resultSet.next()) {
				String CustomerId = resultSet.getString("CustomerId");
				String CustomerName = resultSet.getString("CustomerName");
				String AddressId = resultSet.getString("AddressStreet");
				String PhoneNumber = resultSet.getString("PhoneNumber"); // Corrected column name
				String PublicationId = resultSet.getString("PublicationID"); // Corrected column name

				System.out.println("CustomerID: " + CustomerId + ", Customer Name: " + CustomerName + ", Address ID: "
						+ AddressId + ", PhoneNumber: " + PhoneNumber + // Corrected column name
						", Publication ID: " + PublicationId); // Corrected column name
			}

			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deleteCustomer(String customerID) {
		boolean deleteSuccessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot delete.");
				return false;
			}

			preparedStatement = connect.prepareStatement("DELETE FROM Customer WHERE CustomerId=?");
			preparedStatement.setString(1, customerID);
			int rowsAffected = preparedStatement.executeUpdate();

			// Check if any rows were affected to determine if the deletion was successful
			deleteSuccessful = rowsAffected > 0;
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return deleteSuccessful;
	}

	public boolean getCustomerById(String customerID) {
		boolean getByIdSuccsessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return false;
			}

			preparedStatement = connect.prepareStatement("SELECT * FROM Customer WHERE CustomerId = ?");
			preparedStatement.setString(1, customerID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String CustomerName = resultSet.getString("CustomerName");
				String AddressId = resultSet.getString("AddressStreet");
				String PhoneNumber = resultSet.getString("PhoneNumber");
				String PublicationId = resultSet.getString("PublicationID");

				System.out.println("customerID: " + customerID + ", CustomerName: " + CustomerName + ", AddressId: "
						+ AddressId + ", PhoneNumber: " + PhoneNumber + ", PublicationId: " + PublicationId);
			}

			resultSet.close();
		} catch (Exception e) {
			getByIdSuccsessful = false;

			e.printStackTrace();
		}
		return getByIdSuccsessful;

	}

//--------------------------------------------------------------------------------publication- CRUD-----------------------------------------------------------------------------------------------------

	public boolean insertPublication(Publication publication) {
		boolean insertSuccessful = true;

        try {
            if (connect == null) {
                System.out.println("Connection is null. Cannot insert.");
                return false;
            }
//
//            // Check if the publication ID already exists
//            if (publicationExists(publication.getPublicationID())) {
//                System.out.println("Order with ID " + publication.getPublicationID() + " already exists. Not inserting.");
//                return false;
//            }

            preparedStatement = connect.prepareStatement(
                    "INSERT INTO Publication VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1, publication.getPublicationID());
            preparedStatement.setString(2, publication.getTitle());
            preparedStatement.setString(3, publication.getPrice());
            preparedStatement.setString(4, publication.getQuantity());
            preparedStatement.setString(5, publication.getFrequency());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            insertSuccessful = false;
            e.printStackTrace();
        }

        return insertSuccessful;
    }



	// Helper method to check if an publication with the given ID already exists
    private boolean publicationExists(String publicationID) {
        try {
            preparedStatement = connect.prepareStatement("SELECT 1 FROM Publication  WHERE PublicationId  = ?");
            preparedStatement.setString(1, publicationID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if the publication ID exists in the database
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




public boolean updatePublication(Publication publication) {
	boolean updateSuccessful = true;

	try {
		preparedStatement = connect.prepareStatement(
				"UPDATE Publication  SET PublicationId =?, Title=?, Price =?, Quantity =? , Frequency  =? WHERE PublicationId =?");
		preparedStatement.setString(1, publication.getPublicationID());
		preparedStatement.setString(2, publication.getTitle());
		preparedStatement.setString(3, publication.getPrice());
		preparedStatement.setString(4, publication.getQuantity());
		preparedStatement.setString(5, publication.getFrequency());
                                preparedStatement.setString(6, publication.getPublicationID());
		preparedStatement.executeUpdate();
	} catch (Exception e) {
		updateSuccessful = false;
		e.printStackTrace(); // Add proper error handling/logging
	}
            return updateSuccessful;
}


	public void printAllPublications() {
		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return;
			}

			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Publication");

			while (resultSet.next()) {
				String PublicationId = resultSet.getString("PublicationId");
				String Title = resultSet.getString("Title");
				String Price = resultSet.getString("Price");
				String StocKQuantity = resultSet.getString("Quantity"); // Corrected column name
				String Frequency = resultSet.getString("Frequency"); // Corrected column name

				System.out.println("PublicationId: " + PublicationId + ", Title: " + Title + ", Price: " + Price
						+ ", Quantity: " + StocKQuantity + // Corrected column name
						", Frequency: " + Frequency); // Corrected column name
			}

			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deletePublication(String publicationID) {
		boolean deleteSuccessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot delete.");
				return false;
			}

			preparedStatement = connect.prepareStatement("DELETE FROM Publication WHERE PublicationId=?");
			preparedStatement.setString(1, publicationID);
			int rowsAffected = preparedStatement.executeUpdate();

			// Check if any rows were affected to determine if the deletion was successful
			deleteSuccessful = rowsAffected > 0;
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return deleteSuccessful;
	}

	public boolean getPublicationById(String publicationID) {
		boolean getByIdSuccsessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return false;
			}

			preparedStatement = connect.prepareStatement("SELECT * FROM Publication  WHERE PublicationId  = ?");
			preparedStatement.setString(1, publicationID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String Title = resultSet.getString("Title");
				String Price = resultSet.getString("Price");
				String Quantity = resultSet.getString("StocKQuantity ");
				String Frequency = resultSet.getString("Frequency");

				System.out.println("publicationID: " + publicationID + ", Title: " + Title + ", Price: " + Price
						+ ", Quantity: " + Quantity + ", Frequency: " + Frequency);
			}

			resultSet.close();
		} catch (Exception e) {
			getByIdSuccsessful = false;

			e.printStackTrace();
		}
		return getByIdSuccsessful;

	}

//----------------------------------------------------------------------------------------------invoice-CRUD---------------------------------------------------------------------------------------
	public boolean insertInvoice(Invoice invoice) {
		// Inserts an Invoice into the database
		// Returns true if the insertion is successful, false otherwise

		boolean insertSuccessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot insert.");
				return false;
			}

			// Check if the publication ID already exists
			if (publicationExists(invoice.getInvoiceID())) {
				System.out.println("invoice with ID " + invoice.getInvoiceID() + " already exists. Not inserting.");
				return false;
			}

			preparedStatement = connect.prepareStatement("INSERT INTO Invoice VALUES (?, ?, ?, ?, ?, ? )");
			preparedStatement.setString(1, invoice.getInvoiceID());
			preparedStatement.setString(2, invoice.getPublicationID().getPublicationID());
			preparedStatement.setString(3, invoice.getCustomerID().getCustomerID());
			preparedStatement.setString(4, invoice.getOrderID().getOrderID());
			preparedStatement.setString(5, invoice.getInvoiceMessage());
			preparedStatement.setString(6, invoice.getPrice());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
		}

		return insertSuccessful;
	}

	// Helper method to check if an Invoice with the given ID already exists
	@SuppressWarnings("unused")
	private boolean invoiceExists(String invoiceID) {
		try {
			preparedStatement = connect.prepareStatement("SELECT 1 FROM Invoice   WHERE InvoiceID   = ?");
			preparedStatement.setString(1, invoiceID);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next(); // Returns true if the publication ID exists in the database
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateInvoice(Invoice invoice) {
		// Updates an existing Invoice in the database
		// Returns true if the update is successful, false otherwise

		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement(
					"UPDATE Invoice  SET InvoiceID  =?, PublicationID =?, CustomerId  =?, OrderId  =? , InvoiceMessage  = ?, OrderPrice = ? WHERE InvoiceID  =?");
			preparedStatement.setString(1, invoice.getInvoiceID());
			preparedStatement.setString(2, invoice.getPublicationID().getPublicationID());
			preparedStatement.setString(3, invoice.getCustomerID().getCustomerID());
			preparedStatement.setString(4, invoice.getOrderID().getOrderID());
			preparedStatement.setString(5, invoice.getInvoiceMessage());
			preparedStatement.setString(6, invoice.getPrice());
			preparedStatement.setString(7, invoice.getInvoiceID());
                                    
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return updateSuccessful;
	}

	public void printAllInvoices() {
		// Prints all Invoices stored in the database

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return;
			}

			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Invoice " + "" + "  ");

			while (resultSet.next()) {
				String invoiceID = resultSet.getString("InvoiceID");
				String publicationID = resultSet.getString("PublicationID");
				String customerID = resultSet.getString("CustomerId");
				String orderID = resultSet.getString("OrderId"); // Corrected column name
				String price = resultSet.getString("InvoiceMessage"); // Corrected column name
				String invoiceMessage = resultSet.getString("OrderPrice");

				System.out.println("invoiceID: " + invoiceID + ", publicationID: " + publicationID + ", customerID: "
						+ customerID + ", orderID: " + orderID + // Corrected column name
						", price: " + price + ", invoiceMessage: " + invoiceMessage); // Corrected column name
			}

			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deleteInvoice(String invoiceID) {
		boolean deleteSuccessful = true;

		try {
			if (connect == null || connect.isClosed()) {
				System.out.println("Connection is null. Cannot delete.");
				return false;
			}

			try(PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM Invoice  WHERE InvoiceID =?")){
                                                preparedStatement.setString(1, invoiceID);
			int rowsAffected = preparedStatement.executeUpdate();

			// Check if any rows were affected to determine if the deletion was successful
			deleteSuccessful = rowsAffected > 0;
                                            }
			
		} catch (Exception e) {
			deleteSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return deleteSuccessful;
	}

	public boolean getInvoiceById(String invoiceID) {
		boolean getByIdSuccsessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot retrieve data.");
				return false;
			}

			preparedStatement = connect.prepareStatement("SELECT * FROM Invoice  WHERE InvoiceID  = ?");
			preparedStatement.setString(1, invoiceID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String publicationID = resultSet.getString("PublicationID");
				String customerID = resultSet.getString("CustomerId");
				String orderID = resultSet.getString("orderID");
				String price = resultSet.getString("OrderPrice");
				String invoiceMessage = resultSet.getString("InvoiceMessage");

				System.out.println("invoiceID: " + invoiceID + ", publicationID: " + publicationID + ", customerID: "
						+ customerID + ", orderID: " + orderID + ", price: " + price + ", invoiceMessage: "
						+ invoiceMessage);
			}

			resultSet.close();
		} catch (Exception e) {
			getByIdSuccsessful = false;

			e.printStackTrace();
		}
		return getByIdSuccsessful;

	}
}