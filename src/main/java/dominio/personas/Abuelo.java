package dominio.personas;

import dominio.prendas.Estilo;

public class Abuelo extends Hombre{

	public Abuelo(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
		// TODO Auto-generated constructor stub
	}

	@java.lang.Override
	public boolean esAnciano() {
		return true;
	}

}
