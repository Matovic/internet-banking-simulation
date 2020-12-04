/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package account;

import card.*;

/**
 * Subclass UserB inherits from a superclass User
 * @author Erik Matoviè
 *
 */
public class UserB extends User{
	public UserB(CreditCard creditCard) {
		super(creditCard);
	}
	
	@Override
	public void setName() {
		this.name = "UserB";
	}
}
