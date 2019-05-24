package dominio;
//import dominio.clima.*;
import dominio.persona.*;
import dominio.prenda.*;
import dominio.ropero.*;
import dominio.excepciones.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Collections2;
import com.google.common.primitives.Ints;

public class TestPersonaPrenda {
	private Persona jose;
	private TipoPrenda pantalonVestir;
	private List<String> prendasGabardina;
	private Tela gabardinaNegra;
	private Tela algodonNyR;
	private List<String> prendasAlgodon;
	private TipoPrenda calzoncillo;
	private Ropero ropero;
	
	@Before
	public void init() throws TelaInapropiadaException, ColorDuplicadoException, PrendaNoLeVaException {
	this.pantalonVestir = new TipoPrenda("Pantalon","Piernas","Basico");
	this.prendasGabardina = Arrays.asList("Pantalon","Campera","Calzoncillo");
	this.gabardinaNegra = new Tela("Gabardina",new Color("Negro"));
	this.gabardinaNegra.setParaTipoPrenda(prendasGabardina);
	this.calzoncillo = new TipoPrenda("Calzoncillo","IntimasMasculina","Interior");
	this.algodonNyR = new Tela("Algodon",new Color("Negro"),new Color("Rojo"));
	this.prendasAlgodon = Arrays.asList("Pantalon","Camisa","Medias","Bombacha");
	this.algodonNyR.setParaTipoPrenda(prendasAlgodon);
	this.jose = new Persona("Jose",40,"masculino",48);
	this.ropero = new Ropero("Ropero1");
	}
	
	@Test // -- T E S T #02 --//
	public void nro02_GabardinaNoSirveParaCalzoncillo() {
		Assert.assertTrue(algodonNyR.aptoTipoPrenda(pantalonVestir));
	}
	
	@Test // -- T E S T #03 --//
	public void nro03_AlgodonSirveParaCalzoncillo() {
		Assert.assertTrue(jose.esVaron());
		Assert.assertFalse(jose.esMujer());
	}
	
	@Test // -- T E S T #03 --//
	public void nro04_prueboIterar() {
		List<String> lista = new LinkedList<>();
		lista.addAll(Arrays.asList("Anibal","Alberto","Jose","Pepe","Antonio","Americo"));
		System.out.println(this.ropero.stringsStartsWithA(lista));
		Assert.assertTrue(jose.esVaron());
		Assert.assertFalse(jose.esMujer());
	}
	
	@Test // -- T E S T #05 --//
	public void nro05_listaListas() {
		Assert.assertEquals(24,this.ropero.permutations().size());
		System.out.println(this.ropero.permutations());
	}

}



