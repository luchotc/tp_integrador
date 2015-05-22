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
import java.util.Collection;

public class RecetaTest {
	
	
	private Usuario lucho;
	private Usuario fede;
	private UsuarioMock fedeMock ;
	private Receta bifes;
	private Receta unaSubReceta;
	Collection <String> explicaciones = new ArrayList<String>();
	Collection <Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	Collection <Condimento> condimentos = new ArrayList<Condimento>();
	Collection <Receta> subRecetas = new ArrayList<Receta>();
	Collection <Ingrediente> ingredientesSubReceta = new ArrayList<Ingrediente>();
	Collection <Condimento> condimentosSubReceta = new ArrayList<Condimento>();
	Collection <String> explicacionesSubReceta = new ArrayList<String>();
	
	@Before
	public void setUp() {
		
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,1,18), TipoRutina.INTENSIVO, null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), TipoRutina.LEVE, "Masculino");
	fedeMock = new UsuarioMock("federico", 72.0, 1.20, LocalDate.of(1995,1,18), TipoRutina.LEVE, "Masculino");
	
	Receta.RecetasPublicas = new ArrayList<Receta>();
	
	inicializarReceta();
	inicializarSubReceta();
	
	}

	private void inicializarReceta()
	{
		bifes = new Receta("Bifes a la criolla con papas y arvejas", 785, "Todas");
		
		ingredientes.add(new Ingrediente("Cuadril", 3.0));
		ingredientes.add(new Ingrediente("Papas", 1.5));
		ingredientes.add(new Ingrediente("Tomates triturados", 1.5));
		ingredientes.add(new Ingrediente("Morr�n rojo", 4.0));
		ingredientes.add(new Ingrediente("Morr�n amarillo", 4.0));
		ingredientes.add(new Ingrediente("Morr�n verde", 4.0));
		ingredientes.add(new Ingrediente("Cebollas", 1.0));
		ingredientes.add(new Ingrediente("Aceite de oliva", 2.0));
		ingredientes.add(new Ingrediente("Huevos", 20.0));
		ingredientes.add(new Ingrediente("Tomate perita", 1.0));
		ingredientes.add(new Ingrediente("Pur� de tomate", 500.0));
		ingredientes.add(new Ingrediente("Arvejas congeladas", 500.0));
		condimentos.add(new Condimento("Aj� molido", 0.0));
		condimentos.add(new Condimento("Ajo picado", 1.0));
		condimentos.add(new Condimento("Perejil picado", 0.0));
		condimentos.add(new Condimento("Or�gano", 0.0));
		condimentos.add(new Condimento("Sal", 0.0));
		condimentos.add(new Condimento("Pimienta", 0.0));
		condimentos.add(new Condimento("Hojas de laurel", 0.0));
		condimentos.add(new Condimento("Caldo de verdura o carne", 0.0));
		explicaciones.add("Limpiar el morr�n. Cortar en tiras a lo largo y reservar");
		explicaciones.add("Pelar y cortar las papas en rodajas gruesitas, cortar la cebolla en juliana");
		explicaciones.add("Rociar levemente con aceite de oliva a la paellera");
		explicaciones.add("Pasar la carne por harina (para que se dore mejor) luego disponerla sobre la paella (previamente aceitada). Retirar la carne una vez sellada vuelta y vuelta");
		explicaciones.add("En la misma paellera colocar una capa de cebolla cortada en juliana, pimientos en juliana, luego una capa de rodajas de papas, rodajas de tomates. Agregar la carne, condimentar por encima");
		explicaciones.add("Una vez dispuestos todos los ingredientes en el disco con la sal, la pimienta, el or�gano, el laurel y el aj� molido, incorporar pur� de tomate y caldo de verdura hasta cubrir la totalidad de la preparaci�n");
		explicaciones.add("Cuando las papas tomen color, indicar� que la preparaci�n est� lista (la cocci�n total luego de agregar las papas lleva 20 minutos aproximadamente)");
		explicaciones.add("Agregar los huevos, chasc�ndolos previamente por separado y luego volcarlos encima de los bifes. Sumar las arvejas y espolvorear con perejil picado toda la preparaci�n");
		
		bifes.setIngredientes(ingredientes);
		bifes.setCondimentos(condimentos);
		bifes.setExplicaciones(explicaciones);
		bifes.setSubRecetas(new ArrayList<Receta>());
		bifes.setDificultad("Media");
	}
	
	private void inicializarSubReceta() {
		unaSubReceta = new Receta("una subReceta", 250, "Todas");
		
		ingredientesSubReceta.add(new Ingrediente("un ingrediente", 4.5));
		ingredientesSubReceta.add(new Ingrediente("otro ingrediente", 5.0));
		ingredientesSubReceta.add(new Ingrediente("un ingrediente mas", 1.0));
		condimentosSubReceta.add(new Condimento("un condimento", 0.0));
		condimentosSubReceta.add(new Condimento("otro condimento", 1.0));
		explicacionesSubReceta.add("Hola, soy una explicacion");
		explicacionesSubReceta.add("Hola, yo soy la segunda parte");
		explicacionesSubReceta.add("y yo la tercera parte");
		
		unaSubReceta.setIngredientes(ingredientesSubReceta);
		unaSubReceta.setCondimentos(condimentosSubReceta);
		unaSubReceta.setExplicaciones(explicacionesSubReceta);
		unaSubReceta.setSubRecetas(new ArrayList<Receta>());
		unaSubReceta.setDificultad("Facil");
		
		subRecetas.add(unaSubReceta);
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
		assertEquals ( false , otraReceta.esValida());		}
	
	//Tests Receta inadecuada
	@Test
	public void esInadecuadaParaDiabeticoConMasDe100grDeAzucar()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.getCondiciones().add(new Diabetico());
		bifes.addCondimentos(new Condimento("Azucar", 150.00));
		assertEquals ( true , fede.esInadecuada(bifes));		
	}
	
	@Test
	public void alVeganoNoLeCabeElChori()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.getCondiciones().add(new Vegano());
		bifes.addIngrediente(new Ingrediente("chori", 1.00));
		assertEquals ( true , fede.esInadecuada(bifes));		
	}
	
	@Test
	public void esInadecuadaParaHipertensoConSal()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.getCondiciones().add(new Hipertenso());
		assertEquals ( true , fede.esInadecuada(bifes));	
	}
	
	// Tests Igualdad entre Recetas
	@Test
	public void unaRecetaEsIgualAOtra()
	{
		Receta unaReceta = new Receta ("UnaReceta",90,"invierno");
		Receta otraReceta = new Receta ("UnaReceta",90,"invierno");
		unaReceta.setCondimentos(condimentos);
		unaReceta.setIngredientes(ingredientes);
		unaReceta.setExplicaciones(explicaciones);
		unaReceta.setSubRecetas(subRecetas);
		unaReceta.setDificultad("facil");
		otraReceta.setCondimentos(condimentos);
		otraReceta.setIngredientes(ingredientes);
		otraReceta.setExplicaciones(explicaciones);
		otraReceta.setSubRecetas(subRecetas);
		otraReceta.setDificultad("facil");
		assertEquals ( true, unaReceta.equals(otraReceta));
	}
	
	@Test
	public void unaRecetaNoEsIgualAOtraPorqueTienenDistintoNombre()
	{
		Receta unaReceta = new Receta ("UnaReceta",90,"invierno");
		Receta otraReceta = new Receta ("OtraReceta",90,"invierno");
		unaReceta.setCondimentos(condimentos);
		unaReceta.setIngredientes(ingredientes);
		unaReceta.setExplicaciones(explicaciones);
		unaReceta.setSubRecetas(subRecetas);
		unaReceta.setDificultad("facil");
		otraReceta.setCondimentos(condimentos);
		otraReceta.setIngredientes(ingredientes);
		otraReceta.setExplicaciones(explicaciones);
		otraReceta.setSubRecetas(subRecetas);
		otraReceta.setDificultad("facil");
		assertEquals ( false, unaReceta.equals(otraReceta));
	}
	
	// Tests visualizacion Receta
	@Test
	public void usuarioPuedeVerUnaRecetaPropia()
	{	
		fede.setRecetas(new ArrayList<Receta>());
		fede.addReceta(bifes);
		assertEquals ( true , fede.esRecetaPropia(bifes));
		assertEquals ( true , fede.puedeVerOModificar(bifes));		
	}
	
	@Test
	public void usuarioPuedeVerUnaRecetaAjena()
	{	
		fede.setGrupos(new ArrayList<Grupo>());
		lucho.setGrupos(new ArrayList<Grupo>());
		Grupo lasSuris = new Grupo ("Suricatas");
		Grupo adrianYLosDados = new Grupo ("Adrian y los Dados Negros");
		lasSuris.setUsuarios(new ArrayList<Usuario>());
		adrianYLosDados.setUsuarios(new ArrayList<Usuario>());
		lasSuris.agregarUsuario(lucho);
		adrianYLosDados.agregarUsuario(fede);
		fede.setRecetas(new ArrayList<Receta>());
		lucho.setRecetas(new ArrayList<Receta>());
		fede.addReceta(bifes);
		assertEquals ( false , lucho.esRecetaPropia(bifes));
		assertEquals ( false , lucho.puedeVerOModificar(bifes));		
	}
	
	@Test
	public void usuarioPuedeVerUnaRecetaPublica()
	{	
		Receta.addRecetasPublicas(bifes);
		fede.setRecetas(new ArrayList<Receta>());
		lucho.setRecetas(new ArrayList<Receta>());
		assertEquals ( false , fede.esRecetaPropia(bifes));
		assertEquals ( false , lucho.esRecetaPropia(bifes));
		assertEquals ( true , fede.puedeVerOModificar(bifes));
		assertEquals ( true , lucho.puedeVerOModificar(bifes));	
	}
	
	// Tests modificar Receta
	@Test
	public void usuarioModificaUnaRecetaPublica()
	{	
		Receta.addRecetasPublicas(bifes);
		assertEquals ( true , bifes.esPublica());
		fedeMock.setRecetas(new ArrayList<Receta>());
		Receta recetaNueva = new Receta ();
		recetaNueva.setNombre("Bifes");
		Receta recetaModificada = fedeMock.devuelveRecetaModificada(bifes, recetaNueva);
		assertEquals(true , recetaModificada.getNombre().equals("Bifes"));
	}

	
}

