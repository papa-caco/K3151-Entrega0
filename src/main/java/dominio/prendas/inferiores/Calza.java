package dominio.prendas.inferiores;
import dominio.prendas.*;

public class Calza extends Prenda {

	public Calza(Integer talla, String genero,
				 String idealClima, String esPara, Color color) {
		super(talla, genero, idealClima, esPara, color);
		// TODO Auto-generated constructor stub
		this.estilo = new Estilo("Deportivo");
		this.sePoneEn = "Piernas";
		this.uso = "Interior";
	}

}