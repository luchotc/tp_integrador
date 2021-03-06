package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import filtros.*;
import ar.com.ddsutn.resultados.*;
import ar.com.ddsutn.Comparadores.*;
import ar.com.ddsutn.condicionesExistentes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RecetaTest {
	
	private Usuario lucho;
	private Usuario fede;
	private Receta bifes;
	private BaseUsuarios usuarios;
	private BaseRecetas recetas;
	
	@Before
	public void setUp() {
		iniciarBases();
		crearUsuarios();
		crearRecetas();
		Receta.RecetasPublicas = new ArrayList<Receta>();
		inicializarSubReceta();
	}
	
	private void iniciarBases() {
		usuarios = new BaseUsuarios();
		recetas = new BaseRecetas();		
	}
	
	private void crearUsuarios() {
		lucho = usuarios.getLucho();
		fede = usuarios.getFede();
	}
	
	private void crearRecetas()
	{
		bifes = recetas.getBifes();
	}

	private void inicializarSubReceta() {
		bifes.addSubReceta(recetas.subRecetaCualquiera());
	}
	
	
	
	//Tests condimentos
	@Test
	public void condimentoConCN()
	{
		Condimento azucar = new Condimento ("Azucar","C/N");
		assertEquals ((Double) 0.0 , azucar.getCantidad());
	}
	@Test
	public void condimentoConValorNormal()
	{
		Condimento azucar = new Condimento ("Azucar",70.0);
		assertEquals ((Double) 70.0 , azucar.getCantidad());
	}
	
	//Tests Receta Valida
	@Test
	public void unaRecetaEsValida()
	{	
		assertEquals ( true , bifes.esValida());	
	}
	
	@Test
	public void unaRecetaNoEsValidaPorNoTenerIngredientes()
	{
		Receta otraReceta = new Receta("otra Receta",1500);
		otraReceta.setIngredientes(new ArrayList<Ingrediente>());
		assertEquals ( false , otraReceta.esValida());		
	}
	
	@Test
	public void unaRecetaNoEsValidaPorNoTenerRangoEntre10Y5000()
	{
		Receta otraReceta = new Receta("otra Receta",8000);
		otraReceta.setIngredientes(new ArrayList<Ingrediente>());
		assertEquals ( false , otraReceta.esValida());		
	}
	
	//Tests Receta inadecuada
	@Test
	public void esInadecuadaParaDiabeticoConMasDe100grDeAzucar()
	{	
		fede.addCondicion(new Diabetico());
		bifes.addCondimentos(new Condimento("Azucar", 150.00));
		assertEquals ( true , fede.esInadecuada(bifes));		
	}
	
	@Test
	public void alVeganoNoLeCabeElChori()
	{	
		fede.addCondicion(new Vegano());
		bifes.addIngrediente(new Ingrediente("chori", 1.00));
		assertEquals ( true , fede.esInadecuada(bifes));		
	}
	
	@Test
	public void esInadecuadaParaHipertensoConSal()
	{	
		fede.addCondicion(new Hipertenso());
		assertEquals ( true , fede.esInadecuada(bifes));	
	}
	
	// Tests Igualdad entre Recetas
	@Test
	public void unaRecetaEsIgualAOtra()
	{
		Receta unaReceta = new Receta ("UnaReceta",90,"invierno");
		Receta otraReceta = new Receta ("UnaReceta",90,"invierno");
		
		unaReceta.setCondimentos(new ArrayList<>());
		otraReceta.setCondimentos(new ArrayList<>());

		unaReceta.setIngredientes(new ArrayList<>());
		otraReceta.setIngredientes(new ArrayList<>());

		unaReceta.setExplicaciones(new ArrayList<>());
		otraReceta.setExplicaciones(new ArrayList<>());

		unaReceta.setSubRecetas(new ArrayList<>());
		otraReceta.setSubRecetas(new ArrayList<>());

		unaReceta.setDificultad("facil");
		otraReceta.setDificultad("facil");
		
		assertEquals ( true, unaReceta.equals(otraReceta));
	}
	
	@Test
	public void unaRecetaNoEsIgualAOtraPorqueTienenDistintoNombre()
	{
		Receta unaReceta = new Receta ("UnaReceta",90,"invierno");
		Receta otraReceta = new Receta ("OtraReceta",90,"invierno");
		
		unaReceta.setCondimentos(new ArrayList<>());
		otraReceta.setCondimentos(new ArrayList<>());

		unaReceta.setIngredientes(new ArrayList<>());
		otraReceta.setIngredientes(new ArrayList<>());

		unaReceta.setExplicaciones(new ArrayList<>());
		otraReceta.setExplicaciones(new ArrayList<>());

		unaReceta.setSubRecetas(new ArrayList<>());
		otraReceta.setSubRecetas(new ArrayList<>());

		unaReceta.setDificultad("facil");
		otraReceta.setDificultad("facil");
		
		assertEquals ( false, unaReceta.equals(otraReceta));
	}
	
	// Tests visualizacion Receta
	@Test
	public void usuarioPuedeVerUnaRecetaPropia()
	{	
		fede.addReceta(bifes);
		assertEquals ( true , fede.esRecetaPropia(bifes));
		assertEquals ( true , fede.puedeVerOModificar(bifes));		
	}
	
	@Test
	public void usuarioPuedeVerUnaRecetaAjena()
	{	
		Grupo lasSuris = new Grupo ("Suricatas");
		Grupo adrianYLosDados = new Grupo ("Adrian y los Dados Negros");
		
		lasSuris.setUsuarios(new ArrayList<Usuario>());
		adrianYLosDados.setUsuarios(new ArrayList<Usuario>());
		
		lasSuris.agregarUsuario(lucho);
		adrianYLosDados.agregarUsuario(fede);
		
		fede.addReceta(bifes);
		
		assertEquals ( false , lucho.esRecetaPropia(bifes));
		assertEquals ( false , lucho.puedeVerOModificar(bifes));		
	}
	
	@Test
	public void usuarioPuedeVerUnaRecetaPublica()
	{	
		Receta.addRecetasPublicas(bifes);

		assertEquals ( false , fede.esRecetaPropia(bifes));
		assertEquals ( false , lucho.esRecetaPropia(bifes));
		assertEquals ( true , fede.puedeVerOModificar(bifes));
		assertEquals ( true , lucho.puedeVerOModificar(bifes));	
	}
	
	// Tests sugerencia
	@Test
	public void unaRecetaNoPuedeSugerirseAUnUsuario()
	{
		fede.addDisgusto("paella");
		bifes.addIngrediente(new Ingrediente ("paella",50.0));
		assertEquals(false, fede.puedeSugerir(bifes));
	}
	/*@Test
	public void unaRecetaPuedeSugerirseAUnUsuario()
	{
		assertEquals(true,lucho.puedeSugerir(bifes));
	}*/
	
	// Es cara una receta
	@Test
	public void unaRecetaEsCara()
	{
		bifes.addIngrediente(new Ingrediente("lomo",10.0));
		assertEquals(true,bifes.esCara());
	}
	
	@Test
	public void unaRecetaNoEsCara()
	{
		assertEquals(false,bifes.esCara());
	}

	
	// Tests filtros por decorator
	@Test
	public void filtroCaro()
	{
		//Filtro filtroso = new FiltroCaro(new FiltroCalorias(new FiltroGusto(new FiltroPosta())));
		Filtro filtroCaro = new FiltroCaro(new FiltroPosta());
		lucho.addReceta(bifes);
		lucho.addReceta(recetas.getComidaTop());
		lucho.addReceta(recetas.getSuperChori());
		Collection<Receta> recetasTotales = lucho.getRecetasTotales();
		recetasTotales = recetasTotales.stream().filter(receta -> filtroCaro.filtrar(receta, lucho)).collect(Collectors.toList());
		Collection<Receta> recetasFiltradas = new HashSet<>();
		recetasFiltradas.add(bifes);
		recetasFiltradas.add(recetas.getSuperChori());
		
		assertEquals(true,new HashSet<Receta>(recetasTotales).equals(recetasFiltradas));
	}
	
	// Test Filtro por Decorator
	
	@Test
	public void filtroCaroDisgustosoDecorator()
	{
		Filtro filtroCaro = new FiltroCaro(new FiltroGusto(new FiltroPosta()));
		lucho.addReceta(bifes);
		lucho.addReceta(recetas.getComidaTop());
		lucho.addReceta(recetas.getSuperChori());
		lucho.addDisgusto("caca");
		Collection<Receta> recetasTotales = lucho.getRecetasTotales();
		recetasTotales = recetasTotales.stream().filter(receta -> filtroCaro.filtrar(receta, lucho)).collect(Collectors.toList());

		Collection<Receta> recetasFiltradas = new HashSet<>();
		recetasFiltradas.add(bifes);
		
		assertEquals(true,new HashSet<Receta>(recetasTotales).equals(recetasFiltradas));
	}
	
	// Test Filtro por Strategy
	
	@Test
	public void filtroCaroDisgustosoStrategy()
	{
		lucho.setFiltros(new HashSet<Filtro> ());
		lucho.addReceta(bifes);
		lucho.addReceta(recetas.getComidaTop());
		lucho.addReceta(recetas.getSuperChori());
		lucho.addDisgusto("caca");
		lucho.addFiltro(new FiltroCaro());
		lucho.addFiltro(new FiltroGusto());
		Set <Receta> recetasTotales = new HashSet<Receta>();
		recetasTotales = lucho.getRecetasTotales();
		
		recetasTotales = lucho.filtrarConStrategy(recetasTotales);
		
		Collection<Receta> recetasFiltradas = new HashSet<>();
		recetasFiltradas.add(bifes);
		
		assertEquals(true,new HashSet<Receta>(recetasTotales).equals(recetasFiltradas));
	}
	
	
	// Test Resultado por Decorator
	@Test
	public void aplicarResultadosDecorator()
	{
		lucho.addReceta(recetas.getRecetinInadecuada());
		lucho.addReceta(recetas.getSuperChori());
		lucho.addReceta(bifes);
		lucho.addReceta(recetas.getComidaTop());
		lucho.addDisgusto("caca");
		Collection<Receta> recetasTotales = lucho.getRecetasTotales();
		Resultado resultadoParOrdenado = new ResultadoPar(new ResultadoOrdenamiento(new ResultadoPosta(), new ComparadorAlfabetico())); 
		recetasTotales = resultadoParOrdenado.resultar(recetasTotales);
		
		
		Collection<Receta> recetasFiltradas = new HashSet<>();
		recetasFiltradas.add(bifes);
		recetasFiltradas.add(recetas.getComidaTop());

		
		
		assertEquals(true,new HashSet<Receta>(recetasTotales).equals(recetasFiltradas));
	}
	
	
	
	// Test Resultado por Strategy
		@Test
		public void aplicarResultadosStrategy()
		{
			lucho.setResultados(new HashSet<Resultado> ());
			lucho.addReceta(bifes);
			lucho.addReceta(recetas.getSuperChori());
			lucho.addDisgusto("caca");
			lucho.addReceta(recetas.getRecetinInadecuada());
			lucho.addReceta(recetas.getComidaTop());
			lucho.addResultado(new ResultadoPar() );
			lucho.addResultado(new ResultadoOrdenamiento(new ComparadorAlfabetico()) );
			
			Collection<Receta> recetasTotales = lucho.getRecetasTotales();
			
			recetasTotales = lucho.resultarConStrategy(recetasTotales);
			
			Collection<Receta> recetasFiltradas = new HashSet<>();
			recetasFiltradas.add(recetas.getComidaTop());
			recetasFiltradas.add(recetas.getSuperChori());	
			
			assertEquals(true,new HashSet<Receta>(recetasTotales).equals(recetasFiltradas));
		}
}

