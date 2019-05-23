package dominio.ropero;
import dominio.prenda.*;
import dominio.persona.*;
import dominio.excepciones.*;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
//import dominio.clima.*;

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
	
	protected void entregoPrendas(List<Prenda> prendas) throws RoperoSinPrendasException {
		if (prendas.size() > this.prendas.size()) {
			throw new RoperoSinPrendasException();
			}
		else {
			this.prendas.removeAll(prendas);
		}
	}
	
	public void entregaDePrendas(List<Prenda> prendas) throws RoperoSinPrendasException {
		try {
			this.entregoPrendas(prendas);
		}
		catch (RoperoSinPrendasException exception) {
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
	
	protected boolean prendaSeleccionadaPor
	(Prenda prenda, Persona persona, String categoria, String parteCuerpo) {
	return persona.leCalzaBien(prenda) &&
		   prenda.paraPonerEn(parteCuerpo) &&
		   prenda.categoria(categoria);
	}
	
	public Prenda seleccionoCualquierPrenda(List<Prenda> prendas) {
		return prendas.stream().findAny().get();
	}
	
	public List<Prenda> filtroPrendasPor
		(Persona persona, String categoria, String parteCuerpo) {
			return this.prendas.stream()
				   .filter(prenda->this.prendaSeleccionadaPor(prenda, persona, categoria, parteCuerpo))
				   .collect(Collectors.toList());
	}
	
	public Prenda elijoPrendaPor(Persona persona, String categoria, String parteCuerpo) 
			throws RoperoSinPrendasException {
			List<Prenda> prendasR = this.filtroPrendasPor(persona, categoria, parteCuerpo);
			if (prendasR.isEmpty()) {
				throw new RoperoSinPrendasException();
			}
			else {
					return this.seleccionoCualquierPrenda(prendasR);
			}
		
		}
		
		public Prenda seleccionoPrendaPor(Persona persona, String categoria, String parteCuerpo) 
				throws RoperoSinPrendasException {
			try {
				return this.elijoPrendaPor(persona, categoria, parteCuerpo);
			}
			catch (RoperoSinPrendasException exception) {
				throw exception;
			}
		}
	
		public List<Prenda> prendasIntimas(Persona persona) throws RoperoSinPrendasException {
			try {
				List<Prenda> interiores = new LinkedList<>();
				if (persona.esVaron()) {
					Prenda unaPrenda = this.seleccionoPrendaPor(persona, "Interior", "IntimasMasculino");
					interiores.add(unaPrenda);
					return interiores;
				}
				else {
					Prenda prenda1 = this.seleccionoPrendaPor(persona, "Interior", "IntimasFemeninoInf");
					Prenda prenda2 = this.seleccionoPrendaPor(persona, "Interior", "IntimasFemeninoSup");
					interiores = Arrays.asList(prenda1, prenda2);
					return interiores;
				}
			}
			catch (RoperoSinPrendasException exception) {
				throw exception;
			}	
		}
		
		public List<Prenda> prendasNoIntimas(Persona persona) throws RoperoSinPrendasException {
			try {
				List<Prenda> exteriores = new LinkedList<>();
				Prenda prenda1 = this.seleccionoPrendaPor(persona, "Interior", "Pies");
				Prenda prenda2 = this.seleccionoPrendaPor(persona, "Calzado", "Pies");
				Prenda prenda3 = this.seleccionoPrendaPor(persona, "Basico", "Piernas");
				Prenda prenda4 = this.seleccionoPrendaPor(persona, "Basico", "Torso");
				exteriores = Arrays.asList(prenda1, prenda2, prenda3, prenda4);
				return exteriores;
			}
			catch (RoperoSinPrendasException exception) {
				throw exception;
			}
		}
		
		public List<Prenda> sugerenciaPrendas(Persona persona) throws RoperoSinPrendasException {
			try {
				List<Prenda> prendas = this.prendasNoIntimas(persona);
				List<Prenda> intimas = this.prendasIntimas(persona);
				Stream<List<Prenda>> sugerencia = Stream.of(prendas, intimas);
				return sugerencia.flatMap(prenda -> prenda.stream()).collect(Collectors.toList());
			}
			catch (RoperoSinPrendasException exception) {
				throw exception;
			}
		}
		
		public List<String> prendasGuardadas() {
			return this.prendas.stream().map(prenda->prenda.getArticulo()).collect(Collectors.toList());
		}
		
		public List<String> prendasSugeridas(List<Prenda> sugerencia) {
			return sugerencia.stream().map(prenda->prenda.getArticulo()).collect(Collectors.toList());
		}
		
}
