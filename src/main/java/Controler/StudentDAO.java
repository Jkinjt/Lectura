/**
 * 
 */
package Controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Word;
import Model.WordType;

/**
 * @author Joaquin
 *
 */
public class StudentDAO implements iStudentDAO, Serializable {

	List<Student> studens =new ArrayList<>();
	/*
	 * @return lista 
	 */

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStudent(List<Student> Studient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStudent(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student searchStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double studientResult(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double studientResult(String name, WordType wordType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateStudient(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWord(Word word) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
