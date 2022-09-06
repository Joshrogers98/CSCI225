/*@Author Joshua Rogers
 * 11 April 2022
 * CMIS 242
 * UMGC
 * This program organizes snacks by two types: Fruit and Salty.
 * It then calls a specified snack and delivers information about it including:
 * Type , Size , ID , and price.
 */
import java.util.Scanner;

public class OrderSystem {
	
	private static void displayMenu() {
		
		System.out.println("MENU");
		System.out.println("1: Order a Snack");
		System.out.println("2: Exit program");
		System.out.println("Enter your selection: ");
	}
	private static void displayMenuType() {
		System.out.println("Do you want Fruit Snack (1) or Salty Snack (2): ");
	}
	private static void displayMenuSize() {
		System.out.println("What size do you want: S, M, or L: ");
	}
	private void menuChoice(int c) {
		
		switch(c) {
			case 1	:	displayMenuType();
						break;
						
			case 2	:	System.out.println("Thank you for using the program. Goodbye!");
			 			break;
			 			
			default	:	System.out.println("\nInvalid choice, please select a valid option.");	
		}
	}
	private void typeChoice(int c) {
		
		switch(c) {
		case 1 :	System.out.println("Do you want citrus fruit included? true/false: ");
					break;
		case 2 :	System.out.println("Do you want nut snack included? true/false: ");
					break;
		default	:	System.out.println("Error.");
		}
	}
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		OrderSystem orderSystem = new OrderSystem();
		
		displayMenu();							//display the menu
		int menuSelection = stdin.nextInt();	//scan user input
		orderSystem.menuChoice(menuSelection);	//run the correct option
		
		if(menuSelection == 1) {				//display the next menu
			int menuChoice = stdin.nextInt();	//scan user input
			
			if (menuChoice == 1 || menuChoice == 2) {
				displayMenuSize();						//ask user what size snack they want
				String size = stdin.next();	//scan user input
				orderSystem.typeChoice(menuChoice);		//ask user if they want citrus or nuts
				boolean mod = stdin.nextBoolean();		//assign T/F to mod(price modifier)
				
				if (menuChoice == 1) {
					Snack snack1 = new FruitSnack(size , mod);
					snack1.setType(menuChoice);
					snack1.calcPrice();
					System.out.println(snack1.toString());
					
				}else if (menuChoice == 2) {
					Snack snack2 = new SaltySnack(size , mod);
					snack2.setType(menuChoice);
					snack2.calcPrice();
					System.out.println(snack2.toString());
				}
			}
			else {
				System.out.println("Invalid choice, please restart and try again.");
				menuSelection = 2;
			}
		}
	}
}