package dominio.prendas.superiores;
import dominio.prendas.*;

public class Tapado extends Prenda {

	public Tapado(Integer talla, Estilo estilo, 
				     String esPara, Color color) {
		super(talla, estilo, esPara, color);
		// TODO Auto-generated constructor stub
		this.genero = "Femenino";
		this.idealClima = "Frio";
		this.uso = "Exterior";
		this.sePoneEn = "Torso";
	}

}