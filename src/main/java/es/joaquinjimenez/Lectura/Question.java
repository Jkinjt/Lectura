/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;

import es.joaquinjimenez.Lectura.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Joaquin
 *
 */
public class Question {
	
	@FXML
	private Button back;
	@FXML
	private static Label studentName;
	
	@FXML
	public static void setStudent(Student s) {
		studentName.setText(s.getName());
	}
	@FXML
    private void switchToQuestion() throws IOException {
        App.setRoot("secondary");
    }
	

}
