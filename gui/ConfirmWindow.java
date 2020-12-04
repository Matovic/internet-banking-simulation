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
* Class ConfirmWindow shows confirmation window, 
* when program is demanding user´s confirmation.
* @author Erik Matoviè
*/
public class ConfirmWindow {
	private static boolean answer;
	
	/**
	* Display confirmation window.
	* @param  titleOfWindow title of a window to be shown
	* @param  message  		message to be shown
	* @return 				user´s answer(confirmation or rejection)
	* @author Erik Matoviè
	*/
	public static boolean display(String titleOfWindow, String message) {
		Stage windowAlert = new Stage();
		windowAlert.initModality(Modality.APPLICATION_MODAL);
		windowAlert.setTitle(titleOfWindow);
		windowAlert.setMinWidth(600);
		windowAlert.setMinHeight(150);
		
		Button buttonPositive = new Button("Yes");
		Button buttonNegative = new Button("No");
		
		buttonPositive.setOnAction(e -> {
			answer = true;
			windowAlert.close();
		});
		
		buttonNegative.setOnAction(e -> {
			answer = false;
			windowAlert.close();
		});
		
		windowAlert.setOnCloseRequest(e -> {
			answer = false;
			windowAlert.close();
		});
		
		VBox layoutAlert = new VBox(10);
		layoutAlert.getChildren().addAll(new Label(message), buttonPositive, buttonNegative);
		layoutAlert.setAlignment(Pos.CENTER);
		
		Scene sceneAlert = new Scene(layoutAlert);
		windowAlert.setScene(sceneAlert);
		windowAlert.showAndWait();
		
		return answer;
	}
}

