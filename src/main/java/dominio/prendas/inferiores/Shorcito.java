package dominio.prendas.inferiores;
import dominio.prendas.*;

public class Shorcito extends Prenda {

	public Shorcito(Integer talla, String genero,
				 String esPara, Color color) {
		super(talla, genero, esPara, color);
		// TODO Auto-generated constructor stub
		this.idealClima = "Calido";
		this.estilo = new Estilo("Deportivo");
		this.uso = "Exterior";
		this.sePoneEn = "Piernas";
	}

}
