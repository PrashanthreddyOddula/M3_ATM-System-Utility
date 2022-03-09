import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.*;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat money = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();

	public void getLogin() throws IOException {
		boolean ended = false;
		int customerNumber = 0;
		int pinNumber = 0;
		while (!ended) {
			try {
				System.out.print("\nEnter your customer number: ");
				customerNumber = menuInput.nextInt();
				System.out.print("\nEnter your PIN number: ");
				pinNumber = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
				    Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();
					if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
						getAccountType(acc);
						ended = true;
						break;
					}
				}
				if (!ended) {
					System.out.println("\nWrong Customer Number or Pin Number");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Character(s). Only Numbers.");
			}
		}
	}

	public void getAccountType(Account acc) {
		boolean ended = false;
		while (!ended) {
			try {
				System.out.println("\nSelect the account you want to access: ");
				System.out.println(" Type 1 - Current Account");
				System.out.println(" Type 2 - Savings Account");
				System.out.println(" Type 3 - Exit");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					getChecking(acc);
					break;
				case 2:
					getSaving(acc);
					break;
				case 3:
					ended = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getChecking(Account acc) {
		boolean ended = false;
		while (!ended) {
			try {
				System.out.println("\nCheckings Account: ");
				System.out.println(" Type 1 - View Balance");
				System.out.println(" Type 2 - Cash withdrawal");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					System.out.println("\nCheckings Account Balance: " + money.format(acc.getCheckBalance()));
					break;
				case 2:
					acc.getCheckingWithdrawInput();
					break;
				case 3:
					acc.getCheckingDepositInput();
					break;

				case 4:
					acc.getTransferInput("Checkings");
					break;
				case 5:
					ended = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getSaving(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSavings Account: ");
				System.out.println(" Type 1 - View Balance");
				System.out.println(" Type 2 - Cash withdrawal");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Exit");
				System.out.print("Choice: ");
				int selection = menuInput.nextInt();
				switch (selection) {
				case 1:
					System.out.println("\nSavings Account Balance: " + money.format(acc.getSavingBalance()));
					break;
				case 2:
					acc.getSavingwithdrawInput();
					break;
				case 3:
					acc.getsavingDepositInput();
					break;
				case 4:
					acc.getTransferInput("Savings");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void createAccount() throws IOException {
		int cst_no = 0;
		boolean ended = false;
		while (!ended) {
			try {
				System.out.println("\nEnter your customer number ");
				cst_no = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					if (!data.containsKey(cst_no)) {
						ended = true;
					}
				}
				if (!ended) {
					System.out.println("\nThis customer number is already registered");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\nEnter PIN to be registered");
		int pin = menuInput.nextInt();
		data.put(cst_no, new Account(cst_no, pin));
		System.out.println("\nYour new account has been successfuly registered!");
		System.out.println("\nRedirecting to login.............");
		getLogin();
	}

	public void mainMenu() throws IOException {
		data.put(738603, new Account(738603, 3509, 10000, 5000));
		data.put(2033, new Account(2033, 3312, 40000, 50000));
		boolean ended = false;
		while (!ended) {
			try {
				System.out.println("\n Type 1 - Login");
				System.out.println(" Type 2 - Create Account");
				System.out.print("\nChoice: ");
				int choice = menuInput.nextInt();
				switch (choice) {
				case 1:
					getLogin();
					ended = true;
					break;
				case 2:
					createAccount();
					ended = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\nThank You for using this ATM.\n");
		menuInput.close();
		System.exit(0);
	}
	
	public  void introduction() {
		System.out.println("Welcome to the ATM Project");
	}
}