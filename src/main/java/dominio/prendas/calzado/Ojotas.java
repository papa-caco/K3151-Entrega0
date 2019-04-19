package dominio.prendas.calzado;
import dominio.prendas.*;

public class Ojotas extends Prenda {

	public Ojotas(Integer talla, String genero, 
				  String esPara, Color color) {
		super(talla, genero, esPara, color);
		// TODO Auto-generated constructor stub
		this.idealClima = "Calido";
		this.estilo = new Estilo("Deportivo");
		this.sePoneEn = "Pies";
		this.uso = "Exterior";
	}

}
