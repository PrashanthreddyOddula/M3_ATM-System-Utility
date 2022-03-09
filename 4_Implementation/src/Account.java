import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;



public class Account 
{
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance=0;
    private double savingBalance=0;

    Scanner takeinput=new Scanner(System.in);
    DecimalFormat money=new DecimalFormat("'$'###,##0.00");

    public Account()
    {
        //default construct will be call
    }

    public Account(int customerNumber,int pinNumber)
    {
        this.customerNumber=customerNumber;
        this.pinNumber=pinNumber;

    }
    public Account(int customerNumber,int pinNumber,double checkingBalance,double savingBalance)
    {
        this.customerNumber=customerNumber;
        this.pinNumber=pinNumber;
        this.checkingBalance=checkingBalance;
        this.savingBalance=savingBalance;

    }
    public int setCustomerNumber(int customerNumber)
    {
        this.customerNumber=customerNumber;
        return customerNumber;
    }
    public int getcustomerNumber()
    {
        return customerNumber;

    }
    public int setPinNumber(int pinNumber)
    {
        this.pinNumber=pinNumber;
        return pinNumber;
    }
    public int getPinNumber()
    {
        return pinNumber;
    }
    public double getCheckBalance()
    {
        return checkingBalance;
    }
    public double getSavingBalance()
    {
        return savingBalance;
    }
    public double calculateCheckingWithdraw(double amount)
    {
        checkingBalance=(savingBalance-amount);
        return checkingBalance;
    }
    public double calculateSavingWithdraw(double amount)
    {
        savingBalance=(savingBalance-amount);
        return savingBalance;
    }
    public double calculateCheckingDeposit(double amount)
    {
        checkingBalance=(checkingBalance+amount);
        return checkingBalance;
    }
    public double calculateSavingDeposit(double amount)
    {
        savingBalance=(savingBalance+amount);
        return savingBalance;
    }
    public void calculateCheckTransfer(double amount)
    {
        checkingBalance=(checkingBalance-amount);
        savingBalance=(savingBalance+amount);
        
    }
    public void calculateSavingTransfer(double amount)
    {
        checkingBalance=(checkingBalance+amount);
        savingBalance=(savingBalance+amount);
    }

    //withdraw input
    public void getCheckingWithdrawInput()
    {
        boolean ended=false;
        while(!ended){
            try
            {
                System.out.println("\n Current checkings Account balance:"+ money.format(checkingBalance));
                System.out.println("\nAmount you want to withdraw from checking account:");
                double amount=takeinput.nextDouble();
                if((checkingBalance-amount)>=0&&amount>=0)
                {
                    calculateCheckingWithdraw(amount);
                    System.out.println("\nCurrent Checking Account Balance:"+money.format(checkingBalance));
                    ended=true;

                }
                else{
                    System.out.println("\nBalance Can't be Negative.");
                }

            }
            catch(InputMismatchException e)
            {
                System.out.println("\n invalid choice.");
                takeinput.next();
            }
        }
    }
    public void getSavingwithdrawInput()
    {
        boolean ended=false;
        while(!ended)
        {
            try
            {
                System.out.println("\n Current Saving Account balance:"+ money.format(savingBalance));
                System.out.println("\nAmount you want to withdraw from savings account:");
                double amount=takeinput.nextDouble();
                if((savingBalance-amount)>=0&&amount>=0)
                {
                    calculateCheckingWithdraw(amount);
                    System.out.println("\nCurrent saving Account Balance:"+money.format(savingBalance));
                    ended=true;

                }
                else{
                    System.out.println("\nBalance Can't be Negative.");
                }

            }
            catch(InputMismatchException e)
            {
                System.out.println("\n invalid choice.");
                takeinput.next();
            }
        }
    }
    public void getCheckingDepositInput()
    {
        boolean ended=false;
        while(!ended){
            try
            {
                System.out.println("\n Current checkings Account balance:"+ money.format(checkingBalance));
                System.out.println("\nAmount you want to withdraw from checking account:");
                double amount=takeinput.nextDouble();
                if((checkingBalance-amount)>=0&&amount>=0)
                {
                    calculateCheckingWithdraw(amount);
                    System.out.println("\nCurrent Checking Account Balance:"+money.format(checkingBalance));
                    ended=true;

                }
                else{
                    System.out.println("\nBalance Can't be Negative.");
                }

            }
            catch(InputMismatchException e)
            {
                System.out.println("\n invalid choice.");
                takeinput.next();
            }
        }
    }
    public void getsavingDepositInput()
    {
        boolean ended=false;
        while(!ended)
        {
            try
            {
                System.out.println("\n Current Saving Account balance:"+ money.format(savingBalance));
                System.out.println("\nAmount you want to withdraw from savings account:");
                double amount=takeinput.nextDouble();
                if((savingBalance-amount)>=0&&amount>=0)
                {
                    calculateCheckingWithdraw(amount);
                    System.out.println("\nCurrent saving Account Balance:"+money.format(savingBalance));
                    ended=true;

                }
                else{
                    System.out.println("\nBalance Can't be Negative.");
                }

            }
            catch(InputMismatchException e)
            {
                System.out.println("\n invalid choice.");
                takeinput.next();
            }
        }
    }
    public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checkings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = takeinput.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Checkings Account Balance: " + money.format(checkingBalance));
						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = takeinput.nextDouble();
						if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
							calculateCheckTransfer(amount);
							System.out.println("\nCurrent Savings Account Balance: " + money.format(savingBalance));
							System.out.println(
									"\nCurrent Checkings Account Balance: " + money.format(checkingBalance));
							end = true;
						} else {
							System.out.println("\nBalance Can't be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to: ");
					System.out.println("1. Checkings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = takeinput.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Savings Account Balance: " + money.format(savingBalance));
						System.out.print("\nAmount you want to deposit into your savings account: ");
						double amount = takeinput.nextDouble();
						if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
							calculateSavingTransfer(amount);
							System.out.println("\nCurrent checkings account balance: " + money.format(checkingBalance));
							System.out.println("\nCurrent savings account balance: " + money.format(savingBalance));
							end = true;
						} else {
							System.out.println("\nBalance Can't be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nivalid Choice.");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\ninvalid Choice.");
				takeinput.next();
			}
		}
	}




}
