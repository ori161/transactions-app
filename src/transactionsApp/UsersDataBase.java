package transactionsApp;

import java.util.HashMap;

public class UsersDataBase {
	private final HashMap<String, User>users;
	
	public UsersDataBase() {
		this.users = new HashMap<>();
	}
	
	protected HashMap<String, User> getUsers() {
		return this.users;
	}
	
	// add/remove method
	protected void addUser(User user) throws UsernameExistException { // sign up method
		String username = user.getUsername();
		if(!this.users.isEmpty()) {
			// if users not empty than check if name already exists
			if(this.users.containsKey(username)) {
				throw new UsernameExistException(username);
			}
		}
		this.users.put(username, user);
	}
	
	protected void removeUser(User user) { // "delete" user
		String username = user.getUsername();
		this.users.remove(username);
	}
	
	protected User login(String username, String password) throws Exception {
		User user = this.users.get(username);
		
		if(user == null) {
			throw new UsernameNotExistException(username);
		}
		
		if(!user.verifyPassword(password)) {
			throw new PasswordDoesNotMatchException();
		}
		
		return user;
		
	}
	//equals
	
	@Override
	public String toString() {
		return "Users in app: " + this.users.toString();
	}
}
