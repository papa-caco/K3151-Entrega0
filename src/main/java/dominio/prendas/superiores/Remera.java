package dominio.prendas.superiores;
import dominio.prendas.*;

public class Remera extends Prenda {

	public Remera(Integer talla, String genero, Estilo estilo, 
				  String idealClima, String esPara, Color color) {
		super(talla, genero, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.uso = "Exterior";
		this.sePoneEn = "Torso";		
	}

}
