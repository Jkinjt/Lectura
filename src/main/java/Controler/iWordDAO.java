package Controler;

import java.util.ArrayList;
import java.util.List;

import Model.Word;
import Model.WordType;

public interface iWordDAO {

	
	public List<Word> getWords();

	public void setWords(List<Word> words);

	public boolean addWord(Word word);

	public boolean removeWord(String word);

	public Word searchWord(String word);

	public boolean upddateWord(String word);

	public WordType wordType();

	public void searchWorByType(WordType wordType);

	public void searchWordByChar(char character);
	
	public void searchWordByChar(char character1, char character2);
	
	public void searchWordByChar(char character1, char character2, char character3);

	public void searchWordbyTypeAndChar(char character, WordType type);
}
