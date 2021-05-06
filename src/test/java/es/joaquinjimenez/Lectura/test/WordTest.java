package es.joaquinjimenez.Lectura.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.joaquinjimenez.Lectura.model.Word;
import es.joaquinjimenez.Lectura.model.WordDAO;
import es.joaquinjimenez.Lectura.model.WordDB;
import es.joaquinjimenez.Lectura.model.WordType;

class WordTest {

	@Test
	public void constructorTest() {
		WordDAO w=new WordDAO(1,"casa",WordType.direct);
		System.out.println(w.toString());
		assertEquals(w,new WordDAO(1));
		
	}
	
	@Test
	public void saveTest() {
		WordDAO w=new WordDAO(3,"aveja", WordType.direct);
		w.saveWord();
		System.out.println(w.toString());
		assertEquals(w,new WordDAO(3));
		w.setWord("abeja");
		w.saveWord();
		System.out.println(w.toString());
		
		assertEquals(w,new WordDAO(3));
		
		
	}
	@Test
	public void removeTest() {
		WordDAO w=new WordDAO(3,"abeja", WordType.direct);
		assertEquals(w, new WordDAO(3));
		w.removeWord();
		assertNotEquals(w, new WordDAO(3));
		
	}
	@Test
	public void searchTypeTest() {
		WordDAO w1=new WordDAO(1);
		WordDAO w2=new WordDAO(2);
		WordDAO w3=new WordDAO(5);
		List<Word> lw=new ArrayList<Word>();
		lw.add(w1); lw.add(w2);lw.add(w3);
		List<Word> lt=w1.searchType(WordType.direct);
		assertEquals(lw, lt);
		System.out.println(lt.toString());
	}@Test
	public void searchForStudentTest() {
		WordDAO w2=new WordDAO(2);
		List<Word> lw=new ArrayList<Word>();
		lw.add(w2);
		List<Word> lr=WordDAO.searchForStudent(1);
		assertEquals(lw, lr);
		System.out.println(lr.toString());
	}
	
	
}
