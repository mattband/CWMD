package DeliveryPerson;

import DeliveryDocket.DeliveryDocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
        private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
        private String user = "nbuser";
        private String password = "nbuser";
        private Connection conn;
        private PreparedStatement preparedStatement = null;

        public DBHelper() {
             try {
                // Attempt to establish a connection to the database
                conn = DriverManager.getConnection(host, user, password);

            } catch (SQLException e) {
                // Handle any exceptions that occur during the connection process
                e.printStackTrace();
            }
        }
    
        public ResultSet getAllDeliveryPersonDetails(){
                ResultSet resultSet = null;
                try {
                        String sql = "SELECT * FROM DeliveryPerson";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        resultSet = preparedStatement.executeQuery();
                } catch (SQLException e) {
                        System.err.println("Error retrieving delivery persons: " + e.getMessage());
                }
                return resultSet;
        }
        
        
        public boolean insertDeliveryPerson(DeliveryPerson addingRecord) {
                boolean insertSuccessful = true;

               try {
                      // Create prepared statement to issue SQL query to the database
                      try (PreparedStatement preparedStatement = conn.prepareStatement(
                            "INSERT INTO DELIVERYPERSON VALUES( ?, ?, ?, ?, ?)")) {

                      preparedStatement.setString(1, addingRecord.getDeliveryManId());
                      preparedStatement.setString(2, addingRecord.getPhoneNumber());
                      preparedStatement.setString(3, addingRecord.getDeliveryDocketId().getDeliveryDocketId());
                      preparedStatement.setString(4, addingRecord.getArea());
                      preparedStatement.setString(5, addingRecord.getUserId().getUserId());
                      preparedStatement.executeUpdate();
                      conn.commit();
                    }

               } catch (SQLException e) {
                      e.printStackTrace(); // Log or print the exception details
                      insertSuccessful = false;
                       
               }

                      return insertSuccessful;
       }
        
        public boolean updateDeliveryPerson(DeliveryPerson updateRecord) {
            boolean updateSuccessful = true;

            try {
                String updateQuery = "UPDATE DELIVERYPERSON SET " +
                        "DELIVERYPHONENUMBER = ?, " +
                        "DELIVERYDOCKET = ?, " +
                        "AREA = ?, " +
                        "USERID = ? " +
                        "WHERE DELIVERYMANID = ?";

                try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, updateRecord.getPhoneNumber());
                    preparedStatement.setString(2, updateRecord.getDeliveryDocketId().getDeliveryDocketId());
                    preparedStatement.setString(3, updateRecord.getArea());
                    preparedStatement.setString(4, updateRecord.getUserId().getUserId());
                    preparedStatement.setString(5, updateRecord.getDeliveryManId());

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

       public boolean deleteDeliveryPerson(String deliveryPersonId) {
            boolean deleteSuccessfull = true;

            try {
                String deleteQuery = "DELETE FROM DELIVERYPERSON WHERE DELIVERYMANID = ? ";

                try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, deliveryPersonId);

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
       
       public ResultSet getAllDeliveryDocketDetails(){
                ResultSet resultSet = null;
                try {
                        String sql = "SELECT * FROM DeliveryDocket";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        resultSet = preparedStatement.executeQuery();
                } catch (SQLException e) {
                        System.err.println("Error retrieving delivery dockets: " + e.getMessage());
                }
                return resultSet;
        }

       public boolean updateDeliveryDocketStatus(DeliveryDocket deliveryDocketId) {
            boolean updateSuccessfull = true;

            try {
                String updateQuery = "UPDATE DELIVERYDOCKET SET DELIVERYSTATUS = ? WHERE DELIVERYDOCKETID = ?";

                try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, deliveryDocketId.getDeliverystatus());
                    preparedStatement.setString(2, deliveryDocketId.getDeliveryDocketId());

                    // Execute the query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected <= 0) {
                        updateSuccessfull = false;
                        System.out.println("Update unsuccessful. Something went wrong");
                    } else {
                        System.out.println("Update successful");
                    }
                }

            } catch (Exception e) {
                updateSuccessfull = false;
                e.printStackTrace();
            }

            return updateSuccessfull;
       }
    
}
