package dominio.prendas.interiores;
import dominio.prendas.*;

public class Calzoncillo extends Prenda {

	public Calzoncillo(Integer talla, Estilo estilo, String idealClima, 
						String esPara, Color color) {
		super(talla, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.genero = "Masculino";
		this.sePoneEn = "IntimasMasculino";
		this.uso = "Interior";
	}

}
