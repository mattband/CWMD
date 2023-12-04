package matthew;


//developer. Matthew devlin

import java.sql.SQLException;
import java.util.Scanner;

public class InvoicecLine {
	public static void main(String[] args) throws NewsAgentExceptionHandler {
		generateInvoiceMenu();

	}

	public static void generateInvoiceMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                      \\");
		System.out.println("|------------------Invoice-Menu-Options:-----------------|");
		System.out.println("|                                                        |");
		System.out.println("|  1. Create Invoice.                                    |");
		System.out.println("|  2. View All Invoices.                                 |");                                
		System.out.println("|  3. Update Invoice.                                    |");
		System.out.println("|  4. Delete Invoice.                                    |");
		System.out.println("|  5. Exit.            .                                 |");
		System.out.println("|                                                        |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		try {
			int input = sc.nextInt();
			switch (input) {

			case 1:
				try {
					createInvoiceMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateInvoiceMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				}

				break;

			case 2:
				try {
					printAllInvoiceMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateInvoiceMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				}

				break;
			case 3:
				try {
					updateByIDInvoiceMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateInvoiceMenu();

				}  catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				}catch (Exception e) {
					generateInvoiceMenu();
					System.out.println("\n\nUnknown Error Occurred...");
				}

				break;
			case 4:

				try {
					deleteByIDInvoiceMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateInvoiceMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				} catch (Exception e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				}
				break;

			default:
				// problem still acuring

				try {
					problemInvoiceMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateInvoiceMenu();
				} catch (Exception e) {
					System.out.print("\n" + e.getMessage() + "\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateInvoiceMenu();
				}
			}
		} catch (Exception e) {
			System.out.println("not a valid input");
			generateInvoiceMenu();

		}
		sc.close();
	}

	public static void createInvoiceMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-------------------create-a-Invoice--------------------|");
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
			System.out.print("|\n|  . InvoiceID: ");
			String cInvoiceIDInput = sc.next();
			System.out.print("|\n|  . Invoice Message: ");    
			String cInvoiceMessageInput = sc.next();
			System.out.print("|\n|  . Price: ");
			String cPriceInput = sc.next();
			System.out.println("|                                                          ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating Order Book from the Inputs above: ");
			Invoice.validateinvoiceID(cInvoiceIDInput);
			String cPublicationIDInput = cInvoiceIDInput;
			String cCustomerID = cInvoiceIDInput;
			String cOrderID = cInvoiceIDInput;

			Invoice.validateCustomerID(cCustomerID);
			Invoice.validatePublicationID(cPublicationIDInput);
			Invoice.validateOrderID(cOrderID);
			Invoice.validatePrice(cPriceInput);
			Invoice.validateInvoiceMessage(cInvoiceMessageInput);
			
			Invoice inputInvoice = new Invoice(cInvoiceIDInput,cCustomerID,cPublicationIDInput,cOrderID,cInvoiceMessageInput,cPriceInput);
			try {

				MySQLAccess sql = new MySQLAccess();
				boolean res = sql.insertInvoice(inputInvoice);
				sql.insertInvoice(inputInvoice);

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
			generateInvoiceMenu();
		} else if (afermCreate != 1 || afermCreate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void printAllInvoiceMenu() throws NewsAgentExceptionHandler, SQLException ,Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-------------------View-All-Invoices------------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermViewAll = sc.nextInt();
		if (afermViewAll == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------------All-Invoices:--------------------|");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nFetching All Order Books: ");
				MySQLAccess sql = new MySQLAccess();
				sql.printAllInvoices();
		} else if (afermViewAll == 2) {
			generateInvoiceMenu();
		} else if (afermViewAll != 1 || afermViewAll != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}



	public static void updateByIDInvoiceMenu() throws NewsAgentExceptionHandler , SQLException , Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|------------------Update-Invoice-ByID------------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermUpdate = sc.nextInt();
		if (afermUpdate == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Invoice-ID-------------|");
			System.out.println("|-----and-Details-of-Invoice-you-wish-to-Update--------|");
			System.out.print("|\n|  . InvoiceID: ");
			String upInvoiceIDInput = sc.next();
			System.out.print("|\n|  . Invoice Message: ");    
			String upInvoiceMessageInput = sc.next();
			System.out.print("|\n|  . Price: ");
			String upPriceInput = sc.next();
			System.out.println("|                                                        ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating updated customer from the Inputs above: ");

			Invoice updateInvoice = new Invoice();
            MySQLAccess sql = new MySQLAccess();
			Invoice.validateinvoiceID(upInvoiceIDInput);
			String upPublicationIDInput = upInvoiceIDInput;
			String upCustomerIDInput = upInvoiceIDInput;
			String upOrderIDInput = upInvoiceIDInput;
			Invoice.validateCustomerID(upCustomerIDInput);
			Invoice.validatePublicationID(upPublicationIDInput);
			Invoice.validateOrderID(upOrderIDInput);
			Invoice.validateInvoiceMessage(upInvoiceMessageInput);
			Invoice.validatePrice(upPriceInput);
			updateInvoice = new Invoice(upInvoiceIDInput,upCustomerIDInput,upPublicationIDInput,upOrderIDInput,upInvoiceMessageInput,upPriceInput);

            // Insert an Invoice
            sql.updateInvoice(updateInvoice);

            // Update the Invoice by InvoiceID
            boolean updateResult = sql.updateInvoice(updateInvoice);
            if (updateResult) {
                System.out.println("Invoice updated successfully.");
            } else {
                System.out.println("Failed to update Invoice.");
            }
		} else if (afermUpdate == 2) {
			generateInvoiceMenu();

		} else if (afermUpdate != 1 || afermUpdate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}

	public static void deleteByIDInvoiceMenu() throws NewsAgentExceptionHandler, SQLException, Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-----------------Delete-Invoice-ByID-------------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermDelete = sc.nextInt();
		if (afermDelete == 1) {
	        System.out.println("  _____________________________________________________");
	        System.out.println(" /                                                     \\");
	        System.out.println("|--------------Please-enter-the-Invoice-ID--------------|");
	        System.out.println("|-------------Of-Invoice-you-wish-to-Delete-------------|");
	        System.out.print("|\n|  . Invoice ID: ");
	        String deleteInvoiceInput = sc.next();
	        System.out.println("|\n|                                                       |");
	        System.out.println("\\-------------------------------------------------------/");

			// Creating an instance of MySQLAccess
			MySQLAccess sql = new MySQLAccess();
			Invoice.validateinvoiceID(deleteInvoiceInput);
			boolean deleteResult = sql.deleteInvoice(deleteInvoiceInput);

			if (deleteResult) {
				System.out.println("Invoice deleted successfully.");
			} else {
				System.out.println("Failed to delete Invoice.");
			}
		} else if (afermDelete == 2) {
			generateInvoiceMenu();

		} else if (afermDelete != 1 || afermDelete != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void problemInvoiceMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|--------------Something-has-gone-wrong-----------------|");
		System.out.println("|----------Please-exit-to-the-previous-panel------------|");
		System.out.println("|  . Exit                                              |");
		System.out.println("\\-------------------------------------------------------/");
		int exit = sc.nextInt();
		if (exit == 1) {
			generateInvoiceMenu();
		} else
			generateInvoiceMenu();
		sc.close();
	}

}

