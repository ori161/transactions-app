package transactionsApp;

import java.time.LocalDate;

public final class TransactionAppBackend {
	private final UsersDataBase usersDataBase = new UsersDataBase(); // ensure only one data base for app
	private final LocalDate currentDate = LocalDate.now(); // need to implement the month charts
	private User currentUser;
	
	//opening screen methods
	protected void signup(String username, String password, int age) throws Exception {
		User temp = new User(username, password, age);
		this.usersDataBase.addUser(temp);
		this.currentUser = temp;
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
	
	public String toString() {
		return this.usersDataBase.toString() + " current user: " + this.currentUser;
	}
}
