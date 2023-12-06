/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DeliveryDocket;

import Login.LoginCommandLine;
import matthew.Customer;
import matthew.OrderBook;
import matthew.Publication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class NewsAgentInDDCommandLine {

    public static void DeliveryDocketMenu() {
        System.out.println(" ");
        System.out.println("==================");
        System.out.println("Please select one to proceed");
        System.out.println("1. Create new docket");
        System.out.println("2. List all dockets");
        System.out.println("3. Edit docket");
        System.out.println("4. Delete docket");
        System.out.println("5. Exit");
        System.out.println("==================");
        System.out.print("Select one option:");

    }

    public static void PrintAllDeliveryDocket(ResultSet resultSet) {
        int count = 0;
        try {
            while (resultSet.next()) {
                count++;
                String deliveryDocketId = resultSet.getString("DELIVERYDOCKETID");
                String publicationId = resultSet.getString("PUBLICATIONID");
                String customerId = resultSet.getString("CUSTOMERID");
                String orderId = resultSet.getString("ORDERID");
                String deliveryStatus = resultSet.getString("DELIVERYSTATUS");

                System.out.println("No: " + count);
                System.out.println("delivery docket Id: " + deliveryDocketId);
                System.out.println("Publication id: " + publicationId);
                System.out.println("Customer id: " + customerId);
                System.out.println("Order id: " + orderId);
                System.out.println("Delivery status: " + deliveryStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //show in the main
    public static void mainMethod() throws SQLException, Exception {
        DeliveryDocketHelper dbHelper = new DeliveryDocketHelper();
        // Get user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            DeliveryDocketHelper create = new DeliveryDocketHelper();
            DeliveryDocketHelper update = new DeliveryDocketHelper();
            Scanner inserting = new Scanner(System.in);
            Scanner updating = new Scanner(System.in);
            Scanner deleting = new Scanner(System.in);

            // Display the menu
            DeliveryDocketMenu();

            choice = scanner.nextInt();

            // Process user's choice
            switch (choice) {
                case 1:
                    System.out.println("=======");
                    System.out.print("Enter delivery docket id:");
                    String deliveryDocketId = inserting.next();

                    System.out.print("Enter publication Id:");
                    String publicationId = inserting.next();
                    Publication DDpublicationId = new Publication();
                    DDpublicationId.setPublicationID(publicationId);

                    System.out.print("Enter customer id:");
                    String customerId = inserting.next();
                    Customer DDcustomerId = new Customer(customerId);
                    DDcustomerId.setCustomerID(customerId);

                    System.out.print("Enter order id: ");
                    String orderId = inserting.next();
                    OrderBook DDorderId = new OrderBook(orderId);
                    DDorderId.setOrderID(orderId);

                    System.out.print("Enter delivery status: ");
                    String deliveryStatus = inserting.next();

                    DeliveryDocket newDocket = new DeliveryDocket(deliveryDocketId, DDpublicationId, DDcustomerId, DDorderId, deliveryStatus);
                    boolean addedResult = create.insertDeliveryDocket(newDocket);
                    if (addedResult == true) {
                        System.out.println("Record added successfully");
                    } else {
                        System.out.println("Record added unsuccessfull");
                    }
                    break;
                case 2:
                    // Retrieve and print all delivery persons
                    System.out.println(" ");
                    ResultSet resultSet = dbHelper.getAllDeliveryDocketDetails();
                    PrintAllDeliveryDocket(resultSet);
                    break;
                case 3:
                    // Edit account logic
                    ResultSet resultSet2 = dbHelper.getAllDeliveryDocketDetails();
                    int count = 0;
                    System.out.println("IDs");

                    while (resultSet2.next()) {
                        count++;
                        String idToDisplay = resultSet2.getString("DELIVERYDOCKETID");
                        System.out.println(" " + idToDisplay);
                    }
                    System.out.println("=======");
                    System.out.print("Enter delivery docket id: ");
                    String updateDeliveryDocketId = inserting.next();

                    System.out.print("Enter publication Id:");
                    String updatePublicationId = inserting.next();
                    Publication updateDDpublicationId = new Publication();
                    updateDDpublicationId.setPublicationID(updatePublicationId);

                    System.out.print("Enter customer id:");
                    String updateCustomerId = inserting.next();
                    Customer updateDDcustomerId = new Customer(updateCustomerId);
                    updateDDcustomerId.setCustomerID(updateCustomerId);

                    System.out.print("Enter order id: ");
                    String updateOrderId = inserting.next();
                    OrderBook updateDDorderId = new OrderBook(updateOrderId);
                    updateDDorderId.setOrderID(updateOrderId);

                    System.out.print("Enter delivery status: ");
                    String updatedeliveryStatus = inserting.next();

                    DeliveryDocket editDocket = new DeliveryDocket(updateDeliveryDocketId, updateDDpublicationId, updateDDcustomerId, updateDDorderId, updatedeliveryStatus);
                    boolean updateResult = update.updateDeliveryDocket(editDocket);
                    if (updateResult == true) {
                        System.out.println("Record updated successfully");
                    } else {
                        System.out.println("Record updated unsuccessfull");
                    }
                    break;
                case 4:
                    // Delete account logic
                    ResultSet resultSet3 = dbHelper.getAllDeliveryDocketDetails();

                    System.out.println("IDs");

                    while (resultSet3.next()) {
                        String idToDisplay = resultSet3.getString("DELIVERYDOCKETID");
                        System.out.println(" " + idToDisplay);
                    }

                    System.out.println("Select 1 id to delete:");
                    String idDelete = deleting.next();

                    // Pass the String ID to deleteDeliveryPerson
                    boolean deleteResult = dbHelper.deleteDeliveryDocket(idDelete);

                    if (deleteResult) {
                        System.out.println("Record deleted successfully");
                    } else {
                        System.out.println("Record deletion unsuccessful");
                    }
                case 5:
                     LoginCommandLine.mainMethod();
                    break;
                  
            }
        } while (choice != 5);
        // Close the scanner
        scanner.close();

    }
}
