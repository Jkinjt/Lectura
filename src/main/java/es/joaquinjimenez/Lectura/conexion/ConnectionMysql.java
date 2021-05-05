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
			if(connection==null) {
				conecta(sc);
			}
			return connection;
		}
	public static void conecta(ServerConnection sc) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			connection= DriverManager.getConnection(sc.getServer()+"/"+sc.getDatabase(),  sc.getUsername(), sc.getPassword());
		}/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			connection=null;
			e.printStackTrace();
		}
		if(connection!=null) {
		}
		
		
	}
	
	

}
