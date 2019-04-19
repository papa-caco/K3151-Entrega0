package dominio.prendas.superiores;
import dominio.prendas.*;

public class Sweater extends Prenda {

	public Sweater(Integer talla, String genero, Estilo estilo,
				   String esPara, Color color) {
		super(talla, genero, estilo, esPara, color);
		// TODO Auto-generated constructor stub
		this.idealClima = "Frio";
		this.uso = "Exterior";
		this.sePoneEn = "Torso";
	}

}
