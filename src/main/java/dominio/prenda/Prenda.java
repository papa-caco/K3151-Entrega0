package dominio.prenda;

import dominio.ropero.*;
import dominio.excepciones.*;
//import dominio.personas.*;

public class Prenda {
	
	private String articulo;
	private int talla;
	private TipoPrenda tipo;
	private Tela tela;
	private Ropero ropero;
		
	public String getArticulo() {
		return articulo;
	}

	public int getTalla() {
		return talla;
	}

	public TipoPrenda getTipo() {
		return tipo;
	}

	public Tela getTela() {
		return tela;
	}

	public Ropero getRopero() {
		return ropero;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public void setTipo(TipoPrenda tipo) {
		this.tipo = tipo;
	}

	protected void tela(Tela tela) throws TelaInapropiadaException {
		
		if (tela.aptoTipoPrenda(this.tipo)) {
			this.tela = tela;
		}
		else {
			throw new TelaInapropiadaException();
		}
	}
	
	public void setTela(Tela tela) throws TelaInapropiadaException {
		try {
			this.tela(tela);
		}
		catch (TelaInapropiadaException exception) {
			throw exception;
		}
	}

	public void setRopero(Ropero ropero) {
		this.ropero = ropero;
	}

	public boolean paraPonerEn(String donde) {
		return tipo.getSePoneEn() == donde; 
	}
	
	public boolean categoria(String unaCategoria) {
		return tipo.getCategoria() == unaCategoria; 
	}
	
	public String tipoPrenda() {
		return this.getTipo().tipo();
	}
	
	
	public String paraGenero() {
		return tipo.getGenero();
	}
	
	public String colorBase() {
		return this.getTela().getColorPrimario().deColor();
	}
	
	public String colorSecundario() {
		return this.getTela().SegundoColor();
	}
	
	public Boolean prendaDe2Colores() {
		return !this.getTela().esDeUnSoloColor();
	}
	
}