package newspaperdeliverysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NewsPaperDeliverySystem {
    private String host = "jdbc:derby://localhost:1527/NewsPaperDeliverySystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    
    public NewsPaperDeliverySystem() {
        
         try {

            // Attempt to establish a connection to the database
            conn = DriverManager.getConnection(host, user, password);

            // If no exception is thrown, the connection was successful
            System.out.println("Connected to the database!");
            
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM CUSTOMER";
            ResultSet resultset = stmt.executeQuery(sql);
            
            while(resultset.next()){
                int customerId = resultset.getInt("CustomerId");
                String customerName = resultset.getString("Name");
                String customerAddress = resultset.getString("Address");
                String customerPhoneNumber = resultset.getString("PhoneNumber");
                
                System.out.println("Customer id: " + customerId);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Customer Address: " + customerAddress);
                System.out.println("Customer phone Number: " + customerPhoneNumber);
                
            }
                
        
        } catch (SQLException e) {
            // Handle any exceptions that occur during the connection process
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NewsPaperDeliverySystem system = new NewsPaperDeliverySystem();
    }
    
}
