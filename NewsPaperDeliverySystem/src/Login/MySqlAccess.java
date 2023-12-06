package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import matthew.MySQLAccess;

/**
 *
 * @author User
 */
public class MySqlAccess {
    
     
    private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
        private String user = "nbuser";
        private String password = "nbuser";
        private Connection conn;
        private PreparedStatement preparedStatement = null;

        public MySqlAccess() {
             try {
                // Attempt to establish a connection to the database
                conn = DriverManager.getConnection(host, user, password);

            } catch (SQLException e) {
                // Handle any exceptions that occur during the connection process
                e.printStackTrace();
            }
        }
        
        public boolean AdminLoginValidate(String username, String password) {
            boolean validateLogin = false;

            String sql = "SELECT * FROM USERS WHERE NAME = ? AND PASSWORD = ?";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next() && "admin".equals(password)) {
                    validateLogin = true;
                }
            } catch (SQLException e) {
                System.out.println("Error validating admin login: " + e.getMessage());
            }

            return validateLogin;
       }
        
       public boolean NewsAgentLoginValidate(String agentId, String password) {
            boolean validateLogin = false;

                String sql = "SELECT N.*, U.PASSWORD AS USER_PASSWORD " +
                             "FROM NEWSAGENT N " +
                             "JOIN USERS U ON N.USERID = U.USERID " +
                             "WHERE N.AGENTID = ? AND U.PASSWORD = ?";

            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, agentId);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is at least one row in the result set and if the password is "NewsAgent"
                if (resultSet.next() && "NewsAgent".equals(password)) {
                    validateLogin = true;
                }
            } catch (SQLException e) {
                System.out.println("Error validating newsagent login: " + e.getMessage());
            }

            return validateLogin;
        }
       
       public boolean DeliveryPersonLoginValidate(String devPersonId, String password) {
            boolean validateLogin = false;

            String sql = "SELECT D.*, U.PASSWORD AS USER_PASSWORD " +
                         "FROM DELIVERYPERSON D " +
                         "JOIN USERS U ON D.USERID = U.USERID " +
                         "WHERE D.DELIVERYMANID = ? AND U.PASSWORD = ?";

            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, devPersonId);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is at least one row in the result set and if the password is "devPerson"
                if (resultSet.next() && "devPerson".equals(password)) {
                    validateLogin = true;
                }
            } catch (SQLException e) {
                System.out.println("Error validating delivery person login: " + e.getMessage());
            }

            return validateLogin;
        }



}
