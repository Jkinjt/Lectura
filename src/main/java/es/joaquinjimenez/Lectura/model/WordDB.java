package es.joaquinjimenez.Lectura.model;

public abstract class WordDB {

	protected int id;
	protected String word;	
	protected WordType wordType;
	
	public WordDB() {
		this.id=-1;
		this.word="";
		this.wordType=WordType.direct;
	}
			
	public WordDB(int id, String word, WordType wordType) {
		super();
		this.id = id;
		this.word = word;
		this.wordType = wordType;
	}
	public WordDB(String word, WordType wordType) {
		super();
		this.id =-1;
		this.word = word;
		this.wordType = wordType;
	}

	

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj!=null) {
			if(obj==this) {
				result=true;
			}
			else if(obj instanceof WordDB) {
				WordDB p=(WordDB)obj;
				if(p.getId()==this.id) {
					result=true;
				}
			}
		}
		return result;
	}

	
}
