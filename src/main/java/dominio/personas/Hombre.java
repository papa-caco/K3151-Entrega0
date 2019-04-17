package dominio.personas;

import java.util.List;

import dominio.prendas.Estilo;
import dominio.prendas.Prenda;

public class Hombre extends Persona {

	public Hombre(String nombre, int edad, int talla, Estilo estilo, List<Prenda> prendas) {
		super(nombre, edad, talla, estilo, prendas);
		// TODO Auto-generated constructor stub
		this.sexo = "Masculino";
	}

	@java.lang.Override
	public boolean esVaron() {
		return true;
	}
	
}
