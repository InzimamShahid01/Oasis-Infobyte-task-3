package atm_interface;
import java.util.*;

public class ATM {
	int transactions;
	String transactionHistory="";
	int t_amount =0;
	int limit = 25000;
	String uname;
	String account_No;
	String pin;
	boolean isLoggedIn =false;
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		ATM atm = new ATM();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("******  Welcome to Oasis bank ATM  ******");
		System.out.println("1.Register");
		System.out.println("2.exit");
		
		int ch = sc.nextInt();
		
		switch(ch){ 
		
			case 1: atm.register();
			break;
			
			case 2: 
			System.exit(0);
			break;
		}
		
		while(true) {
			
		System.out.println("1.Login");
		System.out.println("2.exit");
		
		int l = sc.nextInt();
		
		switch(l){ 
		
			case 1: atm.login();
			break;
			
			case 2: System.exit(0);
			break;
		}
		
		if(atm.isLoggedIn) {
			while(true) {

				System.out.println("\n1.Deposit");
				System.out.println("2.Withdrawl");
				System.out.println("3.Transfer");
				System.out.println("4.Transaction History");
				System.out.println("5.Quit");
				
				int res = sc.nextInt();
				
				switch(res) {
				case 1: atm.deposit();
				break;
				case 2 : atm.withdraw();
				break;
				case 3: atm.transfer();
				break;
				case 4: atm.transHistory();
				break;
				case 5:System.out.println("****** Thank you for using Oasis bank ******");
					System.exit(0);
				break;
				}
				
			}
			
		}
		else {
			System.out.println("Invalid Login Info!!!");
		}
	}
		
	}
	
	
	
	private void deposit() {
		System.out.println("***Limit is "+ limit +" ***");
		System.out.print("\nEnter the amount: ");
		long amount = sc.nextInt();
		if(amount < limit) {
		System.out.println("\n"+amount +"Rs Deposited");
		transactions++;
		transactionHistory += amount + "Rs Deposited\n";
		t_amount += amount;
		}
		else {
			System.out.println("***Limit is "+ limit +" ***");
		}
	}



	private void withdraw() {
		System.out.println("***Limit is "+ limit +" ***");
		System.out.print("Enter the amount: ");
		long amount =sc.nextInt();
		if(amount >= t_amount ) {
			System.out.println("Insufficient Balance");
		}
		else if(amount <= limit) {
			System.out.println("\n"+amount + "Rs Withdrawn");
			transactionHistory += amount + "Rs Withdrawn\n";
			t_amount -= amount; 
			transactions++;
		}
		else {
			System.out.println("***Limit is "+ limit +" ***");
		}
		
	}



	private void transfer() {
		System.out.println("***Limit is "+ limit +" ***");
	    System.out.print("Enter the amount: ");
	    long amount = sc.nextInt();
	    System.out.print("Enter Recepient name: ");
	    String name = sc.next();
	    if(amount >= t_amount) {
	    	System.out.println("\nInsufficient Balance");
	    }
		else if(amount <= limit) {
			System.out.println("\n"+amount + "Rs transfered to "+name);
			transactionHistory += amount + "Rs transfered to " + name + "\n";
			t_amount -= amount; 
			transactions++;
		}
		else {
			System.out.println("***Limit is "+ limit +" ***");
		}
		
	}



	private void transHistory() {
		if(transactions == 0) {
			System.out.println("****** No transaction found ******");
		}
		System.out.println(transactionHistory);
		System.out.println("Current Balance: "+t_amount);
		
	}



	private void login() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your 6 digit account No");
		String acc_no = sc.next();
		
		System.out.println("Enter Your 4 digit Pin");
		String u_pin = sc.next();
		
		if(acc_no.equals(account_No) && u_pin.equals(pin)) {
			isLoggedIn = true;
			System.out.println("\n     Login Successfull!     \n");
		}
		else {
			isLoggedIn = false;
		}
		
	}



	private void register() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Username");
		uname = sc.next();
		
		if(!uname.matches("^[a-zA-Z]*$")) {
			System.out.println("\nUsername must contain only alphabets");
			System.out.println("\nRegistration failed!");
			System.exit(0);
		}
		
		System.out.println("Enter Your 6 digit account No");
		account_No = sc.next();
		
		if(account_No.length()!= 6 ) {
			System.out.println("\nRegistration failed!");
			System.out.println("\nAccount number must be of 6 digit!");
			System.exit(0);
		}
		
		System.out.println("Enter Your 4 digit Pin");
		pin = sc.next();
		
		if(pin.length()!= 4 ) {
			System.out.println("\nPin must be of 4 digit");
			System.out.println("\nRegistration failed!");
			System.exit(0);
		}
		
		System.out.println("\n     Registration Successfull!     \n");
		
	}
	
	
	
}
