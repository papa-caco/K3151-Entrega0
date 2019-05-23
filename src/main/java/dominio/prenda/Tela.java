package dominio.prenda;
import java.util.List;
import dominio.excepciones.*;
//import java.util.LinkedList;
	
public class Tela {
	private String material;			// Algodon, Lana, Seda, Cuero, Lona //
	private String idealClima; 			// Frio, Calido, Templado, Lluvioso, Soleado //
	private List<String> paraTipoPrenda;	// [Remera, Chomba, Pantalon] //
	private Color colorPrimario;		// new Color("Verde") //
	private Color colorSecundario;		// new Color("Verde") //
	
	public Tela(String material, String idealClima, Color color1,
			Color color2) throws ColorDuplicadoException {
		super();
		this.material = material;
		this.idealClima = idealClima;
		this.colorPrimario = color1;
		this.setColorSecundario(color2);		
	}
	
	public Tela(String material, String idealClima, Color color1) {
		super();
		this.material = material;
		this.idealClima = idealClima;
		this.colorPrimario = color1;
	}

	public String getMaterial() {
		return material;
	}
	public String getIdealClima() {
		return idealClima;
	}
	public List<String> getTipoPrenda() {
		return paraTipoPrenda;
	}
	public Color getColorPrimario() {
		return colorPrimario;
	}
	public Color getColorSecundario() {
		return colorSecundario;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void setIdealClima(String clima) {
		this.idealClima = clima;
	}

	public void setColorPrimario(Color color) {
		this.colorPrimario = color;
	}
	
	public void setParaTipoPrenda(List<String> paraPrendas) {
		this.paraTipoPrenda = paraPrendas;
	}

	protected void colorSecundario(Color color) throws ColorDuplicadoException {
		
		if (this.colorPrimario.deColor() != color.deColor()) {
			this.colorSecundario = color;
		}
		else {
			throw new ColorDuplicadoException();
		}
	}
	
	public void setColorSecundario(Color color) throws ColorDuplicadoException {
		try {
			this.colorSecundario(color);
		}
		catch (ColorDuplicadoException exception) {
			throw exception;
		}
	}
	
	public Boolean aptoTipoPrenda(TipoPrenda tipoPrenda) {
		String tipo = tipoPrenda.tipo();
		return paraTipoPrenda.stream().anyMatch(unTipo -> unTipo.equals(tipo));
	}
	
	public Boolean esDeUnSoloColor() {
		return this.colorSecundario.deColor().isEmpty();
	}
	
	public String SegundoColor() {
		return this.colorSecundario.deColor();
	}

}