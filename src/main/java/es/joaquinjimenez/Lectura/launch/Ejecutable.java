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
import es.joaquinjimenez.Lectura.model.WordDAO;
import es.joaquinjimenez.Lectura.model.WordType;
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
		
		
		WordDAO w1=new WordDAO(6,"choza",WordType.direct);
		w1.saveWord();
		WordDAO w=new WordDAO(6);
		System.out.println(w.toString());
		w.setWord("chosa");
		w.saveWord();
		w1=new WordDAO(6);
		System.out.println(w1.toString());
		w1.removeWord();
		
		
		
		
		
	}
	

}
