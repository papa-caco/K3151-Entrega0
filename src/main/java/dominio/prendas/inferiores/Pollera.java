package dominio.prendas.inferiores;
import dominio.prendas.*;

public class Pollera extends Prenda {

	public Pollera(Integer talla, Estilo estilo, String idealClima,
				   String esPara, Color color) {
		super(talla, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.genero = "Femenino";
		this.uso = "Exterior";
		this.sePoneEn = "Piernas";
	}
	

}
