package transactionsApp;

public class PasswordNotValidException extends Exception {
	public PasswordNotValidException() {
		super("password is not valid. password must be 8 or more letters");
	}
}
