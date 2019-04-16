package dominio.personas;

import dominio.prendas.Estilo;

public class Abuela extends Mujer {

	public Abuela(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
		// TODO Auto-generated constructor stub
	}

	@java.lang.Override
	public boolean esAnciano() {
		return true;
	}

}
