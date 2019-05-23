package dominio.excepciones;
@SuppressWarnings("serial")

public class RoperoSinPrendasException extends Exception {
	
	public RoperoSinPrendasException() {
		super("No se encontraron las prendas solicitadas en el ropero ");
	}

}
