package ar.com.ddsutn.integrador;

import java.util.Collection;
import java.util.stream.Collectors;

import ar.com.ddsutn.condicionesExistentes.Condicion;

public class Receta {
	private String nombre;
	private int totalCalorias;
	private Collection <Comida> ingredientes;
	protected Collection <Comida> condimentos;
	private Collection <String> explicaciones;
	private Collection <Receta> subRecetas;
	private String temporada;
	private String dificultad;
	public static Collection <Receta> recetasPublicas;
	
	public boolean equals(Receta receta)
	{
		boolean mismoNombre = nombre.equals(receta.nombre);
		boolean mismosIngredientes = ingredientes.equals(receta.ingredientes);
		boolean mismosCondimentos = condimentos.equals(receta.condimentos);
		boolean mismasExplicaciones = explicaciones.equals(receta.explicaciones);
		boolean mismasSubrecetas = subRecetas.equals(receta.subRecetas);
		boolean mismaTemporada = temporada.equals(receta.temporada);
		boolean mismaDificultad = dificultad.equals(receta.dificultad);
		return  mismoNombre && mismosIngredientes && mismosCondimentos && mismasExplicaciones && mismasSubrecetas && mismaTemporada && mismaDificultad;
	}
	
	public void modificarse()
	{
	
	}
	
	public Receta(String nombre, int totalCalorias){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
	}
	
	public Receta(String nombre, int totalCalorias, String temporada){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
		this.temporada = temporada;
	}
	
	public static boolean EsPublica(Receta receta)
	{
		return recetasPublicas.stream().anyMatch(recetaPropia -> (recetaPropia.equals(receta)));
	}
	
	public boolean esValida(){
		return !this.ingredientes.isEmpty() &&
				this.totalCalorias > 10 &&
				this.totalCalorias < 5000 ;
	}
	
	public boolean inadecuadoPara(Usuario usuario){
		return usuario.esInadecuada(this);
	}
	
	public Collection <Condicion> condicionesInadecuadas()
	{
		return Usuario.GetCondicionesExistentes().stream().filter(condicion -> !condicion.esAdecuada(this)).collect(Collectors.toList());
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

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
}
