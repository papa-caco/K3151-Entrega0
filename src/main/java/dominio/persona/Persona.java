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
	
	
	public boolean esVaron() {
		return this.sexo == "masculino";
	}

	public boolean esMujer() {
		return this.sexo == "femenino";
	}

}
