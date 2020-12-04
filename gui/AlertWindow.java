/*
 * Object-Oriented Programming
 * Project: Internetbanking
 * Erik Matovic
 */
package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
* Class AlertWindow shows alert, when user is using
* program wrong.
* @author Erik Matoviè
*/
public class AlertWindow {
	/**
	* Display alert window.
	* @param  titleOfWindow title of a window to be shown
	* @param  message  		message to be shown
	* @author Erik Matoviè
	*/
	public static void display(String titleOfWindow, String message) {
		Stage windowAlert = new Stage();
		windowAlert.initModality(Modality.APPLICATION_MODAL);
		windowAlert.setTitle(titleOfWindow);
		windowAlert.setMinWidth(600);
		windowAlert.setMinHeight(150);
		
		Button buttonClose = new Button("Close window");
		buttonClose.setOnAction(e -> windowAlert.close());
		
		VBox layoutAlert = new VBox(10);
		layoutAlert.getChildren().addAll(new Label(message), buttonClose);
		layoutAlert.setAlignment(Pos.CENTER);
		
		Scene sceneAlert = new Scene(layoutAlert);
		windowAlert.setScene(sceneAlert);
		windowAlert.showAndWait();
	}
}
