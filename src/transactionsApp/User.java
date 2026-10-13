package transactionsApp;

import java.util.ArrayList;

public class User {
	private String username;
	private Password password;
	private int age;
	private ArrayList<Transaction>transactions;
	
	public User(String username, String password, int age) throws Exception {
		setUsername(username);
		this.password = new Password(password.toCharArray());
		setAge(age);
		this.transactions = new ArrayList<Transaction>();
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) throws OutOfRangeException {
		if(username.length() < 3) {
			throw new OutOfRangeException("Name must be at least 3 letters. Enter name again: ");
		}
		this.username = username; // need to change in user data base???
	}
	
	protected boolean verifyPassword(String password) throws Exception {
		return this.password.verifyPassword(password.toCharArray());
	}
	protected void setPassword(String password) throws Exception {
		try {
			this.password.setHashPass(password.toCharArray());
		} catch(Exception e) {
			throw e;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) throws OutOfRangeException {
		if(age < 10 || age > 120) {
			throw new OutOfRangeException("Age is not eligble for using this application. Enter age again: ");
		}
		this.age = age;
	}
	
	private ArrayList<Transaction> getTransactions(){
		return this.transactions;
	}
	
	private void addTransaction(Transaction t) {
		this.transactions.add(t);
	}
	
	private double calculateTransactions() {
		int sum = 0;
		for(Transaction t : this.transactions) {
			sum += t.getCost();
		}
		return sum;
	}
	
	// equals
	
	public String toString() {
		return "[REDACTED]";
	}
	
	
}
