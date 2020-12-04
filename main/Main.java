/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import account.*;
import card.*;
import gui.*;

/**
* Class Main uses public static void main
* to run a program.
* <p>
* Class Main implements Application class.
* @author Erik Matoviè
*/
public class Main extends Application{
	/**
	 * window shows to user graphical user interface 
	 */
	public static Stage window;
	
	/**
	 * set scene to show user log in menu
	 */
	public static Scene sceneLogIn;	
	
	/**
	 * User A and his credit card created with design pattern Builder
	 */
	public static final UserA userA = new UserA(CreditCard.newCreditCard()
			.cardNumber("789123")
			.expirationDate("08/22")
			.securityCode("369")
			.build());
	
	/**
	 * User B and his credit card created with design pattern Builder
	 */
	public static final UserB userB = new UserB(CreditCard.newCreditCard()
			.cardNumber("123456")
			.expirationDate("02/25")
			.securityCode("963")
			.build());
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Internetbanking");
		
		//separate gui from logic
		View view = new View();										//object view as view in mvc pattern
		User user = new User();										//object user as model in mvc pattern
		UsefulMethods controller = new UsefulMethods(user, view);	//object controller as controller in mvc pattern
		
		//closing program with my method exitProgram()
		window.setOnCloseRequest(e -> {
			e.consume();												//consumes this event so that it will not be processed in the default manner by the source which originated it
			controller.exitProgram();
		});
		
		controller.setButtons();
		controller.getView().setLogInSceneAndLayout();
		
		window.setScene(sceneLogIn);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
