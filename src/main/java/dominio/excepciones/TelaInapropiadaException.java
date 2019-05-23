package dominio.excepciones;
@SuppressWarnings("serial")

public class TelaInapropiadaException extends Exception {

	public TelaInapropiadaException( ) {
		super(" La tela elegida no es apropiada para esa prenda.");
	}
}
