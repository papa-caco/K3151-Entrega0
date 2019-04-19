package dominio.prendas.calzado;
import dominio.prendas.*;

public class Zapatillas extends Prenda {

	public Zapatillas(Integer talla, String genero, 
				   	  String idealClima, String esPara, Color color) {
		super(talla, genero, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.estilo = new Estilo("Deportivo");
		this.sePoneEn = "Pies";
		this.uso = "Exterior";
	}
}
