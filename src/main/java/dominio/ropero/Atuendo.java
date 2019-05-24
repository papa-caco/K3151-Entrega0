package dominio.ropero;

import java.util.List;
import java.util.stream.Collectors;

import dominio.prenda.*;


public class Atuendo {

	private List<Prenda> prendasAtuendo;

	public List<Prenda> getPrendasAtuendo() {
		return prendasAtuendo;
	}

	public void setPrendasAtuendo(List<Prenda> prendasAtuendo) {
		this.prendasAtuendo = prendasAtuendo;
	}
	
	
	public List<String> tiposAtuendo() {
		return this.prendasAtuendo.stream().map(prenda -> prenda.tipoPrenda()).collect(Collectors.toList());
	}
	
	
}
