package Model;

public class Word {

	private String word;
	private char[] letters;
	private boolean passed;
	private WordType wordType;
	private int id;

	

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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

	public WordType getWordType() {
		return wordType;
	}

	public void setWordType(WordType wordType) {
		this.wordType = wordType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
