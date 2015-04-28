package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	
	private Usuario lucho;
	
	@Before
	
	public void setUp() {
	lucho = new Usuario(1.80 , 81.0);
	
	}
	
	@Test
	
	public void imcHaceBienLaCuenta(){
		
	assertEquals ((Double) 25.0, lucho.imc()  )	;
	}
	

}
