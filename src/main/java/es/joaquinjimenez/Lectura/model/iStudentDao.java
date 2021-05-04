/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.util.List;

/**
 * @author Joaquin
 *
 */
public interface iStudentDao {
	
	public boolean saveStudent(Student s);
	public boolean removeStudent(Student s);
	public boolean addWord(Word w);
	public Student searchStudent(int id);
	public static List<Student> searchStudent(String name) {
		return null;
	}
	public boolean studentResult();
	

}
