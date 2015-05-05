package ar.com.ddsutn.integrador;

import java.util.Collection;
import java.util.stream.Collectors;

public class Receta {
	private String nombre;
	private int totalCalorias;
	private Collection <Comida> ingredientes;
	protected Collection <Comida> condimentos;
	private Collection <String> explicaciones;
	private Collection <Receta> subRecetas;
	private Usuario usuarioQueLaCargo;
	private String temporada;
	public static Collection <Receta> recetasPublicas;
	
	public Receta(String nombre, int totalCalorias, Usuario usuarioQueLaCargo){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
		this.usuarioQueLaCargo = usuarioQueLaCargo;
	}
	
	public Receta(String nombre, int totalCalorias, Usuario usuarioQueLaCargo, String temporada){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
		this.usuarioQueLaCargo = usuarioQueLaCargo;
		this.temporada = temporada;
	}
	
	public static boolean EsPublica(Receta receta)
	{
		return Receta.recetasPublicas.stream().anyMatch(recetaPropia -> (recetaPropia.equals(receta)));
	}
	
	public boolean esValida(){
		return !this.ingredientes.isEmpty() &&
				this.totalCalorias > 10 &&
				this.totalCalorias < 5000 ;
	}
	
	public boolean inadecuadoPara(){
		return usuarioQueLaCargo.esInadecuada(this);
	}
	
	/*	setters y getters	*/
	public void addIngrediente(Comida ingrediente)
	{	
		this.ingredientes.add(ingrediente);		
	}
	
	public void addRecetasPublicas(Receta receta)
	{
		if(receta.esValida())
		{
		  recetasPublicas.add(receta);
		}
	}
	
	public void addExplicacion(String explicacion)
	{	
		this.explicaciones.add(explicacion);		
	}
	
	public void addCondimentos(Comida condimento)
	{	
		this.condimentos.add(condimento);		
	}
	
	public Collection <Comida> getCondimentos()
	{	
		return this.condimentos;		
	}
	
	public Collection <Comida> getIngredientes()
	{	
		return this.ingredientes;	
	}
	
	public void setCondimentos(Collection <Comida> condimentos)
	{	
		this.condimentos = condimentos;		
	}
	
	public void setIngredientes(Collection <Comida> ingredientes)
	{	
		this.ingredientes = ingredientes;	
	}
	
	public Collection<String> getNombreCondimentos() 
	{	
		return this.getCondimentos().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());	
	}
	
	public Collection<String> getNombreIngredientes() 
	{	
		return this.getIngredientes().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());
	}

	public Collection <Receta> getSubRecetas() {
		return subRecetas;
	}

	public void setSubRecetas(Collection <Receta> subRecetas) {
		this.subRecetas = subRecetas;
	}

	public void setExplicaciones(Collection<String> explicaciones) {
		this.explicaciones = explicaciones;
	}
	
}
