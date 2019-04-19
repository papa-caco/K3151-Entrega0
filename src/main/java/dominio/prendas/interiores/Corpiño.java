package dominio.prendas.interiores;
import dominio.prendas.*;

public class Corpiño extends Prenda {

	public Corpiño(Integer talla, Estilo estilo, String idealClima, 
				   String esPara, Color color) {
		super(talla, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.genero = "Femenino";
		this.sePoneEn = "IntimasFemeninoSup";
		this.uso = "Interior";
	}

}
