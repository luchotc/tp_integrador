package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import filtros.Filtro;
import filtros.FiltroCalorias;
import filtros.FiltroCaro;
import filtros.FiltroGusto;
import filtros.FiltroPosta;
import ar.com.ddsutn.condicionesExistentes.Diabetico;
import ar.com.ddsutn.condicionesExistentes.Hipertenso;
import ar.com.ddsutn.condicionesExistentes.Vegano;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioTest {
	
	private Usuario lucho;
	private Usuario fede;
	private Usuario rama;
	private Usuario nicoLuis;
	private BaseUsuarios base;
	
	@Before
	
	public void setUp() {
		base = new BaseUsuarios();
		lucho = base.getLucho();
		fede = base.getFede();
		nicoLuis = base.getNicoLuis();
		rama = base.getRama();
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
		assertEquals ((Double)15.0 , rama.imc());
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
		assertEquals ( true , nicoLuis.esValido());		
	}
	
	@Test
	public void noEsValidoPorqueVeganoNoPuedeTenerPollo()
	{
		fede.addCondicion(new Vegano());  //revisar si new Vegano() es correcto
		fede.addPreferencia("pollo");
		assertEquals ( false , fede.esValido());
	}
	
	
	@Test
	public void noEsValidoPorqueTieneQueTenerMasDe4Letras()
	{	
		assertEquals ( false , rama.esValido());	
	}
	
	@Test
	public void noEsValidoPorqueTieneQueTenerFecha()
	{
		assertEquals ( false , new Usuario("carlos",  81.0, 1.80, null,TipoRutina.MEDIANO, null).esValido()); 
	}
	
	//Tests sigueRutinaSaludable()
	@Test
	public void sigueRutinaSaludableParaNicoLuis()
	{	
		assertEquals ( true , nicoLuis.sigueRutinaSaludable());		
	}
	
	@Test
	public void sigueRutinaSaludableParaUsuarioFueraRangoIMC()
	{	
		assertEquals ( false , rama.sigueRutinaSaludable());	
	}
	
	@Test
	public void sigueRutinaSaludableParaUsuarioConCondiciones()
	{	
		lucho.addCondicion(new Diabetico());
		lucho.addCondicion(new Vegano());
		lucho.addPreferencia("frutas");
		assertEquals (true , lucho.sigueRutinaSaludable());		
	}
	@Test
	public void noSigueRutinaSaludableParaVeganoSinFrutas()
	{
		nicoLuis.addCondicion(new Vegano());
		assertEquals ( false , nicoLuis.sigueRutinaSaludable());		
	}
	
	@Test
	public void noSigueRutinaSaludableParaHipertensoSinIntensivo()
	{	
		fede.addCondicion(new Hipertenso());
		assertEquals ( false , fede.sigueRutinaSaludable());		
	}
	
	//tests agregar recetas
	@Test
	public void elUsuarioAgregaRecetaPeroNoEsValida()
	{
		Receta recetaInvalida = new Receta("Recetin", 25000);
		recetaInvalida.setIngredientes(new ArrayList<>());
		lucho.addReceta(recetaInvalida);
		assertEquals ( true, lucho.getRecetas().isEmpty() );
	}
	
	
}
