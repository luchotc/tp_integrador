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
	public static Collection <Receta> RecetasPublicas;
	
	public boolean equals(Receta receta)
	{
		return  nombre.equals(receta.nombre) &&
				ingredientes.equals(receta.ingredientes) &&
				condimentos.equals(receta.condimentos) &&
				explicaciones.equals(receta.explicaciones) &&
				subRecetas.equals(receta.subRecetas) &&
				temporada.equals(receta.temporada) &&
				dificultad.equals(receta.dificultad);
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
	
	public boolean esPublica()
	{
		return RecetasPublicas.stream().anyMatch(recetaPublica -> recetaPublica.equals(this));
	}
	
	public boolean esValida(){
		return !ingredientes.isEmpty() &&
				totalCalorias > 10 &&
				totalCalorias < 5000 ;
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
		ingredientes.add(ingrediente);		
	}
	
	public static void addRecetasPublicas(Receta receta)
	{
		if(receta.esValida())
		{
		  RecetasPublicas.add(receta);
		}
	}
	
	public void addExplicacion(String explicacion)
	{	
		explicaciones.add(explicacion);		
	}
	
	public void addCondimentos(Comida condimento)
	{	
		condimentos.add(condimento);		
	}
	
	public Collection <Comida> getCondimentos()
	{	
		return condimentos;		
	}
	
	public Collection <Comida> getIngredientes()
	{	
		return ingredientes;	
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
		return getCondimentos().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());	
	}
	
	public Collection<String> getNombreIngredientes() 
	{	
		return getIngredientes().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());
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
	
	public String getTemporada() {
		return temporada;
	}
	
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	public int getTotalCalorias() {
		return totalCalorias;
	}
	
	public void setTotalCalorias(int totalCalorias) {
		this.totalCalorias = totalCalorias;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
