package dominio;
import dominio.clima.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClima {
	
	private Clima clima;
	private Fecha hoy;

	@Before
	public void init(){
   	this.clima = new Clima(24.0,new Cielo("Soleado"));
   	this.hoy = new Fecha(clima);
	}
    	
    @Test
     public void termicaYcondicionesClima(){
    	Assert.assertEquals("Templado",hoy.climaActual());
    	Assert.assertEquals("Soleado",hoy.condicionesClima());
    }
    
    











}
