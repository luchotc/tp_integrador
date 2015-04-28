package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	
	private Usuario lucho;
	private Usuario fede;
	
	@Before
	
	public void setUp() {
	lucho = new Usuario(1.80 , 81.0);
	fede = new Usuario(1.20, 72.0);
	
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

}
