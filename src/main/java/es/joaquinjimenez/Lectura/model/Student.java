package es.joaquinjimenez.Lectura.model;

import java.time.LocalDate;
import java.util.*;

public class Student extends Person {

	protected String observations;
	protected List<String> words;
	
	public Student() {
		this(-1,"","",LocalDate.now(),"");
	}
	public Student( String name, String surname, LocalDate date, String observations) {
		super(0, name, surname, date);
		this.observations = observations;
	}
	public Student(int id, String name, String surname, LocalDate date, String observations) {
		super(id, name, surname, date);
		this.observations = observations;
	}

	public Student(int id, String name, String surname, LocalDate date, String observations,
			List<String> words) {
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

	

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	

	public void setObservations(int observations) {
		throw new UnsupportedOperationException();
	}
	
	

	
}
