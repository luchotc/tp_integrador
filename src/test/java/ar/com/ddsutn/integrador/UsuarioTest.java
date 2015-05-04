package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import condicionesExistentes.Condicion;
import condicionesExistentes.Diabetico;
import condicionesExistentes.Hipertenso;
import condicionesExistentes.Vegano;

import java.time.LocalDate;
import java.util.ArrayList;

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
	// ^ Le quedan 2 commits antes de que lo elimine ^
	*/
	
	public void setUp() {
		
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,1,18), "INTENSIVO", null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), "LEVE", "Masculino");
	nico = new Usuario("nico", 60.0, 2.00, LocalDate.of(1995,1,18), "LEVE", null);
	nicoLuis = new Usuario("nicoLuis", 57.8 , 1.70, LocalDate.of(1995,6,24) ,"NADA", null);
	nicoLuis.setCondiciones(new ArrayList<Condicion>());
	nicoLuis.setPreferenciasAlimenticias(new ArrayList<String>());
	
	}
	
	//Tests imc()
	@Test
	public void imcHaceBienLaCuenta()
	{	assertEquals ((Double) 25.0, lucho.imc()  )	;	}
	@Test
	public void imcSeCalculaBienParaFede()
	{	assertEquals ((Double)50.0 , fede.imc());	}
	@Test
	public void imcSeCalculaBienParaNico()
	{	assertEquals ((Double)15.0 , nico.imc());	}
	@Test
	public void imcSeCalculaBienParaNicoLuis()
	{	assertEquals ((Double)20.0 , nicoLuis.imc());	}
	
	//Tests esValido()
	@Test
	public void esValidoParaNicoLuis()
	{	
		assertEquals ((boolean)true , nicoLuis.esValido());		}
	@Test
	public void noEsValidoPorqueVeganoNoPuedeTenerPollo()
	{
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.setPreferenciasAlimenticias(new ArrayList<String>());
		fede.añadirCondicion(new Vegano());  //revisar si new Vegano() es correcto
		fede.aniadirPreferencia("Pollo");
		assertEquals ((boolean)false , fede.esValido());
	}
	@Test
	public void noEsValidoPorqueTieneQueTenerMasDe4Letras()
	{	assertEquals ((boolean)false , nico.esValido());	}
	@Test
	public void noEsValidoPorqueTieneQueTenerFecha()
	{	assertEquals ((boolean)false , (new Usuario("carlos",  81.0, 1.80, null,"MEDIANO", null)).esValido()); 	}
	
	//Tests sigueRutinaSaludable()
	@Test
	public void sigueRutinaSaludableParaNicoLuis()
	{	assertEquals ((boolean)true , nicoLuis.sigueRutinaSaludable());		}
	@Test
	public void sigueRutinaSaludableParaUsuarioFueraRangoIMC()
	{	assertEquals ((boolean)false , nico.sigueRutinaSaludable());		}
	@Test
	public void sigueRutinaSaludableParaUsuarioConCondiciones()
	{	
		lucho.setCondiciones(new ArrayList<Condicion>());
		lucho.setPreferenciasAlimenticias(new ArrayList<String>());
		lucho.añadirCondicion(new Diabetico());
		lucho.añadirCondicion(new Vegano());
		lucho.aniadirPreferencia("frutas");
		assertEquals ((boolean)true , lucho.sigueRutinaSaludable());		
	}
	@Test
	public void noSigueRutinaSaludableParaVeganoSinFrutas()
	{
		nicoLuis.añadirCondicion(new Vegano());
		assertEquals ((boolean)false , nicoLuis.sigueRutinaSaludable());		
	}
	@Test
	public void noSigueRutinaSaludableParaHipertensoSinIntensivo()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.añadirCondicion(new Hipertenso());
		assertEquals ((boolean)false , fede.sigueRutinaSaludable());		
	}
	
	
}
