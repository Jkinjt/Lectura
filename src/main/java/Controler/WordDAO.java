/**
 * 
 */
package Controler;

import java.util.List;

import Model.Word;
import Model.WordType;

/**
 * @author Joaquin
 *
 */
public class WordDAO implements iWordDAO {

	@Override
	public List<Word> getWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWords(List<Word> words) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addWord(Word word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Word searchWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean upddateWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WordType wordType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchWorByType(WordType wordType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchWordByChar(char character) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchWordByChar(char character1, char character2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchWordByChar(char character1, char character2, char character3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchWordbyTypeAndChar(char character, WordType type) {
		// TODO Auto-generated method stub
		
	}

}
