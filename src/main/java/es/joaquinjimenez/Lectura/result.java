/**
 * 
 */
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
import javafx.collections.ObservableListBase;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * @author Joaquin
 *
 */
public class result {
	
	@FXML
	private Button back;
	@FXML
	private Button search;
	@FXML
	private Button seeWord;
	@FXML
	private TextField name;
	@FXML
	private TableView<Student> studenTable;
	@FXML
	private TableView<Word> wordTable;
	@FXML
	private TableColumn<Student, String> nameColum;
	@FXML
	private TableColumn<Student, String> surnameColum;
	@FXML
	private TableColumn<Student, String> observationColum;
	@FXML
	private TableColumn<Word, String> wordColum;
	@FXML
	private TableColumn<Word, String> passColum;
	@FXML
	private TableColumn<Word, String> tipeColum;
	
	@FXML
	private void switchToPrimary() throws IOException{
		App.setRoot("primary");
	}
	
	@FXML
	private void searchStudent() {
		configureStudent();
		List<Student> students=StudentDAO.searchStudent(name.getText());
		studenTable.setItems(FXCollections.observableArrayList(students));
		
	}
	//se activa cuando se selecciona un alumno
	@FXML 
	private void searchStudentWords() {
		studenTable.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
			searchWord(newValue);
		});
	}
	//recibe por parametro el estudiante seleccionado en la studentTable
	@FXML
	private void searchWord(Student s) {
		configureWord();
		if(s!=null) {
			List<Word> words=WordDAO.searchForStudent(s.getId());
			wordTable.setItems(FXCollections.observableArrayList(words));
		}
		
		
		
		
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
	private void configureWord() {
		   wordColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(eachStudent.getValue().getWord());
			   return v;
		   });
		   passColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   if(eachStudent.getValue().isPassed())
				   v.setValue("si");
			   else if(!eachStudent.getValue().isPassed())
				   v.setValue("no");
			   
			   return v;
		   });
		   
		   tipeColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   
			   
				switch (eachStudent.getValue().getWordType()) {
				case direct: {
					v.setValue("Directa");
					break;
				}
				case reverse: {
					v.setValue("Inversa");
					break;
				}
				case stuck: {
					v.setValue("Trabada");
					break;
				}
				case  mixed: {
					v.setValue("Mixta");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + eachStudent.getValue().getWordType());
				}
			   
			   return v;
		   });
	   }

}
