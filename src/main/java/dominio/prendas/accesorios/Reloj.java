package dominio.prendas.accesorios;
import dominio.prendas.*;

public class Reloj extends Prenda {

	public Reloj(Integer talla, String genero, Estilo estilo, 
					String esPara, Color color) {
		super(talla, genero, estilo, esPara, color);
		// TODO Auto-generated constructor stub
		this.idealClima = "";
		this.uso = "Exterior";
		this.sePoneEn = "Brazo";
	}
 
}
