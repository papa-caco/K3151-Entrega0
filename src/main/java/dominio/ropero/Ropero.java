package dominio.ropero;
import dominio.prendas.*;
import dominio.personas.*;
import dominio.clima.*;
import dominio.excepciones.*;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

public class Ropero {
	
	private String nombre;
	private int capacidadMaxima;
	private List<Prenda> prendas;
	
	public Ropero(String nombre, int capacidadMaxima, List<Prenda> prendas) {
		super();
		this.nombre = nombre;
		this.capacidadMaxima = capacidadMaxima;
		this.prendas = new LinkedList<>();
	}

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public String nombre() {
		return nombre;
	}

	public int capacidadMaxima() {
		return capacidadMaxima;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	protected void tomaPrenda(Prenda prenda) throws RoperoFullException {
		if (this.fullCapacidad()) {
			throw new RoperoFullException();
		} else {
			this.prendas.add(prenda);
		}
	}
	
	public void recibePrenda(Prenda prenda) throws RoperoFullException {
		try {
			this.tomaPrenda(prenda);
		}
		catch (RoperoFullException exception) {
			throw exception;
		}
	}
	
	public void quitoPrendas(List<Prenda> prendas) {
		this.prendas.removeAll(prendas);
	}
	
	protected void daPrenda(Prenda prenda) throws RoperoVacioException {
		if (this.prendas.isEmpty()) {
			throw new RoperoVacioException();
		} else {
			this.prendas.remove(prenda);
		}
	}

	public void entregaPrenda(Prenda prenda) throws RoperoVacioException {
		try {
			this.daPrenda(prenda);
		}
		catch (RoperoVacioException exception) {
			throw exception;
		}
	}
		
	public int capacidadDisponible() {
		return this.capacidadMaxima - this.prendas.size();
	}
	
	public boolean fullCapacidad() {
		return this.capacidadDisponible() == 0; 
	}
	
	protected boolean prendaSeleccionadaPor
		(Prenda prenda, Persona persona, String unUso, String donde, Fecha hoy) {
		return persona.leCalzaBien(prenda) &&
			   prenda.idealParaClimaDe(hoy) &&
			   prenda.paraPonerEn(donde) &&
			   prenda.paraUso(unUso);
	}
	
	public Prenda seleccionoCualquierPrenda(List<Prenda> prendas) {
		return prendas.stream().findAny().get();
	}
	
	public List<Prenda> filtroPrendasPor
		(Persona persona, String unUso, String donde, Fecha hoy) {
			return this.prendas.stream()
				   .filter(prenda->this.prendaSeleccionadaPor(prenda, persona, unUso, donde, hoy))
				   .collect(Collectors.toList());
	}

	public Prenda elijoPrendaPor(Persona persona, String unUso, String donde, Fecha hoy) 
		throws SinPrendasException {
		List<Prenda> prendasR = this.filtroPrendasPor(persona, unUso, donde, hoy);
		if (prendasR.isEmpty()) {
			throw new SinPrendasException();
		}
		else {
				return this.seleccionoCualquierPrenda(prendasR);
		}
	
	}
	
	public Prenda seleccionoPrendaPor(Persona persona, String unUso, String donde, Fecha hoy) 
			throws SinPrendasException {
		try {
			return this.elijoPrendaPor(persona, unUso, donde, hoy);
		}
		catch (SinPrendasException exception) {
			throw exception;
		}
	}
	
	public List<Prenda> prendasIntimas(Persona persona, Fecha hoy)
			throws SinPrendasException {
		try {
			List<Prenda> interiores = new LinkedList<>();
			if (persona.esVaron()) {
				Prenda unaPrenda = this.seleccionoPrendaPor(persona, "Interior", "IntimasMasculino", hoy);
				interiores.add(unaPrenda);
				return interiores;
			}
			else {
				Prenda prenda1 = this.seleccionoPrendaPor(persona, "Interior", "IntimasFemeninoInf", hoy);
				Prenda prenda2 = this.seleccionoPrendaPor(persona, "Interior", "IntimasFemeninoSup", hoy);
				interiores = Arrays.asList(prenda1, prenda2);
				return interiores;
			}
		}
		catch (SinPrendasException exception) {
			throw exception;
		}	
	}
	
	public List<Prenda> prendasNoIntimas(Persona persona, Fecha hoy) throws SinPrendasException {
		try {
			List<Prenda> exteriores = new LinkedList<>();
			Prenda prenda1 = this.seleccionoPrendaPor(persona, "Interior", "Pies", hoy);
			Prenda prenda2 = this.seleccionoPrendaPor(persona, "Exterior", "Pies", hoy);
			Prenda prenda3 = this.seleccionoPrendaPor(persona, "Exterior", "Piernas", hoy);
			Prenda prenda4 = this.seleccionoPrendaPor(persona, "Exterior", "Torso", hoy);
			exteriores = Arrays.asList(prenda1, prenda2, prenda3, prenda4);
			return exteriores;
		}
		catch (SinPrendasException exception) {
			throw exception;
		}
	}

	public List<Prenda> sugerenciaPrendas(Persona persona, Fecha hoy) throws SinPrendasException {
		try {
			List<Prenda> prendas = this.prendasNoIntimas(persona, hoy);
			List<Prenda> intimas = this.prendasIntimas(persona, hoy);
			Stream<List<Prenda>> sugerencia = Stream.of(prendas, intimas);
			return sugerencia.flatMap(prenda -> prenda.stream()).collect(Collectors.toList());
		}
		catch (SinPrendasException exception) {
			throw exception;
		}
	}
	
	protected void entregoPrendas(List<Prenda> prendas) throws SinPrendasException {
		if (prendas.size() > this.prendas.size()) {
			throw new SinPrendasException();
			}
		else {
			this.prendas.removeAll(prendas);
		}
	}
	
	public void entregaDePrendas(List<Prenda> prendas) throws SinPrendasException {
		try {
			this.entregoPrendas(prendas);
		}
		catch (SinPrendasException exception) {
			throw exception;
		}
	}
	
	protected void recepcionPrendas(List<Prenda> prendas) throws RoperoFullException {
		if (prendas.size() > this.capacidadDisponible()) {
			throw new RoperoFullException();
			}
		else {
			this.prendas.addAll(prendas);
		}
	}
	
	public void recepcionDePrendas(List<Prenda> prendas) throws RoperoFullException {
		try {
			this.recepcionPrendas(prendas);
		}
		catch (RoperoFullException exception) {
			throw exception;
		}
	}
	
}
