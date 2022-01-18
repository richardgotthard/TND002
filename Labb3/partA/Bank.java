package partA;


import java.util.*;
public class Bank {

	ArrayList<Customer> theCustomers;
	ArrayList<Account> theAccounts;
	
	public Bank() {
		theCustomers = new ArrayList<Customer>();
		theAccounts = new ArrayList<Account>();
	}
	
	public boolean hasCustomer(String arg) {
		boolean dummy = false;
		for (int j=0; j < theCustomers.size();j++) {
			if (theCustomers.get(j).getName().equals(arg.trim())) {
				dummy = true;
			}
		}		
		return dummy;
	}			
	
	public void addCustomer(String arg) {
		String dummy = arg.trim();
		if (hasCustomer(dummy)) System.out.println("The customer already exists");
		else {
			System.out.println("Added customer.");
			theCustomers.add(new Customer(dummy));
		}
	}
	//anders kod
	public void addCurrentAccount(String arg1, double arg2) {
		if (hasCustomer(arg1)) {
			Customer dummy = getCustomer(arg1);
			if (dummy.hasCurrentAccount()) {
				System.out.println("The customer already has a current account.");
			}
			else {
				CurrentAccount newAccount = new CurrentAccount(dummy,arg2);
				theAccounts.add(newAccount);
				dummy.addCurrentAccount(newAccount);
				System.out.println("Added a account for " + dummy.getName());
			}
		}
		else {
			System.out.println("There is no customer with that name.");
		}
	}
	//anders kod
	public Customer getCustomer(String arg) {
		String dummy = arg.trim();
		Customer result = null;
		for (int j=0; j < theCustomers.size(); j++) {
			if (dummy.equals(theCustomers.get(j).getName())) {
				result = theCustomers.get(j);
			}
		}
		
		return result;
	}
	
	
	public String toString() {
		String result = "Bank information\n";
		result = result + "The bank has " + theCustomers.size() + " customers" + "\n";
		result = result + "The bank has " + theAccounts.size() + " accounts" + "\n";
		
		double dummy = 0.0;
		for (int j=0; j < theAccounts.size(); j++) {
			dummy = dummy + theAccounts.get(j).getBalance();
		}
		result = result + "The bank controls the total amount of : " + dummy;
		
		return result;
	}
	
}
