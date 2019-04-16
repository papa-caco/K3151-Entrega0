package dominio.clima;

public class Clima {
	
	private Frio limiteFrio;
	private Calor limiteCalor;
	protected Double temperatura;
	protected Double velocidadViento;
	protected Cielo cielo;
	
	public Clima(Double temp, Double veloc, Double frio, Double calor, Cielo cielo) {
		this.temperatura = temp;
		this.velocidadViento = veloc;
		this.limiteFrio = new Frio(frio);
		this.limiteCalor = new Calor(calor);
		this.cielo = cielo;
	}
	
	public Double getTemperatura() {
		return temperatura;
	}
	
	protected void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	public Double getVelocidadViento() {
		return velocidadViento;
	}
	
	public void setVelocidadViento(Double velocidadViento) {
		this.velocidadViento = velocidadViento;
	}
	
	protected Cielo getCielo() {
		return cielo;
	}

	protected void setCielo(Cielo cielo) {
		this.cielo = cielo;
	}
	
	public boolean esCalido() {
		return this.temperatura >= this.limiteCalor.tempLimite;
	}
	
	public boolean esFrio() {
		return this.temperatura <= this.limiteFrio.tempLimite;
	}
	
	public boolean estaNublado() {
		 return this.cielo.esNuboso();
	}
	
	public boolean esLluvioso() {
		return this.cielo.estaLloviendo();
	}
	
	public boolean esVentoso() {
		return this.velocidadViento > 30.0;
	}
	
	public boolean esDiurno() {
		return this.cielo.estaSoleado();
	}
	
	public boolean esNocturno() {
		return this.cielo.esDeNoche();
	}
	
}
