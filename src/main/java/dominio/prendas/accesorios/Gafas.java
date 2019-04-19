package dominio.prendas.accesorios;
import dominio.prendas.*;

public class Gafas extends Prenda {

	public Gafas(int talla, String genero, 
			 String esPara, Color color) {
		super(talla, genero, esPara,  color);
		// 	TODO Auto-generated constructor stub
		this.sePoneEn = "Ojos";
		this.idealClima = "Soleado";
		this.estilo = new Estilo("Casual") ;
		this.uso = "Accesorio";
	}

}
