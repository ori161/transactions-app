package transactionsApp;

public class UsernameExistException extends Exception {
	public UsernameExistException(String name) {
		super("The username: " + name + " already exists. Please enter a new name: ");
	}
}
