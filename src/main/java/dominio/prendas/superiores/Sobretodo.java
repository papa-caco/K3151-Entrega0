package dominio.prendas.superiores;
import dominio.prendas.*;

public class Sobretodo extends Prenda {

	public Sobretodo(Integer talla, Estilo estilo, 
				     String esPara, Color color) {
		super(talla, estilo, esPara, color);
		// TODO Auto-generated constructor stub
		this.genero = "Masculino";
		this.idealClima = "Frio";
		this.uso = "Exterior";
		this.sePoneEn = "Torso";
	}

}