package dominio.prendas.inferiores;
import dominio.prendas.*;

public class Pantalon extends Prenda {

	public Pantalon(Integer talla, String genero, Estilo estilo, 
					String idealClima, String esPara, Color color) {
		super(talla, genero, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.uso = "Exterior";
		this.sePoneEn = "Piernas";
	}
	
}
