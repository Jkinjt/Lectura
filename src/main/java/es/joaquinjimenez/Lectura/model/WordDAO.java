/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import es.joaquinjimenez.Lectura.conexion.ConnectionMysql;
import es.joaquinjimenez.Lectura.utils.WrapperForXML;

/**
 * @author Joaquin
 *
 */
public class WordDAO extends Word implements iWordDAO {

	private final static String SELECT = "SELECT `Id`, `nombre`, `tipo` FROM `palabra` WHERE Id=";
	private final static String SELECTTYPE = "SELECT `Id`, `nombre`, `tipo` FROM `palabra` WHERE tipo=";
	private static final String PASSWORDS = "select s.Id_Alumno, s.Id_Palabra, s.superado, p.nombre, p.tipo"
			+ " from supera s, palabra p where s.Id_palabra=p.Id and Id_Alumno=";
	private static final String INSERTUPDATE = "INSERT INTO `palabra` (`Id`, `nombre`, `tipo`) VALUES (?, ?, ?)"
			+ "ON DUPLICATE KEY UPDATE nombre=?,tipo=?";
	private static final String DELETE = "DELETE FROM `palabra` WHERE Id=";
	private static final String DELETERELATIONSHIP="DELETE FROM supera WHERE Id_Palabra=";
	/**
	 * 
	 */
	public WordDAO() {
		// TODO Auto-generated constructor stub
	}
	

	public WordDAO(int id, String word, WordType wordType) {
		super(id, word, wordType);
		// TODO Auto-generated constructor stub
	}


	public WordDAO(String word, WordType wordType) {
		super(word, wordType);
		// TODO Auto-generated constructor stub
	}
	
	public WordDAO(Word w) {
		super(w.id, w.word, w.wordType);
	}

	/*
	 * crea la palabra con la informacion de la base de datos
	 * @param id de la palabra en la base de datos
	 * 
	 */
	public WordDAO(int id) {
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
						this.word = rs.getString("nombre");
						int type = rs.getInt("tipo");
						this.letters = word.toCharArray();
						switch (type) {
						case 1: {
							this.wordType = wordType.direct;
							break;
						}
						case 2: {
							this.wordType = wordType.reverse;
							break;
						}
						case 3: {
							this.wordType = wordType.stuck;
							break;
						}
						case 4: {
							this.wordType = wordType.mixed;
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + type);
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
	 * guarda la palabra en la base de datos
	 */
	@Override
	public boolean saveWord() {
		boolean result = false;
		if (this != null) {
			int rs = 0;
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				try {
					PreparedStatement q = con.prepareStatement(INSERTUPDATE);
					if (this.id < 0) {
						q.setNull(1, Types.NULL);
					} else {
						q.setInt(1, this.id);
					}

					q.setString(2, this.word);
					int type;
					switch (this.wordType) {
					case direct: {
						type=1;
						break;
					}
					case reverse: {
						type=2;
						break;
					}
					case stuck: {
						type=3;
						break;
					}
					case  mixed: {
						type=4;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.wordType);
					}
					q.setInt(3, type);
					q.setString(4, this.word);
					q.setInt(5, type);
					rs = q.executeUpdate();
					result = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	public boolean saveWord(Word w) {
		boolean result = false;
		if (w != null) {
			int rs = 0;
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				try {
					PreparedStatement q = con.prepareStatement(INSERTUPDATE);
					if (w.id < 0) {
						q.setNull(1, Types.NULL);
					} else {
						q.setInt(1, w.id);
					}

					q.setString(2, w.word);
					int type;
					switch (w.wordType) {
					case direct: {
						type=1;
						break;
					}
					case reverse: {
						type=2;
						break;
					}
					case stuck: {
						type=3;
						break;
					}
					case  mixed: {
						type=4;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + this.wordType);
					}
					q.setInt(3, type);
					q.setString(4, w.word);
					q.setInt(5, type);
					rs = q.executeUpdate();
					result = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/*
	 * Borra la palabra de la base de datos
	 */
	@Override
	public boolean removeWord() {
		boolean result = false;
		if (this != null && this.id > 0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					//primero borra las tuplas que de la tabla de enmedio tenga
					String q = DELETERELATIONSHIP + this.id;
					st.executeUpdate(q);
					q = DELETE + this.id;
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

	public boolean removeWord(Word w) {
		boolean result = false;
		if (w != null && w.getId() > 0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				Statement st;
				try {
					
					st = con.createStatement();
					String q = DELETERELATIONSHIP + w.getId();
					st.executeUpdate(q);
					q = DELETE + w.getId();
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

	/*
	 * devuelve las palabras de un tipo
	 * @param tipo de palabra que se quiera buscar
	 */
	public static List<Word> searchType(WordType wt) {
		List<Word> result=new ArrayList<Word>();
		if(wt!=null) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());
			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					int type;
					switch (wt) {
					case direct: {
						type=1;
						break;
					}
					case reverse: {
						type=2;
						break;
					}
					case stuck: {
						type=3;
						break;
					}
					case  mixed: {
						type=4;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + wt);
					}
					String q = SELECTTYPE +"'"+type+"'";
					ResultSet rs = st.executeQuery(q);
					
					while (rs.next()) {
						Word w=new Word();
						w.setId(rs.getInt("Id"));
						w.setWord(rs.getString("nombre"));
						w.setWordType(wt);
						result.add(w);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/*
	 * @param id del alumno del alumno
	 * @return lista de las palabras hechas por el alumno
	 */
	public static List<Word> searchForStudent(int id) {
		List<Word> result = new ArrayList<Word>();
		if (id>0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());
			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					String q = PASSWORDS +"'"+id+"'";
					ResultSet rs = st.executeQuery(q);
					
					while (rs.next()) {
						Word w=new Word();
						w.setId(rs.getInt("s.Id_palabra"));
						boolean pass;
						if(rs.getInt("s.superado")==1) {
							w.setPassed(true);	
						}else {
							w.setPassed(false);
						}
						
						w.setWord(rs.getString("p.nombre"));
						int type = rs.getInt("p.tipo");
						switch (type) {
						case 1: {
							w.setWordType(WordType.direct);
							break;
						}
						case 2: {
							w.setWordType(WordType.reverse);
							break;
						}
						case 3: {
							w.setWordType(WordType.stuck);
							break;
						}
						case 4: {
							w.setWordType(WordType.mixed);
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + type);
						}
						result.add(w);
						
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
