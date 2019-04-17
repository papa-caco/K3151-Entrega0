package dominio.prendas;
import dominio.personas.*;

public abstract class Prenda {
	
	private Integer talla;
	private String genero;
	private Estilo estilo;
	private String sePoneEn;
	private String uso;
	private String idealClima;
	private String esPara;
	private Color color;
	
	public Prenda(Integer talla, String genero, Estilo estilo, String uso, String idealClima, String esPara,
			Color color) {
		super();
		this.talla = talla;
		this.genero = genero;
		this.estilo = estilo;
		this.uso = uso;
		this.idealClima = idealClima;
		this.esPara = esPara;
		this.color = color;
	}
	
	public Integer talla() {
		return talla;
	}

	public String genero() {
		return genero;
	}

	public Estilo estilo() {
		return estilo;
	}

	public String sePoneEn() {
		return sePoneEn;
	}

	public String uso() {
		return uso;
	}

	public String idealClima() {
		return idealClima;
	}

	public String esPara() {
		return esPara;
	}

	public Color color() {
		return color;
	}
	
	protected void setTalla(Integer talla) {
		this.talla = talla;
	}
	
	protected void setGenero(String genero) {
		this.genero = genero;
	}
	
	protected void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	protected void setSePoneEn(String sePoneEn) {
		this.sePoneEn = sePoneEn;
	}

	protected void setUso(String uso) {
		this.uso = uso;
	}
	
	protected void setIdealClima(String idealClima) {
		this.idealClima = idealClima;
	}
	
	protected void setEsPara(String esPara) {
		this.esPara = esPara;
	}

	protected void setColor(Color color) {
		this.color = color;
	}
	
	protected boolean coincideTalla(Persona persona) {
		return this.talla == persona.talla();
	}
	
	protected boolean coincideGenero(Persona persona) {
		return this.genero == persona.sexo();
	}
	
	protected boolean coincideEstilo(Persona persona) {
		return this.estilo == persona.estilo();
	}
	
	protected boolean coincideFranjaEtarea(Persona persona) {
		return this.esPara == persona.franjaEtarea();
	}
	
	public boolean matcheaCon(Persona persona) {
		return this.coincideTalla(persona) && this.coincideGenero(persona)
				&& this.coincideEstilo(persona) && this.coincideFranjaEtarea(persona);
	}
	
	

}
