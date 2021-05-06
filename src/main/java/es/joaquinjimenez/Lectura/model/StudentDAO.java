/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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

	private final static String SELECT = "select id, nombre, apellidos, observaciones, fechaNacimiento from alumno where id=";
	private final static String SELECTBYNAME = "select id, nombre, apellidos, observaciones, fechaNacimiento from alumno where nombre like ";
	private static final String DELETE = "DELETE FROM alumno WHERE id=";
	private static final String INSERTUPDATE = "INSERT INTO `alumno` "
			+ "(`Id`, `nombre`, `apellidos`, `observaciones`, `fechaNacimiento`) " + "VALUES (?, ?, ?, ?, ?)"
			+ "ON DUPLICATE KEY UPDATE nombre=?,apellidos=?, observaciones=?, fechaNacimiento=?";

	public StudentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDAO(int id, String name, String surname, LocalDate date, String observations, List<Word> words) {
		super(id, name, surname, date, observations, words);
		// TODO Auto-generated constructor stub
	}
	

	public StudentDAO(int id, String name, String surname, LocalDate date, String observations) {
		super(id, name, surname, date, observations);
		// TODO Auto-generated constructor stub
	}

	public StudentDAO(Student s) {
		this.id = s.getId();
		this.name = s.getName();
		this.surname = s.getSurname();
		this.date = s.getDate();
		this.observations = s.getObservations();
		this.words = s.getWords();

	}

	// busca el estudiante en la base de datos por el id
	public StudentDAO(int id) {
		if (id > 0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());
			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					String q = SELECT + id;
					ResultSet rs = st.executeQuery(q);
					while (rs.next()) {
						this.id = rs.getInt("Id");
						this.name = rs.getString("nombre");
						this.surname = rs.getString("apellidos");
						java.sql.Date date = rs.getDate("fechaNacimiento");
						this.date = date.toLocalDate();
						if (rs.getString("observaciones") != null) {
							this.observations = "";

						} else {

							this.observations = rs.getString("observaciones");
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	

	/*
	 * @param estudiante a borrar
	 * 
	 * @return boleano que devuelve verdadero si se ha añadido correctamente
	 */
	@Override
	public boolean removeStudent(Student s) {
		boolean result = false;
		if (s != null && s.getId() > 0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					String q = DELETE + s.getId();
					st.executeUpdate(q);
					result = true;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}

	// borra el estudiante actual
	public boolean removeStudent() {
		boolean result = false;
		if (this != null && this.id > 0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					String q = DELETE + this.id;
					st.executeUpdate(q);
					result = true;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}

	@Override
	public boolean saveStudent(Student s) {
		boolean result = false;
		if (s != null) {
			int rs = 0;
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());
			if (con != null) {
				try {
					PreparedStatement q = con.prepareStatement(INSERTUPDATE);
					if (this.id >0) {
						q.setInt(1, (Integer) null);
					} else {
						q.setInt(1, s.id);
					}

					q.setString(2, s.name);
					q.setString(3, s.surname);
					q.setString(4, s.observations);
					q.setDate(5, java.sql.Date.valueOf(s.date));
					q.setString(6, s.name);
					q.setString(7, s.surname);
					q.setString(8, s.observations);
					q.setDate(9, java.sql.Date.valueOf(s.date));
					rs = q.executeUpdate();
					result=true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public boolean saveStudent() {
		boolean result = false;
		if (this != null) {
			int rs = 0;
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				try {
					PreparedStatement q = con.prepareStatement(INSERTUPDATE);
					if (this.id <0) {
						q.setInt(1, (Integer) null);
					} else {
						q.setInt(1, this.id);
					}

					q.setString(2, this.name);
					q.setString(3, this.surname);
					q.setString(4, this.observations);
					q.setDate(5, java.sql.Date.valueOf(this.date));
					q.setString(6, this.name);
					q.setString(7, this.surname);
					q.setString(8, this.observations);
					q.setDate(9, java.sql.Date.valueOf(this.date));
					rs = q.executeUpdate();
					result=true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public boolean studentResult() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWord(Word w) {
		boolean result=false;
			if(w!=null) {
				this.words.add(w);
				result=true;
			}
		return result;
	}

	@Override
	public Student searchStudent(int id) {
		Student result=new Student();
		if(id>0) {
			result=new StudentDAO(id);
			
		}
		return result;
	}

	
	public static List<Student> searchStudent(String name) {
		List<Student> result = new ArrayList<Student>();
		if (name!=null) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());
			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					String q = SELECTBYNAME +"'"+name+"'";
					ResultSet rs = st.executeQuery(q);
					
					while (rs.next()) {
						Student s=new Student();
						s.setId(rs.getInt("Id"));
						s.setName(rs.getString("nombre"));
						s.setSurname(rs.getString("apellidos"));
						java.sql.Date date = rs.getDate("fechaNacimiento");
						s.setDate(date.toLocalDate());
						
						if (rs.getString("observaciones") != null) {
							s.setObservations("");

						} else {

							s.setObservations(rs.getString("observaciones"));
						}
						result.add(s);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return result;
	}

}
