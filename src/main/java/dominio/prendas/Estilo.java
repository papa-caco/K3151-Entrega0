package dominio.prendas;

public class Estilo {
	
	private String tipo;
	
	public Estilo(String tipo) {
		super();
		this.tipo = tipo;
	}
	
	public String tipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
