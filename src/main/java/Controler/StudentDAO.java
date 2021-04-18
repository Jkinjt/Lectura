/**
 * 
 */
package Controler;

import java.util.List;

import Model.Word;
import Model.WordType;

/**
 * @author Joaquin
 *
 */
public class StudentDAO implements iStudentDAO {

	@Override
	public List<Model.Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStudent(List<Model.Student> Studient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Model.Student searchStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean updateStudient() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWord() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Word> studientResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Word> studientResult(WordType wordType) {
		// TODO Auto-generated method stub
		return null;
	}

}
