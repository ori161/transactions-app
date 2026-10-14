package transactionsApp;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Password implements Hashable {
	// constants
	private static final int SALT_LENGTH = 16; //bytes
	private static final int ITERATIONS = 50000;
	private static final int KEY_LENGTH = 256; // bits
			
	private String hashPass;
	
	public Password(char[]password) throws Exception{
		setHashPass(password);
	}
	
	// for change password in user without using the constructor again
	protected void setHashPass(char[]password) throws Exception {
		if(password.length < 8) {
			throw new PasswordNotValidException();
		}
		
		String newPass = hashPassword(password);
		if(this.hashPass != null && this.verifyPassword(password)) { // check if the current password is the same as the new one
			throw new ChangeToCurrentPasswordException();
		}
		this.hashPass = newPass;
	}
	
	@Override
	public byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[]salt = new byte[SALT_LENGTH];
		random.nextBytes(salt);
		return salt;
	}
	
	@Override
	public String hashPassword(char[]password)throws Exception {
		byte[]salt = generateSalt();
		byte[]hash = pbkdf2(password, salt);
		return Base64.getEncoder().encodeToString(salt) + ":" +
        Base64.getEncoder().encodeToString(hash);
	}
	
	@Override
	public boolean verifyPassword(char[]password) throws Exception{
		 if (this.hashPass == null || !this.hashPass.contains(":")) {
	            throw new IllegalArgumentException("Stored password format is invalid.");
	     }
		 
		 String[] parts = this.hashPass.split(":");
		 
		 byte[] salt = Base64.getDecoder().decode(parts[0]);
		 byte[] expectedHash = Base64.getDecoder().decode(parts[1]);
		 
		 byte[]hash = pbkdf2(password, salt);
		 
		 if(hash.length != expectedHash.length) {
			 return false;
		 }
		 
		 int diff = 0;
	     for (int i = 0; i < hash.length; i++) {
	    	 diff |= hash[i] ^ expectedHash[i]; // xor bitwise
	     }
	     return diff == 0;
	}
	
	//used locally
	private byte[] pbkdf2(char[]password, byte[]salt) throws Exception{
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		return skf.generateSecret(spec).getEncoded();
	}
	
	//equals 
	
	public String toString() {
		return "[REDACTED]";
	}
}
