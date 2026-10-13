package transactionsApp;

import java.time.LocalDate;

public class TransactionAppBackend {
	private final UsersDataBase usersDataBase = new UsersDataBase(); // ensure only one data base for app
	private final LocalDate currentDate = LocalDate.now(); // need to implement the month charts
	
}
