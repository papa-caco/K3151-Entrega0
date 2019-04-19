package dominio.ropero;
import dominio.prendas.*;
import dominio.personas.*;
import dominio.clima.*;
import dominio.excepciones.*;
import java.util.List;
import java.util.ArrayList;
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

	protected void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public void recibePrenda(Prenda prenda) throws RoperoFullException {
		if (this.fullCapacidad()) {
			throw new RoperoFullException();
		} else {
			this.prendas.add(prenda);
		}
	}
	
	public void entregaPrenda(Prenda prenda) throws RoperoVacioException {
		if (this.prendas.isEmpty()) {
			throw new RoperoVacioException();
		} else {
			this.prendas.remove(prenda);
		}
	}

	
	public int capacidadDisponible() {
		return this.capacidadMaxima - this.prendas.size();
	}
	
	protected boolean fullCapacidad() {
		return this.capacidadDisponible() == 0; 
	}
	
	protected boolean prendaParaPersona(Prenda prenda, Persona persona) {
		return persona.leCalzaBien(prenda);
	}
	
	protected boolean prendaParaClima(Prenda prenda, Fecha hoy) {
		return prenda.idealParaClimaDe(hoy);
	}
	
	protected boolean prendaParaPonerEn(Prenda prenda, String donde) {
		return prenda.paraPonerEn(donde);
	}
	
	protected boolean prendaParaUso(Prenda prenda, String unUso) {
		return prenda.paraUso(unUso);
	}
	
	protected boolean prendaSeleccionadaPor
		(Prenda prenda, Persona persona, String unUso, String donde, Fecha hoy) {
		return this.prendaParaPersona(prenda, persona) &&
			   this.prendaParaClima(prenda, hoy) &&
			   this.prendaParaUso(prenda, unUso) &&
			   this.prendaParaPonerEn(prenda, donde);
	}
	
	protected Prenda seleccionoCualquierPrenda(List<Prenda> prendas) {
		return prendas.stream().findAny().get();
	}
	
	protected List<Prenda> filtroPrendasPor
		(Persona persona, String unUso, String donde, Fecha hoy) {
			return this.prendas.stream()
				   .filter(prenda->this.prendaSeleccionadaPor(prenda, persona, unUso, donde, hoy))
				   .collect(Collectors.toList());
	}

	protected Prenda seleccionoPrendaPor(Persona persona, String unUso, String donde, Fecha hoy) 
			throws SinPrendasException {
			List<Prenda> prendasR = this.filtroPrendasPor(persona, unUso, donde, hoy);
			if (prendasR.isEmpty()) {
				throw new SinPrendasException();
			}
			else {
				return this.seleccionoCualquierPrenda(prendasR);
			}
	}
	
		
	protected List<Prenda> prendasIntimas(Persona persona, Fecha hoy)
			throws SinPrendasException,RoperoVacioException {
		List<Prenda> interiores = new ArrayList<>();
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
	
	protected List<Prenda> prendasNoIntimas(Persona persona, Fecha hoy) throws SinPrendasException {
		List<Prenda> prendas = new ArrayList<>();
		Prenda prenda1 = this.seleccionoPrendaPor(persona, "Interior", "Pies", hoy);
		Prenda prenda2 = this.seleccionoPrendaPor(persona, "Exterior", "Pies", hoy);
		Prenda prenda3 = this.seleccionoPrendaPor(persona, "Exterior", "Piernas", hoy);
		Prenda prenda4 = this.seleccionoPrendaPor(persona, "Interior", "Torso", hoy);
		prendas = Arrays.asList(prenda1, prenda2, prenda3, prenda4);
		return prendas;
	}

	public List<Prenda> sugerenciaPrendas(Persona persona, Fecha hoy) 
		throws SinPrendasException,RoperoVacioException {
		List<Prenda> prendas = this.prendasNoIntimas(persona, hoy);
		List<Prenda> intimas = this.prendasIntimas(persona, hoy);
		Stream<List<Prenda>> sugerencia = Stream.of(prendas, intimas);
		return sugerencia.flatMap(prenda -> prenda.stream()).collect(Collectors.toList());
	}
	
	public void entregaDePrendas(List<Prenda> prendas) 
			throws SinPrendasException,RoperoVacioException {
		if (prendas.size() > this.prendas.size()) {
			throw new SinPrendasException();
			}
		else {
			this.prendas.removeAll(prendas);
		}
	}
	
	public void recepcionDePrendas(List<Prenda> prendas) 
			throws RoperoFullException {
		if (prendas.size() > this.capacidadDisponible()) {
			throw new RoperoFullException();
			}
		else {
			this.prendas.addAll(prendas);
		}
	}
	
	
	
	
}
