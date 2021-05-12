/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author Joaquin
 *
 */
public class Add {
	
	@FXML
	private Button back;
	@FXML
	private Button addStudent;
	@FXML
	private Button addWord;
	
	@FXML
	private void switchToPrimary() throws IOException{
		App.setRoot("primary");
	}
	@FXML
	private void switchToAddStudent() throws IOException{
		App.setRoot("addStudent");
	}
	@FXML
	private void switchToAddWord() throws IOException{
		App.setRoot("addWord");
	}
	

}
