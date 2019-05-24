package dominio.prenda;

import dominio.excepciones.*;

public class Prenda {
	
	private TipoPrenda tipo;
	private Tela tela;
		
	public TipoPrenda getTipo() {
		return tipo;
	}

	public Tela getTela() {
		return tela;
	}

	public void setTipo(TipoPrenda tipo) {
		this.tipo = tipo;
	}

	private void tela(Tela tela) throws TelaInapropiadaException {
		
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

	public boolean esDeCategoria(String categoria) {
		return this.tipo.getCategoria() == categoria; 
	}
	
	public boolean esDeTipo(String tipo) {
		return this.tipo.getTipo() == tipo; 
	}

	public boolean esDeFucion(String funcion) {
		return this.tipo.getFuncion() == funcion; 
	}

	public String tipoPrenda() {
		return this.tipo.getTipo();
	}
	
	public String colorBase() {
		return this.getTela().getColorPrimario().deColor();
	}
	
	public String colorSecundario() {
		return this.getTela().SegundoColor();
	}
	
	public Boolean esDe2Colores() {
		return !this.getTela().esDeUnSoloColor();
	}
	
}