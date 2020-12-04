/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package account;

import card.*;
/**
* Interface Account for user.
* @author Erik Matoviè
*/
public interface Account {
	/**
	 * Get method to access name.<p>
	 * Encapsulation.
	 * @return	String
	 */
	public String getName();
	
	/**
	 * Get method to access password.<p>
	 * Encapsulation.
	 * @return	String
	 */
	public String getPassword();

	/**
	 * Get method to access number.<p>
	 * Encapsulation.
	 * @return	String
	 */
	public String getNumber();

	/**
	 * Get method to access bank balance.<p>
	 * Encapsulation.
	 * @return	money from bank account of user
	 */
	public double getBankBalance();
	
	/**
	 * Get method to access debitCard.<p>
	 * Encapsulation.
	 * @return	debit card
	 */
	public DebitCard getDebitCard();

	/**
	 * Set method to access name.<p>
	 * Encapsulation.
	 */
	public void setName();

	/**
	 * Set method to access name.<p>
	 * Encapsulation.
	 * @param name set name
	 */
	public void setName(String name);
	
	/**
	 * Set method to access debitCard.<p>
	 * Encapsulation.
	 * Polymorphism - userCard is referencing to a DebitCard type of object.
	 * @param userCard set debitCard
	 */
	public void setDebitCard(UserCard userCard);
	
	/**
	 * Set method to access creditCard.<p>
	 * Encapsulation.
	 * Polymorphism - userCard is referencing to a CreditCard type of object.
	 * @param userCard set creditCard
	 */
	public void setCreditCard(UserCard userCard);
	
	/**
	 * Set method to access bankBalance.<p>
	 * Encapsulation.
	 * @param amount set bankBalance
	 */
	public void newBankBalance(double amount);
	
	/**
	 * Get method to access firstRun.<p>
	 * Encapsulation.
	 * @return	true or false
	 */
	public boolean isFirstRun();
	
	/**
	 * Set method to access firstRun to decide if it is a user´s first run.<p>
	 * Encapsulation.
	 * @param firstRun set firstRun
	 */
	public void setFirstRun(boolean firstRun);

	/**
	 * Send money from current user to second user
	 * @param user		user to receive money
	 * @param amount	amount of money to be transferred 
	 */
	public void userTransaction(User user, double amount);
	
	/**
	 * Default method for user to receive transaction
	 * @param amount money to be received
	 */
	public default void receiveTransaction(double amount) {
		this.newBankBalance(amount);
	}
}
