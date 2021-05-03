package es.joaquinjimenez.Lectura.test;

import static org.junit.jupiter.api.Assertions.*;

import es.joaquinjimenez.Lectura.model.StudentDAO;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		StudentDAO s=new StudentDAO("Rosa");
		System.out.println(s.toString());
	}

}
