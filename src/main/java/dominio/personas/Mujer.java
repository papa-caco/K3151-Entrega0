package dominio.personas;

import dominio.prendas.Estilo;

public class Mujer extends Persona {

	public Mujer(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
	}
	
	@java.lang.Override
	public boolean esMujer() {
		return true;
	}
	
}
