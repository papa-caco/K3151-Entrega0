package dominio.prendas;

import dominio.clima.Fecha;

public abstract class Prenda {
	
	protected int talla;
	protected String genero;
	protected Estilo estilo;
	protected String sePoneEn;
	protected String uso;
	protected String idealClima;
	protected String esPara;
	protected Color color;
	
	public Prenda(int talla, String genero, Estilo estilo, String idealClima, String esPara, Color color) {
		//sin uso y sePoneEn
		super();
		this.talla = talla;
		this.genero = genero;
		this.estilo = estilo;
		this.idealClima = idealClima;
		this.esPara = esPara;
		this.color = color;
	}
	
	public Prenda(int talla,Estilo estilo, String idealClima, String esPara, Color color) {
		//sin genero, uso y sePoneEn
		super();
		this.talla = talla;
		this.estilo = estilo;
		this.idealClima = idealClima;
		this.esPara = esPara;
		this.color = color;
	}
	
	public Prenda(int talla,String genero, Estilo estilo, String esPara, Color color) {
		//sin idealClima, uso y sePoneEn
		super();
		this.talla = talla;
		this.genero = genero;
		this.estilo = estilo;
		this.esPara = esPara;
		this.color = color;
	}
	
	public Prenda(int talla,String genero, String idealClima, String esPara, Color color) {
		//sin Estilo, uso y sePoneEn
		super();
		this.talla = talla;
		this.genero = genero;
		this.idealClima = idealClima;
		this.esPara = esPara;
		this.color = color;
	}
	
	public Prenda(int talla, Estilo estilo, String esPara, Color color) {
		//sin genero, idealClima, uso y sePoneEn
		super();
		this.talla = talla;
		this.estilo = estilo;
		this.esPara = esPara;
		this.color = color;
	}

	public Prenda(int talla, String genero, String esPara, Color color) {
		//sin Estilo, idealClima, uso y sePoneEn
		super();
		this.talla = talla;
		this.genero = genero;
		this.esPara = esPara;
		this.color = color;
	}
	
	public int talla() {
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
	
	protected void setTalla(int talla) {
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
	
	public boolean idealParaClimaDe(Fecha hoy) {
		return this.idealClima() == hoy.climaActual() 
			|| this.idealClima() == hoy.condicionesClima();
	}
	
	public boolean paraPonerEn(String donde) {
		return this.sePoneEn == donde; 
	}
	
	public boolean paraUso(String unUso) {
		return this.uso == unUso; 
	}

}