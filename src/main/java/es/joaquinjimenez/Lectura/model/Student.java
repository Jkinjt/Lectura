package es.joaquinjimenez.Lectura.model;

import java.util.*;

public class Student extends Person {

	protected String observations;
	protected List<String> words;
	
	

	public Student(int id, String name, String surname, GregorianCalendar date, String observations) {
		super(id, name, surname, date);
		this.observations = observations;
	}

	public Student(int id, String name, String surname, GregorianCalendar date, String observations,
			List<String> words) {
		super(id, name, surname, date);
		this.observations = observations;
		this.words = words;
	}

	public String getObservations() {
		throw new UnsupportedOperationException();
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

	public Student() {
		throw new UnsupportedOperationException();
	}

	public void setObservations(int observations) {
		throw new UnsupportedOperationException();
	}

	
}
