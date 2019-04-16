package dominio.personas;

import dominio.prendas.Estilo;

public class Ninio extends Hombre {

	public Ninio(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
		// TODO Auto-generated constructor stub
	}
	
	@java.lang.Override
	public boolean esNinio() {
		return true;
	}

}