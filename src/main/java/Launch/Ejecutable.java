/**
 * 
 */
package Launch;

import java.util.ArrayList;
import java.util.List;

import es.joaquinjimenez.utils.ServerConnection;
import es.joaquinjimenez.utils.WrapperForXML;

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
		sc.setServer("jbdc:mysql://localhost");
		sc.setDatabase("Prueba");
		sc.setUsername("root");
		sc.setPassword("1234");
		
		List<ServerConnection> servers=new ArrayList<ServerConnection>();
		servers.add(sc);
		WrapperForXML.guardaXML(new WrapperForXML(servers));
		System.out.println("guardado");
		
		
		
		
	}

}
