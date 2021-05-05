package es.joaquinjimenez.Lectura.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import es.joaquinjimenez.Lectura.model.Student;
import es.joaquinjimenez.Lectura.model.StudentDAO;

class StudentTest {

	
	
	
	@org.junit.jupiter.api.Test
	//comprueba que el usuario se ha introducido
	void testConstructor() {		
		Student s1=new Student(1,"Juan","Ramirez",LocalDate.of(2018, 01, 02),null);
		assertEquals(s1, new StudentDAO(1));
		
	}
	
	@Test
	void testSaveStudent() {
		StudentDAO s =new StudentDAO(3,"Fernan","Gonzalez",LocalDate.of(2020, 03, 15),null);
		/*
		 * Student sT=new Student("Leonor","de Aquitania",LocalDate.now(),null);
		 
		StudentDAO s1=new StudentDAO(sT);
		*/ 
		assertTrue(s.saveStudent());
	}
	
	
	@Test
	void testRemoveStudent() {
		StudentDAO s=new StudentDAO(3);
		assertTrue(s.removeStudent());
		
	}
	
	
}
