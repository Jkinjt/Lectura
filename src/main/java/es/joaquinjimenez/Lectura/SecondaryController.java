package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.util.List;

import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;
import es.joaquinjimenez.Lectura.model.Word;
import es.joaquinjimenez.Lectura.model.WordDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SecondaryController {
	@FXML
	private Button back;
	@FXML
	private Button search;
	@FXML
	private TextField name;
	@FXML
	private TableView<Student> studenTable;
	@FXML
	private TableColumn<Student, String> nameColum;
	@FXML
	private TableColumn<Student, String> surnameColum;
	@FXML
	private TableColumn<Student, String> observationColum;
	
	
	@FXML
	private void searchStudent() {
		configureStudent();		
		List<Student> students=StudentDAO.searchStudent(name.getText());
		studenTable.setItems(FXCollections.observableArrayList(students));
		
	}
		
	@FXML
	private void configureStudent() {
		   nameColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(eachStudent.getValue().getName());
			   return v;
		   });
		   surnameColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(eachStudent.getValue().getSurname());
			   return v;
		   });
		   observationColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(eachStudent.getValue().getObservations());
			   return v;
		   });
	   }
	//para pasar el estudiante seleccionado a la siguiente pantalla
	private void setStudent() {
		studenTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
			Question.setStudent(newValue);
			
		});
	}
	
	@FXML
    private void switchToQuestion() throws IOException {
        App.setRoot("question");
        setStudent();
    }  
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}