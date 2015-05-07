package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.Collection;

import ar.com.ddsutn.condicionesExistentes.Celiaco;
import ar.com.ddsutn.condicionesExistentes.Condicion;
import ar.com.ddsutn.condicionesExistentes.Diabetico;
import ar.com.ddsutn.condicionesExistentes.Hipertenso;
import ar.com.ddsutn.condicionesExistentes.Vegano;


public class Usuario {

	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private Collection <String> preferenciasAlimenticias;
	private Collection <String> palabrasDisgustan;
	private Collection <Condicion> condiciones;	// Revisar si es correcto el uso de HashSet<String>(), o si hay otra forma
	private Double altura;
	private Double peso;
	private String rutina;		// ------ es String?? ------ <----<----<----<---- Revisar
	private Collection <Receta> recetas;
	private static Collection<Condicion> CondicionesExistentes ;
	
	public static void SetCondicionesExistentes()
	{
		CondicionesExistentes.add(new Celiaco());
		CondicionesExistentes.add(new Hipertenso());
		CondicionesExistentes.add(new Vegano());
		CondicionesExistentes.add(new Diabetico());
	}
	
	public static Collection <Condicion> GetCondicionesExistentes()
	{
		return CondicionesExistentes;
	}
	
	
	public Usuario()
	{super();}
	
	public Usuario (String nombre, Double peso, Double altura, LocalDate fechaNacimiento, String rutina, String sexo){
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.rutina = rutina;
	}
	
	public Double imc ()
	{
	  return peso/Math.pow(altura, 2);
	}
	
	public boolean esValido() {
		return esValidoPorCampos() && condiciones.stream().allMatch(usuario -> usuario.validar(this));
	}
	public boolean esValidoPorCampos() {
		return  nombre != null && 
				peso != null && 
				altura != null && 
				fechaNacimiento != null && 
				rutina != null &&
				esValidoPorNombre() &&
				esValidoPorFecha();
	}
	public boolean esValidoPorNombre(){
		return nombre.length() > 4;
	}
	public boolean esValidoPorFecha(){
		return LocalDate.now().isAfter(fechaNacimiento);
	}
	
	public boolean sigueRutinaSaludable(){
		return  imc() > 18 && 
				imc() < 30 &&
				condiciones.stream().allMatch(condicion -> condicion.lograSubsanar(this));
	}
	
	public boolean esInadecuada(Receta receta){
		return !condiciones.stream().allMatch(condicion -> condicion.esAdecuada(receta));
	}
	
	public boolean esRecetaPropia (Receta receta)
	{
		return recetas.stream().anyMatch(recetaPropia -> (recetaPropia.equals(receta)));
	}
	
	public boolean puedeVerOModificarReceta (Receta receta)
	{ return receta.esPublica() || esRecetaPropia(receta);
	}
	
	
	/* Modificar Receta */
	public void modificarNombreReceta(Receta receta, String nombre)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setNombre(nombre);
	}
	public void modificarTotalCaloriasReceta(Receta receta, int totalCalorias)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setTotalCalorias(totalCalorias);
	}
	public void modificarIngredientesReceta(Receta receta, Collection<Comida> ingredientes)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setIngredientes(ingredientes);
	}
	public void modificarCondimentosReceta(Receta receta, Collection<Comida> condimentos)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setCondimentos(condimentos);
	}
	public void modificarExplicacionReceta(Receta receta, Collection<String> explicacion)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setExplicaciones(explicacion);
	}
	public void modificarSubRecetaReceta(Receta receta, Collection<Receta> subReceta)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setSubRecetas(subReceta);
	}
	public void modificarTemporadaReceta(Receta receta, String temporada)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setTemporada(temporada);
	}
	public void modificarDificultadReceta(Receta receta, String dificultad)
	{
		if(puedeVerOModificarReceta(receta))
		receta.setDificultad(dificultad);
	}

	/*	setters y getters	*/
	
	public Collection <Condicion> getCondiciones() 
	{	
		return condiciones;
	}
	
	public void setCondiciones(Collection <Condicion> condiciones)
	{	
		this.condiciones = condiciones;	
	}
	
	public void addCondicion(Condicion condicion)
	{
		condiciones.add(condicion);
	}
	
	public Collection <String> getPreferenciasAlimenticias() 
	{	
		return preferenciasAlimenticias;	
	}
	
	public void setPreferenciasAlimenticias(Collection <String> preferenciasAlimenticias)
	{	
		this.preferenciasAlimenticias = preferenciasAlimenticias;
	}
	
	public void addPreferencia(String preferenciasAlimenticias)
	{
		this.preferenciasAlimenticias.add(preferenciasAlimenticias);
	}

	public Collection <String> getPalabrasDisgustan() 
	{	
		return palabrasDisgustan;
	}
	
	public void setPalabrasDisgustan(Collection <String> palabrasDisgustan) 
	{	
		this.palabrasDisgustan = palabrasDisgustan;	
	}
	
	public void addPalabrasDisgustan(String palabrasDisgustan) 
	{	
		this.palabrasDisgustan.add(palabrasDisgustan);
	}
	
	public Collection <Receta> getRecetas() 
	{	
		return recetas;
	}
	
	public void setRecetas(Collection <Receta> recetas) 
	{	
		this.recetas = recetas;	
	}
	
	public void addReceta(Receta receta) 
	{	
		if(receta.esValida())
		  recetas.add(receta);
	}
	
	public Double getPeso()
	{	
		return peso;	
	}
	
	public String getSexo()
	{	
		return sexo;	
	}
	
	public String getRutina()
	{	
		return rutina;	
	}
	
	public boolean rutinaSedentaria(){
		return rutina.equals("LEVE") ||
			   rutina.equals("NADA") ||
			   rutina.equals("MEDIANO");
	}
	
}

