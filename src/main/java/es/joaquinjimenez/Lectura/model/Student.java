package es.joaquinjimenez.Lectura.model;

import java.time.LocalDate;
import java.util.*;

public class Student extends Person {

	protected String observations;
	protected List<Word> words;
	
	public Student() {
		this(-1,"","",LocalDate.now(),"");
	}
	public Student( String name, String surname, LocalDate date, String observations) {
		super(0, name, surname, date);
		this.observations = observations;
		this.words=new ArrayList<Word>();
	}
	public Student(int id, String name, String surname, LocalDate date, String observations) {
		super(id, name, surname, date);
		this.observations = observations;
		this.words=new ArrayList<Word>();
	}

	public Student(int id, String name, String surname, LocalDate date, String observations,
			List<Word> words) {
		super(id, name, surname, date);
		this.observations = observations;
		this.words = words;
	}

	public String getObservations() {
		return this.observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	

	public void setObservations(int observations) {
		throw new UnsupportedOperationException();
	}
	
	

	
}
