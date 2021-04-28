/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Joaquin
 *
 */
public class StudentDAO extends Student implements iStudentDao {

	
	
	public StudentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDAO(int id, String name, String surname, GregorianCalendar date, String observations,
			List<String> words) {
		super(id, name, surname, date, observations, words);
		// TODO Auto-generated constructor stub
	}

	public StudentDAO(int id, String name, String surname, GregorianCalendar date, String observations) {
		super(id, name, surname, date, observations);
		// TODO Auto-generated constructor stub
	}
	
	public StudentDAO(Student s)
	{this.id=s.getId();
	this.name=s.getName();
	this.surname=s.getSurname();
	this.date=s.getDate();
	this.observations=s.getObservations();
	this.words=s.getWords();
		
	}
	@Override
	public boolean saveStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWord() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean studentResult() {
		// TODO Auto-generated method stub
		return false;
	}

}
