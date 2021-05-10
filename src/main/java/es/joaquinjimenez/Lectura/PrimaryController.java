package es.joaquinjimenez.Lectura;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

	@FXML
	private Button add;
	@FXML
	private Button start;
	@FXML
	private Button result;
   
	
	@FXML
    private void switchToStart() throws IOException {
        App.setRoot("secondary");
    }
	@FXML
	private void switchToAdd() throws IOException {
        App.setRoot("add");
    }
	@FXML
	private void switchToResult() throws IOException {
        App.setRoot("result");
    }
    
}
