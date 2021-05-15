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
	private Button removeWord;
	@FXML
	private Button updateWord;
	@FXML
	private Button removeStudent;
	@FXML
	private Button updateStudent;
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
	@FXML
	private void switchToRemoveWord() throws IOException{
		App.setRoot("remuveWord");
	}
	@FXML
	private void switchToUpdateWord() throws IOException{
		App.setRoot("updateWord");
	}
	@FXML
	private void switchToRemoveStudent() throws IOException{
		App.setRoot("remuveStudent");
	}
	@FXML
	private void switchToUpdateStudent() throws IOException{
		App.setRoot("updateStudent");
	}
	
	

}
