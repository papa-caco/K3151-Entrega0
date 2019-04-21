package dominio.personas;
import java.util.List;
import java.util.LinkedList;
import dominio.prendas.*;
import dominio.ropero.*;
import dominio.excepciones.*;
import dominio.clima.*;

public abstract class Persona {

	protected String nombre;
	protected int edad;
	protected String sexo;
	protected int talla;
	protected Estilo estilo;
	protected List<Prenda> prendas;
	
	public Persona(String nombre, int edad, int talla, Estilo estilo, List<Prenda> prendas) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.talla = talla;
		this.estilo = estilo;
		this.prendas = new LinkedList<>();
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
	
	public List<Prenda> getPrendas() {
		return prendas;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setTalla(int talla) {
		this.talla = talla;
	}
	
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	
	protected void addPrenda(Prenda prenda) throws PrendaNoLeVaException {
		
		if (this.leCalzaBien(prenda)) {
			this.prendas.add(prenda);
		}
		else {
			throw new PrendaNoLeVaException();
		}
	}
	
	public void sePone(Prenda prenda) throws PrendaNoLeVaException {
		try {
			this.addPrenda(prenda);
		}
		catch (PrendaNoLeVaException exception) {
			throw exception;
		}
	}
	
	public boolean esVaron() {
		return false;
	}

	public boolean esMujer() {
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
	
	protected boolean coincideTalla(Prenda prenda) {
		return this.talla == prenda.talla();
	}
	
	protected boolean coincideGenero(Prenda prenda) {
		return this.sexo() == prenda.genero();
	}
	
	protected boolean coincideEstilo(Prenda prenda) {
		return this.estilo.tipo() == prenda.estilo().tipo();
	}
	
	protected boolean coincideFranjaEtarea(Prenda prenda) {
		return this.franjaEtarea() == prenda.esPara();
	}
	
	public boolean leCalzaBien(Prenda prenda) {
		return this.coincideTalla(prenda) 
			&& this.coincideGenero(prenda)
			&& this.coincideEstilo(prenda) 
			&& this.coincideFranjaEtarea(prenda);
	}
	
	public List<Prenda> pedirSugerencia(Ropero ropero, Fecha hoy) throws SinPrendasException {
		try {
			return ropero.sugerenciaPrendas(this,hoy);
		}
		catch (SinPrendasException exception) {
			throw exception;
		}
	}
	
	protected void devolverPilchas(Ropero ropero) throws RoperoFullException {
		if (this.prendas.size() > ropero.capacidadDisponible()) {
			throw new RoperoFullException();
			}
		else {
			ropero.recepcionDePrendas(this.prendas);
			this.prendas.clear();
		}
	}
	
	public void desvestirse(Ropero ropero) throws RoperoFullException {
		try {
			this.devolverPilchas(ropero);
		}
		catch (RoperoFullException exception) {
			throw exception;
		}
	}
	
	public void vestirSugerencia(Ropero ropero, Fecha hoy) 
		throws SinPrendasException, RoperoFullException {
		try {
			List<Prenda> sugerencia = this.pedirSugerencia(ropero, hoy);
			if (!this.estaDesnudo()) {
				this.desvestirse(ropero);
				}
			else {
				ropero.entregaDePrendas(sugerencia);
				this.prendas.addAll(sugerencia);
				}
		}
		catch (SinPrendasException exception) {
			throw exception;
		}
		catch (RoperoFullException exception) {
			throw exception;
		}
	}
		
}
