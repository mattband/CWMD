package matthew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.sql.ResultSet;

public class MySQLAccess implements OrderBookController //  , InvoiceController, PublicationController, CustomerController, NewsagentController
{
	String jdbcUrl = "jdbc:mysql://localhost:3307/NewsPaperDeliverySystem";
	
	private String user = "nbuser";
	private String password = "nbuser";
	private Connection connect; //  =  DriverManager.getConnection("jdbc:derby://localhost:1527/NewsPaperDeliverySystem", user, password);
	private PreparedStatement preparedStatement = null;



//	   private String host = "jdbc:mysql://localhost:3306/NewsPaperDeliverySystem";
//	    private String user = "your_mysql_username";
//	    private String password = "your_mysql_password";
//	    private Connection connect;
//	    private PreparedStatement preparedStatement = null;

    public MySQLAccess() throws Exception {
        try {
            // Load MySQL Driver
        	String jdbcUrl = "jdbc:mysql://localhost:3307/NewsPaperDeliverySystem";
        	//connect = DriverManager.getConnection(jdbcUrl, "NewsPaperDeliverySystem", "");
        	connect = DriverManager.getConnection(jdbcUrl, "taha", "");
        	//connect = DriverManager.getConnection(jdbcUrl);
        	
            // Setup the connection with the DB
            //connect = DriverManager.getConnection(host, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//	public MySQLAccess() throws Exception {
//
//		try {
//
//			// Load MySQL Driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// Setup the connection with the DB
//			connect = DriverManager.getConnection(
//					"jdbc:mysql://" + host + "/NewsPaperDeliverySystem?" + "user=" + user + "&password=" + password);
//		} catch (Exception e) {
//			throw e;
//		}
//
//	}

// ---------------------------------------------------------------- CRUD order book--------------------------------------------------------------------------------------------------
    public boolean insertOrderBook(OrderBook orderbook) {
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

            preparedStatement = connect.prepareStatement(
                    "INSERT INTO ORDERBOOK VALUES (?, ?, ?, ?, ?)"
            );
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



//	public boolean insertOrderBook(OrderBook orderbook) {
//		boolean insertSuccessfull = true;
//
//		try {
//			preparedStatement = connect.prepareStatement("INSERT INTO NewsPaperDeliverySystem.ORDERBOOK VALUES(?, ?, ?, ?, ?)");
//			preparedStatement.setString(1, orderbook.getOrderID());
//			preparedStatement.setString(2, orderbook.getCustomerID());
//			preparedStatement.setString(3, orderbook.getPublicationID());
//			preparedStatement.setString(5, orderbook.getOrderSchedule());
//			preparedStatement.setString(5, orderbook.getOrderPrice());
//		} catch (Exception e) {
//			insertSuccessfull = false;
//		}
//
//		return insertSuccessfull;
//	}

public boolean updateOrderBook(OrderBook orderbook) {
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

            System.out.println("OrderID: " + orderId +
                    ", CustomerID: " + customerId +
                    ", PublicationID: " + publicationId +
                    ", OrderSchedule: " + orderSchedule + // Corrected column name
                    ", OrderPrice: " + orderPrice); // Corrected column name
        }

        resultSet.close();
        statement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


public boolean deleteOrderBook(String orderID) {
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

public boolean  getOrderBookById(String orderId) {
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

            System.out.println("OrderID: " + orderId +
                    ", CustomerID: " + customerId +
                    ", PublicationID: " + publicationId +
                    ", OrderDate: " + orderDate +
                    ", TotalAmount: " + totalAmount);
            }

            resultSet.close();
        } catch (Exception e) {
        	getByIdSuccsessful = false;

            e.printStackTrace();
        }
		return getByIdSuccsessful;

  
    }
	

//--------------------------------------------------------------------------------------Customer-CRUD -------------------------------------------------------------------------------------------------------


	public boolean insertCustomer(Customer customer) {
		boolean insertSuccessful = true;

		try {
			if (connect == null) {
				System.out.println("Connection is null. Cannot insert.");
				return false;
			}

			// Check if the customer already exists
			if (orderExists(customer.getCustomerID())) {
				System.out.println("Customer with ID " + customer.getCustomerID() + " already exists. Not inserting.");
				return false;
			}

			preparedStatement = connect.prepareStatement("INSERT INTO Customer VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, customer.getCustomerID());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getAddressID());
			preparedStatement.setString(4, customer.getPhoneNumber());
			preparedStatement.setString(5, customer.getPublicationID());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			insertSuccessful = false;
			e.printStackTrace();
		}

		return insertSuccessful;
	}

//Helper method to check if an customer with the given ID already exists
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
		boolean updateSuccessful = true;

		try {
			preparedStatement = connect.prepareStatement(
					"UPDATE Customer SET CustomerId=?, CustomerName=?, AddressId=?, PhoneNumber=? , Publication = ? WHERE CustomerId=?");
			preparedStatement.setString(1, updateCustomer.getCustomerID());
			preparedStatement.setString(2, updateCustomer.getCustomerName());
			preparedStatement.setString(3, updateCustomer.getAddressID());
			preparedStatement.setString(4, updateCustomer.getPhoneNumber());
			preparedStatement.setString(5, updateCustomer.getPublicationID());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return updateSuccessful;
	}

	public void printAllCustomer() {
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
				String AddressId = resultSet.getString("AddressId");
				String PhoneNumber = resultSet.getString("PhoneNumber"); // Corrected column name
				String PublicationId = resultSet.getString("Publication"); // Corrected column name

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
				String AddressId = resultSet.getString("AddressId");
				String PhoneNumber = resultSet.getString("PhoneNumber");
				String PublicationId = resultSet.getString("Publication");

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

            // Check if the publication ID already exists
            if (publicationExists(publication.getPublicationID())) {
                System.out.println("Order with ID " + publication.getPublicationID() + " already exists. Not inserting.");
                return false;
            }

            preparedStatement = connect.prepareStatement(
                    "INSERT INTO Publication; VALUES (?, ?, ?, ?, ?)"
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
				"UPDATE Publication  SET PublicationId =?, Title=?, Price =?, StocKQuantity =? , Frequency  =? WHERE PublicationId =?");
		preparedStatement.setString(1, publication.getPublicationID());
		preparedStatement.setString(2, publication.getTitle());
		preparedStatement.setString(3, publication.getPrice());
		preparedStatement.setString(4, publication.getQuantity());
		preparedStatement.setString(5, publication.getFrequency());
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
            String Title  = resultSet.getString("Title");
            String Price = resultSet.getString("Price");
            String StocKQuantity = resultSet.getString("StocKQuantity"); // Corrected column name
            String Frequency = resultSet.getString("Frequency"); // Corrected column name

            System.out.println("PublicationId: " + PublicationId +
                    ", Title: " + Title +
                    ", Price: " + Price +
                    ", Quantity: " + StocKQuantity + // Corrected column name
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

public boolean  getPublicationById(String publicationID) {
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
            String Title  = resultSet.getString("Title");
            String Price = resultSet.getString("Price");
            String Quantity  = resultSet.getString("StocKQuantity ");
            String Frequency  = resultSet.getString("Frequency");

            System.out.println("publicationID: " + publicationID +
                    ", Title: " + Title +
                    ", Price: " + Price +
                    ", Quantity: " + Quantity +
                    ", Frequency: " + Frequency);
            }

            resultSet.close();
        } catch (Exception e) {
        	getByIdSuccsessful = false;

            e.printStackTrace();
        }
		return getByIdSuccsessful;

  
    }
}