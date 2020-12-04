/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package card;

import card.CreditCard.CreditCardBuilder;
/**
* Interface Card for user´s credit card or debit card.
* @author Erik Matoviè
*/
public interface Card {
	/**
	 * Get method to access getCardNumber.<p>
	 * Encapsulation.
	 * @return	String
	 */
	public String getCardNumber();
	
	/**
	 * Get method to access expirationDate.<p>
	 * Encapsulation.
	 * @return	String
	 */
	public String getExpirationDate();
	
	/**
	 * Get method to access securityCode.<p>
	 * Encapsulation.
	 * @return	String
	 */
	public String getSecurityCode();
	
	/**
	 * Set method to access cardNumber.<p>
	 * Encapsulation.
	 * @param cardNumber set cardNumber
	 */
	public void setCardNumber(String cardNumber);
	
	/**
	 * Set method to access expirationDate.<p>
	 * Encapsulation.
	 * @param expirationDate set expirationDate
	 */
	public void setExpirationDate(String expirationDate);
	
	/**
	 * Set method to access securityCode.<p>
	 * Encapsulation.
	 * @param securityCode set securityCode
	 */
	public void setSecurityCode(String securityCode);
	
	/**
	 * Default build method for design pattern Builder for CreditCardBuilder
	 * @return	credit card for user
	 */
	public default CreditCard build() {
		return new CreditCard((CreditCardBuilder) this);
	}
}
