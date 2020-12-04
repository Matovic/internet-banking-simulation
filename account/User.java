/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package account;

import java.util.Observable;

import card.*;
import gui.AlertWindow;
import transaction.Transaction;
import exception.*;

/**
 * Superclass User implements interface Account and extends Observable
 * @author Erik Matoviè
 */
public class User extends Observable implements Account{
	protected String name;
	private String password;
	private String number;
	private double bankBalance;
	private boolean firstRun;
	
	// aggregation 
	private CreditCard creditCard;
	
	// aggregation
	private DebitCard debitCard;
	
	/**
	 * Constructor overloading - used for model in mvc pattern in Main.java
	 */
	public User() {
		
	}
	
	/**
	 * Constructor overloading to create 2 static final objects in Main.java
	 * @param userCard	polymorphism - object userCard of a superclass references to a object of a subclass CreditCard or DebitCard
	 */
	public User(UserCard userCard) {				                    
		this.setName();
		this.bankBalance = 0.0;
		this.setCreditCard(userCard);	//polymorphism - object userCard of a superclass references to a object of a subclass CreditCard     
		this.setDebitCard(null);
		this.setFirstRun(true); 
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getNumber() {
		return this.number;
	}

	@Override
	public double getBankBalance() {
		return this.bankBalance;
	}
	
	@Override
	public DebitCard getDebitCard() {
		return this.debitCard;
	}
	
	@Override
	public void setName() {
		this.name = "User";
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setDebitCard(UserCard userCard) {
		this.debitCard = (DebitCard) userCard;
	}
	
	@Override
	public void setCreditCard(UserCard userCard) {
		this.creditCard = (CreditCard) userCard;
	}
	
	@Override
	public boolean isFirstRun() {
		return firstRun;
	}

	@Override
	public void setFirstRun(boolean firstRun) {
		this.firstRun = firstRun;
	}

	@Override
	public void newBankBalance(double amount) {
		this.bankBalance += amount;
	}
	
	/**
	 * Make transaction from this user to other user.
	 * This is why user is observable object to observer
	 * transferred money.
	 */
	@Override
	public void userTransaction(User user, double amount) {
		Transaction transaction = new Transaction(this);
		
		//exception - if there is an exception in Transaction class it will be thrown from makeTransaction method in Transaction class
		try {
			transaction.makeTransaction(user, amount);
			this.addObserver(transaction);	//observer - transaction object
			setChanged();
			notifyObservers(user);			//notify transaction object with argument other user(he will get money from this user, an observable object)
			deleteObserver(transaction);
		}
		
		//exception caught
		catch(AlertException alert) {
			AlertWindow.display("ALERT", alert.getMessage());
		}
	}
	
	@Override
	public String toString() {
		
		//show account info without a debit card - user does not have it yet
		if(this.getDebitCard() == null)	return this.getName() + " with bank balance " + this.getBankBalance() + " with your credit card info " + this.creditCard + ".";
		
		////show account info with a debit card
		return this.getName() + " with bank balance " + this.getBankBalance() + " with your credit card info " + this.creditCard + " and your debit card info " + this.debitCard + ".";
	}
}
