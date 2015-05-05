package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.ddsutn.condicionesExistentes.Condicion;
import ar.com.ddsutn.condicionesExistentes.Diabetico;
import ar.com.ddsutn.condicionesExistentes.Hipertenso;
import ar.com.ddsutn.condicionesExistentes.Vegano;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioTest {
	
	
	private Usuario lucho;
	private Usuario fede;
	private Usuario nico;
	private Usuario nicoLuis;
	
	@Before
	
	public void setUp() {
		
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,3,20), "INTENSIVO", null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), "LEVE", "Masculino");
	nico = new Usuario("nico", 60.0, 2.00, LocalDate.of(1994,03,29), "LEVE", null);
	nicoLuis = new Usuario("nicoLuis", 57.8 , 1.70, LocalDate.of(1995,6,24) ,"NADA", null);
	nicoLuis.setCondiciones(new ArrayList<Condicion>());
	nicoLuis.setPreferenciasAlimenticias(new ArrayList<String>());
	
	}
	
	//Tests imc()
	@Test
	public void imcHaceBienLaCuenta()
	{	
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
	
	//Tests esValido()
	@Test
	public void esValidoParaNicoLuis()
	{	
		assertEquals ((boolean)true , nicoLuis.esValido());		
	}
	
	@Test
	public void noEsValidoPorqueVeganoNoPuedeTenerPollo()
	{
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.setPreferenciasAlimenticias(new ArrayList<String>());
		fede.addCondicion(new Vegano());  //revisar si new Vegano() es correcto
		fede.addPreferencia("pollo");
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
		assertEquals ((boolean)false , (new Usuario("carlos",  81.0, 1.80, null,"MEDIANO", null)).esValido()); 
	}
	
	//Tests sigueRutinaSaludable()
	@Test
	public void sigueRutinaSaludableParaNicoLuis()
	{	
		assertEquals ((boolean)true , nicoLuis.sigueRutinaSaludable());		
	}
	
	@Test
	public void sigueRutinaSaludableParaUsuarioFueraRangoIMC()
	{	
		assertEquals ((boolean)false , nico.sigueRutinaSaludable());	
	}
	
	@Test
	public void sigueRutinaSaludableParaUsuarioConCondiciones()
	{	

		lucho.setCondiciones(new ArrayList<Condicion>());
		lucho.setPreferenciasAlimenticias(new ArrayList<String>());
		lucho.addCondicion(new Diabetico());
		lucho.addCondicion(new Vegano());

		lucho.addPreferencia("frutas");
		assertEquals ((boolean)true , lucho.sigueRutinaSaludable());		
	}
	@Test
	public void noSigueRutinaSaludableParaVeganoSinFrutas()
	{
		nicoLuis.addCondicion(new Vegano());
		assertEquals ((boolean)false , nicoLuis.sigueRutinaSaludable());		
	}
	
	@Test
	public void noSigueRutinaSaludableParaHipertensoSinIntensivo()
	{	

		fede.setCondiciones(new ArrayList<Condicion>());
		fede.addCondicion(new Hipertenso());

		assertEquals ((boolean)false , fede.sigueRutinaSaludable());		
	}
	
	@Test
	public void elUsuarioAgregaRecetaPeroNoEsValida()
	{
		Receta recetaInvalida = new Receta("Recetin", 25000);
		recetaInvalida.setIngredientes(new ArrayList<>());
		lucho.setRecetas(new ArrayList<>());
		lucho.addReceta(recetaInvalida);
		assertEquals ( (boolean)true, lucho.getRecetas().isEmpty() );
	}
	
	
}
