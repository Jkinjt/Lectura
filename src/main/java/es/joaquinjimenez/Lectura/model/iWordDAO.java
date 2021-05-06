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
	public List<Word> searchType();
	public List<Word> searchForStudent(int id);
}
