package dominio.prendas.interiores;
import dominio.prendas.*;

public class Corpi�o extends Prenda {

	public Corpi�o(Integer talla, Estilo estilo, String idealClima, 
				   String esPara, Color color) {
		super(talla, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.genero = "Femenino";
		this.sePoneEn = "IntimasFemeninoSup";
		this.uso = "Interior";
	}

}
