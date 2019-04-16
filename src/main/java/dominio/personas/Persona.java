package dominio.personas;
import java.util.LinkedList;
import java.util.List;
import dominio.prendas.*;
	
	

public abstract class Persona {
	private String nombre;
	private int edad;
	private int talla;
	private Estilo estilo;




	private List<Prenda> prendas;
	
	public Persona(String nombre, int edad, int talla, Estilo est) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.talla = talla;
		this.estilo = est;
		this.prendas = new LinkedList<>();
	}
	
	public void addPrenda(Prenda prenda){
		this.prendas.add(prenda);
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public Integer getTalla() {
		return talla;
	}
	
	public Estilo getEstilo() {
		return estilo;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setEdad(int edad) {
		this.edad = edad;
	}
	
	protected void setTalla(int talla) {
		this.talla = talla;
	}
	
	protected void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	
	public boolean esVaron() {
		return false;
	}

	public boolean esMujer() {
		return false;
	}

	public boolean esNinio() {
		return false;
	}
	
	public boolean esBebe() {
		return false;
	}

	public boolean esAnciano() {
		return false;
	}
	
	public boolean estaDesnudo() {
		return this.prendas.isEmpty();
	}
	
	public boolean prendaTalla(int talla) {
		return this.prendas.stream().anyMatch(prenda->prenda.getTalla() == talla);
	}
	
	public void pedirSugerencia() {
		
	}
	
}
