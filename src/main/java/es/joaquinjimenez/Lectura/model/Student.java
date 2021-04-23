package es.joaquinjimenez.Lectura.model;

import java.util.List;
import java.util.*;

public class Student extends Person {

	private String observations;
	private List<String> words;

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
