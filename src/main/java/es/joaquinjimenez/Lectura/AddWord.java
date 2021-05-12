/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.joaquinjimenez.Lectura.model.WordDAO;
import es.joaquinjimenez.Lectura.model.WordType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * @author Joaquin
 *
 */
public class AddWord implements Initializable{

	@FXML
	private Button exit;
	@FXML
	private Button save;
	@FXML
	private ChoiceBox<String> wordType;
	@FXML
	private TextField word;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		wordType.getItems().addAll("Directa","Inversa","Trabada","Mixta");
		wordType.setValue("Directa");
	}
	
	@FXML
	private void save() throws IOException{
		WordDAO w=new WordDAO();
		w.setWord(word.getText());
		String type=wordType.getValue();
		switch(type) {
		case "Directa":
			w.setWordType(WordType.direct);
			break;
		case "Inversa":
			w.setWordType(WordType.reverse);
			break;
		case "Trabada":
			w.setWordType(WordType.stuck);
			break;
		case "Mixta":
			w.setWordType(WordType.mixed);
			break;
		 default:
             throw new IllegalArgumentException("Tipo de palabra invalida" + type);
		}
		w.saveWord();
		switchToExit();
	}
	@FXML
	private void switchToExit() throws IOException {
        App.setRoot("add");
    }
}
