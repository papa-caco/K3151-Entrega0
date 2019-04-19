package dominio.prendas.accesorios;
import dominio.prendas.*;

public class Mochila extends Prenda {

	public Mochila(int talla, String genero, 
			 String esPara, Color color) {
		super(talla, genero, esPara,  color);
		// 	TODO Auto-generated constructor stub
		this.sePoneEn = "Hombros";
		this.idealClima = "";
		this.estilo = new Estilo("") ;
		this.uso = "Accesorio";
	}
	
}
