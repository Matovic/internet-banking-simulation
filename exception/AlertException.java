/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package exception;

/**
* Class AlertException is implemented exception.
* @author Erik Matoviè
*/
public class AlertException extends RuntimeException{
	private static final long serialVersionUID = 2314189733333944776L;
	
	/**
	* Class constructor specifying what
	* message is going to be shown.
	* <p>
	* @param  message	message to be shown
	*/
	public AlertException(String message) {
		super(message);
	}
}
