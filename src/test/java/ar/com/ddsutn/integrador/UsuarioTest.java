package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class UsuarioTest {
	
	
	private Usuario lucho;
	private Usuario fede;
	private Usuario nico;
	private Usuario nicoLuis;
	
	@Before
	/*	Nico Luis no usa mock no sabe que es, expliquenle giles!
	public void setUp() {
	lucho = new UsuarioMock(1.80 , 81.0);
	fede = new UsuarioMock(1.20, 72.0);
	nico = new UsuarioMock(2.00, 60.0);
	nicoLuis = new UsuarioMock(1.70, 57.8);
	}
	*/
	
	public void setUp() {
		
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,1,18), "unaRutina", null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), "unaRutina", "Masculino");
	nico = new Usuario("nico", 60.0, 2.00, LocalDate.of(1995,1,18), "unaRutina", null);
	nicoLuis = new Usuario("nicoLuis", 57.8 , 1.70, LocalDate.of(1995,6,24) ,"unaRutina", null);
	
	}
	
	
	@Test
	
	public void imcHaceBienLaCuenta(){
		
	assertEquals ((Double) 25.0, lucho.imc()  )	;
	}
	
	@Test
	public void imcSeCalculaBienParaFede()
	{
		assertEquals ((Double)50.0 , fede.imc());
	}
	@Test
	public void imcSeCalculaBienParaNico()
	{
		assertEquals ((Double)15.0 , nico.imc());
	}

	@Test
	public void imcSeCalculaBienParaNicoLuis()
	{
		assertEquals ((Double)20.0 , nicoLuis.imc());
	}
	
	@Test
	public void esValidoParaNicoLuis()
	{
		assertEquals ((boolean)true , nicoLuis.esValido());
	}
	
	@Test
	public void noEsValidoPorqueVeganoNoPuedeTenerPollo()
	{
		fede.condiciones.add(new Vegano());  //revisar si new Vegano() es correcto
		fede.aniadirPreferencia("pollo");
		assertEquals ((boolean)false , fede.esValido());
	}
	
	@Test
	public void noEsValidoPorqueTieneQueTenerMasDe4Letras()
	{
		assertEquals ((boolean)false , nico.esValido());
	}
	
	@Test
	public void noEsValidoPorqueTieneQueTenerFecha()
	{
		assertEquals ((boolean)false , (new Usuario("carlos",  81.0, 1.80, null,"unaRutina", null)).esValido());
	}
}
