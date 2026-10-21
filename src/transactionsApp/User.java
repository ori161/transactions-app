package transactionsApp;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private final HashMap<Integer, Double>sumByMonth;
	private String username;
	private Password password;
	private ArrayList<Transaction>transactions;
	
	
	public User(String username, String password) throws Exception {
		setUsername(username);
		this.password = new Password(password.toCharArray());
		this.transactions = new ArrayList<Transaction>();
		this.sumByMonth = new HashMap<>();
	}
	
	public String getUsername() {
		return this.username;
	}
	
	// check later cause we need to change the key if we change the username(if we desire to have a change username feature
	public void setUsername(String username) throws OutOfRangeException {
		if(username.length() < 3) {
			throw new OutOfRangeException("Name must be at least 3 letters. Enter name again: ");
		}
		this.username = username; // need to change in user data base???
	}
	
	protected boolean verifyPassword(String password) throws Exception {
		return this.password.verifyPassword(password.toCharArray());
	}
	
	protected void setPassword(String password) throws Exception { // change password
		this.password.setHashPass(password.toCharArray());
	}
	
	private ArrayList<Transaction> getTransactions(){
		return this.transactions;
	}
	
	protected void addTransaction(Transaction t) {
		this.transactions.add(t);
		this.sumByMonth.merge(t.getDateOfTransaction().getMonthValue(), t.getCost(), Double::sum); //add the transaction cost to his month
		// to see later on the chart the amount of expanse each month
	}
	
	protected double calculateTransactionsTotal() {
		int sum = 0;
		for(Transaction t : this.transactions) {
			sum += t.getCost();
		}
		return sum;
	}
	
	protected HashMap<Integer, Double> getSumByMonth(){
		return this.sumByMonth;
	}
	
	// equals
	
	public String toString() {
		return this.username; //"[REDACTED]";
	}
	
	
}
