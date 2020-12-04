/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package card;

/**
 * Superclass UserCard implements interface Card
 * @author Erik Matoviè
 */
public class UserCard implements Card{
	private String cardNumber;
	private String expirationDate;
	private String securityCode;
	
	/**
	 * Constructor used for design patterns in Main.java to create cards for users
	 */
	public UserCard() {
		
	}
	
	@Override
	public String getCardNumber() {
		return this.cardNumber;
	}

	@Override
	public String getExpirationDate() {
		return this.expirationDate;
	}

	@Override
	public String getSecurityCode() {
		return this.securityCode;
	}
	
	@Override
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	public String toString() {
		return "card number: " + this.cardNumber + " security number: " + this.securityCode + " expiration date: " + this.expirationDate;
	}
}
