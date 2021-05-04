/**
 * 
 */
package es.joaquinjimenez.Lectura.launch;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.joaquinjimenez.Lectura.conexion.ConnectionMysql;
import es.joaquinjimenez.Lectura.conexion.ServerConnection;
import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;
import es.joaquinjimenez.Lectura.utils.WrapperForXML;

/**
 * @author Joaquin
 *
 */
public class Ejecutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		ServerConnection sc= WrapperForXML.loadFile();
		System.out.println(sc.toString());
		*/
		/*
		StudentDAO sd=new StudentDAO(1);
		System.out.println(sd.toString());
		*/
		List<Student> ls=StudentDAO.searchStudent("Rosa");
		System.out.println(ls.toString());
		
		Student s=new Student("Antonio", "Ramirez",
				LocalDate.of(2015, 5, 15),"Sin escolarizar");
		ls.add(s);
		System.out.println(ls.toString());
		/*
		StudentDAO sDAO=new StudentDAO(s);
		sDAO.saveStudent(s);
		*/
		
	}

}
