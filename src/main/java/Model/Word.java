/**
 * 
 */
package Model;

/**
 * @author Joaquin
 *
 */
public class Word extends WordDB {

	private char[] letters;
	private boolean passed;
	String imagen;
	
	public char[] getLetters() {
		return letters;
	}
	public void setLetters(char[] letters) {
		this.letters = letters;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
}
