package es.joaquinjimenez.Lectura.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;
import es.joaquinjimenez.Lectura.model.WordDAO;

class StudentTest {

	
	
	
	@org.junit.jupiter.api.Test
	//comprueba que el usuario se ha introducido
	void testConstructor() {		
		Student s1=new Student(1,"Juan","Ramirez",LocalDate.of(2018, 01, 02),null);
		assertEquals(s1, new StudentDAO(1));
		
	}
	
	@Test
	void testSaveStudent() {
		StudentDAO sT=new StudentDAO(12,"Leonor","de Aquitania", LocalDate.now(),"Le gusta el frances");
		assertTrue(sT.saveStudent());
		System.out.println(sT.toString());
		sT.setObservations("Le gusta el ingles");
		assertTrue(sT.saveStudent());
		StudentDAO s =new StudentDAO(3,"Fernan","Gonzalez",LocalDate.of(2020, 03, 15),null);
		WordDAO w=new WordDAO(4);
		assertTrue(s.addWord(w));
		assertTrue(s.saveStudent());
	}
	
	
	@Test
	void testRemoveStudent() {
		StudentDAO s=new StudentDAO(3);
		assertTrue(s.removeStudent());
	}
	@Test
	void testSearchStudent() {
		StudentDAO s1=new StudentDAO(6);
		StudentDAO s2=new StudentDAO(11);
		List<Student> ls=new ArrayList<Student>();
		ls.add(s1);ls.add(s2);
		assertEquals(ls, StudentDAO.searchStudent("Antonio"));
	}
	
	
}
