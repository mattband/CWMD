package matthew;


//developer. Matthew devlin

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class CustomercLine {
	public static void main(String[] args) throws NewsAgentExceptionHandler {
		generateCustomerMenu();

	}

	public static void generateCustomerMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Customer-Menu-Options:-  --------------|");
		System.out.println("|                                                       |");
		System.out.println("|  1. Create Customer.                                  |");
		System.out.println("|  2. View All Customers.                               |");
		System.out.println("|  3. update Customer.                                  |");
		System.out.println("|  4. delete Customer.                                  |");
		System.out.println("|  5. Exit Customer.                                    |");
		System.out.println("|                      .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		try {
			int input = sc.nextInt();
			switch (input) {

			case 1:
				try {
					createCustomerMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateCustomerMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				}

				break;

			case 2:
				try {
					printAllCustomerMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateCustomerMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				}

				break;
			case 3:
				try {
					updateByIDCustomerMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateCustomerMenu();

				}  catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				}catch (Exception e) {
					generateCustomerMenu();
					System.out.println("\n\nUnknown Error Occurred...");
				}

				break;
			case 4:
				// problem still acuring

				try {
					deleteByIDCustomerMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateCustomerMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				} catch (Exception e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				}
				break;

			default:
				// problem still acuring

				try {
					problemCustomerMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateCustomerMenu();
				} catch (Exception e) {
					System.out.print("\n" + e.getMessage() + "\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateCustomerMenu();
				}
			}
		} catch (Exception e) {
			System.out.println("not a valid input");
			generateCustomerMenu();

		}
		sc.close();
	}
	// problem still acuring

	public static void createCustomerMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
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
		if (afermCreate == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-following:--------------|");
			System.out.print("|\n|  . Customers Name: ");
			String customerNameInput = sc.next();
			System.out.print("|\n|  . AddressStreet : ");
			String cAddressStreetInput = sc.next();
			System.out.print("|\n|  . Phone Number: ");
			String phoneNumberInput = sc.next();
			System.out.println("|                                                       ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating Order Book from the Inputs above: ");
			Random random = new Random(System.currentTimeMillis());
			int customerIDint = ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
			String customerIDinput = Integer.toString(customerIDint);
			String cPublicationinput = customerIDinput;
			Customer.validatePublicationID(cPublicationinput);
			Customer.validateCustomerID(customerIDinput);
			Customer.validateAddress(cAddressStreetInput);
			Customer.validatePhoneNumber(phoneNumberInput);
			Customer.validateCustomerName(customerNameInput);
			Customer inputCustomer = new Customer(customerIDinput, customerNameInput, cAddressStreetInput,
					phoneNumberInput,cPublicationinput);
			try {

				MySQLAccess sql = new MySQLAccess();
				boolean res = sql.insertCustomer(inputCustomer);
				sql.insertCustomer(inputCustomer);

				if (res) {
					System.out.println("Inserted");
				}
				if (!res) {
					System.out.println("not Inserted");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (afermCreate == 2) {
			generateCustomerMenu();
		} else if (afermCreate != 1 || afermCreate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void printAllCustomerMenu() throws NewsAgentExceptionHandler, SQLException ,Exception {
		Scanner sc = new Scanner(System.in);
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
				MySQLAccess sql = new MySQLAccess();
				sql.printAllCustomers();

		} else if (afermViewAll == 2) {
			generateCustomerMenu();
		} else if (afermViewAll != 1 || afermViewAll != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}



	public static void updateByIDCustomerMenu() throws NewsAgentExceptionHandler , SQLException , Exception{
		Scanner sc = new Scanner(System.in);
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
			System.out.println("|-----and-Details-of-Customer-you-wish-to-Update--------|");
			System.out.print("|\n|  . Customer ID: ");
			String upCustomerIDInput = sc.next();
			System.out.print("|\n|  . Customers Name: ");
			String upcustomerNameInput = sc.next();
			System.out.print("|\n|  . AddressStreet : ");
			String upAddressStreetInput = sc.next();
			System.out.print("|\n|  . Phone Number: ");
			String upPhoneNumberInput = sc.next();
			System.out.println("|                                                       ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating updated customer from the Inputs above: ");

				Customer updateCustomer = new Customer();
				MySQLAccess sql = new MySQLAccess();
				Customer.validateCustomerID(upCustomerIDInput);
				String upPublicationID = upCustomerIDInput;
				Customer.validateCustomerName(upcustomerNameInput);
				Customer.validatePhoneNumber(upPhoneNumberInput);
				Customer.validateAddress(upAddressStreetInput);
				updateCustomer = new Customer(upCustomerIDInput, upcustomerNameInput, upAddressStreetInput,
						upPhoneNumberInput,upPublicationID);

				// Insert an customer
				sql.updateCustomer(updateCustomer);

				boolean updateResult = sql.updateCustomer(updateCustomer);
				if (updateResult) {
					System.out.println("Customer updated successfully.");
				} else {
					System.out.println("Failed to update Customer.");
				}
		} else if (afermUpdate == 2) {
			generateCustomerMenu();

		} else if (afermUpdate != 1 || afermUpdate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}

	public static void deleteByIDCustomerMenu() throws NewsAgentExceptionHandler, SQLException, Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-----------------Delete-Customer-ByID------------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermDelete = sc.nextInt();
		if (afermDelete == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Customer-ID-------------|");
			System.out.println("|----------Of-Customer-Book-you-wish-to-Delete----------|");
			System.out.print("|\n|  . Customer ID: ");
			String deleteCustomerIDInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");

			// Creating an instance of MySQLAccess
			MySQLAccess sql = new MySQLAccess();
			Customer.validateCustomerID(deleteCustomerIDInput);
			boolean deleteResult = sql.deleteCustomer(deleteCustomerIDInput);

			if (deleteResult) {
				System.out.println("Customer deleted successfully.");
			} else {
				System.out.println("Failed to delete Customer.");
			}
		} else if (afermDelete == 2) {
			generateCustomerMenu();

		} else if (afermDelete != 1 || afermDelete != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void problemCustomerMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|--------------Something-has-gone-wrong-----------------|");
		System.out.println("|----------Please-exit-to-the-previous-panel------------|");
		System.out.println("|  . Exit                                              |");
		System.out.println("\\-------------------------------------------------------/");
		int exit = sc.nextInt();
		if (exit == 1) {
			generateCustomerMenu();
		} else
			generateCustomerMenu();
		sc.close();
	}

}
