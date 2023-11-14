package DeliveryDocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeliveryDocket {
    private static final String url = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
    private static final String user = "nbuser";
    private static final String password = "nbuser";

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
                connection.close();
            } else {
                System.out.println("Failed to connect to the database!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    	
}
}
