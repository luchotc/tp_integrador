package ar.com.ddsutn.integrador;

import java.util.Collection;
import java.util.stream.Collectors;

import ar.com.ddsutn.condicionesExistentes.Condicion;

public class Receta implements Cloneable{
	private String nombre;
	private int totalCalorias;
	private Collection <Ingrediente> ingredientes;
	protected Collection <Condimento> condimentos;
	private Collection <String> explicaciones;
	private Collection <Receta> subRecetas;
	private String temporada;
	private String dificultad;
	public static Collection <Receta> RecetasPublicas;
	
	public Receta() {}
	
	public Receta(String nombre, int totalCalorias){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
	}
	
	public Receta(String nombre, int totalCalorias, String temporada){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
		this.temporada = temporada;
	}
	
	public void modificarSegun(Receta receta)
	{
		String nombreNuevo = receta.getNombre();
		int caloriasNuevas = receta.getTotalCalorias();
		Collection <Ingrediente> ingredientes = receta.getIngredientes();
		Collection <Condimento> condimentos = receta.getCondimentos();
		Collection <String> explicaciones = receta.getExplicaciones();
		Collection <Receta> subRecetas = receta.getSubRecetas();
		String temporada = receta.getTemporada();
		String dificultad = receta.getDificultad();
		
		if (nombreNuevo!=null)
			setNombre(nombreNuevo);
		
		if (caloriasNuevas!=0)
			setTotalCalorias(caloriasNuevas);
		
		if (ingredientes!=null)
			setIngredientes(ingredientes);
		
		if (condimentos!=null)
			setCondimentos(condimentos);
		
		if (explicaciones!=null)
			setExplicaciones(explicaciones);
		
		if (subRecetas!=null)
			setSubRecetas(subRecetas);
		
		if (temporada!=null)
			setTemporada(temporada);
		
		if (dificultad!=null)
			setDificultad(dificultad);
			
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

    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
         //   System.out.println(" no se puede duplicar");
        }
        return obj;
    }
    
    public String toString() //temporal para encontrar errores
    {
    	return nombre;
    }
	

	public Collection<String> getNombreCondimentos() 
	{	
		return getCondimentos().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());	
	}
	
	public Collection<String> getNombreIngredientes() 
	{	
		return getIngredientes().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());
	}

	/*	setters y getters	*/
	
	public static void addRecetasPublicas(Receta receta)
	{
		if(receta.esValida())
		{
		  RecetasPublicas.add(receta);
		}
	}
	
	public void addIngrediente(Ingrediente ingrediente)
	{	
		ingredientes.add(ingrediente);		
	}
	
	public void addCondimento(Condimento condimento)
	{	
		condimentos.add(condimento);		
	}
	
	public Collection <Receta> getSubRecetas() {
		return subRecetas;
	}

	public void setSubRecetas(Collection <Receta> subRecetas) {
		this.subRecetas = subRecetas;
	}
	
	public void addExplicacion(String explicacion)
	{	
		explicaciones.add(explicacion);		
	}
	
	public void addCondimentos(Condimento condimento)
	{	
		condimentos.add(condimento);		
	}
	
	public Collection <Condimento> getCondimentos()
	{	
		return condimentos;		
	}
	
	public Collection <Ingrediente> getIngredientes()
	{	
		return ingredientes;	
	}
	
	public void setCondimentos(Collection <Condimento> condimentos)
	{	
		this.condimentos = condimentos;		
	}
	
	public void setIngredientes(Collection <Ingrediente> ingredientes)
	{	
		this.ingredientes = ingredientes;	
	}

	private Collection<String> getExplicaciones() {
		return explicaciones;
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

	public void addSubReceta(Receta subReceta) {
		subRecetas.add(subReceta);
	}
	
}

