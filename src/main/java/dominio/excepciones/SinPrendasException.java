package dominio.excepciones;
@SuppressWarnings("serial")

public class SinPrendasException extends Exception {
	
	public SinPrendasException( ) {
		super("No se encontraron la prendas solicitadas ");
	}

}
