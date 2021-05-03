/**
 * 
 */
package es.joaquinjimenez.Lectura.launch;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import es.joaquinjimenez.Lectura.conexion.ConnectionMysql;
import es.joaquinjimenez.Lectura.conexion.ServerConnection;
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
		StudentDAO sd=new StudentDAO("Rosa");
		System.out.println(sd.toString());
		
		
		
	}

}
