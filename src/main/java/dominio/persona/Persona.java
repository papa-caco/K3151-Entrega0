package dominio.persona;
import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedList;
import dominio.prenda.*;
import dominio.ropero.*;
import dominio.excepciones.*;

public class Persona {
	
	private String nombre;
	private int edad;
	private String sexo;
	private int talla;
	
	public Persona(String nombre, int edad, String sexo, int talla) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.talla = talla;
	}

	public String sexo() {
		return sexo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public Integer talla() {
		return talla;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setTalla(int talla) {
		this.talla = talla;
	}
	
	protected boolean esBebe() {
		return this.edad <= 3;
	}

	protected boolean esNinio() {
		return this.edad > 3 && this.edad <= 16;
	}
	
	protected boolean esAnciano() {
		return this.edad >= 75;
	}

	protected boolean coincideTalla(Prenda prenda) {
		return this.talla == prenda.getTalla();
	}
	
	protected boolean coincideGenero(Prenda prenda) {
		return this.sexo() == prenda.paraGenero();
	}
	
	public boolean leCalzaBien(Prenda prenda) {
		return this.coincideTalla(prenda) 
			&& this.coincideGenero(prenda);
	}

	public boolean esVaron() {
		return this.sexo == "masculino";
	}

	public boolean esMujer() {
		return this.sexo == "femenino";
	}

	public String franjaEtarea() {
		if (this.esBebe()) {
			return "Bebe";
			}
		if (this.esNinio()) {
			return "Ninio";
			}
		if (this.esAnciano()) {
			return "Anciano";
			}
		else {
			return "Adulto";
		}
	}

}


