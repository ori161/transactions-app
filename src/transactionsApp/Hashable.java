package transactionsApp;

public interface Hashable {
	byte[] generateSalt();
	String hashPassword(char[]password) throws Exception;
	boolean verifyPassword(char[]password) throws Exception;
}
