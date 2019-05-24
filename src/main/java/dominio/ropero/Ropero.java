package dominio.ropero;
import dominio.prenda.*;
import dominio.persona.*;
import dominio.excepciones.*;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.Arrays;
//import dominio.clima.*;

public class Ropero {
	
	private String nombre;
	private List<Prenda> prendas;
	
	public Ropero(String nombre, List<Prenda> prendas) {
		super();
		this.nombre = nombre;
		this.prendas = new LinkedList<>();
	}
	
	public Ropero(String nombre) {
		super();
		this.nombre = nombre;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public Prenda seleccionoCualquierPrenda(List<Prenda> prendas) {
		return prendas.stream().findAny().get();
	}
	
	public List<Prenda> filtroPrendasPor
		(String categoria) {
			return this.prendas.stream()
				   .filter(prenda-> prenda.esDeCategoria(categoria))
				   .collect(Collectors.toList());
	}
	
	
	public List<String> prendasGuardadas() {
			return this.prendas.stream().map(prenda->prenda.tipoPrenda()).collect(Collectors.toList());
	}
	
		
	final Predicate<? super String> selectStartsWithA = new Predicate<String>() {
		@Override
		public boolean apply(final String word) {
			return word.toLowerCase().startsWith("a");
		}
	};
	
	public final List<String> stringsStartsWithA(List<String> listOfString) {
		 return FluentIterable.from(listOfString).filter(selectStartsWithA).toList();
	}
	
	 public List<List<String>> listaIterada(List<String> listOfString, int max) { 
       return  Lists.partition(listOfString,max);
	
	 }
	
}
