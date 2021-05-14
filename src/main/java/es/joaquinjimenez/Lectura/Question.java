/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.joaquinjimenez.Lectura.model.Student;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * @author Joaquin
 *
 */
public class Question  {
	private Student student;
	@FXML
	private Button back;
	@FXML
	private static Label studentName;
	
	
	
	public void start(TableView<Student> studenTable){
		
		if(studenTable==null) {
			student=new Student();
			
		}else {
			   	
		}
		
	}
	@FXML
    private void switchToQuestion() throws IOException {
        App.setRoot("secondary");
    }
	

}
