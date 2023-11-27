package matthew;

import java.util.Random;
import java.util.Scanner;

/*
 * 
 * this class is being used for a example at the current time
 * i will save it somewhere else later.*/

public class PublicationcLine {
	public static void main(String[] args) throws NewsAgentExceptionHandler {
		generatePublicationMenu();

	}

	public static void generatePublicationMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Publication-Menu-Options:--------------|");
		System.out.println("|                                                       |");
		System.out.println("|  1. Create Publication.                               |");
		System.out.println("|  2. View All Publications.                            |");
		System.out.println("|  3. View Select Publications.                         |");
		System.out.println("|  4. Update Publication.                               |");
		System.out.println("|  5. Delete Publication.                               |");
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
			System.out.println("|------------------create-a-Publication-----------------|");
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
				System.out.print("|\n|  . Publication ID: ");
				String cPublicationIDInput = sc.next();
				System.out.print("|\n|  . Title: ");
				String cTitleInput = sc.next();
				System.out.print("|\n|  . Price: ");
				String cPriceInput = sc.next();
				System.out.print("|\n|  . Quanity: ");
				String cQuanityInput = sc.next();
				System.out.print("|\n|  . Frequncey: ");
				String cFrequnceyInput = sc.next();
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nGenerating Publication from the Inputs above: ");
				Publication.validatePublicationID(cPublicationIDInput);
				Publication.validateTitle(cTitleInput);
				Publication.validatePrice(cPriceInput);
				Publication.validateQuantity(cQuanityInput);
				Publication.validateFrequency(cFrequnceyInput);
				Publication inputPublication = new Publication(cPublicationIDInput, cTitleInput, cPriceInput,
						cQuanityInput, cFrequnceyInput);
				try {

					MySQLAccess sql = new MySQLAccess();
					boolean res = sql.insertPublication(inputPublication);
					sql.insertPublication(inputPublication);

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
				generatePublicationMenu();

			} else if (afermCreate != 1 || afermCreate != 2) {
				System.out.println("please enter a valid input on screen.");
			}

			break;

		case 2:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------View-All-Publications-----------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewAll = sc.nextInt();
			if (afermViewAll == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|----------------------All-Publications:----------------|");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nFetching All Order Books: ");
				try {
					MySQLAccess sql = new MySQLAccess();
					sql.printAllPublications();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermViewAll == 2) {

				generatePublicationMenu();
			} else if (afermViewAll != 1 || afermViewAll != 2) {
				System.out.println("please enter a valid input on screen.");
			}

			break;
		case 3:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------View-byID-Publications----------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewByID = sc.nextInt();
			if (afermViewByID == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|-----------Please-enter-the-Publication-ID-------------|");
				System.out.println("|------------Of-Publication-you-wish-to-View-------------|");
				System.out.print("|\n|  . Publication ID: ");
				String getByPublicationIDInput = sc.next();
				System.out.println("|\n|                                                       |");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nFetching Order Book from the Inputs above: ");
				Publication.validatePublicationID(getByPublicationIDInput);
				try {
					MySQLAccess sql = new MySQLAccess();

					// Call getOrderBookById method to retrieve OrderBook by OrderID
					boolean getByIdResult = sql.getPublicationById(getByPublicationIDInput);

					if (getByIdResult) {
						System.out.println("Publication retrieved successfully.");
					} else {
						System.out.println("Failed to retrieve Publication. It may not exist or there was an error.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermViewByID == 2) {
				generatePublicationMenu();

			} else if (afermViewByID != 1 || afermViewByID != 2) {
				System.out.println("please enter a valid input on screen.");
			}

			break;
		case 4:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------Update-Publication-ByID---------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermUpdate = sc.nextInt();
			if (afermUpdate == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|--------------Please-enter-the-Publication-ID----------|");
				System.out.println("|-----and-Details-of-Publication-you-wish-to-Update-----|");
				System.out.print("|\n|  . Publication ID: ");
				String upPublicationIDInput = sc.next();
				System.out.print("|\n|  . Title: ");
				String upTitleInput = sc.next();
				System.out.print("|\n|  . Price: ");
				String upPriceInput = sc.next();
				System.out.print("|\n|  . Quanity: ");
				String upQuanityInput = sc.next();
				System.out.print("|\n|  . Frequncey: ");
				String upFrequnceyInput = sc.next();
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nGenerating Order Book from the Inputs above: ");

				try {
					Publication updatePublication = new Publication();
					MySQLAccess sql = new MySQLAccess();
					Publication.validatePublicationID(upPublicationIDInput);
					Publication.validateTitle(upTitleInput);
					Publication.validatePrice(upPriceInput);
					Publication.validateQuantity(upQuanityInput);
					Publication.validateFrequency(upFrequnceyInput);
				
					updatePublication = new Publication(upPublicationIDInput, upTitleInput, upPriceInput,
							upQuanityInput, upFrequnceyInput);

					// Insert an OrderBook
					sql.updatePublication(updatePublication);

					// Update the OrderBook by OrderID
					boolean updateResult = sql.updatePublication(updatePublication);
					if (updateResult) {
						System.out.println("Publication updated successfully.");
					} else {
						System.out.println("Failed to update Publication.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermUpdate == 2) {
				generatePublicationMenu();
			} else if (afermUpdate != 1 || afermUpdate != 2) {
				System.out.println("please enter a valid input on screen.");
			}

			break;
		case 5:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------Delete-Publication-ByID---------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermDelete = sc.nextInt();
			if (afermDelete == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|------------Please-enter-the-Publication-ID------------|");
				System.out.println("|-----------Of-Publication-you-wish-to-Delete-----------|");
				System.out.print("|\n|  . Publication ID: ");
				String deletePublicationIDInput = sc.next();
				System.out.println("|\n|                                                       |");
				System.out.println("\\-------------------------------------------------------/");
				try {
					// Creating an instance of MySQLAccess
					MySQLAccess sql = new MySQLAccess();
					Publication.validatePublicationID(deletePublicationIDInput);
					boolean deleteResult = sql.deletePublication(deletePublicationIDInput);

					if (deleteResult) {
						System.out.println("Publication deleted successfully.");
					} else {
						System.out.println("Failed to delete Publication.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermDelete == 2) {
				generatePublicationMenu();

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
			if (exit == 1) {
				generatePublicationMenu();
			} else
				System.out.println("please enter a valid input on screen.");

		}

	}

}
