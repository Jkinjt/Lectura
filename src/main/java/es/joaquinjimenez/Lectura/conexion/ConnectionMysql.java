/**
 * 
 */
package es.joaquinjimenez.Lectura.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.joaquinjimenez.Lectura.utils.WrapperForXML;

/**
 * @author Joaquin
 *
 */
public class ConnectionMysql {
	
	private static ConnectionMysql con;
	private static Connection connection;
	
	
		public static Connection getConnection(ServerConnection sc) {
			System.out.println(sc.toString());
			if(con==null) {
				conecta(sc);
			}
			return connection;
		}
	public static void conecta(ServerConnection sc) {
		try {
			System.out.println("conectando");
			Class.forName("com.mysql.cj.jdbc.Driver");			
			connection= DriverManager.getConnection(sc.getServer()+"/"+sc.getDatabase(),  sc.getUsername(), sc.getPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			con=null;
			e.printStackTrace();
		}
		if(con!=null) {
			System.out.println("esta conectado");	
		}
		
		
	}
	
	

}
