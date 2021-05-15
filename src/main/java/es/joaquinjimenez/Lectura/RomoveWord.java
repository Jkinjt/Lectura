/**
 * 
 */
package es.joaquinjimenez.Lectura;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import es.joaquinjimenez.Lectura.model.StudentDAO;
import es.joaquinjimenez.Lectura.model.Word;
import es.joaquinjimenez.Lectura.model.WordDAO;
import es.joaquinjimenez.Lectura.model.WordType;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author Joaquin
 *
 */
public class RomoveWord implements Initializable{
	
	@FXML
	private Button exit;
	@FXML
	private Button remove;
	@FXML
	private Button searchWord;
	@FXML
	private ChoiceBox<String> wordType;
	@FXML
	private TextField id;
	@FXML
	private TableView<Word> wordTable;
	@FXML
	private TableColumn<Word, String> wordColum;
	@FXML
	private TableColumn<Word, String> idColum;
	@FXML
	private TableColumn<Word, String> tipeColum;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		wordType.getItems().addAll("Directa","Inversa","Trabada","Mixta");
		wordType.setValue("Directa");
	}
	@FXML
	private void search() throws IOException{
		configureWord();
		List<Word> words=new ArrayList<Word>();
		String type=wordType.getValue();
		switch(type) {
		case "Directa":
			words=WordDAO.searchType(WordType.direct);
			wordTable.setItems(FXCollections.observableArrayList(words));
			break;
		case "Inversa":
			words=WordDAO.searchType(WordType.reverse);
			wordTable.setItems(FXCollections.observableArrayList(words));
			break;
		case "Trabada":
			words=WordDAO.searchType(WordType.stuck);
			wordTable.setItems(FXCollections.observableArrayList(words));
			break;
		case "Mixta":
			words=WordDAO.searchType(WordType.mixed);
			wordTable.setItems(FXCollections.observableArrayList(words));
			break;
		 default:
             throw new IllegalArgumentException("Tipo de palabra invalida" + type);
		}
		
	}
	@FXML
	private void removeWord() {
		WordDAO s=new WordDAO(Integer.parseInt(id.getText()));
		if(s.removeWord()) {
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
	
	private void configureWord() {
		   wordColum.setCellValueFactory(eachWord->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(eachWord.getValue().getWord());
			   return v;
		   });
		   idColum.setCellValueFactory(eachWord->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   v.setValue(""+eachWord.getValue().getId());
			   
			   return v;
		   });
		   
		   tipeColum.setCellValueFactory(eachWord->{
			   SimpleStringProperty v=new SimpleStringProperty();
			   
			   
				switch (eachWord.getValue().getWordType()) {
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
					throw new IllegalArgumentException("Unexpected value: " + eachWord.getValue().getWordType());
				}
			   
			   return v;
		   });
	   }

}
