package dominio;
/**
 * 
 */

/**
 * @author Carlos
 *
 */
public class Pajaro {
	private int energia ; // atributo
	// métodos
	public void volar () {
	this . energia = this . energia - 10 ;
	}
	public void comer () {
	this . energia = this . energia + 300 ;
	this . volar () ;
	}
}
