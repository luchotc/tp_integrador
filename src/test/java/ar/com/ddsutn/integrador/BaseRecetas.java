package ar.com.ddsutn.integrador;

import java.util.ArrayList;

public class BaseRecetas {
	private Receta bifes;
	private Receta comidaTop;
	private Receta superChori;

	public BaseRecetas()
	{
		crearBifes();
		Receta.setIngredientesCaros();
	}
	
	private void crearComidaTop()
	{
		comidaTop = new Receta("Comida excesivamente cara y top", 594, "Invierno");
		comidaTop.setDificultad("Media");
		iniciarVariables(comidaTop);
		comidaTop.addIngrediente(new Ingrediente("Lomo", 2.0));
		comidaTop.addIngrediente(new Ingrediente("Alcaparras", 2.0));
	}
	
	private void crearSuperChori()
	{
		superChori = new Receta("Super chori", 294, "Verano");
		superChori.setDificultad("Media");
		iniciarVariables(superChori);
		superChori.addIngrediente(new Ingrediente("Chori", 1.0));
		superChori.addIngrediente(new Ingrediente("Caca", 5.0));
	}
	
	private void crearBifes() {
		bifes = new Receta("Bifes a la criolla con papas y arvejas", 785, "Todas");
		bifes.setDificultad("Media");
		iniciarVariables(bifes);
		bifesIngredientes();
		bifesCondimentos();
		bifesExplicacion();
	}

	private void iniciarVariables(Receta receta) {
		receta.setIngredientes(new ArrayList<Ingrediente>());
		receta.setCondimentos(new ArrayList<Condimento>());
		receta.setExplicaciones(new ArrayList<String>());
		receta.setSubRecetas(new ArrayList<Receta>());
	}

	private void bifesExplicacion() {
		bifes.addExplicacion("Limpiar el morr�n. Cortar en tiras a lo largo y reservar");
		bifes.addExplicacion("Pelar y cortar las papas en rodajas gruesitas, cortar la cebolla en juliana");
		bifes.addExplicacion("Rociar levemente con aceite de oliva a la paellera");
		bifes.addExplicacion("Pasar la carne por harina (para que se dore mejor) luego disponerla sobre la paella (previamente aceitada). Retirar la carne una vez sellada vuelta y vuelta");
		bifes.addExplicacion("En la misma paellera colocar una capa de cebolla cortada en juliana, pimientos en juliana, luego una capa de rodajas de papas, rodajas de tomates. Agregar la carne, condimentar por encima");
		bifes.addExplicacion("Una vez dispuestos todos los ingredientes en el disco con la sal, la pimienta, el or�gano, el laurel y el aj� molido, incorporar pur� de tomate y caldo de verdura hasta cubrir la totalidad de la preparaci�n");
		bifes.addExplicacion("Cuando las papas tomen color, indicar� que la preparaci�n est� lista (la cocci�n total luego de agregar las papas lleva 20 minutos aproximadamente)");
		bifes.addExplicacion("Agregar los huevos, chasc�ndolos previamente por separado y luego volcarlos encima de los bifes. Sumar las arvejas y espolvorear con perejil picado toda la preparaci�n");
	}

	private void bifesCondimentos() {
		bifes.addCondimento(new Condimento("Aj� molido", 0.0));
		bifes.addCondimento(new Condimento("Ajo picado", 1.0));
		bifes.addCondimento(new Condimento("Perejil picado", 0.0));
		bifes.addCondimento(new Condimento("Or�gano", 0.0));
		bifes.addCondimento(new Condimento("Sal", 0.0));
		bifes.addCondimento(new Condimento("Pimienta", 0.0));
		bifes.addCondimento(new Condimento("Hojas de laurel", 0.0));
		bifes.addCondimento(new Condimento("Caldo de verdura o carne", 0.0));
	}

	private void bifesIngredientes() {
		bifes.addIngrediente(new Ingrediente("Cuadril", 3.0));
		bifes.addIngrediente(new Ingrediente("Papas", 1.5));
		bifes.addIngrediente(new Ingrediente("Tomates triturados", 1.5));
		bifes.addIngrediente(new Ingrediente("Morr�n rojo", 4.0));
		bifes.addIngrediente(new Ingrediente("Morr�n amarillo", 4.0));
		bifes.addIngrediente(new Ingrediente("Morr�n verde", 4.0));
		bifes.addIngrediente(new Ingrediente("Cebollas", 1.0));
		bifes.addIngrediente(new Ingrediente("Aceite de oliva", 2.0));
		bifes.addIngrediente(new Ingrediente("Huevos", 20.0));
		bifes.addIngrediente(new Ingrediente("Tomate perita", 1.0));
		bifes.addIngrediente(new Ingrediente("Pur� de tomate", 500.0));
		bifes.addIngrediente(new Ingrediente("Arvejas congeladas", 500.0));
	}
	
	public Receta subRecetaCualquiera()
	{
		Receta unaSubReceta = new Receta("una subReceta", 250, "Todas");
		unaSubReceta.setDificultad("Facil");
		iniciarVariables(unaSubReceta);
		
		unaSubReceta.addIngrediente(new Ingrediente("un ingrediente", 4.5));
		unaSubReceta.addIngrediente(new Ingrediente("otro ingrediente", 5.0));
		unaSubReceta.addIngrediente(new Ingrediente("un ingrediente mas", 1.0));
		unaSubReceta.addCondimento(new Condimento("un condimento", 0.0));
		unaSubReceta.addCondimento(new Condimento("otro condimento", 1.0));
		unaSubReceta.addExplicacion("Hola, soy una explicacion");
		unaSubReceta.addExplicacion("Hola, yo soy la segunda parte");
		unaSubReceta.addExplicacion("y yo la tercera parte");
		
		return unaSubReceta;
	}
	
	public Receta getBifes() {
		return bifes;
	}
	
	
}
