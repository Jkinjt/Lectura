/**
 * 
 */
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author Joaquin
 *
 */
public class Question implements Initializable {
	private Student student;
	private List<Word> words;
	@FXML
	private Button back;
	@FXML
	private Button setStudent;
	@FXML
	private Button update;
	@FXML
	private Button search;
	@FXML
	private TextField idStudent;
	@FXML
	private TextField idWord;
	@FXML
	private TextField tfName;

	@FXML
	private TableView<Word> wordTable;
	@FXML
	private TableColumn<Word, String> wordColum;
	@FXML
	private TableColumn<Word, String> tipeColum;
	@FXML
	private TableColumn<Word, String> idColum;
	@FXML
	private ChoiceBox<String> wordType;
	@FXML
	private CheckBox pass;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		configureWord();
		wordType.getItems().addAll("Directa", "Inversa", "Trabada", "Mixta");
		wordType.setValue("Directa");

	}

	// para pasar el estudiante elegidp
	public void setStudent(int id) {
		student = new StudentDAO(id);

	}

	// para traspasar los tipos de palabra de una ventana a otra
	public void setWords(WordType wt) {
		words = WordDAO.searchType(wt);
		wordTable.setItems(FXCollections.observableArrayList(words));
	}

	@FXML
	private void searchWords() {
		configureWord();
		String type = wordType.getValue();
		switch (type) {
		case "Directa":
			words = WordDAO.searchType(WordType.direct);

			break;
		case "Inversa":
			words = WordDAO.searchType(WordType.reverse);
			break;
		case "Trabada":
			words = WordDAO.searchType(WordType.stuck);
			break;
		case "Mixta":
			words = WordDAO.searchType(WordType.mixed);
			break;
		default:
			throw new IllegalArgumentException("Tipo de palabra invalida" + type);
		}
		wordTable.setItems(FXCollections.observableArrayList(words));
	}

	@FXML
	private void setThisStudent() {
		student = new StudentDAO(Integer.parseInt(idStudent.getText()));

		tfName.setText(student.getName());

	}

	@FXML
	private void addWord() {
		Word w = new WordDAO(Integer.parseInt(idWord.getText()));
		w.setPassed(pass.isSelected());
		StudentDAO s = (StudentDAO) student;
		s.addWord(w);
		s.saveStudent();
		pass.setDisable(false);
		idWord.setText("");
	}

	private void configureWord() {
		wordColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(eachStudent.getValue().getWord());
			return v;
		});
		idColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue("" + eachStudent.getValue().getId());
			return v;
		});
		tipeColum.setCellValueFactory(eachStudent -> {
			SimpleStringProperty v = new SimpleStringProperty();

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
			case mixed: {
				v.setValue("Mixta");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + eachStudent.getValue().getWordType());
			}

			return v;
		});
	}

	@FXML
	private void switchToQuestion() throws IOException {
		
		
		App.setRoot("secondary");
	}

}
