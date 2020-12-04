/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package transaction;

import java.util.Observable;
import java.util.Observer;

import account.User;
import gui.AlertWindow;
import exception.AlertException;

/**
* Class Transaction sends money from one user
* to a second one and it also display alert window
* to see which user sent money and which user received money.
* <p>
* Class Transaction implements Observer class.
* @author Erik Matoviè
*/
public class Transaction implements Observer{
	private User user;
	
	/**
	* Class constructor specifying which user
	* is going to make a transaction.
	* <p>
	* @param  user	this user is trying to make a transaction
	*/
	public Transaction(User user) {
		this.user = user;
	}
	
	/**
	* Make transaction from this user to second user.
	* <p>
	* This method contains polymorphism - secondUser object 
	* of a superclass User is referencing to a subclass(UserA or UserB)
	* @param  secondUser    a user to receive money
	* @param  amount  		amount of money to be send
	* @see         			User
	*/
	public void makeTransaction(User secondUser, double amount) {
		//exception - amount of money to send is either too big or too small
		//exception is caught in User.java
		if(amount > this.user.getBankBalance() || amount <= 0) throw new AlertException("You can not send this amount of money!");
			
		this.user.newBankBalance(-amount);
		secondUser.receiveTransaction(amount);	//polymorphism - secondUser object of a superclass User is referencing to a subclass(UserA or UserB)
	}
	
	/**
	* Displays alert window to show which user 
	* sent money and which user received money. 
	* <p>
	* This method always displays alert window to show which user 
	* sent money and which user received money.
	* @param  o    observable
	* @param  arg  a second user
	* @see         User
	* @author Erik Matoviè
	*/
	@Override
	public void update(Observable o, Object arg) {
		User secondUser = (User) arg;	// polymorphism - secondUser object of a superclass User is referencing to a subclass(UserA or UserB)
			
		AlertWindow.display("Transaction", "Transaction successful. " + this.user.getName() + 
				" sent money and " + secondUser.getName() + " received money.");
	}	
}
