package transactionsApp;

import java.time.LocalDate;
import java.util.HashMap;

import transactionsApp.Transaction.eType;

public final class TransactionAppBackend {
	private final UsersDataBase usersDataBase = new UsersDataBase(); // ensure only one data base for app
	private final LocalDate currentDate = LocalDate.now(); // need to implement the month charts
	private User currentUser;
	
	//opening screen methods
	protected void signup(String username, String password, int age) throws Exception {
		User currUser = new User(username, password, age);
		this.usersDataBase.addUser(currUser);
		this.currentUser = currUser;
	}
	
	protected void login(String username, String password)throws Exception {
		this.currentUser = this.usersDataBase.login(username, password);
	}
	
	//settings methods
	protected void signout() {
		this.currentUser = null; // after this return to opening screen
	}
	
	protected void deleteUser() {
		this.usersDataBase.removeUser(this.currentUser);
		signout();
	}
	
	protected void changePassword(String password) throws Exception {
		this.currentUser.setPassword(password);
	}
	
	//transactions methods(might be incomes too later)
	protected void addTransactions(String nameOfTransaction, String description, double cost, LocalDate dateOfTransaction, eType type) throws OutOfRangeException {
		this.currentUser.addTransaction(new Transaction(nameOfTransaction, description, cost, dateOfTransaction, type));
	}
	
	protected Double showTotalTransactionExpanse() {
		return this.currentUser.calculateTransactionsTotal();
	}
	
	protected HashMap<Integer, Double>showTotalByMonths(){
		return this.currentUser.getSumByMonth();
	}
	
	public String toString() {
		return this.usersDataBase.toString() + " current user: " + this.currentUser;
	}
}
