package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	
	private Usuario lucho;
	private Usuario fede;
	private Usuario nico;
	private Usuario nicoLuis;
	
	@Before
	
	public void setUp() {
	lucho = new UsuarioMock(1.80 , 81.0);
	fede = new UsuarioMock(1.20, 72.0);
	nico = new UsuarioMock(2.00, 60.0);
	nicoLuis = new UsuarioMock(1.70, 57.8);
	
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
}
