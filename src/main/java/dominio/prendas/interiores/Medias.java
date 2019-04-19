package dominio.prendas.interiores;
import dominio.prendas.*;

public class Medias extends Prenda {

	public Medias(Integer talla, String genero, Estilo estilo, 
				   String idealClima, String esPara, Color color) {
		super(talla, genero, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.sePoneEn = "Pies";
		this.uso = "Interior";
	}
	
}
