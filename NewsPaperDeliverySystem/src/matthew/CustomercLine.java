package matthew;

import Login.LoginCommandLine;
import java.util.Random;
import java.util.Scanner;



public class CustomercLine {
	public static void mainMethod() throws NewsAgentExceptionHandler, Exception {
		generateCustomerMenu();

	}

	public static void generateCustomerMenu() throws NewsAgentExceptionHandler, Exception {
                int input;
        
                do{
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Customer-Menu-Options:---------------|");
		System.out.println("|                                                       |");
		System.out.println("|  1. Create Customer.                                  |");
		System.out.println("|  2. View All Customers.                               |");                                
		System.out.println("|  3. View Select Customer.                             |");
		System.out.println("|  4. Update Customer.                                  |");
		System.out.println("|  5. Delete Customer.                                  |");
		System.out.println("|  6. Exit.            .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
                                input = sc.nextInt();
		switch (input) {

		case 1:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-------------------create-a-Customer-------------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermCreate = sc.nextInt();
			if(afermCreate == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|--------------Please-enter-the-following:--------------|");
                                                                System.out.print("|\n|  . Customers id: ");
				String customerIdInput = sc.next();
				System.out.print("|\n|  . Customers Name: ");
				String customerNameInput = sc.next();
                                                                System.out.print("|\n|  . Customers address: ");
				String customerAddressInput = sc.next();
				System.out.print("|\n|  . Phone Number: ");    
				String phoneNumberInput = sc.next();
                                                                System.out.print("|\n|  . Customers publication id: ");
				String publicationIdInput = sc.next();
                                                                Publication pbInput = new Publication();
                                                                pbInput.setPublicationID(publicationIdInput);
                                
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nGenerating Order Book from the Inputs above: ");
				Random random = new  Random(System.currentTimeMillis());
				int customerIDint = ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
				Customer.validateCustomerID(customerIdInput);
				Customer.validatePublicationID(publicationIdInput);
				Customer.validateAddressID(customerAddressInput);
				Customer.validatePhoneNumber(phoneNumberInput);
				Customer.validateCustomerName(customerNameInput);
				Customer inputCustomer = new Customer(customerIdInput,customerNameInput,customerAddressInput,phoneNumberInput,pbInput);
				try {
					
					MySQLAccess sql = new MySQLAccess();
					boolean res = sql.insertCustomer(inputCustomer);
					sql.insertCustomer(inputCustomer);

					if(res) {
						System.out.println("Inserted");
					}
					if(!res) {
						System.out.println("not Inserted");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (afermCreate == 2) {
				generateCustomerMenu();				
			}else if(afermCreate != 1 || afermCreate != 2) {
				System.out.println("please enter a valid input on screen.");
			}
	
					
			
			break;

		case 2:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-------------------View-All-Customers------------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewAll = sc.nextInt();
			if (afermViewAll == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|----------------------All-Customers:--------------------|");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nFetching All Order Books: ");
				try {
					MySQLAccess sql = new MySQLAccess();
					sql.printAllCustomers();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermViewAll == 2) {
				generateCustomerMenu();
			} else if (afermViewAll != 1 || afermViewAll != 2) {
				System.out.println("please enter a valid input on screen.");
			}
			
			break;
		case 3:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-------------------View-byID-Customer------------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewByID = sc.nextInt();
			if (afermViewByID == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Customer-ID-------------|");
			System.out.println("|--------------Of-Customer-you-wish-to-View-------------|");			
			System.out.print("|\n|  . Customer ID: ");
			String getByCustomerIDInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nFetching Order Book from the Inputs above: ");
			Customer.validateCustomerID(getByCustomerIDInput);
			try {
	            MySQLAccess sql = new MySQLAccess();

	            // Call getCustomergetById method to retrieve Customer by CustomerID
	            boolean getByIdResult = sql.getCustomerById(getByCustomerIDInput);

	            if (getByIdResult) {
	                System.out.println("Custmoner retrieved successfully.");
	            } else {
	                System.out.println("Failed to retrieve Customer. It may not exist or there was an error.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			} else if (afermViewByID == 2) {
				generateCustomerMenu();

			} else if (afermViewByID != 1 || afermViewByID != 2) {
				System.out.println("please enter a valid input on screen.");
			}   

			break;
		case 4:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|------------------Update-Customer-ByID-----------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermUpdate = sc.nextInt();
			if (afermUpdate == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Customer-ID-------------|");
			System.out.println("|-----and-Details-of-Customer-you-wish-to-Update------|");	
			System.out.print("|\n|  . Customer ID: ");
			String upCustomerIDInput = sc.next();
			System.out.print("|\n|  . Customers Name: ");
			String upcustomerNameInput = sc.next();
                                                System.out.print("|\n|  . Customers address: ");
			String upcustomerAddressInput = sc.next();
			System.out.print("|\n|  . Phone Number: ");    
			String upPhoneNumberInput = sc.next();
                                                System.out.print("|\n|  . Publication id: ");    
			String upPublicationIdInput = sc.next();
                                                Publication upPbInput = new Publication();
                                                upPbInput.setPublicationID(upPublicationIdInput);
                                                
			System.out.println("|                                                       ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating updated customer from the Inputs above: ");


			        try {
						Customer updateCustomer = new Customer();
			            MySQLAccess sql = new MySQLAccess();
			            Customer.validateCustomerID(upCustomerIDInput);
			            Customer.validateCustomerName(upcustomerNameInput);
			            Customer.validateAddressID(upcustomerAddressInput);
			            Customer.validatePhoneNumber(upPhoneNumberInput);
						updateCustomer = new Customer(upCustomerIDInput,upcustomerNameInput,upcustomerAddressInput,upPhoneNumberInput,upPbInput);

			            // Insert an OrderBook
			            sql.updateCustomer(updateCustomer);

			            // Update the OrderBook by OrderID
			            boolean updateResult = sql.updateCustomer(updateCustomer);
			            if (updateResult) {
			                System.out.println("Customer updated successfully.");
			            } else {
			                System.out.println("Failed to update Customer.");
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			} else if (afermUpdate == 2) {
				generateCustomerMenu();

			} else if (afermUpdate != 1 || afermUpdate != 2) {
				System.out.println("please enter a valid input on screen.");
			}   
			
			break;
		case 5:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|------------------Delete-Customer-ByID-----------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermDelete = sc.nextInt();
			if (afermDelete == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Customer-ID--------------|");
			System.out.println("|-------------Of-Customer-you-wish-to-Delete-------------|");
			System.out.print("|\n|  . Customer ID: ");
			String deleteCustomerInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			try {
	            // Creating an instance of MySQLAccess
	            MySQLAccess sql = new MySQLAccess();	
	            Customer.validateCustomerID(deleteCustomerInput);
	                boolean deleteResult = sql.deleteCustomer(deleteCustomerInput);

	                if (deleteResult) {
	                    System.out.println("Customer deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete Customer.");
	                }
	            } catch (Exception e) {
	            e.printStackTrace();
	        }
			} else if (afermDelete == 2) {
				generateCustomerMenu();

			} else if (afermDelete != 1 || afermDelete != 2) {
				System.out.println("please enter a valid input on screen.");
			}  
			break;



                    case 6:
                                           LoginCommandLine.mainMethod();

		}
                }while(input != 6);

	}

	}

