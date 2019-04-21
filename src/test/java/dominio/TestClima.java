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
    	
    @Test // -- T E S T #01 --//
     public void nro01_consultoTermicaYcondiciones() {
    	Assert.assertEquals("Templado",hoy.climaActual());
    	Assert.assertEquals("Soleado",hoy.condicionesClima());
    }
    
    @Test // -- T E S T #02 --//
    public void nro02_cambioTermicaYcondiciones() {
    	clima.setTemperatura(27.0);
    	clima.setCielo(new Cielo("Noche"));
    	Assert.assertEquals("Calido",hoy.climaActual());
   		Assert.assertEquals("Nocturno",hoy.condicionesClima());
    }
    
    @Test // -- T E S T #03 --//
    public void nro03_otroCambioTermicaYcondiciones() {
    	clima.setTemperatura(9.0);
    	clima.setCielo(new Cielo("Lloviendo"));
    	Assert.assertEquals("Frio",hoy.climaActual());
    	Assert.assertEquals("Lluvioso",hoy.condicionesClima());
    }
    
    /*@Test // -- T E S T #04 --//
    public void verificoFechaDeHoy() {
    	Assert.assertEquals("2019-04-21",hoy.getFecha());	--Cambiar la fecha al
    	 														 momento de Testear
    }*/

}
