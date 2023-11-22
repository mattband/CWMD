package orderBook_Matt;

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
			int aferm = sc.nextInt();
			if(aferm == 1) {
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
				double orderPriceInput = sc.nextDouble();
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nGenerating Order Book from the Inputs above: ");
				Random random = new  Random(System.currentTimeMillis());
				int orderIDint = ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
				String orderIDinput = Integer.toString(orderIDint);
				OrderBook inputedorderBook = new OrderBook(orderIDinput,customerIDInput,publicationIDInput,orderSheduleInput,orderPriceInput);
			}else if (aferm == 2) {
				generateOrderBookMenu();
				
			}
	
					
			
			break;

		case 2: //TODO 
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-following:--------------|");
			System.out.print("|\n|  . Customers ID: ");

			break;
		case 3:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Order-ID----------------|");
			System.out.println("|------------Of-Order-Book-you-wish-to-View-------------|");			
			System.out.print("|\n|  . Order ID: ");
			String OrderIDInput = sc.next(); // might overlap
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			break;
		case 4:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Order-ID----------------|");
			System.out.println("|----------Of-Order-Book-you-wish-to-Update-------------|");
			break;
		case 5:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Please-enter-the-Order-ID----------------|");
			System.out.println("|----------Of-Order-Book-you-wish-to-Delete-------------|");
			break;



		default:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|--------------Something-has-gone-wrong-----------------|");
			System.out.println("|----------Please-exit-to-the-previous-panel------------|");
			System.out.println("|  1. Exit                                              |");
			System.out.println("\\-------------------------------------------------------/");
		}

	}

	}

