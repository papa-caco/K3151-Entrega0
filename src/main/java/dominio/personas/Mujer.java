package dominio.personas;

import java.util.List;

import dominio.prendas.Estilo;
import dominio.prendas.Prenda;

public class Mujer extends Persona {


	
	public Mujer(String nombre, int edad, int talla, Estilo estilo, List<Prenda> prendas) {
		super(nombre, edad, talla, estilo, prendas);
		// TODO Auto-generated constructor stub
		this.sexo="Femenino";
	}

	@java.lang.Override
	public boolean esMujer() {
		return true;
	}
	
}
