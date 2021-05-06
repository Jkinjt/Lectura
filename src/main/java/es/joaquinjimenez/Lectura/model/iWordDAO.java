/**
 * 
 */
package es.joaquinjimenez.Lectura.model;

import java.util.List;

/**
 * @author Joaquin
 *
 */
public interface iWordDAO {

	public boolean saveWord();
	public boolean removeWord();
	public static List<Word> searchType(WordType wt) {
		return null;
	}
	public static List<Word> searchForStudent(int id) {
		return null;
	}
}
