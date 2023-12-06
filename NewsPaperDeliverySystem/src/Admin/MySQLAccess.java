/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import Newsagent.Newsagent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cianf
 */
public class MySQLAccess {

	private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
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
	        	String jdbcUrl = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
	        	connect = DriverManager.getConnection(jdbcUrl, "nbuser", "nbuser");
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

	// ---------------------------------------------------------------- CRUD Newsagent --------------------------------------------------------------------------------------------------

    public boolean insertNewsagent(Newsagent newsagent)  {
        boolean insertSuccessful = true;

        try {
            if (connect == null) {
                System.out.println("Connection is null. Cannot insert.");
                return false;
            }

            preparedStatement = connect.prepareStatement(
                    "INSERT INTO NEWSAGENT VALUES (?, ?)"
            );
            preparedStatement.setString(1, newsagent.getId());
            preparedStatement.setString(2, newsagent.getUserId().getUserId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            insertSuccessful = false;
            e.printStackTrace();
        }

        return insertSuccessful;
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

	public boolean updateNewsagent(Newsagent newsagent) {
		boolean updateSuccessful = true;
                String sql = "UPDATE NEWSAGENT SET AGENTID = ? , USERID = ? WHERE AGENTID = ?";
		try(PreparedStatement preparedStatement = connect.prepareStatement(sql)){
			preparedStatement.setString(1, newsagent.getId());
			preparedStatement.setString(2, newsagent.getUserId().getUserId());
			preparedStatement.setString(3, newsagent.getId());
                        
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if (rowsAffected <= 0) {
                updateSuccessful = false;
                System.out.println("Update failed. No records were affected.");
            } else {
                System.out.println("Update successful.");
            }
			
		} catch (Exception e) {
			updateSuccessful = false;
			e.printStackTrace(); // Add proper error handling/logging
		}

		return updateSuccessful;
	}

	
	public ResultSet printAllNewsagent() {
		ResultSet resultSet = null;
        	 
	     try {
	             String sql = "SELECT * FROM NEWSAGENT";
	             PreparedStatement preparedStatement = connect.prepareStatement(sql);
	             resultSet = preparedStatement.executeQuery();
	     } catch (SQLException e) {
	             System.err.println("Error retrieving delivery persons: " + e.getMessage());
	     }
        
        return resultSet;
    }
	
	
	public boolean deleteNewsagent(String newsagentID) {
	    boolean deleteSuccessful = true;

	    try {
	        if (connect == null) {
	            System.out.println("Connection is null. Cannot delete.");
	            return false;
	        }

	        preparedStatement = connect.prepareStatement("DELETE FROM NEWSAGENT WHERE AGENTID = ? ");
	        preparedStatement.setString(1, newsagentID)	;
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check if any rows were affected to determine if the deletion was successful
	        if(rowsAffected > 0){
                    System.out.println("Delete successfull");
                }
	    } catch (Exception e) {
	        deleteSuccessful = false;
	        e.printStackTrace(); // Add proper error handling/logging
	    }

	    return deleteSuccessful;
	}
	
    public boolean  getNewsagentById(String updateAgent) {
	    boolean getByIdSuccsessful = true;


        try {
            if (connect == null) {
                System.out.println("Connection is null. Cannot retrieve data.");
                return false;
            }

            preparedStatement = connect.prepareStatement("SELECT * FROM NEWSAGENT WHERE NEWSAGENTID = ?");
            preparedStatement.setString(1, updateAgent);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	String newsagentID1 = resultSet.getString("Newsagent ID");
                String newsagentPassword = resultSet.getString("Password");
              

                System.out.println("AdminID: " + updateAgent+ ", Password: " + newsagentPassword);

            }

            resultSet.close();
        } catch (Exception e) {
        	getByIdSuccsessful = false;

            e.printStackTrace();
        }
		return getByIdSuccsessful;

  
    }
	
}