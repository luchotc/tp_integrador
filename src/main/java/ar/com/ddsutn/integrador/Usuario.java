package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.ArrayList;
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
	private Collection <Condicion> condiciones;	
	private Double altura;
	private Double peso;
	private TipoRutina rutina;
	private Collection <Receta> recetas;
	private Collection <Grupo> grupos;
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
	
	public Usuario(){}
	
	public Usuario (String nombre, Double peso, Double altura, LocalDate fechaNacimiento, TipoRutina rutina, String sexo){
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
	
	public Receta agregarAPropias(Receta receta)
	{
			Receta copiaReceta = (Receta) receta.clone();
			addReceta(copiaReceta);
			return copiaReceta;
	}
	
	public boolean puedeVerOModificar (Receta receta)
	{ 
		return receta.esPublica() || esRecetaPropia(receta) || perteneceAAlgunGrupo(receta);
	}
	
	public void modificarRecetaGeneral(Receta receta, Receta recetaModificada)
	{
		if(puedeVerOModificar(receta))
			if (receta.esPublica())
			{
				Receta recetaAgregada = agregarAPropias(receta);
				recetaAgregada.modificarSegun(recetaModificada);
				
			}
			else
			{
				receta.modificarSegun(recetaModificada);
			}	
	}
	
	boolean puedeSugerir(Receta receta){
		
		return puedeVerOModificar(receta) && !esInadecuada(receta) && !incluyeIngredienteQueDisgusta(receta);
	}
	
	private boolean incluyeIngredienteQueDisgusta(Receta receta) {
		
		 return palabrasDisgustan.stream().anyMatch(p -> (receta.getIngredientes()).contains(p));
	}
	
	
	
	
	/*public Collection <Receta> getRecetasDeLosGrupos()
	{
		Collection<Receta> recetasTotales = new ArrayList<Receta>();
		grupos.stream().forEach(g -> recetasTotales.addAll(g.getRecetasGrupo()));
		return recetasTotales;
	} 
	PUEDE LLEGAR A SERVIR*/
	
	  
	public boolean perteneceAAlgunGrupo (Receta receta)
	  
	  {return grupos.stream().anyMatch(grupo -> (grupo.getRecetasGrupo()).contains(receta));
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
		return rutina.name();	
	}
	
	public boolean esSedentario(){
		return rutina.equals(TipoRutina.LEVE) ||
			   rutina.equals(TipoRutina.NADA) ||
			   rutina.equals(TipoRutina.MEDIANO);
	}

	public Collection <Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Collection <Grupo> grupos) {
		this.grupos = grupos;
	}
	
}


