package transactionsApp;

import java.time.LocalDate;

public class Transaction {
	public static enum eType{Income, Expanse};
	
	private String nameOfTransaction;
	private String description;
	private double cost;
	private final LocalDate dateOfTransaction;
	private eType type;
	
	public Transaction(String nameOfTransaction, String description, double cost, LocalDate dateOfTransaction, eType type) throws OutOfRangeException {
		this.nameOfTransaction = nameOfTransaction;
		this.description = description;
		setCost(cost);
		this.dateOfTransaction = dateOfTransaction;
		this.type = type;
	}
	
	public String getNameOfTransaction() {
		return this.nameOfTransaction;
	}
	
	public void setNameOfTransaction(String nameOfTransaction) {
		this.nameOfTransaction = nameOfTransaction;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double cost) throws OutOfRangeException {
		if(cost < 0) {
			throw new OutOfRangeException("Cost of product cant be under 0. Please enter cost again: ");
		}
		this.cost = cost;
	}
	
	public LocalDate getDateOfTransaction() {
		return this.dateOfTransaction;
	}
	
	public eType getType() {
		return this.type;
	}
	
	//equals, toString
	
	
	
}
