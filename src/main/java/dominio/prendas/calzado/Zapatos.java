package dominio.prendas.calzado;
import dominio.prendas.*;
 
public class Zapatos extends Prenda {

	public Zapatos(Integer talla, String genero, Estilo estilo, 
				   String idealClima, String esPara, Color color) {
		super(talla, genero, estilo, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.sePoneEn = "Pies";
		this.uso = "Exterior";
	}

}
