/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import es.joaquinjimenez.Lectura.conexion.ConnectionMysql;
import es.joaquinjimenez.Lectura.conexion.ServerConnection;
import es.joaquinjimenez.Lectura.utils.WrapperForXML;

/**
 * @author Joaquin
 *
 */
public class StudentDAO extends Student implements iStudentDao {

	private final static  String SELECT="select id, nombre, apellidos, observaciones, fechaNacimiento from alumno where name like";
	
	public StudentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDAO(int id, String name, String surname, GregorianCalendar date, String observations,
			List<String> words) {
		super(id, name, surname, date, observations, words);
		// TODO Auto-generated constructor stub
	}

	public StudentDAO(int id, String name, String surname, GregorianCalendar date, String observations) {
		super(id, name, surname, date, observations);
		// TODO Auto-generated constructor stub
	}
	
	public StudentDAO(Student s)
	{this.id=s.getId();
	this.name=s.getName();
	this.surname=s.getSurname();
	this.date=s.getDate();
	this.observations=s.getObservations();
	this.words=s.getWords();
		
	}
	
	public StudentDAO(String name) {
		Connection con=ConnectionMysql.getConnection(WrapperForXML.loadFile());
		if(con!=null) {
			Statement st;
			try {
				st = con.createStatement();
				String q=SELECT+"'"+name+"'";
				ResultSet rs =st.executeQuery(q);
				while(rs.next()) {
					this.id=rs.getInt("Id");
					this.name=rs.getString("nombre");
					Date date=rs.getDate("edad");
					this.date.setTime(date);
				}	this.observations=rs.getString("observaciones");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	@Override
	public boolean saveStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWord() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean studentResult() {
		// TODO Auto-generated method stub
		return false;
	}

}
