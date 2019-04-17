package dominio.clima;

public class Cielo {
	
	private String estado;
	
	public Cielo(String estado) {
		super();
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean esNuboso() {
		return this.estado == "Nuboso";
	}

	public boolean estaLloviendo() {
		return this.estado == "Lloviendo";
	}
	
	public boolean estaSoleado() {
		return this.estado == "Soleado";
	}
	
	public boolean esDeNoche(){
		return this.estado == "Noche";
	}

}


	
