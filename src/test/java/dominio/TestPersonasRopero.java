package dominio;
import dominio.clima.*;
import dominio.personas.*;
import dominio.ropero.*;
import dominio.prendas.*;
import dominio.prendas.interiores.*;
import dominio.prendas.inferiores.*;
import dominio.prendas.superiores.*;
import dominio.prendas.calzado.*;
import dominio.excepciones.*;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPersonasRopero {
	private Hombre jose;
	private Mujer maria;
	private Fecha hoy;
	private Clima climaHoy;
	private Fecha maniana;
	private Clima climaManiana;
	private Calzoncillo calzoncillo;
	private Corpino corpino;
	private Bombacha bombacha;
	private Medias mediasH;
	private Medias mediasM;
	private Zapatos zapatos;
	private Zapatillas zapas;
	private Pantalon pantalon;
	private Bermuda bermuda;
	private Calza calza;
	private Shorcito shorcito;
	private Pollera pollera;
	private Camisa camisa;
	private Remera remeraH;
	private Remera musculosa;
	private Remera remeraM;
	private ArrayList<Prenda> prendasJose;
	private ArrayList<Prenda> prendasMaria;
	private List<Prenda> prendasRopero;
	private Ropero ropero;
	
	@Before
	public void init(){
		this.climaHoy = new Clima(24.0,new Cielo("Nuboso"));
		this.hoy = new Fecha(climaHoy);
		this.climaManiana = new Clima(29.0,new Cielo("Soleado"));
		this.maniana = new Fecha(climaManiana);
		this.mediasH = new Medias(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Negro"));
		this.mediasM = new Medias(37,"Femenino",new Estilo("Deportivo"),"Calido","Adulto",new Color("Blanco"));
		this.calzoncillo = new Calzoncillo(48,new Estilo("Casual"),"Templado","Adulto",new Color("Azul"));
		this.bombacha = new Bombacha(37,new Estilo("Deportivo"),"Calido","Adulto",new Color("Rosa"));
		this.corpino = new Corpino(37,new Estilo("Deportivo"),"Calido","Adulto",new Color("Blanco"));
		this.zapatos = new Zapatos(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Negro"));
		this.zapas = new Zapatillas(37,"Femenino","Calido","Adulto",new Color("Marron"));
		this.remeraH = new Remera(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Celeste"));
		this.camisa = new Camisa(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Blanco"));
		this.remeraM = new Remera(37,"Femenino",new Estilo("Deportivo"),"Calido","Adulto",new Color("Amarillo"));
		this.musculosa = new Remera(37,"Femenino",new Estilo("Deportivo"),"Calido","Adulto",new Color("Fucsia"));
		this.pantalon = new Pantalon(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Azul"));
		this.bermuda = new Bermuda(48,"Masculino",new Estilo("Casual"),"Adulto",new Color("Gris"));
		this.calza = new Calza(37,"Femenino","Calido","Adulto",new Color("Negro"));
		this.shorcito = new Shorcito(37,"Femenino","Adulto",new Color("Rojo"));
		this.pollera = new Pollera(37,new Estilo("Deportivo"),"Calido","Adulto",new Color("Amarillo"));
		this.prendasJose = new ArrayList<>();
		this.prendasMaria = new ArrayList<>();
		this.prendasRopero = new LinkedList<>();
		this.jose = new Hombre("Jose",35,48,new Estilo("Casual"), prendasJose);
		this.maria = new Mujer("Maria",30,37,new Estilo("Deportivo"), prendasMaria);
		this.ropero = new Ropero("NuestroRopero",30,prendasRopero);
		this.ropero.getPrendas().addAll(Arrays.asList(calzoncillo,bombacha,corpino,mediasH,mediasM,zapatos,zapas,
				remeraH,camisa,remeraM,musculosa,pantalon,bermuda,calza,shorcito,pollera));
	}
	
	@Test // -- T E S T  #01 --//
	public void nro01_chequeoCapacidadRopero() {
		System.out.println("TEST #01 - Los colores de las prendas cargadas son: " + ropero.getPrendas().toString()); 
		Assert.assertFalse(ropero.fullCapacidad());
		Assert.assertEquals(14,ropero.capacidadDisponible());
	}
	
	@Test // -- T E S T  #02 --//
	public void nro02_sacoLasMediasYchequeoCapacidadRopero() {
		try {
			LinkedList<Prenda> medias = new LinkedList<>();
			medias.addAll(Arrays.asList(mediasH,mediasM));
			this.ropero.entregaDePrendas(medias);
			Assert.assertEquals(16,this.ropero.capacidadDisponible());
		}
		catch (SinPrendasException exception) {
			System.out.println("TEST #02 " + exception.getMessage());
		}
	}
	
	@Test // -- T E S T  #03 --//
	public void nro03_sacoTodoEintentoSacarUnaMas() {
		try {
			LinkedList<Prenda> todo = new LinkedList<>();
			todo.addAll(Arrays.asList(calzoncillo,bombacha,corpino,mediasH,mediasM,zapatos,zapas,
					remeraH,camisa,remeraM,musculosa,pantalon,bermuda,calza,shorcito,pollera));
			this.ropero.entregaDePrendas(todo);
			this.ropero.entregaPrenda(calza);
			Assert.assertEquals(30,this.ropero.capacidadDisponible());
		}
		catch (RoperoVacioException exception) {
			System.out.println("TEST #03 " + exception.getMessage());
		}
		catch (SinPrendasException exception) {
			System.out.println("TEST #03 " + exception.getMessage());
		}
	}

	@Test // -- T E S T  #04 -- //
	public void nro04_intentoSacarMasPrendasDeLasQueHay() {
		try {
			LinkedList<Prenda> todo = new LinkedList<>();
			todo.addAll(Arrays.asList(calzoncillo,bombacha,corpino,mediasH,mediasM,zapatos,zapas,
					remeraH,camisa,remeraM,musculosa,calza,corpino,pantalon,bermuda,calza,shorcito,pollera));
			this.ropero.entregaDePrendas(todo);
			Assert.assertEquals(30,this.ropero.capacidadDisponible());
		}
		catch (SinPrendasException exception) {
			System.out.println("TEST #04 " + exception.getMessage());
		}
	}
	
	@Test // -- T E S T  #05 -- //
	public void nro05_cargoMasPrendasYchequeoCapacidad() {
		try {
			LinkedList<Prenda> masPrendas = new LinkedList<>();
			masPrendas.addAll(Arrays.asList(corpino,zapatos,zapas,remeraH,camisa,remeraM,
										musculosa,pantalon,bermuda,calza,shorcito,pollera,mediasH,mediasM));
			this.ropero.recepcionDePrendas(masPrendas);
			Assert.assertEquals(0,this.ropero.capacidadDisponible());
		}
		catch (RoperoFullException exception) {
			System.out.println("TEST #05 " + exception.getMessage());
		}
	}

	@Test // -- T E S T  #06 -- //
	public void nro06_cargoMasPrendasDeLasCabenEnElRopero() {
		try {
			LinkedList<Prenda> masPrendas = new LinkedList<>();
			masPrendas.addAll(Arrays.asList(corpino,bombacha,calzoncillo,zapatos,zapas,remeraH,camisa,remeraM,
										musculosa,pantalon,bermuda,calza,shorcito,pollera,mediasH,mediasM));
			this.ropero.recepcionDePrendas(masPrendas);
			Assert.assertEquals(0,this.ropero.capacidadDisponible());
		}
		catch (RoperoFullException exception) {
			System.out.println("TEST #06 " + exception.getMessage());
		}
	}
	
	@Test // -- T E S T  #07 -- //
	public void nro07_joseSeVisteYdespuesSePoneEnBolas() {
		try {
			jose.sePone(mediasH);
			jose.sePone(calzoncillo);
			jose.sePone(pantalon);
			jose.sePone(remeraH);
			Assert.assertEquals(4,jose.getPrendas().size());
			jose.desvestirse(ropero);
			Assert.assertTrue(jose.estaDesnudo());
			Assert.assertEquals(10,this.ropero.capacidadDisponible());
		}
		catch (PrendaNoLeVaException exception) {
            System.out.println("TEST #07 " + exception.getMessage());
		}
		catch (RoperoFullException exception) {
			System.out.println("TEST #07 " + exception.getMessage());
		}
	}
	
	@Test // -- T E S T  #08 -- //
	public void nro08_mariaSeVisteYdespuesSeQuitaTodo() {
		try {
			maria.sePone(mediasM);
			maria.sePone(corpino);
			maria.sePone(bombacha);
			maria.sePone(remeraM);
			maria.sePone(calza);
			Assert.assertTrue(!maria.estaDesnudo());
			System.out.println("TEST #08 " + maria.getPrendas().toString());
			Assert.assertEquals(5,maria.getPrendas().size());
			maria.desvestirse(ropero);
			Assert.assertTrue(maria.estaDesnudo());
			Assert.assertEquals(9,this.ropero.capacidadDisponible());
		}
		catch (PrendaNoLeVaException exception) {
            System.out.println("TEST #08 " + exception.getMessage());
		}
		catch (RoperoFullException exception) {
			System.out.println("TEST #08 " + exception.getMessage());
		}
	}
	
	@Test // -- T E S T  #09 -- //
	public void nro09_josePideSugerenciaParaHoy() {
		try {
			List<Prenda> sugerenciaJose = jose.pedirSugerencia(ropero, hoy);
			System.out.println("TEST #09 " + sugerenciaJose.toString());
			Assert.assertEquals(5,sugerenciaJose.size());
			}
			catch (SinPrendasException exception) {
				System.out.println("TEST #09 " + exception.getMessage());
			}
		}
	
	@Test // -- T E S T  #10 -- //
	public void nro10_josePideSugerenciaParaManianaYnoTienePilchasDeVerano() {
		try {
			List<Prenda> sugerenciaJose = jose.pedirSugerencia(ropero, maniana);
			Assert.assertEquals(55,sugerenciaJose.size());
			}
		catch (SinPrendasException exception) {
			System.out.println("TEST #10 " + exception.getMessage());
			}
	}

	@Test // -- T E S T  #11//
	public void nro11_mariaPideSugerenciaParaManiana() {
		try {
			List<Prenda> sugerenciaMaria = maria.pedirSugerencia(ropero, maniana);
			Assert.assertEquals(6,sugerenciaMaria.size());
			}
		catch (SinPrendasException exception) {
				System.out.println("TEST #11 " + exception.getMessage() );
			}
	}
	
	@Test // -- T E S T  #12//
	public void nro12_mariaPideSugerenciaParaHoyYnoConsiguePrendas() {
		try {
			List<Prenda> sugerenciaMaria = maria.pedirSugerencia(ropero, hoy);
			Assert.assertEquals(8,sugerenciaMaria.size());
			}
		catch (SinPrendasException exception) {
				System.out.println("TEST #12 " + exception.getMessage() );
			}
	}
	
	@Test // -- T E S T  #13//
	public void nro13_joseSeVisteConSugerenciaDeHoy() {
		try {
			Assert.assertTrue(jose.estaDesnudo());
			jose.vestirSugerencia(ropero, hoy);
			System.out.println("TEST #13 " + jose.getPrendas().toString());
			Assert.assertTrue(!jose.estaDesnudo());
			Assert.assertEquals(5,jose.getPrendas().size());
			Assert.assertEquals(19,ropero.capacidadDisponible());
			}
		catch (SinPrendasException exception) {
				System.out.println("TEST #13 " + exception.getMessage());
			}
		catch (RoperoFullException exception) {
			System.out.println("TEST #13 " + exception.getMessage());
		}
	}

	@Test // -- T E S T  #14//
	public void nro14_mariaSeVisteConSugerenciaDeManiana() {
		try {
			Assert.assertTrue(maria.estaDesnudo());
			maria.vestirSugerencia(ropero, maniana);
			Assert.assertTrue(!maria.estaDesnudo());
			Assert.assertEquals(6,maria.getPrendas().size());
			Assert.assertEquals(20,ropero.capacidadDisponible());
			}
		catch (SinPrendasException exception) {
				System.out.println("TEST #14 " + exception.getMessage());
			}
		catch (RoperoFullException exception) {
			System.out.println("TEST #14 " + exception.getMessage());
		}
	}
	
}
