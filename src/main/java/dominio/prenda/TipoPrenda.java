package dominio.prenda;

public class TipoPrenda {
	
	private String tipo;		// Remera, Pantalon, Camisa, musculosa, etc.//
	private String sePoneEn;	// Torso, Pies, Piernas, Intimas, etc. //
	private String categoria;	// Interior, Basico, Abrigo, Calzado, etc. //
	private String genero;		// Masculino, Femenino //
	
	public String tipo() {
		return tipo;
	}
	public String getSePoneEn() {
		return sePoneEn;
	}
	public String getCategoria() { 
		return categoria;
	}
	public String getGenero() {
		return genero;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setSePoneEn(String sePoneEn) {
		this.sePoneEn = sePoneEn;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public TipoPrenda(String tipo, String sePoneEn, String categoria, String genero) {
		super();
		this.tipo = tipo;
		this.sePoneEn = sePoneEn;
		this.categoria = categoria;
		this.genero = genero;
	}
	
	public Boolean paraHombre() {
		return genero == "Masculino";
	}
	
	public Boolean paraMujer() {
		return genero == "Femenino";
	}

}
