package transactionsApp;

public class PasswordNotValidException extends TransactionAppExceptions {
	public PasswordNotValidException() {
		super("password is not valid. password must be 8 or more letters");
	}
}
