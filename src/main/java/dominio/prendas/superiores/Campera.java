package dominio.prendas.superiores;
import dominio.prendas.*;

public class Campera extends Prenda {

	public Campera(Integer talla, String genero, Estilo estilo,
				   String esPara, Color color) {
		super(talla, genero, estilo, esPara, color);
		// TODO Auto-generated constructor stub
		this.idealClima = "Templado";
		this.uso = "Exterior";
		this.sePoneEn = "Torso";
	}

}