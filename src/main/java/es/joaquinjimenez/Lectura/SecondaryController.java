package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.util.List;

import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;
import es.joaquinjimenez.Lectura.model.Word;
import es.joaquinjimenez.Lectura.model.WordDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SecondaryController {
	private Student student;
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
	
	
	@FXML
    private void switchToQuestion() throws IOException {
       //se carga el fxml de la pantalla a cargar
        FXMLLoader loader=new FXMLLoader(getClass().getResource("question.fxml"));
        Parent root=loader.load();
        //se obtiene la clase que controla la vista a cargar
        Question question=loader.getController();
        studenTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
        	student=newValue;
		}); 
        question.start(studenTable);
        App.setRoot("question");
    }  
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}