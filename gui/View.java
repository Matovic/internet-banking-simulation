/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import main.Main;

/**
* Class View shows graphical users interface.
* <p>
* View class in mvc pattern.
* @author Erik Matoviè
*/
public class View {

	private Button 
		buttonAccount = new Button("Your account"), 
		buttonUser = new Button("Go back to user menu"), 
		buttonTransferMoney = new Button("Transfer money"),
		buttonDebitCard = new Button("Request debit card"),
		buttonLogIn = new Button("Log in"),
		buttonLogOut = new Button("Log Out"),
		buttonSendMoney = new Button("Send money");
	
	private Scene sceneUser, sceneTransaction; 

	private VBox 
		layoutUser = new VBox(20),
		layoutTransaction = new VBox(20),
		layoutLogIn = new VBox(20);
	
	private TextField textUsernameInput, textPasswordInput, textAmountMoneyToSend;
	
	/**
	 * Set scene for log in menu
	 */
	public void setLogInSceneAndLayout() {
		Label usernameLabel = new Label("Username: ");
		
		this.textUsernameInput = new TextField();
		this.getTextUsernameInput().setPromptText("username");

		Label passwordLabel = new Label("Password: (a - 123 / b - 456) ");
		
		this.textPasswordInput = new TextField();
		this.getTextPasswordInput().setPromptText("password");
				
		//layout for log in menu
		this.layoutLogIn.setPadding(new Insets(30, 100, 50, 100));
		this.layoutLogIn.getChildren().addAll(new Label("Choose user: A or B?"), usernameLabel, this.getTextUsernameInput(), 
				passwordLabel, this.getTextPasswordInput(), this.getButtonLogIn());
		Main.sceneLogIn = new Scene(this.layoutLogIn, 1200, 700);
	}
	
	/**
	 * Set scene for user menu
	 */
	public void setUserSceneAndLayout() {
		//layout for user
		this.layoutUser.getChildren().addAll(new Label("Welcome to your account!"), 
				this.getButtonAccount(), this.getButtonTransferMoney(), this.getButtonDebitCard(), this.getButtonLogOut());		
		this.sceneUser = new Scene(this.layoutUser, 1200, 700);
		setTransactionSceneAndLayout();			
	}
	
	/**
	 * Set scene for transaction menu
	 */
	public void setTransactionSceneAndLayout() {
		//layout for transaction
		this.textAmountMoneyToSend = new TextField();
		this.getTextAmountMoneyToSend().setPromptText("choose amount of money to be transferred");
		this.layoutTransaction.setPadding(new Insets(30, 100, 50, 100));
		this.layoutTransaction.getChildren().addAll(new Label("To make a transaction please choose amount of money to be transferred.\n"
				+ "(for example: 12.5 - do not use 12,5)"), this.getTextAmountMoneyToSend(), this.getButtonSendMoney(), this.getButtonUser());
		this.sceneTransaction = new Scene(this.layoutTransaction, 1200, 700);
	}
	
	/**
	 * Get method to access buttonAccount.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonAccount() {
		return buttonAccount;
	}
	
	/**
	 * Get method to access buttonLogIn.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonLogIn() {
		return buttonLogIn;
	}
	
	/**
	 * Get method to access textUsernameInput.<p>
	 * Encapsulation.
	 * @return	text field
	 */
	public TextField getTextUsernameInput() {
		return textUsernameInput;
	}

	/**
	 * Get method to access textPasswordInput.<p>
	 * Encapsulation.
	 * @return	text field
	 */
	public TextField getTextPasswordInput() {
		return textPasswordInput;
	}

	/**
	 * Get method to access sceneUser.<p>
	 * Encapsulation.
	 * @return	scene
	 */
	public Scene getSceneUser() {
		return sceneUser;
	}
	
	/**
	 * Get method to access buttonDebitCard.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonDebitCard() {
		return buttonDebitCard;
	}
	
	/**
	 * Get method to access buttonTransferMoney.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonTransferMoney() {
		return buttonTransferMoney;
	}
	
	/**
	 * Get method to access sceneTransaction.<p>
	 * Encapsulation.
	 * @return	scene
	 */
	public Scene getSceneTransaction() {
		return sceneTransaction;
	}
	
	/**
	 * Get method to access buttonUser.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonUser() {
		return buttonUser;
	}
	
	/**
	 * Get method to access buttonLogOut.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonLogOut() {
		return buttonLogOut;
	}
	
	/**
	 * Get method to access buttonSendMoney.<p>
	 * Encapsulation.
	 * @return	button
	 */
	public Button getButtonSendMoney() {
		return buttonSendMoney;
	}
	
	/**
	 * Get method to access textAmountMoneyToSend.<p>
	 * Encapsulation.
	 * @return	text field
	 */
	public TextField getTextAmountMoneyToSend() {
		return textAmountMoneyToSend;
	}
}
