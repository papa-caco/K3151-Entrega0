package dominio.personas;

import dominio.prendas.Estilo;

public class Bebe extends Hombre {

	public Bebe(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
		// TODO Auto-generated constructor stub
	}
	
	@java.lang.Override
	public boolean esBebe() {
		return true;
	}

}
