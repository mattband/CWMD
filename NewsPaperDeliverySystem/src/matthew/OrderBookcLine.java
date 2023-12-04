package matthew;


//developer. Matthew devlin

import java.sql.SQLException;
import java.util.Scanner;

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
		System.out.println("|  3. Update Order Book.                                |");
		System.out.println("|  4. Delete Order Book.                                |");
		System.out.println("|  5. Exit             .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		try {
			int input = sc.nextInt();
			switch (input) {

			case 1:
				try {
					createOrderBookMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateOrderBookMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				}

				break;

			case 2:
				try {
					printAllOrderBookMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateOrderBookMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				}

				break;
			case 3:
				try {
					updateByIDOrderBookMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateOrderBookMenu();

				}  catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				}catch (Exception e) {
					generateOrderBookMenu();
					System.out.println("\n\nUnknown Error Occurred...");
				}

				break;
			case 4:

				try {
					deleteByIDOrderBookMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateOrderBookMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				} catch (Exception e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				}
				break;

			default:

				try {
					problemOrderBoookMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generateOrderBookMenu();
				} catch (Exception e) {
					System.out.print("\n" + e.getMessage() + "\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generateOrderBookMenu();
				}
			}
		} catch (Exception e) {
			System.out.println("not a valid input");
			generateOrderBookMenu();

		}
		sc.close();
	}
	// problem still acuring

	public static void createOrderBookMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-------------------create-a-OrderBook------------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermCreate = sc.nextInt();
		if (afermCreate == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-OrderBook---------------|");
			System.out.println("|                                                       |");
			System.out.print("|\n|  . Customers ID: ");
			String cCustomerIDInput = sc.next();
			System.out.print("|\n|  . Publication ID: ");
			String cPublicationIDInput = sc.next();
			System.out.print("|\n|  . Order Shedule: ");
			String cOrderSheduleInput = sc.next();
			System.out.print("|\n|  . Order Price: ");
			String cOrderPriceInput = sc.next();
			System.out.println("|                                                      ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating Order Book from the Inputs above: ");

			
			OrderBook.validateCustomerID(cCustomerIDInput);
			OrderBook.validatePublicationID(cPublicationIDInput);
			OrderBook.validateOrderShedule(cOrderSheduleInput);
			OrderBook.validateOrderPrice(cOrderPriceInput);
			OrderBook.validateCustomerAndPublicationSame(cCustomerIDInput, cPublicationIDInput);
			String cOrderID = cCustomerIDInput;
			OrderBook orderBook = new OrderBook();
			orderBook = new OrderBook(cOrderID,cCustomerIDInput,cPublicationIDInput,cOrderPriceInput,cOrderSheduleInput);
			
			try {

				MySQLAccess sql = new MySQLAccess();
				boolean res = sql.insertOrderBook(orderBook);
				sql.insertOrderBook(orderBook);

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
			generateOrderBookMenu();
		} else if (afermCreate != 1 || afermCreate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void printAllOrderBookMenu() throws NewsAgentExceptionHandler, SQLException ,Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-------------------View-All-OberBook-------------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermViewAll = sc.nextInt();
		if (afermViewAll == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------------All-OrderBooks:-------------------|");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nFetching All Order Books: ");
				MySQLAccess sql = new MySQLAccess();
				sql.printAllOrderBooks();

		} else if (afermViewAll == 2) {
			generateOrderBookMenu();
		} else if (afermViewAll != 1 || afermViewAll != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}



	public static void updateByIDOrderBookMenu() throws NewsAgentExceptionHandler , SQLException , Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-----------------Update-OrderBook-ByID-----------------|");
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
			System.out.print("\nGenerating updated customer from the Inputs above: ");

			OrderBook orderBook = new OrderBook();
			MySQLAccess sql = new MySQLAccess();
			OrderBook.validateOrderID(uporderIDInput);
			OrderBook.validatePublicationID(uppublicationIDInput);
			OrderBook.validateCustomerID(upcustomerIDInput);
			OrderBook.validateOrderPrice(uporderPriceInput);
			OrderBook.validateOrderShedule(uporderSheduleInput);
			OrderBook.validateCustomerAndPublicationSame(upcustomerIDInput, uppublicationIDInput);
			orderBook = new OrderBook(uporderIDInput,upcustomerIDInput,uppublicationIDInput,uporderPriceInput,uporderSheduleInput);
			

				// Insert an OrderBook
				sql.updateOrderBook(orderBook);

				// Update the OrderBook by OrderID
				boolean updateResult = sql.updateOrderBook(orderBook);
				if (updateResult) {
					System.out.println("orderBook updated successfully.");
				} else {
					System.out.println("Failed to update orderBook.");
				}
		} else if (afermUpdate == 2) {
			generateOrderBookMenu();

		} else if (afermUpdate != 1 || afermUpdate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}

	public static void deleteByIDOrderBookMenu() throws NewsAgentExceptionHandler, SQLException, Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-----------------Delete-OrderBook-ByID-----------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermDelete = sc.nextInt();
		if (afermDelete == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-OrderBook-ID-------------|");
			System.out.println("|-----------Of-OrderBook-you-wish-to-Delete--------------|");
			System.out.print("|\n|  . Order ID: ");
			String deleteOrderIDInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");

			// Creating an instance of MySQLAccess
			MySQLAccess sql = new MySQLAccess();
			OrderBook.validateOrderID(deleteOrderIDInput);

			boolean deleteResult = sql.deleteOrderBook(deleteOrderIDInput);

			if (deleteResult) {
				System.out.println("OrderBook deleted successfully.");
			} else {
				System.out.println("Failed to delete OrderBook.");
			}
		} else if (afermDelete == 2) {
			generateOrderBookMenu();

		} else if (afermDelete != 1 || afermDelete != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void problemOrderBoookMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|--------------Something-has-gone-wrong-----------------|");
		System.out.println("|----------Please-exit-to-the-previous-panel------------|");
		System.out.println("|  . Exit                                              |");
		System.out.println("\\-------------------------------------------------------/");
		int exit = sc.nextInt();
		if (exit == 1) {
			generateOrderBookMenu();
		} else
			generateOrderBookMenu();
		sc.close();
	}

}
