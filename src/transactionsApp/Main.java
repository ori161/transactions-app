package transactionsApp;

public class Main {

	public static void main(String[] args) {
		try {
			User u = new User("oriOhayon4", "orio20077", 18);
			User u1 = new User("ori", "orio20077", 18);
			UsersDataBase database = new UsersDataBase();
			database.addUser(u);
			
			System.out.print(database.toString());
		}catch(Exception e) {
			System.out.print(e);
		}

	}

}
