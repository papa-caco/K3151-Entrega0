package dominio;
import dominio.clima.*;
import dominio.personas.*;
import dominio.prendas.*;
import dominio.prendas.interiores.*;
import dominio.prendas.inferiores.*;
import dominio.prendas.superiores.*;
import dominio.prendas.calzado.*;
import dominio.excepciones.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPersonaPrenda {
	private Hombre jose;
	private Fecha hoy;
	private Clima clima;
	private Zapatillas zapas;
	private Pantalon pantalon;
	private Remera remera;
	private Camisa camisa;
	private Medias medias;
	private Calzoncillo calzoncillo;
	private ArrayList<Prenda> prendas;

	@Before
	public void init(){
	this.clima = new Clima(24.0,new Cielo("Soleado"));
	this.hoy = new Fecha(clima);
	this.pantalon = new Pantalon(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Azul"));
	this.medias = new Medias(48,"Masculino",new Estilo("Casual"),"Templado","Adulto",new Color("Negro"));
	this.calzoncillo = new Calzoncillo(48,new Estilo("Casual"),"Templado","Adulto",new Color("Negro"));
	this.remera = new Remera(48,"Masculino",new Estilo("Casual"),"Calido","Adulto",new Color("Rojo"));
	this.zapas = new Zapatillas(48,"Masculino","Templado","Adulto",new Color("Azul"));
	this.camisa = new Camisa(50,"Masculino",new Estilo("Formal"),"Frio","Anciano",new Color("Blanca"));
	this.jose = new Hombre("Jose",35,48,new Estilo("Casual"), prendas);
	}
	
	@Test // -- T E S T #01 -- //
	public void nro01_aJoseLeVaBienPantalon() {
		Assert.assertTrue(jose.leCalzaBien(pantalon));
		Assert.assertEquals(0,jose.getPrendas().size());
		Assert.assertTrue(jose.estaDesnudo());
	}
	
	@Test // -- T E S T #02 --//
	public void nro02_joseNoPuedeUsarZapatillas() {
		Assert.assertFalse(jose.leCalzaBien(zapas));
		jose.setEstilo(new Estilo("Deportivo"));
		Assert.assertTrue(jose.leCalzaBien(zapas));
	}
	
	@Test // -- T E S T #03 --//
	public void nro03_estaFrescoParaRemera() {
		Assert.assertFalse(remera.idealParaClimaDe(hoy));
		Assert.assertTrue(remera.idealClima() == "Calido");
		System.out.println("TEST #03 - El clima de hoy, " + hoy.getFecha() + ", es: " + hoy.condicionesClima());
		clima.setTemperatura(30.0);
		Assert.assertTrue(remera.idealParaClimaDe(hoy));
	}
	
	@Test // -- T E S T #04 --//
	public void nro04_joseSePoneVariasPrendasQueLeVan() {
		try {
			jose.sePone(medias);
			jose.sePone(calzoncillo);
			jose.sePone(pantalon);
			jose.sePone(remera);
			System.out.println("TEST #04 - Jose tiene en total: " + jose.getPrendas().size() + " prendas puestas.");
			Assert.assertEquals(4,jose.getPrendas().size());
		}
		catch (PrendaNoLeVaException exception) {
            System.out.println("TEST #04 " + exception.getMessage());
		}
	}
	
	@Test // -- T E S T #05 --//
	public void nro05_joseSePoneCamisaYnoLeVa() {
		try {
			jose.sePone(camisa);
			Assert.assertEquals(1,jose.getPrendas().size());
		}
		catch (PrendaNoLeVaException exception) {
            System.out.println("TEST #05 - " + exception.getMessage());
		}
	}

	@Test // -- T E S T #06 --//
	public void nro06_joseEnvejecioYpuedeUsarCamisaDelAbuelo() {
		Assert.assertFalse(jose.leCalzaBien(camisa));
		jose.setEstilo(new Estilo("Formal"));
		jose.setTalla(50);
		jose.setEdad(78);
		Assert.assertTrue(jose.leCalzaBien(camisa));
	}

}
