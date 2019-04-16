package dominio.personas;

import dominio.prendas.Estilo;

public class Hombre extends Persona {

	public Hombre(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
	
	}
	
	@java.lang.Override
	public boolean esVaron() {
		return true;
	}
	
}
