package matthew;

import java.util.Random;
import java.util.Scanner;

/*
 * 
 * this class is being used for a example at the current time
 * i will save it somewhere else later.*/

public class OrderBookcLine {
	public static void main(String[] args) throws NewsAgentExceptionHandler {
		generateOrderBookMenu();

	}

	public static void generateOrderBookMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Order-Book-Menu-Options:---------------|");
		System.out.println("|                                                       |");
		System.out.println("|  1. Create Order Book.                                |");
		System.out.println("|  2. View All Order Books.                             |");                                
		System.out.println("|  3. View Select Order Book.                           |");
		System.out.println("|  4. Update Order Book.                                |");
		System.out.println("|  5. Delete Order Book.                                |");
		System.out.println("|  6. Exit             .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int input = sc.nextInt();
		switch (input) {

		case 1:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------create-a-Order-Book-------------------|");
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
				System.out.print("|\n|  . Customers ID: ");
				String customerIDInput = sc.next();
				System.out.print("|\n|  . Publication ID: ");    
				String publicationIDInput = sc.next();
				System.out.print("|\n|  . Order Shedule: ");
				String orderSheduleInput = sc.next();
				System.out.print("|\n|  . Order Price: ");
				String orderPriceInput = sc.next();
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nGenerating Order Book from the Inputs above: ");
				Random random = new  Random(System.currentTimeMillis());
				int orderIDint = ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
				String orderIDinput = Integer.toString(orderIDint);
				OrderBook.validateOrderID(orderIDinput);
				OrderBook.validateCustomerID(customerIDInput);
				OrderBook.validatePublicationID(publicationIDInput);
				OrderBook.validateOrderPrice(orderPriceInput);
				OrderBook.validateOrderShedule(orderSheduleInput);
				OrderBook.validateCustomerAndPublicationSame(customerIDInput, publicationIDInput);
				OrderBook inputOrderBook = new OrderBook(orderIDinput,customerIDInput,publicationIDInput,orderSheduleInput,orderPriceInput);
				try {
					
					MySQLAccess sql = new MySQLAccess();
					boolean res = sql.insertOrderBook(inputOrderBook);
					sql.insertOrderBook(inputOrderBook);

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
				generateOrderBookMenu();
				
			}else if(afermCreate != 1 || afermCreate != 2) {
				System.out.println("please enter a valid input on screen.");
			}
	
					
			
			break;

		case 2:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------View-All-Order-Books------------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewAll = sc.nextInt();
			if (afermViewAll == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|----------------------All-order-Books:----------------|");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nFetching All Order Books: ");
				try {
					MySQLAccess sql = new MySQLAccess();
					sql.printAllOrderBooks();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermViewAll == 2) {
				generateOrderBookMenu();

			} else if (afermViewAll != 1 || afermViewAll != 2) {
				System.out.println("please enter a valid input on screen.");
			}
			
			break;
		case 3:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------View-byID-Order-Books------------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewByID = sc.nextInt();
			if (afermViewByID == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Order-ID----------------|");
			System.out.println("|------------Of-Order-Book-you-wish-to-View-------------|");			
			System.out.print("|\n|  . Order ID: ");
			String getByOrderIDInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nFetching Order Book from the Inputs above: ");
			OrderBook.validateOrderID(getByOrderIDInput);
	        try {
	            MySQLAccess sql = new MySQLAccess();

	            // Call getOrderBookById method to retrieve OrderBook by OrderID
	            boolean getByIdResult = sql.getOrderBookById(getByOrderIDInput);

	            if (getByIdResult) {
	                System.out.println("OrderBook retrieved successfully.");
	            } else {
	                System.out.println("Failed to retrieve OrderBook. It may not exist or there was an error.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			} else if (afermViewByID == 2) {
				generateOrderBookMenu();

			} else if (afermViewByID != 1 || afermViewByID != 2) {
				System.out.println("please enter a valid input on screen.");
			}   

			break;
		case 4:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------Update-Order-Books-ByID---------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermUpdate = sc.nextInt();
			if (afermUpdate == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Order-ID----------------|");
			System.out.println("|-----and-Details-of-Order-Book-you-wish-to-Update------|");	
			System.out.print("|\n|  . Order ID: ");
			String uporderIDInput = sc.next();
			System.out.print("|\n|  . Customers ID: ");
			String upcustomerIDInput = sc.next();
			System.out.print("|\n|  . Publication ID: ");    
			String uppublicationIDInput = sc.next();
			System.out.print("|\n|  . Order Shedule: ");
			String uporderSheduleInput = sc.next();
			System.out.print("|\n|  . Order Price: ");
			String uporderPriceInput = sc.next();
			System.out.println("|                                                       ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating Order Book from the Inputs above: ");
			


			        try {
						OrderBook updateOrderBook = new OrderBook();
			            MySQLAccess sql = new MySQLAccess();
			            OrderBook.validateOrderID(uporderIDInput);
			            OrderBook.validateCustomerID(upcustomerIDInput);
			            OrderBook.validatePublicationID(uppublicationIDInput);
			            OrderBook.validateOrderPrice(uporderPriceInput);
			            OrderBook.validateOrderShedule(uporderSheduleInput);
			            OrderBook.validateCustomerAndPublicationSame(upcustomerIDInput, uppublicationIDInput);
						updateOrderBook = new OrderBook(uporderIDInput,upcustomerIDInput,uppublicationIDInput,uporderSheduleInput,uporderPriceInput);

			            // Insert an OrderBook
			            sql.updateOrderBook(updateOrderBook);

			            // Update the OrderBook by OrderID
			            boolean updateResult = sql.updateOrderBook(updateOrderBook);
			            if (updateResult) {
			                System.out.println("OrderBook updated successfully.");
			            } else {
			                System.out.println("Failed to update OrderBook.");
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			} else if (afermUpdate == 2) {
				generateOrderBookMenu();

			} else if (afermUpdate != 1 || afermUpdate != 2) {
				System.out.println("please enter a valid input on screen.");
			}   
			
			break;
		case 5:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------Delete-Order-Books-ByID---------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermDelete = sc.nextInt();
			if (afermDelete == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Order-ID----------------|");
			System.out.println("|----------Of-Order-Book-you-wish-to-Delete-------------|");
			System.out.print("|\n|  . Order ID: ");
			String deleteOrderIDInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			try {
	            // Creating an instance of MySQLAccess
	            MySQLAccess sql = new MySQLAccess();	
	            OrderBook.validateOrderID(deleteOrderIDInput);
	                boolean deleteResult = sql.deleteOrderBook(deleteOrderIDInput);

	                if (deleteResult) {
	                    System.out.println("OrderBook deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete OrderBook.");
	                }
	            } catch (Exception e) {
	            e.printStackTrace();
	        }
			} else if (afermDelete == 2) {
				generateOrderBookMenu();

			} else if (afermDelete != 1 || afermDelete != 2) {
				System.out.println("please enter a valid input on screen.");
			}  
			break;



		default:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Something-has-gone-wrong-----------------|");
			System.out.println("|----------Please-exit-to-the-previous-panel------------|");
			System.out.println("|  1. Exit                                              |");
			System.out.println("\\-------------------------------------------------------/");
			int exit = sc.nextInt();
			if(exit == 1) {
				generateOrderBookMenu();
			} else
				System.out.println("please enter a valid input on screen.");

		}

	}

	}

