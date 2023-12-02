/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DeliveryPerson;

import DeliveryDocket.DeliveryDocket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class DPCommandLine {
        public static void DeliveryPersonSelection(){
            System.out.println(" ");
            System.out.println("==================");
            System.out.println("Please select one to proceed");
            System.out.println("1. Delivery Dockets");
            System.out.println("2. Delivery status");
            System.out.println("3. Exit");
            System.out.println("==================");
            System.out.print("Select one option:");

        }
        
         public static void PrintAllDeliveryPerson(ResultSet resultSet){
            int count = 0;
            try{
                while(resultSet.next()){
                    count++;
                    int deliveryDocketId = resultSet.getInt("DELIVERYDOCKETID");
                    int publicationId = resultSet.getInt("PUBLICATIONID");
                    String customerId = resultSet.getString("CUSTOMERID");
                    String orderId = resultSet.getString("ORDERID");
                    String deliveryStatus = resultSet.getString("DELIVERYSTATUS");

                    System.out.println("No: " + count);
                    System.out.println("delivery docket id: " + deliveryDocketId);
                    System.out.println("Publication id: " + publicationId);
                    System.out.println("Customer id: " + customerId);
                    System.out.println("Order id: " + orderId);
                    System.out.println("Delivery status: " + deliveryStatus);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
         
        public static void main(String[] args) throws SQLException {
            DBHelper dbhelper = new DBHelper();
            int choice;
            do{
                
                DeliveryPersonSelection();
                Scanner scanner = new Scanner(System.in);
                Scanner update  = new Scanner(System.in);
                choice = scanner.nextInt();
            
                switch(choice){
                    case 1:
                        System.out.println(" ");
                        ResultSet resultSet = dbhelper.getAllDeliveryDocketDetails();
                        PrintAllDeliveryPerson(resultSet);
                        break;
                    case 2:
                            ResultSet resultSet2 = dbhelper.getAllDeliveryDocketDetails();
                            int count = 0;
                            System.out.println("IDs");

                            while (resultSet2.next()) {
                                count++;
                                int idToDisplay = resultSet2.getInt("DELIVERYDOCKETID");
                                String deliveryStatus = resultSet2.getString("DELIVERYSTATUS");
                                System.out.println(" " + idToDisplay + "- " + deliveryStatus);
                            }
                            System.out.println("=======");
                            System.out.print("Enter id: ");
                            int docketId = update.nextInt();
                            
                            System.out.print("Enter new delivery status: ");
                            String newStatus = update.next();
                            
                            // Update the delivery status based on the entered ID
                            DeliveryDocket docketToUpdate = new DeliveryDocket();
                            docketToUpdate.setDeliverydocketid(docketId);
                            docketToUpdate.setDeliverystatus(newStatus);

                            boolean updateResult = dbhelper.updateDeliveryDocketStatus(docketToUpdate);

                            if (updateResult) {
                                System.out.println("Delivery status updated successfully");
                            } else {
                                System.out.println("Delivery status update unsuccessful");
                            }
                            
                        break;
                }
            }while(choice != 3);

        }
        
}
