/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package account;

import card.*;

/**
 * Subclass UserA inherits from a superclass User
 * @author Erik Matoviè
 *
 */
public class UserA extends User{	
	public UserA(CreditCard creditCard) {
		super(creditCard);
	}
	
	@Override
	public void setName() {
		this.name = "UserA";
	}
}
