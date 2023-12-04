package matthew;
//developer. Matthew devlin

import java.sql.SQLException;
import java.util.Scanner;

public class PublicationCLine {
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
		System.out.println("|  2. View All Publication.                             |");
		System.out.println("|  3. update Publication.                               |");
		System.out.println("|  4. delete Publication.                               |");
		System.out.println("|  5. Exit Publication.                                 |");
		System.out.println("|                      .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		try {
			int input = sc.nextInt();
			switch (input) {

			case 1:
				try {
					createPublicationMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generatePublicationMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				}

				break;

			case 2:
				try {
					printAllPublicationMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generatePublicationMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				} catch (Exception e) {
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				}

				break;
			case 3:
				try {
					updateByIDPublicationMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generatePublicationMenu();

				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				} catch (Exception e) {
					generatePublicationMenu();
					System.out.println("\n\nUnknown Error Occurred...");
				}

				break;
			case 4:

				try {
					deleteByIDPublicationMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generatePublicationMenu();
				} catch (SQLException e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				} catch (Exception e) {
					System.out.print("\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				}
				break;

			default:
				// problem still acuring

				try {
					problemPublicationMenu();
				} catch (NewsAgentExceptionHandler e) {
					System.out.print("\n" + e.message + "\nPlease try again.\n");
					generatePublicationMenu();
				} catch (Exception e) {
					System.out.print("\n" + e.getMessage() + "\nPlease try again.\n");
					System.out.println("\n\nunkown Error Occured...");
					generatePublicationMenu();
				}
			}
		} catch (Exception e) {
			System.out.println("not a valid input");
			generatePublicationMenu();

		}
		sc.close();
	}
	// problem still acuring

	public static void createPublicationMenu() throws NewsAgentExceptionHandler , SQLException,Exception {
		Scanner sc = new Scanner(System.in);
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
			System.out.println("|                                                        ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating Order Book from the Inputs above: ");

			Publication.validatePublicationID(cPublicationIDInput);
			Publication.validateTitle(cTitleInput);
			Publication.validatePrice(cPriceInput);
			Publication.validateQuantity(cQuanityInput);
			Publication.validateFrequency(cFrequnceyInput);
			Publication publication = new Publication();
			publication = new Publication( cPublicationIDInput,cTitleInput,cPriceInput,cQuanityInput,cFrequnceyInput);


				MySQLAccess sql = new MySQLAccess();
				boolean res = sql.insertPublication(publication);
				sql.insertPublication(publication);

				if (res) {
					System.out.println("Inserted");
				}
				if (!res) {
					System.out.println("not Inserted");
				}
		}else if(afermCreate==2)

	{
		generatePublicationMenu();
	}else if(afermCreate!=1||afermCreate!=2)
	{
		System.out.println("please enter a valid input on screen.");
	}sc.close();
	}

	public static void printAllPublicationMenu() throws NewsAgentExceptionHandler, SQLException ,Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|-------------------View-All-Publication----------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermViewAll = sc.nextInt();
		if (afermViewAll == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------------All-Publications:-----------------|");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nFetching All Order Books: ");
				MySQLAccess sql = new MySQLAccess();
				sql.printAllPublications();

		} else if (afermViewAll == 2) {
			generatePublicationMenu();
		} else if (afermViewAll != 1 || afermViewAll != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}

	public static void updateByIDPublicationMenu() throws NewsAgentExceptionHandler, SQLException, Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Are-you-sure-you-want-to---------------|");
		System.out.println("|------------------Update-Publication-ByID--------------|");
		System.out.println("|  1. Yes.                                              |");
		System.out.println("|  2. No.                                               |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		int afermUpdate = sc.nextInt();
		if (afermUpdate == 1) {
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|------------Please-enter-the-Publication-ID------------|");
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
			System.out.println("|                                                         ");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nGenerating updated customer from the Inputs above: ");

			Publication.validatePublicationID(upPublicationIDInput);
			Publication.validateTitle(upTitleInput);
			Publication.validatePrice(upPriceInput);
			Publication.validateQuantity(upQuanityInput);
			Publication.validateFrequency(upFrequnceyInput);
			Publication publication = new Publication();
			publication = new Publication(upPublicationIDInput,upTitleInput,upPriceInput,upQuanityInput,upFrequnceyInput);
			
			MySQLAccess sql = new MySQLAccess();
			// Insert an OrderBook
			sql.updatePublication(publication);

			// Update the OrderBook by OrderID
			boolean updateResult = sql.updatePublication(publication);
			if (updateResult) {
				System.out.println("Customer updated successfully.");
			} else {
				System.out.println("Failed to update Customer.");
			}
		} else if (afermUpdate == 2) {
			generatePublicationMenu();

		} else if (afermUpdate != 1 || afermUpdate != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();

	}

	public static void deleteByIDPublicationMenu() throws NewsAgentExceptionHandler, SQLException, Exception {
		Scanner sc = new Scanner(System.in);
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
			System.out.println("|----------Of-Publication-Book-you-wish-to-Delete-------|");
			System.out.print("|\n|  . Publication ID: ");
			String deletePublicationIDInput = sc.next();
			System.out.println("|\n|                                                       |");
			System.out.println("\\-------------------------------------------------------/");

			// Creating an instance of MySQLAccess
			MySQLAccess sql = new MySQLAccess();
			Publication.validatePublicationID(deletePublicationIDInput);
			boolean deleteResult = sql.deletePublication(deletePublicationIDInput);

			if (deleteResult) {
				System.out.println("Publication deleted successfully.");
			} else {
				System.out.println("Failed to delete Publication.");
			}
		} else if (afermDelete == 2) {
			generatePublicationMenu();

		} else if (afermDelete != 1 || afermDelete != 2) {
			System.out.println("please enter a valid input on screen.");
		}
		sc.close();
	}

	public static void problemPublicationMenu() throws NewsAgentExceptionHandler {
		Scanner sc = new Scanner(System.in);
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|--------------Something-has-gone-wrong-----------------|");
		System.out.println("|----------Please-exit-to-the-previous-panel------------|");
		System.out.println("|  . Exit                                               |");
		System.out.println("\\-------------------------------------------------------/");
		int exit = sc.nextInt();
		if (exit == 1) {
			generatePublicationMenu();
		} else
			generatePublicationMenu();
		sc.close();
	}

}
