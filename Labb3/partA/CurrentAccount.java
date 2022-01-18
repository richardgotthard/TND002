package partA;

public class CurrentAccount extends Account {
	
	public CurrentAccount(Customer arg1, double arg2) {
		super(arg1, arg2);
	}
	
	public Customer getCustomer() {
		return theCustomer;
	}
	//anders kod
	public void payIn(double arg) {
		theBalance = theBalance + arg;
	}
	
	public void receive(double arg) {
		theBalance = theBalance + arg;
	}
	
}
