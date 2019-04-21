package dominio.excepciones;
@SuppressWarnings("serial")

public class PrendaNoLeVaException extends Exception {

	public PrendaNoLeVaException() {
		super("La prenda no le calza ");
	}

}
