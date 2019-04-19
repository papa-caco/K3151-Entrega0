package dominio.prendas.inferiores;
import dominio.prendas.*;

public class Bermuda extends Prenda {

	public Bermuda(Integer talla, String genero, Estilo estilo, String esPara, Color color) {
		super(talla, genero, estilo, esPara, color);
		this.idealClima = "Calido";
		this.uso = "Exterior";
		this.sePoneEn = "Piernas";
	}

}
