package dominio;
//import dominio.clima.*;
import dominio.persona.*;
import dominio.prenda.*;
import dominio.excepciones.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPersonaPrenda {
	private Persona jose;
	private TipoPrenda pantalonVestir;
	private List<String> prendasGabardina;
	private Tela gabardinaNegra;
	private Tela algodonNyR;
	private List<String> prendasAlgodon;
	private TipoPrenda calzoncillo;
	
	@Before
	public void init() throws TelaInapropiadaException, ColorDuplicadoException, PrendaNoLeVaException {
	this.pantalonVestir = new TipoPrenda("Pantalon","Piernas","Basico","Masculino");
	this.prendasGabardina = Arrays.asList("Pantalon","Campera","Calzoncillo");
	this.gabardinaNegra = new Tela("Gabardina","Frio",new Color("Negro"));
	this.gabardinaNegra.setParaTipoPrenda(prendasGabardina);
	this.calzoncillo = new TipoPrenda("Calzoncillo","IntimasMasculina","Interior","Masculino");
	this.algodonNyR = new Tela("Algodon","Calido",new Color("Negro"),new Color("Rojo"));
	this.prendasAlgodon = Arrays.asList("Remera","Camisa","Medias","Bombacha");
	this.algodonNyR.setParaTipoPrenda(prendasAlgodon);
	this.jose = new Persona("Jose",40,"masculino",48);
	}
	
	@Test // -- T E S T #02 --//
	public void nro02_GabardinaNoSirveParaCalzoncillo() {
		Assert.assertTrue(gabardinaNegra.aptoTipoPrenda(pantalonVestir));
	}
	
	@Test // -- T E S T #03 --//
	public void nro03_AlgodonSirveParaCalzoncillo() {
		Assert.assertTrue(jose.esVaron());
		Assert.assertFalse(jose.esMujer());
	}
}


