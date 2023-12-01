/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;
import Newsagent.Newsagent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author cianf
 */
public class AdminCl{
public static void main(String[] args) throws Exception {
		generateNewsagentMenu();

	}

	public static void generateNewsagentMenu() throws Exception {
		MySQLAccess retrieve = new MySQLAccess();
		MySQLAccess create = new MySQLAccess();
		MySQLAccess update = new MySQLAccess();
		MySQLAccess delete = new MySQLAccess();
                Scanner sc = new Scanner(System.in);
                int input;
	do{
		
		System.out.println("  _____________________________________________________");
		System.out.println(" /                                                     \\");
		System.out.println("|----------------Newsagent-Menu-Options:---------------|");
		System.out.println("|                                                       |");
		System.out.println("|  1. Create Newsagent.                                 |");
		System.out.println("|  2. View All Newsagents.                              |");                                
		System.out.println("|  3. Update Newsagent.                                 |");
		System.out.println("|  4. Delete Newsagent.                                 |");
		System.out.println("|  5. Exit             .                                |");
		System.out.println("|                                                       |");
		System.out.println("\\-------------------------------------------------------/");
		System.out.print("\nEnter selection from the options above: ");
		input = sc.nextInt();
		switch (input) {

		case 1:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------create-a-Newsagent?-------------------|");
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
				System.out.print("|\n|  . Newsagent ID: ");
				String newsagentIDInput = sc.next();
				System.out.print("|\n|  . Newsagent Password: ");
				String newsagentPasswordInput = sc.next();
				System.out.println("|                                                       ");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nCreating a Newsagent from the Inputs above: ");
				try {

                                    Newsagent newAgent = new Newsagent(newsagentIDInput, newsagentPasswordInput);
                                    
                                    boolean res = create.insertNewsagent(newAgent);
	
					if(res == true) {
						System.out.println("Inserted");
					}
					if(!res) {
						System.out.println("not Inserted");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (afermCreate == 2) {
				generateNewsagentMenu();
				
			}else if(afermCreate != 1 || afermCreate != 2) {
				System.out.println("please enter a valid input on screen.");
			}
	
					
			
			break;

		case 2:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------View-All-Newsagents?------------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewAll = sc.nextInt();
			if (afermViewAll == 1) {
				System.out.println("  _____________________________________________________");
				System.out.println(" /                                                     \\");
				System.out.println("|----------------------All-Newsagents:----------------|");
				System.out.println("\\-------------------------------------------------------/");
				System.out.print("\nFetching All Newsagents: ");
				try {
					ResultSet resultSet = retrieve.printAllNewsagent();
					if (resultSet != null) {
                                            PrintAllNewsAgent(resultSet);
                                        } else {
                                            System.out.println("Error fetching Newsagents. ResultSet is null.");
                                        }
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (afermViewAll == 2) {
				generateNewsagentMenu();

			} else if (afermViewAll != 1 || afermViewAll != 2) {
				System.out.println("please enter a valid input on screen.");
			}
			
			break;
		case 3:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|-----------------Update-Newsagent?-----------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermViewByID = sc.nextInt();
			if (afermViewByID == 1) {
                            System.out.println("  _____________________________________________________");
                            System.out.println(" /                                                     \\");
                            System.out.println("|--------------Please-enter-the-following:--------------|");
                            System.out.print("|\n|  . Newsagent ID: ");
                            String newsagentIDInput = sc.next();
                            System.out.print("|\n|  . Newsagent Password: ");
                            String newsagentPasswordInput = sc.next();
                            System.out.println("|                                                       ");
                            System.out.println("\\-------------------------------------------------------/");
                            System.out.println("\\-------------------------------------------------------/");
                            System.out.print("\nFetching Order Book from the Inputs above: ");
          
	        try {
                    
	            Newsagent updateAgent = new Newsagent();
                    updateAgent.setId(newsagentIDInput);
                    updateAgent.setPassword(newsagentPasswordInput);
	            boolean updateRecord = update.updateNewsagent(updateAgent);

	            if (updateRecord == true) {
	                System.out.println("Newsagent Updated successfully.");
	            } else {
	                System.out.println("Failed to Update Newsagent. It may not exist or there was an error.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
                    
	        }
			} else if (afermViewByID == 2) {
				generateNewsagentMenu();

			} else if (afermViewByID != 1 || afermViewByID != 2) {
				System.out.println("please enter a valid input on screen.");
			}   

			break;
		case 4:
			System.out.println("  _____________________________________________________");
			System.out.println(" /                                                     \\");
			System.out.println("|----------------Are-you-sure-you-want-to---------------|");
			System.out.println("|------------------Delete-Newsagent-ByID-----------------|");
			System.out.println("|  1. Yes.                                              |");
			System.out.println("|  2. No.                                               |");
			System.out.println("|                                                       |");
			System.out.println("\\-------------------------------------------------------/");
			System.out.print("\nEnter selection from the options above: ");
			int afermDelete = sc.nextInt();
			if (afermDelete == 1) {
                            System.out.println("  _____________________________________________________");
                            System.out.println(" /                                                     \\");
                            System.out.println("|--------------Please-enter-the-Newsagent-ID--------------|");
                            System.out.println("|-------------Of-Newsagent-you-wish-to-Delete-------------|");
                            System.out.print("|\n|  . Newsagent ID: ");
                            String deleteNewsagentInput = sc.next();
                            System.out.println("|\n|                                                       |");
                            System.out.println("\\-------------------------------------------------------/");
			try {
	            // Creating an instance of MySQLAccess	
	                boolean deleteResult = delete.deleteNewsagent(deleteNewsagentInput);

	                if (deleteResult) {
	                    System.out.println("Newsagent deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete Newsagent.");
	                }
	            } catch (Exception e) {
	            e.printStackTrace();
	        }
			} else if (afermDelete == 2) {
				generateNewsagentMenu();

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
				generateNewsagentMenu();
			} else
				System.out.println("please enter a valid input on screen.");

		}
        }while(input != 5);

	}
	
	public static void PrintAllNewsAgent(ResultSet resultSet){
        int count = 0;
        try{
            while(resultSet.next()){
                count++;
                String id = resultSet.getString("AGENTID");
                String password = resultSet.getString("AGENTPASSWORD");

                System.out.println("No: " + count);
                System.out.println("Agent Id: " + id);
                System.out.println("Agent password: " + password);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

