/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.util.Arrays;

/**
 * @author Joaquin
 *
 */
public class Word extends WordDB {

	protected char[] letters;
	protected boolean passed;
	
	
	public Word() {
		super();
		setLetters(word.toCharArray());
		this.passed=false;
		// TODO Auto-generated constructor stub
	}
	public Word(int id, String word, WordType wordType) {
		super(id, word, wordType);
		setLetters(word.toCharArray());
		this.passed=false;
		// TODO Auto-generated constructor stub
	}
	public Word( String word, WordType wordType) {
		super(word, wordType);
		setLetters(word.toCharArray());
		this.passed=false;
		// TODO Auto-generated constructor stub
	}
	
	public void setWord(String word) {
		this.word = word;
		setLetters(word.toCharArray());
	}
	public char[] getLetters() {
		return letters;
	}
	public void setLetters(char[] letters) {
		this.letters = letters;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	@Override
	public String toString() {
		return "Word [, id=" + id + ", word=" + word
				+ ", wordType=" + wordType + "letters=" + Arrays.toString(letters) + ", passed=" + passed + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
