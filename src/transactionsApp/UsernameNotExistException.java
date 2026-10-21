package transactionsApp;

public class UsernameNotExistException extends TransactionAppExceptions {
	public UsernameNotExistException(String username) {
		super("The user: " + username + " does not exist. Enter again: ");
	}
}
