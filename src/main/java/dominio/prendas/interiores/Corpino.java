package dominio.prendas.interiores;
import dominio.prendas.*;

public class Corpino extends Prenda {

	public Corpino(Integer talla, Estilo estilo, String idealClima, 
				   String esPara, Color color) {
		super(talla, estilo, idealClima, esPara, color);
		this.genero = "Femenino";
		this.sePoneEn = "IntimasFemeninoSup";
		this.uso = "Interior";
	}

}
