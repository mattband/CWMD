package DeliveryDocket;

import matthew.Customer;
import matthew.OrderBook;
import matthew.Publication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DeliveryDocketHelper {
    
    private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
        private String user = "nbuser";
        private String password = "nbuser";
        private Connection conn;
        private PreparedStatement preparedStatement = null;

        public DeliveryDocketHelper() {
             try {
                // Attempt to establish a connection to the database
                conn = DriverManager.getConnection(host, user, password);

            } catch (SQLException e) {
                // Handle any exceptions that occur during the connection process
                e.printStackTrace();
            }
        }
        
        public ResultSet getAllDeliveryDocketDetails(){
                ResultSet resultSet = null;
                try {
                        String sql = "SELECT * FROM DELIVERYDOCKET";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        resultSet = preparedStatement.executeQuery();
                } catch (SQLException e) {
                        System.err.println("Error retrieving delivery dockets: " + e.getMessage());
                }
                return resultSet;
        }
        
        public boolean insertDeliveryDocket(DeliveryDocket addingRecord) {
                boolean insertSuccessful = true;

               try {
                      // Create prepared statement to issue SQL query to the database
                      try (PreparedStatement preparedStatement = conn.prepareStatement(
                            "INSERT INTO DELIVERYDOCKET VALUES(?, ?, ?, ?, ?)")) {

                      preparedStatement.setString(1, addingRecord.getDeliveryDocketId());
                      preparedStatement.setString(2, addingRecord.getPublicationid().getPublicationID());
                      preparedStatement.setString(3, addingRecord.getCustomerid().getCustomerID());
                      preparedStatement.setString(4, addingRecord.getOrderid().getOrderID());
                      preparedStatement.setString(5, addingRecord.getDeliverystatus());
                      preparedStatement.executeUpdate();
                      conn.commit();
                    }

               } catch (SQLException e) {
                      e.printStackTrace(); // Log or print the exception details
                      insertSuccessful = false;
                       
               }

                      return insertSuccessful;
       }
        
        public boolean updateDeliveryDocket(DeliveryDocket updateRecord) {
            boolean updateSuccessful = true;

            try {
                String updateQuery = "UPDATE DELIVERYDOCKET SET " +
                        "DELIVERYDOCKETID = ?, " +
                        "PUBLICATIONID = ?, " +
                        "CUSTOMERID = ?, " +
                        "ORDERID = ?, " +
                        "DELIVERYSTATUS = ? " + 
                        "WHERE DELIVERYDOCKETID = ?";

                try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, updateRecord.getDeliveryDocketId());
                      preparedStatement.setString(2, updateRecord.getPublicationid().getPublicationID());
                      preparedStatement.setString(3, updateRecord.getCustomerid().getCustomerID());
                      preparedStatement.setString(4, updateRecord.getOrderid().getOrderID());
                      preparedStatement.setString(5, updateRecord.getDeliverystatus());
                      preparedStatement.setString(6, updateRecord.getDeliveryDocketId());
                      
                    // Execute the update query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected <= 0) {
                        updateSuccessful = false;
                        System.out.println("Update failed. No records were affected.");
                    } else {
                        System.out.println("Update successful.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error message: " + e.getMessage());
                updateSuccessful = false;
            }

            return updateSuccessful;
       }
        
         public boolean deleteDeliveryDocket(String deliveryDocketId) {
            boolean deleteSuccessfull = true;

            try {
                String deleteQuery = "DELETE FROM DELIVERYDOCKET WHERE DELIVERYDOCKETID = ? ";

                try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, deliveryDocketId);

                    // Execute the query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected <= 0) {
                        deleteSuccessfull = false;
                        System.out.println("Delete unsuccessful. Something went wrong");
                    } else {
                        System.out.println("Delete successful");
                    }
                }

            } catch (Exception e) {
                deleteSuccessfull = false;
                e.printStackTrace();
            }

            return deleteSuccessfull;
       }
        
        

}
