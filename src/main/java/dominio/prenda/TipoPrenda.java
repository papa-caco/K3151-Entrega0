package dominio.prenda;

public class TipoPrenda {
	
	private String tipo;		// Remera, Pantalon, Camisa, musculosa, etc.//
	private String categoria;	// Torso, Pies, Piernas, Intimas, etc. //
	private String funcion;	// Interior, Basico, Abrigo, Calzado, etc. //
		
	public TipoPrenda(String tipo, String categoria, String funcion) {
		super();
		this.tipo = tipo;
		this.categoria = categoria;
		this.funcion = funcion;
	}
	public String getTipo() {
		return tipo;
	}
	public String getFuncion() {
		return funcion;
	}
	public String getCategoria() { 
		return categoria;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
