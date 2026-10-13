package transactionsApp;

public class UsernameNotExistException extends Exception {
	public UsernameNotExistException(String username) {
		super("The user: " + username + " does not exist. Enter username again: ");
	}
}
