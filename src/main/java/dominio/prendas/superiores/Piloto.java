package dominio.prendas.superiores;
import dominio.prendas.*;

public class Piloto extends Prenda {

	public Piloto(Integer talla, String genero, Estilo estilo,
				   String esPara, Color color) {
		super(talla, genero, estilo, esPara, color);
		// TODO Auto-generated constructor stub
		this.idealClima = "Lluvioso";
		this.uso = "Exterior";
		this.sePoneEn = "Torso";
	}

}
