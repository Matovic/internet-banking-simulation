/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package card;

/**
 * Subclass CreditCard inherits from a superclass UserCard
 * @author Erik Matoviè
 *
 */
public class CreditCard extends UserCard{
	public CreditCard() {
		super();
	}
	
	/**
	 * Builder pattern
	 * @param creditCardBuilder	Builder pattern credit card
	 */
	public CreditCard(CreditCardBuilder creditCardBuilder) {
		setCardNumber(creditCardBuilder.getCardNumber());
		setExpirationDate(creditCardBuilder.getExpirationDate());
		setSecurityCode(creditCardBuilder.getSecurityCode());
	}
	
	/**
	 * Builder pattern
	 * @return Builder for credit card
	 */
	public static CreditCardBuilder newCreditCard() {
		return new CreditCardBuilder();
	}
	
	/**
	 * Design pattern Builder and also
	 * nested class.
	 * @author Erik Matoviè
	 */
	public static class CreditCardBuilder implements Card{
		private String cardNumber;
		private String expirationDate;
		private String securityCode;
		
		public  CreditCardBuilder() {
		}

		public CreditCardBuilder cardNumber(String cardNumber) {
			this.setCardNumber(cardNumber);
			return this;
		}
		
		public CreditCardBuilder expirationDate(String expirationDate) {
			this.setExpirationDate(expirationDate);
			return this;
		}
		
		public CreditCardBuilder securityCode(String securityCode) {
			this.setSecurityCode(securityCode);
			return this;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public String getExpirationDate() {
			return expirationDate;
		}

		public void setExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
		}

		public String getSecurityCode() {
			return securityCode;
		}

		public void setSecurityCode(String securityCode) {
			this.securityCode = securityCode;
		}
	}	

}
