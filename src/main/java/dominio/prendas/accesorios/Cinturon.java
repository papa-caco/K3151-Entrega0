package dominio.prendas.accesorios;
import dominio.prendas.*;

public class Cinturon extends Prenda {

	public Cinturon(int talla, String genero, 
					 String esPara, Color color) {
		super(talla, genero, esPara,  color);
		// TODO Auto-generated constructor stub
		this.sePoneEn = "Cintura";
		this.idealClima = "";
		this.estilo = new Estilo("") ;
		this.uso = "Accesorio";
	}
 
}
