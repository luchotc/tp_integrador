package ar.com.ddsutn.integrador;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import condicionesExistentes.Diabetico;
import condicionesExistentes.Hipertenso;
import condicionesExistentes.Vegano;

import java.time.LocalDate;

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
	unaReceta.addIngrediente(new Comida("unIngrediente", 2.0));
	unaReceta.addCondimentos(new Comida("Pepinos", 3.0));
	
	bifes = new Receta("Bifes a la criolla con papas y arvejas", 785, fede);
	bifes.addIngrediente(new Comida("Cuadril", 3.0));
	bifes.addIngrediente(new Comida("Papas", 1.5));
	bifes.addIngrediente(new Comida("Tomates triturados", 1.5));
	bifes.addIngrediente(new Comida("Morrón rojo", 4.0));
	bifes.addIngrediente(new Comida("Morrón amarillo", 4.0));
	bifes.addIngrediente(new Comida("Morrón verde", 4.0));
	bifes.addIngrediente(new Comida("Cebollas", 1.0));
	bifes.addIngrediente(new Comida("Aceite de oliva", 2.0));
	bifes.addIngrediente(new Comida("Huevos", 20.0));
	bifes.addIngrediente(new Comida("Tomate perita", 1.0));
	bifes.addIngrediente(new Comida("Puré de tomate", 500.0));
	bifes.addIngrediente(new Comida("Arvejas congeladas", 500.0));
	bifes.addCondimentos(new Comida("Ají molido", 0.0));
	bifes.addCondimentos(new Comida("Ajo picado", 1.0));
	bifes.addCondimentos(new Comida("Perejil picado", 0.0));
	bifes.addCondimentos(new Comida("Orégano", 0.0));
	bifes.addCondimentos(new Comida("Sal", 0.0));
	bifes.addCondimentos(new Comida("Pimienta", 0.0));
	bifes.addCondimentos(new Comida("Hojas de laurel", 0.0));
	bifes.addCondimentos(new Comida("Caldo de verdura o carne", 0.0));
	bifes.addExplicacion("Limpiar el morrón. Cortar en tiras a lo largo y reservar");
	bifes.addExplicacion("Pelar y cortar las papas en rodajas gruesitas, cortar la cebolla en juliana");
	bifes.addExplicacion("Rociar levemente con aceite de oliva a la paellera");
	bifes.addExplicacion("Pasar la carne por harina (para que se dore mejor) luego disponerla sobre la paella (previamente aceitada). Retirar la carne una vez sellada vuelta y vuelta");
	bifes.addExplicacion("En la misma paellera colocar una capa de cebolla cortada en juliana, pimientos en juliana, luego una capa de rodajas de papas, rodajas de tomates. Agregar la carne, condimentar por encima");
	bifes.addExplicacion("Una vez dispuestos todos los ingredientes en el disco con la sal, la pimienta, el orégano, el laurel y el ají molido, incorporar puré de tomate y caldo de verdura hasta cubrir la totalidad de la preparación");
	bifes.addExplicacion("Cuando las papas tomen color, indicará que la preparación está lista (la cocción total luego de agregar las papas lleva 20 minutos aproximadamente)");
	bifes.addExplicacion("Agregar los huevos, chascándolos previamente por separado y luego volcarlos encima de los bifes. Sumar las arvejas y espolvorear con perejil picado toda la preparación");
	
	}
	
	
	//Tests Receta Valida
	@Test
	public void unaRecetaEsValida()
	{	assertEquals ((boolean)true , bifes.esValida());		}
	@Test
	public void unaRecetaNoEsValidaPorNoTenerIngredientes()
	{	assertEquals ((boolean)false , new Receta("otra Receta",1500, lucho).esValida());		}
	@Test
	public void unaRecetaNoEsValidaPorNoTenerRangoEntre10Y5000()
	{	assertEquals ((boolean)false , new Receta("otra Receta",8000, lucho).esValida());		}
	
	//Tests Receta inadecuada
	@Test
	public void esInadecuadaParaDiabeticoConMasDe100grDeAzucar()
	{	
		fede.condiciones.add(new Diabetico());
		unaReceta.addCondimentos(new Comida("Azucar", 150.00));
		assertEquals ((boolean)true , fede.esInadecuada(unaReceta));		
	}
	@Test
	public void esInadecuadaParaVeganoConChori()
	{	
		fede.condiciones.add(new Vegano());
		unaReceta.addIngrediente(new Comida("Chori", 1.00));
		assertEquals ((boolean)true , fede.esInadecuada(unaReceta));		
	}
	@Test
	public void esInadecuadaParaHipertensoConSal()
	{	
		fede.condiciones.add(new Hipertenso());
		assertEquals ((boolean)true , fede.esInadecuada(bifes));		
	}
	
}
