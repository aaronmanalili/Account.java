package firstbank;
import java.util.Scanner;


public class Account {
	//Class Variables
	
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//Class constructor
	Account(String Cname, String CID){
		customerName = Cname;
		customerID = CID;
	}
	

	//Function for depositing money
	void Deposit(int amount) { 
		if(amount >= 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void Withdrawl(int amount) {
		if(amount >= 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

	//Function for getting previous transaction
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction was performed.");
		}
	}
	
	// Function for calculating interest
	void calculatingInterest(int years) {
		double interestRate  = .0185;
		double updatedBalance = (balance * interestRate * years);
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your new balance will be " + updatedBalance);
	}
	
	void showMenu() {
		
		char option = '\0';
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID Number is " + customerID);
		System.out.println();
		System.out.println("Select an option.");
		System.out.println();
		System.out.println("A. Check your balance.");
		System.out.println("B. Make a deposit.");
		System.out.println("C. Withdrawl.");
		System.out.println("D. View previous transaction.");
		System.out.println("E. Calculate interest.");
		System.out.println("F. Exit.");
		
		do {
			System.out.println();
			System.out.println("Enter an option");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			
			// Case A checks user's balance.
			case 'A':
				System.out.println("Balance: " + "$" + balance);
				System.out.println();
				break; // Closes function
			
			// Case B allows user to deposit money into their account.	
			case 'B':
				System.out.println("Enter an amount to deposit.");
				int amount = scanner.nextInt();
				Deposit(amount);
				System.out.println();
				break;
				
			// Case C allows user to withdrawl money from their account.
			case 'C':
				System.out.println("Enter an amount to withdrawl.");
				int amount2 = scanner.nextInt();
				Withdrawl(amount2);
				System.out.println();
				break;
				
			// Case D allows user to view previous transactions.
			case 'D':
				getPreviousTransaction();
				System.out.println();
				break;
				
			// Case E allows user to calculate interest.
			case 'E':
				System.out.println("Enter the number of years of accrued interest.");
				int years = scanner.nextInt();
				calculatingInterest(years);
				break;
				
			// Case F allows user to exit.
			case 'F':
				System.out.println("===============================================");
				break;
				
			default:
				System.out.println("Error: Invalid option. Please enter A, B, C, D, E, or F.");
				break;
			}
		} while(option != 'F');
			System.out.println("Thank you for banking with us! Have a nice day!");
			
	}
}
