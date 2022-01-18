package partA;


public class Account {
	
	protected Customer theCustomer;
	protected int accountNumber;
	protected double theBalance;
	protected Bank theBank;
	private static int availableNumbers = 0;
	
	public static double CURRENTACCOUNTFEE;
	public static double SAVINGSINTEREST;
	
	
	public Account (Customer arg1, Bank thebank, double arg2) {
		SAVINGSINTEREST = 0.01;
		CURRENTACCOUNTFEE = 10.0;
		theCustomer = arg1;
		theBalance = arg2;
		availableNumbers = availableNumbers + 1;
		accountNumber = availableNumbers;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return theBalance;
	}
	
	public void annualChange() {
		
	}
	
	public String toString() {
		String result = "\n************************";
		result = result + "\nAccountN number : " + accountNumber;
		result = result + "\nCustomer :  " + theCustomer.getName();
		result = result + "\nBalance :" + theBalance;
		result = result + "\n******************************";
		return result;
	}
}
