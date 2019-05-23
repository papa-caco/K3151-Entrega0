package dominio.excepciones;
@SuppressWarnings("serial")

public class ColorDuplicadoException extends Exception {
	
	public ColorDuplicadoException( ) {
		super(" : Color Secundario Igual al Color Primario.");
	}

}
