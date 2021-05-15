/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author Joaquin
 *
 */
public class UpdateStudent {

	private Student student;
	@FXML
	private Button back;
	@FXML
	private Button search;
	@FXML
	private Button save;
	@FXML
	private TextField name;
	@FXML
	private TableView<Student> studenTable;
	@FXML
	private TableColumn<Student, String> idColum;
	@FXML
	private TableColumn<Student, String> nameColum;
	@FXML
	private TableColumn<Student, String> surnameColum;
	@FXML
	private TableColumn<Student, String> observationColum;
	@FXML
	private TextField id;
	@FXML
	private TextField newName;
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
	private void searchStudent() {
		configureStudent();
		List<Student> students = StudentDAO.searchStudent(name.getText());
		studenTable.setItems(FXCollections.observableArrayList(students));

	}

	@FXML
	private void configureStudent() {
		idColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue("" + eachStudent.getValue().getId());
			return v;
		});
		nameColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(eachStudent.getValue().getName());
			return v;
		});
		surnameColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(eachStudent.getValue().getSurname());
			return v;
		});
		observationColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(eachStudent.getValue().getObservations());
			return v;
		});
	}

	@FXML
	private void setStudent() {
		student = new StudentDAO(Integer.parseInt(id.getText()));
		newName.setText(student.getName());
		surname.setText(student.getSurname());
		if(student.getObservations()!=null) {
			observations.setText(student.getObservations());	
		}
		dateDay.setText(""+student.getDate().getDayOfMonth());
		dateMonth.setText(""+student.getDate().getMonthValue());
		dateYear.setText(""+student.getDate().getYear());
		

	}

	@FXML
	private void save() throws IOException {
		if(student!=null) {
			StudentDAO s = (StudentDAO) student;
				
			s.setName(newName.getText());
			s.setSurname(surname.getText());
			int d = Integer.parseInt(dateDay.getText());
			int m = Integer.parseInt(dateMonth.getText());
			int y = Integer.parseInt(dateYear.getText());
			LocalDate date = LocalDate.of(y, m, d);
			s.setDate(date);
			if(observations.getText()!=null&&!observations.getText().equals("")) {
				s.setObservations(observations.getText());
			}
			
			s.saveStudent();
			switchToExit();
		}
		
	}

	@FXML
	private void switchToExit() throws IOException {
		App.setRoot("add");
	}

}
