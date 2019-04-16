package dominio.personas;

import dominio.prendas.Estilo;

public class Ninia extends Mujer {

	public Ninia(String nombre, int edad, int talla, Estilo estilo) {
		super(nombre, edad, talla, estilo);
		// TODO Auto-generated constructor stub
	}
	
	@java.lang.Override
	public boolean esNinio() {
		return true;
	}

}
