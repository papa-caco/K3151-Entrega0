package dominio.clima;
import java.util.Date;
import com.sun.jmx.snmp.Timestamp;

public class Fecha {
	
	private Date fecha;
	private Clima clima;
	
	public Fecha(Clima clima) {
		super();
		this.clima = clima;
		Timestamp ahora = new Timestamp(System.currentTimeMillis());
		this.fecha = ahora.getDate();
	}

	public Date getFecha() {
		return fecha;
	}

	protected void setFecha(Date fecha) {
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
