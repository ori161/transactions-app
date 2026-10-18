package transactionsApp;

public class ChangeToCurrentPasswordException extends TransactionAppExceptions {
	public ChangeToCurrentPasswordException() {
		super("The password you entered is the same as Current password. ");
	}
}
