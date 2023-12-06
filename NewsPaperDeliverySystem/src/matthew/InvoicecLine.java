package matthew;

import Login.LoginCommandLine;
import java.util.Scanner;

/*
 * 
 * this class is being used for a example at the current time
 * i will save it somewhere else later.*/

public class InvoicecLine {
	public static void mainMethod() throws NewsAgentExceptionHandler, Exception {
		generateInvoiceMenu();

	}

	public static void generateInvoiceMenu() throws NewsAgentExceptionHandler, Exception {
                int input;
                do{
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Invoice-Menu-Options:---------------|");
			System.out.println("|                                                       |");
			System.out.println("|  1. Create Invoice.                                  |");
			System.out.println("|  2. View All Invoices.                               |");                                
			System.out.println("|  3. View Select Invoice.                             |");
			System.out.println("|  4. Update Invoice.                                  |");
			System.out.println("|  5. Delete Invoice.                                  |");
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
				System.out.println("|-------------------create-a-Invoice-------------------|");
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
					System.out.print("|\n|  . InvoiceID: ");
					String cInvoiceIDInput = sc.next();
                                                                        System.out.print("|\n|  . PublicationID: ");
					String cPublicationIDInput = sc.next();
                                                                        Publication insertPublication = new Publication();
                                                                        insertPublication.setPublicationID(cPublicationIDInput);
                                                                        
                                                                        System.out.print("|\n|  . CustomerID: ");
					String cCustomerIDInput = sc.next();
                                                                        Customer insertCustomer = new Customer();
                                                                        insertCustomer.setCustomerID(cCustomerIDInput);
                                                                        System.out.print("|\n|  . OrderID: ");
					String cOrderIDInput = sc.next();
                                                                        OrderBook insertOrder = new OrderBook();
                                                                        insertOrder.setOrderID(cOrderIDInput);
					System.out.print("|\n|  . Invoice Message: ");    
					String cInvoiceMessageInput = sc.next();
					System.out.print("|\n|  . Price: ");
					String cPriceInput = sc.next();
					System.out.println("|                                                       ");
					System.out.println("\\-------------------------------------------------------/");
					System.out.print("\nGenerating Order Book from the Inputs above: ");

					Invoice.validateinvoiceID(cInvoiceIDInput);

					Invoice.validateCustomerID(cCustomerIDInput);
					Invoice.validatePublicationID(cPublicationIDInput);
					Invoice.validateOrderID(cOrderIDInput);
					Invoice.validatePrice(cPriceInput);
					Invoice.validateInvoiceMessage(cInvoiceMessageInput);
					
					Invoice inputInvoice = new Invoice(cInvoiceIDInput , insertPublication,insertCustomer,insertOrder,cInvoiceMessageInput,cPriceInput);
					try {
						
						MySQLAccess sql = new MySQLAccess();
						boolean res = sql.insertInvoice(inputInvoice);
						sql.insertInvoice(inputInvoice);

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
					generateInvoiceMenu();				
				}else if(afermCreate != 1 || afermCreate != 2) {
					System.out.println("please enter a valid input on screen.");
				}

						
				
				break;

			case 2:
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|----------------Are-you-sure-you-want-to---------------|");
				System.out.println("|-------------------View-All-Invoices-------------------|");
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
					System.out.print("\nFetching All Invoices: ");
					try {
						MySQLAccess sql = new MySQLAccess();
						sql.printAllInvoices();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (afermViewAll == 2) {
					generateInvoiceMenu();
				} else if (afermViewAll != 1 || afermViewAll != 2) {
					System.out.println("please enter a valid input on screen.");
				}
				
				break;
			case 3:
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|----------------Are-you-sure-you-want-to---------------|");
				System.out.println("|-------------------View-byID-Invoice------------------|");
				System.out.println("|  1. Yes.                                              |");
				System.out.println("|  2. No.                                               |");
				System.out.println("|                                                       |");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nEnter selection from the options above: ");
				int afermViewByID = sc.nextInt();
				if (afermViewByID == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|--------------Please-enter-the-Invoice-ID-------------|");
				System.out.println("|--------------Of-Invoice-you-wish-to-View-------------|");			
				System.out.print("|\n|  . Invoice ID: ");
				String getByInvoiceIDInput = sc.next();
				System.out.println("|\n|                                                       |");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nFetching Order Book from the Inputs above: ");
				Invoice.validateinvoiceID(getByInvoiceIDInput);
				try {
			        MySQLAccess sql = new MySQLAccess();

			        // Call getInvoiceById method to retrieve Invoice by InvoiceID
			        boolean getByIdResult = sql.getInvoiceById(getByInvoiceIDInput);

			        if (getByIdResult) {
			            System.out.println("Invoice retrieved successfully.");
			        } else {
			            System.out.println("Failed to retrieve Invoice. It may not exist or there was an error.");
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
				} else if (afermViewByID == 2) {
					generateInvoiceMenu();

				} else if (afermViewByID != 1 || afermViewByID != 2) {
					System.out.println("please enter a valid input on screen.");
				}   

				break;
			case 4:
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
				System.out.println("|-------and-Details-of-Invoice-you-wish-to-Update------|");	
				System.out.print("|\n|  . InvoiceID: ");
                                                          String upInvoiceIDInput = sc.next();
                                                          System.out.print("|\n|  . PublicationID: ");
                                                          String cPublicationIDInput = sc.next();
                                                          Publication upPublicationIDInput = new Publication();
                                                          upPublicationIDInput.setPublicationID(cPublicationIDInput);

                                                          System.out.print("|\n|  . CustomerID: ");
                                                          String cCustomerIDInput = sc.next();
                                                          Customer upCustomerIDInput = new Customer();
                                                          upCustomerIDInput.setCustomerID(cCustomerIDInput);
                                                          System.out.print("|\n|  . OrderID: ");
                                                          String cOrderIDInput = sc.next();
                                                          OrderBook upOrderIDInput = new OrderBook();
                                                          upOrderIDInput.setOrderID(cOrderIDInput);
                                                          System.out.print("|\n|  . Invoice Message: ");    
                                                          String upInvoiceMessageInput = sc.next();
                                                          System.out.print("|\n|  . Price: ");
                                                          String upPriceInput = sc.next();
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nGenerating updated invoice from the Inputs above: ");
				        try {
							Invoice updateInvoice = new Invoice();
				            MySQLAccess sql = new MySQLAccess();
							Invoice.validateinvoiceID(upInvoiceIDInput);
//							Invoice.validateCustomerID(upCustomerIDInput);
//							Invoice.validatePublicationID(upPublicationIDInput);
//							Invoice.validateOrderID(upOrderIDInput);
							Invoice.validateInvoiceMessage(upInvoiceMessageInput);
							Invoice.validatePrice(upPriceInput);
							updateInvoice = new Invoice(upInvoiceIDInput, upPublicationIDInput, upCustomerIDInput, upOrderIDInput, upInvoiceMessageInput,upPriceInput);

				            // Insert an Invoice
				            sql.updateInvoice(updateInvoice);

				            // Update the Invoice by InvoiceID
				            boolean updateResult = sql.updateInvoice(updateInvoice);
				            if (updateResult) {
				                System.out.println("Invoice updated successfully.");
				            } else {
				                System.out.println("Failed to update Invoice.");
				            }
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				} else if (afermUpdate == 2) {
					generateInvoiceMenu();

				} else if (afermUpdate != 1 || afermUpdate != 2) {
					System.out.println("please enter a valid input on screen.");
				}   
				
				break;
			case 5:
			    System.out.println("  _____________________________________________________");
			    System.out.println(" /                                                     \\");
			    System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			    System.out.println("|------------------Delete-Invoice--ByID-----------------|");
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
			        if (Invoice.validateinvoiceID(deleteInvoiceInput)) {
                                                            try {
                                                                MySQLAccess sql = new MySQLAccess();
                                                                boolean deleteResult = sql.deleteInvoice(deleteInvoiceInput);

                                                                if (deleteResult) {
                                                                    System.out.println("Invoice deleted successfully.");
                                                                } else {
                                                                    System.out.println("Failed to delete Invoice.");
                                                                }
                                                            } catch (Exception e) {
                                                                e.printStackTrace();
                                                            }
                                                        } else {
                                                            System.out.println("Invalid Invoice ID. Please enter a valid ID.");
                                                        }
                                                    } else if (afermDelete == 2) {
                                                        generateInvoiceMenu();
                                                    } else {
                                                        System.out.println("Please enter a valid input on screen.");
                                                    }
			    break;


			default:
                                                        LoginCommandLine.mainMethod();
				break;
			}
		}
                }while(input!= 6);

	}

	}
