package transactionsApp;

public class PasswordDoesNotMatchException extends Exception {
	public PasswordDoesNotMatchException() {
		super("The password is incorrect. Please Try again: ");
	}
}
