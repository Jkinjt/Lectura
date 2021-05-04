package es.joaquinjimenez.Lectura.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;

class StudentTest {

	@org.junit.jupiter.api.Test
	//comprueba que el usuario se ha introducido
	void testConstructor() {		
		
		StudentDAO s=new StudentDAO("Rosa");
		System.out.println(s.toString());
	}
	
	@Test
	void testSaveStudent() {
		Student s=new Student("Antonio", "Ramirez",
				LocalDate.of(2015, 5, 15),"Sin escolarizar");
		StudentDAO sDAO=new StudentDAO(s);
		sDAO.saveStudent();
		//assertEquals(s, new StudentDAO("Antonio"));
	}

}
