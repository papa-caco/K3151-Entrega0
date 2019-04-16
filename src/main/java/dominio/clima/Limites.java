package dominio.clima;

public abstract class Limites {
	
	protected Double tempLimite;
		
	public Double tempLimite() {
		return tempLimite;
	}
	
	public void tempLimite(Double temp) {
		this.tempLimite = temp;
	}

}
