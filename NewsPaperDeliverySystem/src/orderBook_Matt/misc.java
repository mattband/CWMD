package orderBook_Matt;

import java.util.Scanner;

/*
 * 
 * this class is being used for a example at the current time
 * i will save it somewhere else later.*/

public class misc {
	public static void main(String[] args) {
		generateMainMenu();

	}

	public static void generateMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("main menu");

		System.out.println("1. Customer");
		System.out.println("2. Delivery Driver");
		System.out.println("3. Invoice ");
		System.out.println("4. publication");
		System.out.println("5. delivery area");
		System.out.println("6. delivery docket");
		System.out.println("7. Matt");
		System.out.println("8. read invoice");

		System.out.print("\nEnter selection from the options: ");
		int input = sc.nextInt();
		switch (input) {

		case 1:
			System.out.println("your choice is Customer");
			break;

		case 2:
			System.out.println("your choice is Delivery Driver");
			break;
		case 3:
			System.out.println("your choice is invoice");
			generateInvoiceMenu();
			break;
		case 4:
			System.out.println("your choice is invoice");

			break;
		case 5:
			System.out.println("your choice is publication");
			break;

		case 6:
			System.out.println("your choice is delivery area");
			break;
		case 7:
			System.out.println("your choice is Matt");
			break;
		case 8:
			System.out.println("your choice is read invoice");
			break;

		default:
			System.out.println("enter a fucking valid input");
		}

	}

	public static void generateInvoiceMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("invoice menu");

		System.out.println("1. create invoice");
		System.out.println("2. update  invoice");
		System.out.println("3. delete invoice ");
		System.out.println("4. read invoice");

		System.out.print("Enter a valid selection from the options: ");
		int input = sc.nextInt();
		switch (input) {

		case 1:
			System.out.println("your choice is create invoice");
			break;

		case 2:
			System.out.println("your choice is update invoice");
			break;
		case 3:
			System.out.println("your choice is delete invoice");
			break;
		case 4:
			System.out.println("your choice is read invoice");
			break;

		default:
			System.out.println("enter a fucking valid input");
		}

	}

	private static void listOrderBookFuctionalityAvailable() {

		/* this is a example of what where doing for the command line. */

		// login password and id of the admin, newsagent and deliviry person.
		System.out.println("=============================================");
		System.out.println("enter ID of user:");
		System.out.println("enter Password of user");
		System.out.println("=============================================");

		// depending on what user based of first switch case. deliviry person displ
		// case switch to determin which part to acsess
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. acssess customer");
		System.out.println("2. acssess OrderBook");
		System.out.println("3. acsess delivery person");
		System.out.println("4. acsess delivery docket");
		System.out.println("5. acsess publication");
		System.out.println("6. acsess invoice");
		System.out.println("=============================================");

		// acssess the cruds for the spcific class
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. get by OrderBook id");
		System.out.println("2. View ALL Order Book list");
		System.out.println("3. Update Order Book by ID");
		System.out.println("3. Delete Order Book by ID");
		System.out.println("4. Close Order Book");
		System.out.println("=============================================");

	}
}
