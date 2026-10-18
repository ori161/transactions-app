package transactionsApp;

public class PasswordDoesNotMatchException extends TransactionAppExceptions{
	public PasswordDoesNotMatchException() {
		super("The password is incorrect. Please Try again: ");
	}
}
