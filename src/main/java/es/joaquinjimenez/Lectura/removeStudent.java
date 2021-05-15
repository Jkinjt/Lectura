/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;
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
public class removeStudent {

	@FXML
	private Button back;
	@FXML
	private Button search;
	@FXML
	private Button remove;
	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private TableView<Student> studenTable;
	@FXML
	private TableColumn<Student, String> idColum;
	@FXML
	private TableColumn<Student, String> nameColum;
	@FXML
	private TableColumn<Student, String> surnameColum;
	
	
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
	}
	@FXML
	private void removeStudent() {
		StudentDAO s=new StudentDAO(Integer.parseInt(id.getText()));
		if(s.removeStudent()) {
			try {
				switchToExit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@FXML
	private void switchToExit() throws IOException {
		App.setRoot("add");
	}
	
}
