package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;
import es.joaquinjimenez.Lectura.model.Word;
import es.joaquinjimenez.Lectura.model.WordDAO;
import es.joaquinjimenez.Lectura.model.WordType;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SecondaryController implements Initializable{
	@FXML
	private Button star;
	@FXML
	private Button back;
	@FXML
	private Button search;
	@FXML
	private Button setStudent;
	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private TableView<Student> studenTable;
	@FXML
	private TableColumn<Student, String> nameColum;
	@FXML
	private TableColumn<Student, String> surnameColum;
	@FXML
	private TableColumn<Student, String> idColum;
	@FXML
	private ChoiceBox<String> wordType;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		wordType.getItems().addAll("Directa","Inversa","Trabada","Mixta");
		wordType.setValue("Directa");
	}
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
		   idColum.setCellValueFactory(eachStudent->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(""+eachStudent.getValue().getId());
			   return v;
		   });
	   }
	@FXML
	private void setStudent() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("question.fxml"));
        Parent root=loader.load();
        Question question=loader.getController();
        question.setStudent(Integer.parseInt(id.getText()));
	}
	/*
	 * pasa el id a la siguiente ventana para que busque el  alumno correspondiente
	 */
	@FXML
    private void switchToQuestion() throws IOException {
		/*
       //se carga el fxml de la pantalla a cargar
        FXMLLoader loader=new FXMLLoader(getClass().getResource("question.fxml"));
        Parent root=loader.load();
        //se obtiene la clase que controla la vista a cargar
        Question question=loader.getController();
        String type=wordType.getValue();
		switch(type) {
		case "Directa":
			question.setWords(WordType.direct);
			break;
		case "Inversa":
			question.setWords(WordType.reverse);
			break;
		case "Trabada":
			question.setWords(WordType.stuck);
			break;
		case "Mixta":
			question.setWords(WordType.mixed);
			break;
		 default:
             throw new IllegalArgumentException("Tipo de palabra invalida" + type);
		}
		question.setStudent(Integer.parseInt(id.getText()));
		*/
        App.setRoot("question");
    }  
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}