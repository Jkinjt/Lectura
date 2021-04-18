package Controler;

import java.util.ArrayList;
import java.util.List;

import Model.Student;

public interface iStudentDAO  {

	public List<Student> studients=new ArrayList<Student>();

	public List<Student> getStudents();

	public void setStudent(List<Student> Studient);

	public boolean addStudent();

	public boolean removeStudent();

	public Student searchStudent();

	public void studientResult();

	public boolean updateStudient();

	public boolean addWord();
}
