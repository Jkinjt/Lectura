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
	private void switchToPrimary() throws IOException{
		App.setRoot("primary");
	}
	
	

}
