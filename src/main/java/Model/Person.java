package Model;

import java.util.Date;
import java.util.*;

public abstract class Person {

	protected String name;
	protected Date date;
	private int id;

	protected String surname;

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public void setName(int name) {
		throw new UnsupportedOperationException();
	}

	public Date getDate() {
		throw new UnsupportedOperationException();
	}

	public void setDate(int date) {
		throw new UnsupportedOperationException();
	}

	public Person() {
		throw new UnsupportedOperationException();
	}

	public void getId() {
		throw new UnsupportedOperationException();
	}

	public void setId(int id) {
		this.id = id;
	}
}
