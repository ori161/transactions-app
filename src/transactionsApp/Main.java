package transactionsApp;

public class Main {

	public static void main(String[] args) {
		try {
			TransactionAppBackend be = new TransactionAppBackend();
			be.signup("oriOhayon4", "orio20077", 18);
			be.signup("ori", "orio20077", 18);
			System.out.println(be.toString());
			be.login("oriOhayon4", "orio20077");
			System.out.println(be.toString());
			//be.signout();
			//System.out.println(be.toString());
			be.changePassword("orio20077@");
			be.signout();
			be.login("oriOhayon4", "orio20077@");
			be.changePassword("orio20077");
			System.out.println(be.toString());
		}catch(Exception e) {
			System.out.print(e);
		}

	}

}
