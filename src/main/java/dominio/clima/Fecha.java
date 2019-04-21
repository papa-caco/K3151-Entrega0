package dominio.clima;
import java.sql.Date;

public class Fecha {
	
	private String fecha;
	private Clima clima;
	
	public Fecha(Clima clima) {
		super();
		this.clima = clima;
		Date hoy = new Date(System.currentTimeMillis());
		this.fecha = hoy.toString();
	}

	public String getFecha() {
		return fecha;
	}

	protected void setFecha(String fecha) {
		this.fecha = fecha;
	}

	protected void setClima(Clima clima) {
		this.clima = clima;
	}
	
	public String climaActual() {
		return this.clima.marcaTermica();
	}
	
	public String condicionesClima() {
		return this.clima.condiciones();
	}

}
