package dominio.prendas.accesorios;
import dominio.prendas.*;

public class Cartera extends Prenda {

	public Cartera(int talla, String genero, 
			 String esPara, Color color) {
		super(talla, genero, esPara,  color);
		// 	TODO Auto-generated constructor stub
		this.sePoneEn = "Brazo";
		this.idealClima = "";
		this.estilo = new Estilo("") ;
		this.uso = "Accesorio";
	}
 
}
