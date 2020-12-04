/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package card;

/**
 * Design pattern Factory
 * @author Erik Matoviè
 *
 */
public class Factory {
	/**
	 * Constructor to creade debit card
	 * @param cardNumber		set card number as String
	 * @param expirationDate	set expiration date as String
	 * @param securityCode		set security code as String
	 * @return	debit card for user
	 */
	public static DebitCard newDebitCard(String cardNumber, String expirationDate, String securityCode) {
		DebitCard DebitCard = new DebitCard();
		DebitCard.setCardNumber(cardNumber);
		DebitCard.setExpirationDate(expirationDate);
		DebitCard.setSecurityCode(securityCode);
		
		return DebitCard;
	}
}
