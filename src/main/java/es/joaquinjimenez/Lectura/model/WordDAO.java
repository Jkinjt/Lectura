/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import es.joaquinjimenez.Lectura.conexion.ConnectionMysql;
import es.joaquinjimenez.Lectura.utils.WrapperForXML;

/**
 * @author Joaquin
 *
 */
public class WordDAO extends Word implements iWordDAO {

	private final static String SELECT = "SELECT `Id`, `nombre`, `tipo` FROM `palabra` WHERE Id=";
	private static final String PASSWORDS = "select s.Id_Alumno, s.Id_Palabra, s.superado, p.nombre, p.tipo"
			+ " from supera s, palabra p where s.Id_palabra=p.Id and Id_Alumno=";
	private static final String INSERTUPDATE = "INSERT INTO `palabra` (`Id`, `nombre`, `tipo`) VALUES (?, ?, ?)";
	private static final String DELETE = "DELETE FROM `palabra` WHERE Id=";

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
						q.setInt(1, (Integer) null);
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
						q.setInt(1, (Integer) null);
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

	@Override
	public boolean removeWord() {
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

	public boolean removeWord(Word w) {
		boolean result = false;
		if (w != null && w.getId() > 0) {
			Connection con = ConnectionMysql.getConnection(WrapperForXML.loadFile());

			if (con != null) {
				Statement st;
				try {
					st = con.createStatement();
					String q = DELETE + w.getId();
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
	public List<Word> searchType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Word> searchForStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
