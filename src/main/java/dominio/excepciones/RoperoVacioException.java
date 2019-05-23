package dominio.excepciones;
@SuppressWarnings("serial")

public class RoperoVacioException extends Exception {

	public RoperoVacioException() {
		super("Se encontró vacío al ropero ");
	}

}
