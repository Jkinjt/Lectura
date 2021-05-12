/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.time.LocalDate;

import es.joaquinjimenez.Lectura.model.StudentDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Joaquin
 *
 */
public class AddStudent {
	@FXML
	private Button save;
	@FXML
	private Button exit;
	@FXML 
	private TextField name;
	@FXML 
	private TextField surname;
	@FXML 
	private TextField dateDay;
	@FXML 
	private TextField dateMonth;
	@FXML 
	private TextField dateYear;
	@FXML 
	private TextField observations;
	
	
	
	@FXML
    private void save() throws IOException {
		StudentDAO s=new StudentDAO();
		s.setName(name.getText());
		s.setSurname(surname.getText());
		int d=Integer.parseInt(dateDay.getText());
		int m=Integer.parseInt(dateMonth.getText());
		int y=Integer.parseInt(dateYear.getText());
		LocalDate date= LocalDate.of(y, m, d);
		s.setDate(date);
		s.setObservations(observations.getText());
		s.saveStudent();
		switchToExit();
	}
	
	@FXML
	private void switchToExit() throws IOException {
        App.setRoot("add");
    }

}
