package dominio.clima;

public class Clima {
	
	private Frio frio;
	private Calor calor;
	protected Double temperatura;
	protected Cielo cielo;
	
	public Clima(Double temp, Cielo cielo) {
		this.temperatura = temp;
		this.frio = new Frio(10.0);
		this.calor = new Calor(25.0);
		this.cielo = cielo;
	}
	
	public Double getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	protected Frio getFrio() {
		return frio;
	}

	protected void setFrio(Frio frio) {
		this.frio = frio;
	}

	protected Calor getCalor() {
		return calor;
	}

	protected void setCalor(Calor calor) {
		this.calor = calor;
	}

	public Cielo getCielo() {
		return cielo;
	}

	public void setCielo(Cielo cielo) {
		this.cielo = cielo;
	}
	
	protected boolean esCalido() {
		return this.temperatura >= this.calor.tempLimite;
	}
	
	protected boolean esFrio() {
		return this.temperatura <= this.frio.tempLimite;
	}
	
	protected boolean estaNublado() {
		 return this.cielo.esNuboso();
	}
	
	protected boolean esLluvioso() {
		return this.cielo.estaLloviendo();
	}
	
	protected boolean esSoleado() {
		return this.cielo.estaSoleado();
	}
	
	protected boolean esNocturno() {
		return this.cielo.esDeNoche();
	}
	
	public String  marcaTermica() {
		if (this.esFrio()) {
			return "Frio";
			}
		if (this.esCalido()) {
			return "Calido";
			}
		else {
			return "Templado";
		}
	}
	
	public String  condiciones() {
		if (this.esLluvioso()) {
			return "Lluvioso";
			}
		if (this.estaNublado()) {
			return "Nublado";
			}
		if (this.esNocturno()) {
			return "Nocturno";
			}
		else {
			return "Soleado";
		}
	}
	
}
