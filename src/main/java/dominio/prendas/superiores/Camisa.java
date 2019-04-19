package dominio.prendas.superiores;
import dominio.prendas.*;

public class Camisa extends Prenda {

	public Camisa(Integer talla, String genero, Estilo estilo,
				  String idealClima, String esPara, Color color) {
		super(talla, genero, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.uso = "Exterior";
		this.sePoneEn = "Torso";
	}

}
