/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package gui;

import account.*;
import card.Factory;
import main.Main;
import exception.*;

/**
* Class UsefulMethods controls graphical users interface.
* <p>
* Controller class in mvc pattern.
* @author Erik Matoviè
*/
public class UsefulMethods {
	private boolean firstRun;
	private User user;
	private View view;
	
	/**
	* Class constructor specifying which user
	* is going to be a current logged in.
	* <p>
	* Constructor works with object user as model and
	* object view as view and UsefulMethods is a controller
	* as in design pattern mvc.
	* Variable firstRun is to determinate if program has its first run.
	* @param  user	this user is going to be a current logged in
	* @param  view	object view to change what user sees
	*/
	public UsefulMethods(User user, View view) {
		this.firstRun = true;
		this.user = user;
		this.view = view;
	}
	
	/**
	 * Set method for Buttons - event handling, what each button will do, when clicked.<p>
	 * Button buttonAccount shows info about user´s account when clicked.<p>
	 * Button buttonLogIN is imitating security - you can log on with password as UserA or UserB.<p>
	 * Button buttonDebitCard will set debit card for user if it is not already set.<p>
	 * Button buttonTransferMoney will change scene to go to the menu for transferring the money when clicked.<p>
	 * Button buttonUser will go back to the user´s menu when clicked.<p>
	 * Button buttonLogOut will log out user and scene will go back to the main menu when clicked.<p>
	 * Button buttonSendMoney will send money from one user to the second one when clicked.
	 */
	public void setButtons() {
		//show info about user´s account 
		getView().getButtonAccount().setOnAction(e -> AlertWindow.display("Account of " + this.user.getName(), this.user.toString()));
		
		// imitating security - you can log on with password as UserA or UserB
		getView().getButtonLogIn().setOnAction(e -> {
			String choosedUser = getView().getTextUsernameInput().getText();
			String password = getView().getTextPasswordInput().getText();
			
			try {
				Lambda lambda = (User user, double money) -> user.newBankBalance(money);	//lambda expression
				
				//exception - text field for choosed user or password is empty
				if(choosedUser.isEmpty() || password.isEmpty()) throw new AlertException("Text field is empty! Please try again.");
				
				//exception - wrong username 
				else if( !choosedUser.equalsIgnoreCase("a") && !choosedUser.equalsIgnoreCase("b") ) throw new AlertException("Incorrect username or password. Please try again.");
				
				//exception - wrong password
				else if( ( choosedUser.equalsIgnoreCase("a") && !password.equals("123") ) || ( choosedUser.equalsIgnoreCase("b") && !password.equals("456") ) ) 
					throw new AlertException("Incorrect username or password. Please try again.");
				
				//user was choosed as userB
				// polymorphism - user object of a superclass User is referencing to a subclass(UserB)
				else if(choosedUser.equalsIgnoreCase("b")) this.user = Main.userB;						
				
				//user was choosed as userA
				// polymorphism - user object of a superclass User is referencing to a subclass(UserA)
				else if(choosedUser.equalsIgnoreCase("a")) this.user = Main.userA;						
				
				//first run for this user - set new bank balance as 1000 with lambda expression 
				if(this.user.isFirstRun()) {
					lambda.setBankBalance(this.user, 1000);	//lambda expression to set bank account for first run for this user
					this.user.setFirstRun(false);
				}
				
				//first run for this program - set user scene and layout
				if(firstRun) {
					getView().setUserSceneAndLayout();
					firstRun = false;
				}
				
				//user does not have a debit card - button´s text: "Request debit card"
				if(this.user.getDebitCard() == null) getView().getButtonDebitCard().setText("Request debit card");
				
				//user has a debit card - button´s text: "You already have a debit card"
				else getView().getButtonDebitCard().setText("You already have a debit card");
				
				//set scene for user´s menu
				Main.window.setScene(getView().getSceneUser());
			}
			
			//exception has been caught 
			catch(AlertException alert) {
				AlertWindow.display("ALERT", alert.getMessage());
				Main.window.setScene(Main.sceneLogIn);
			}
		});
		
		//request debit card for user
		getView().getButtonDebitCard().setOnAction(e -> {
			Lambda lambda = (User user, double money) -> user.newBankBalance(money);	//lambda expression
			
			//debit card has not been selected yet for userA
			if(this.user.getName().equals("UserA")) {
				if(this.user.getDebitCard() == null) {
					AlertWindow.display("REQUEST DEBIT CARD", "Your debit card was added to your account, " + this.user.getName() + "!");
					this.user.setDebitCard(Factory.newDebitCard("1111111", "01/30", "111"));	//Factory pattern to create debit card
					lambda.setBankBalance(this.user, 1000);		//lambda expression to increase bank account when debit card created
					getView().getButtonDebitCard().setText("You already have a debit card");
				}
			}
			
			//debit card has not been selected yet for userB
			if(this.user.getName().equals("UserB")) {
				if(this.user.getDebitCard() == null) {
					AlertWindow.display("REQUEST DEBIT CARD", "Your debit card was added to your account, " + this.user.getName() + "!");
					this.user.setDebitCard(Factory.newDebitCard("222222", "02/30", "222"));		//Factory pattern to create debit card
					lambda.setBankBalance(this.user, 1000);		//lambda expression to increase bank account when debit card created
					getView().getButtonDebitCard().setText("You already have a debit card");
				}
			}
		});
		
		//go to the menu for transferring the money
		getView().getButtonTransferMoney().setOnAction(e -> Main.window.setScene(getView().getSceneTransaction()));
		
		//go back to the user´s menu
		getView().getButtonUser().setOnAction(e -> Main.window.setScene(getView().getSceneUser()));
		
		//log out and go back to the main menu
		getView().getButtonLogOut().setOnAction(e->{
			AlertWindow.display("LOG OUT", "You successfully logged out of your bank account, " + this.user.getName() + "!");
			this.user = null;
			Main.window.setScene(Main.sceneLogIn);
		});
		
		//send money in the menu for transferring the money
		getView().getButtonSendMoney().setOnAction(e -> {
			if(ConfirmWindow.display("TRANSACTION", "Do you really want to make a transaction, " + this.user.getName() + "?")) {
				String checkNumber = getView().getTextAmountMoneyToSend().getText();
				try {
					//exception - the amount of money has not been written in the text field 
					if(checkNumber.isEmpty()) throw new AlertException("Text field is empty! Please try again.");
					
					else {
						//cycle to find if there is , or a letter
					    for (int i = 0; i < checkNumber.length(); i++) {
					    	
					    	//exception - there is a letter
					        if( Character.isLetter( checkNumber.charAt(i) ) ) throw new AlertException(String.format("%s is not number! Please try again.", checkNumber));
					        
					        //exception - there is ,
					        else if( ',' == checkNumber.charAt(i) )
					        	throw new AlertException(String.format("You can not use , in %s! Please try again.", checkNumber));
					    }
					    
					    //text in the text field is a valid number
					    //transfer String object to Double object - wrapper class
						Double amount = new Double(checkNumber);
						
						//send money to the userB from userA
						if("UserA".equalsIgnoreCase(this.user.getName())) this.user.userTransaction(Main.userB, amount);
						
						//send money to the userA from userB
						else this.user.userTransaction(Main.userA, amount);
					}
				}
				
				//exception has been caught 
				catch(AlertException alert) {
					AlertWindow.display("ALERT", alert.getMessage());
				}
			}
		});
	}
	
	/**
	 * Exit program when clicked. 
	 */
	public void exitProgram() {
		boolean answer = ConfirmWindow.display("Exit", "Do you really want to exit a program?");
		if(answer) Main.window.close();
	}
	
	/**
	 * Get method to access view.<p>
	 * Encapsulation.
	 * @return	object view
	 */
	public View getView() {
		return view;
	}
}
