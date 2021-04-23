/**
 * 
 */
package es.joaquinjimenez.Lectura.launch;

import java.util.ArrayList;
import java.util.List;

import es.joaquinjimenez.Lectura.conexion.ServerConnection;
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

		ServerConnection sc=new ServerConnection();
		
		/*sc.setServer("jbdc:mysql://localhost");
		sc.setDatabase("Prueba");
		sc.setUsername("root");
		sc.setPassword("1234");
		*/
		
		
		sc=WrapperForXML.loadFile();
		System.out.println(sc.toString());
		
		
		
		
	}

}
