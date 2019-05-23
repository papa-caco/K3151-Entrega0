package dominio.excepciones;
@SuppressWarnings("serial")

public class RoperoFullException extends Exception {

	public RoperoFullException() {
		super("Se ha completado la capacidad del ropero ");
	}

}
