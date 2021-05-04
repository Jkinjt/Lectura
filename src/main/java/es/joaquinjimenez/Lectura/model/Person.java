package es.joaquinjimenez.Lectura.model;

import java.util.Date;
import java.time.LocalDate;
import java.util.*;

public abstract class Person {

	protected int id;
	protected String name;
	protected String surname;
	protected LocalDate date;
	
	
	
	public Person(int id, String name, String surname, LocalDate date) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.date = date;
	}
	
	public Person() {
		this(-1,"","", LocalDate.now());
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", date=" + date + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj!=null) {
			if(obj==this) {
				result=true;
			}
			else if(obj instanceof Person) {
				Person p=(Person)obj;
				if(p.getId()==this.id) {
					result=true;
				}
			}
		}
		return result;
	}
	
	
}
