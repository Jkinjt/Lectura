/**
 * 
 */
package es.joaquinjimenez.Lectura.conexion;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Joaquin
 *
 */
public class ConnectionMysql {
	
	private static ConnectionMysql con;
	
	
		public static ConnectionMysql getConnection(ServerConnection sc) {
			if(con==null) {
				conecta(sc);
			}
			return con;
		}
	public static void conecta(ServerConnection sc) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			con=(ConnectionMysql) DriverManager.getConnection(sc.getServer()+"/"+sc.getDatabase(),  sc.getUsername(), sc.getPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			con=null;
			e.printStackTrace();
		}
		
	}
	
	

}
