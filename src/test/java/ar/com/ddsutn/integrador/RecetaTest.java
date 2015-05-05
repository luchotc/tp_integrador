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
	private Receta unaReceta;
	private Receta bifes;

	@Before
	public void setUp() {
		
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,1,18), "INSTENSIVO", null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), "LEVE", "Masculino");
	
	unaReceta = new Receta("una receta", 1500, fede);
	Collection <Comida> ingredientes = new ArrayList<Comida>();
	Collection <Comida> condimentos = new ArrayList<Comida>();

	ingredientes.add(new Comida ("unIngrediente", 2.0));
	condimentos.add(new Comida("Pepinos", 3.0));
	
	unaReceta.setIngredientes(ingredientes);
	unaReceta.setCondimentos(condimentos);
	
	bifes = new Receta("Bifes a la criolla con papas y arvejas", 785, fede);
	
	ingredientes.clear();
	condimentos.clear();

	Collection <String> explicaciones = new ArrayList<String>();
	
	ingredientes.add(new Comida("Cuadril", 3.0));
	ingredientes.add(new Comida("Papas", 1.5));
	ingredientes.add(new Comida("Tomates triturados", 1.5));
	ingredientes.add(new Comida("Morrón rojo", 4.0));
	ingredientes.add(new Comida("Morrón amarillo", 4.0));
	ingredientes.add(new Comida("Morrón verde", 4.0));
	ingredientes.add(new Comida("Cebollas", 1.0));
	ingredientes.add(new Comida("Aceite de oliva", 2.0));
	ingredientes.add(new Comida("Huevos", 20.0));
	ingredientes.add(new Comida("Tomate perita", 1.0));
	ingredientes.add(new Comida("Puré de tomate", 500.0));
	ingredientes.add(new Comida("Arvejas congeladas", 500.0));
	condimentos.add(new Comida("Ají molido", 0.0));
	condimentos.add(new Comida("Ajo picado", 1.0));
	condimentos.add(new Comida("Perejil picado", 0.0));
	condimentos.add(new Comida("Orégano", 0.0));
	condimentos.add(new Comida("Sal", 0.0));
	condimentos.add(new Comida("Pimienta", 0.0));
	condimentos.add(new Comida("Hojas de laurel", 0.0));
	condimentos.add(new Comida("Caldo de verdura o carne", 0.0));
	explicaciones.add("Limpiar el morrón. Cortar en tiras a lo largo y reservar");
	explicaciones.add("Pelar y cortar las papas en rodajas gruesitas, cortar la cebolla en juliana");
	explicaciones.add("Rociar levemente con aceite de oliva a la paellera");
	explicaciones.add("Pasar la carne por harina (para que se dore mejor) luego disponerla sobre la paella (previamente aceitada). Retirar la carne una vez sellada vuelta y vuelta");
	explicaciones.add("En la misma paellera colocar una capa de cebolla cortada en juliana, pimientos en juliana, luego una capa de rodajas de papas, rodajas de tomates. Agregar la carne, condimentar por encima");
	explicaciones.add("Una vez dispuestos todos los ingredientes en el disco con la sal, la pimienta, el orégano, el laurel y el ají molido, incorporar puré de tomate y caldo de verdura hasta cubrir la totalidad de la preparación");
	explicaciones.add("Cuando las papas tomen color, indicará que la preparación está lista (la cocción total luego de agregar las papas lleva 20 minutos aproximadamente)");
	explicaciones.add("Agregar los huevos, chascándolos previamente por separado y luego volcarlos encima de los bifes. Sumar las arvejas y espolvorear con perejil picado toda la preparación");
	
	bifes.setIngredientes(ingredientes);
	bifes.setCondimentos(condimentos);
	bifes.setExplicaciones(explicaciones);
	
	}
	
	
	//Tests Receta Valida
	@Test
	public void unaRecetaEsValida()
	{	
		assertEquals ((boolean)true , bifes.esValida());	
	}
	
	@Test
	public void unaRecetaNoEsValidaPorNoTenerIngredientes()
	{
		Receta otraReceta = new Receta("otra Receta",1500, lucho);
		otraReceta.setIngredientes(new ArrayList<Comida>());
		assertEquals ((boolean)false , otraReceta.esValida());		
	}
	
	@Test
	public void unaRecetaNoEsValidaPorNoTenerRangoEntre10Y5000()
	{
		Receta otraReceta = new Receta("otra Receta",8000, lucho);
		otraReceta.setIngredientes(new ArrayList<Comida>());
		assertEquals ((boolean)false , otraReceta.esValida());		}
	
	//Tests Receta inadecuada
	@Test
	public void esInadecuadaParaDiabeticoConMasDe100grDeAzucar()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.getCondiciones().add(new Diabetico());
		unaReceta.addCondimentos(new Comida("Azucar", 150.00));
		assertEquals ((boolean)true , fede.esInadecuada(unaReceta));		
	}
	
	@Test
	public void esInadecuadaParaVeganoConChori()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.getCondiciones().add(new Vegano());
		unaReceta.addIngrediente(new Comida("chori", 1.00));
		assertEquals ((boolean)true , fede.esInadecuada(unaReceta));		
	}
	
	@Test
	public void esInadecuadaParaHipertensoConSal()
	{	
		fede.setCondiciones(new ArrayList<Condicion>());
		fede.getCondiciones().add(new Hipertenso());
		assertEquals ((boolean)true , fede.esInadecuada(bifes));		
	}
	
}
