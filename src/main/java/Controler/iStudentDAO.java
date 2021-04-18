package Controler;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Word;
import Model.WordType;

public interface iStudentDAO  {

	public List<Student> studients=new ArrayList<Student>();

	public List<Student> getStudents();

	/*
	 * @return añade una lista de estudiantes
	 */
	public void setStudent(List<Student> Studient);

	/*
	 * @param estudiante que se quiere añadir a la lista
	 * @return 
	 */
	public boolean addStudent(Student student);

	/*
	 * @param nombre del estudiante a borrar
	 */
	public boolean removeStudent(String name);
	
	/*
	 * @param nombre del estudiante a buscar
	 */
	public Student searchStudent(String name);
	
	/*
	 * @param nombre del estudiante del que se quieran ver los resultados
	 * @return porcentaje de aciertos
	 */
	public double studientResult(String name);
	
	/*
	 * @param nombre del estudiante y tipo de palabra del que se quieran ver los resultados
	 * @return porcentaje de aciertos
	 */
	public double studientResult(String name, WordType wordType);

	/*
	 * @param estudiante que se quiera actualizar
	 */
	public boolean updateStudient(Student student);

	/*
	 * @param palabra que se quiera añadir a la lista
	 */
	public boolean addWord(Word word);
}
