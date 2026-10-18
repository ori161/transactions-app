package transactionsApp;

public class UsernameExistException extends TransactionAppExceptions {
	public UsernameExistException(String name) {
		super("The username: " + name + " already exists. Please enter a new name: ");
	}
}
