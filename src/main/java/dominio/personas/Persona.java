package dominio.personas;
import java.util.List;
import dominio.prendas.*;

public abstract class Persona {

	private String nombre;
	private int edad;
	protected String sexo;
	private int talla;
	private Estilo estilo;
	private List<Prenda> prendas;
	
	public Persona(String nombre, int edad, int talla, Estilo estilo, List<Prenda> prendas) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.talla = talla;
		this.estilo = estilo;
		this.prendas = prendas;
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
	
	public Estilo estilo() {
		return estilo;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setEdad(int edad) {
		this.edad = edad;
	}
	
	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	protected void setTalla(int talla) {
		this.talla = talla;
	}
	
	protected void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	
	public void addPrenda(Prenda prenda){
		this.prendas.add(prenda);
	}
	
	protected boolean esVaron() {
		return false;
	}

	protected boolean esMujer() {
		return false;
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

	
	public boolean estaDesnudo() {
		return this.prendas.isEmpty();
	}
	
	public boolean prendaTalla(int talla) {
		return this.prendas.stream().anyMatch(prenda->prenda.talla() == talla);
	}
	
	public void pedirSugerencia() {
		
	}
	
}
