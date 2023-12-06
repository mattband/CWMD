package Login;

import Admin.AdminCl;
import DeliveryDocket.NewsAgentInDDCommandLine;
import DeliveryPerson.DPCommandLine;
import DeliveryPerson.NewAgentInDPcommandLine;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import matthew.CustomercLine;
import matthew.InvoicecLine;
import matthew.MySQLAccess;
import matthew.OrderBookcLine;
import matthew.PublicationcLine;
import sun.tools.jar.CommandLine;

public class LoginCommandLine {
    private String username;
    private CommandLine commandLine;
    private MySQLAccess mySQLAccess;

    public static void mainMethod() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("  _____________________________________________________");
        System.out.println(" /                                                     \\");
        System.out.println("|----------------Login-Menu:---------------|");
        System.out.println("|                                                      |");
        System.out.println("|  1. NewsAgent                                  |");
        System.out.println("|  2. Admin                                         |");                                
        System.out.println("|  3. Delivery person                             |");
        System.out.println("|  4. Exit                             |");
        System.out.println("\\-------------------------------------------------------/");
        System.out.print("\nEnter selection from the options above: ");
        int choice = sc.nextInt();
        
        switch(choice){
            case 1:
                Scanner newsAgentCheck = new Scanner(System.in);
                Scanner option = new Scanner(System.in);
                System.out.println("  _____________________________________________________");
                System.out.println(" /                                                     \\");
                System.out.println("|----------------Admin-Panel:---------------|");
                System.out.println("|                                                      |");
                System.out.print("|  1. Enter Agent Id:");
                String agentId = newsAgentCheck.nextLine();
                System.out.print("|  2. Enter password:");     
                String NewsAgentpassword = newsAgentCheck.next();
                
                MySqlAccess validateNewsAgent = new MySqlAccess();
                validateNewsAgent.AdminLoginValidate(agentId, NewsAgentpassword);
                
                boolean loginResult1 = validateNewsAgent.NewsAgentLoginValidate(agentId, NewsAgentpassword);

                if (loginResult1) {
                    System.out.println("Login successful. Welcome, Agent " + agentId);
                    LoginCommandLine showMenu = new LoginCommandLine();
                    showMenu.NewsAgentMenu();
                    int choice2 = option.nextInt();
                    
                    switch(choice2){
                        case 1:
                            CustomercLine.mainMethod();
                            break;
                        case 2:
                            NewAgentInDPcommandLine.mainMethod();
                            break;
                        case 3:
                            NewsAgentInDDCommandLine.mainMethod();
                            break;
                        case 4:
                            OrderBookcLine.mainMethod();
                            break;
                        case 5:
                            PublicationcLine.mainMethod();
                        case 6:
                            InvoicecLine.mainMethod();
                        default:
                            LoginCommandLine.mainMethod();
                    }
                    
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
                break;
            case 2:
                Scanner adminCheck = new Scanner(System.in);
                System.out.println("  _____________________________________________________");
                System.out.println(" /                                                     \\");
                System.out.println("|----------------Admin-Panel:---------------|");
                System.out.println("|                                                      |");
                System.out.print("|  1. Enter username:");
                String username = adminCheck.nextLine();
                System.out.print("|  2. Enter password:");     
                String password = adminCheck.next();
                
                MySqlAccess validate = new MySqlAccess();
                validate.AdminLoginValidate(username, password);
                
                boolean loginResult2 = validate.AdminLoginValidate(username, password);

                if (loginResult2) {
                    System.out.println("Login successful. Welcome, Admin!");
                    AdminCl.mainMethod();
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
                
                break;
            case 3:
                 Scanner DeliveryPersonCheck = new Scanner(System.in);
                System.out.println("  _____________________________________________________");
                System.out.println(" /                                                     \\");
                System.out.println("|----------------Admin-Panel:---------------|");
                System.out.println("|                                                      |");
                System.out.print("|  1. Enter id:");
                String deliveryPersonId = DeliveryPersonCheck.nextLine();
                System.out.print("|  2. Enter password:");     
                String deliveryPersonPassword = DeliveryPersonCheck.next();
                
                MySqlAccess validateDeliveryPerson = new MySqlAccess();
                validateDeliveryPerson.DeliveryPersonLoginValidate(deliveryPersonId, deliveryPersonPassword);
                
                boolean loginResult3 = validateDeliveryPerson.DeliveryPersonLoginValidate(deliveryPersonId, deliveryPersonPassword);

                if (loginResult3) {
                    System.out.println("Login successful. Welcome, Staff " + deliveryPersonId);
                    DPCommandLine.mainMethod();
                } else {
                    System.out.println("Login failed. Invalid id or password.");
                }
                
            default:
                break;
                
        }
    }
    
    public static void NewsAgentMenu(){
        System.out.println("  _____________________________________________________");
        System.out.println(" /                                                     \\");
        System.out.println("|----------------NewsAgent-Menu:---------------|");
        System.out.println("|                                                      |");
        System.out.println("|  1. Modify Customer                                  |");
        System.out.println("|  2. Modify Delivery Person                                         |");                                
        System.out.println("|  3. Modify Delivery Docket                             |");
        System.out.println("|  4. Modify Order book                            |");
        System.out.println("|  5. Modify Publication                            |");
        System.out.println("|  6. Modify Invoice                             |");
        System.out.println("|  7. Exit                             |");
        System.out.println("\\-------------------------------------------------------/");
        System.out.print("\nEnter selection from the options above: ");
        
        
    }
}