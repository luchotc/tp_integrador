package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import filtros.Filtro;
import ar.com.ddsutn.condicionesExistentes.Celiaco;
import ar.com.ddsutn.condicionesExistentes.Condicion;
import ar.com.ddsutn.condicionesExistentes.Diabetico;
import ar.com.ddsutn.condicionesExistentes.Hipertenso;
import ar.com.ddsutn.condicionesExistentes.Vegano;
import ar.com.ddsutn.resultados.Resultado;


public class Usuario implements Sugerible{
	
	private String nombre,sexo;
	private LocalDate fechaNacimiento;
	private Double altura,peso;
	private TipoRutina rutina;
	private Collection <String> preferenciasAlimenticias,palabrasDisgustan;
	private Collection <Condicion> condiciones;	
	private Collection <Receta> recetas,recetasFavoritas;
	private Collection <Grupo> grupos;
	public Collection <Resultado> resultados;
	public Collection <Filtro> filtros;
	private static Collection<Condicion> CondicionesExistentes = new ArrayList<>();
	
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
		return getRecetasTotales().contains(receta);
	}
	
	public boolean incluyeIngredienteQueDisgusta(Receta receta)
	{
		return receta.getIngredientes().stream().anyMatch(ing -> esDisgusto(ing.getNombre()));
	}
	
	public boolean perteneceAAlgunGrupo (Receta receta)
	{
		return grupos.stream().anyMatch(grupo -> (grupo.getRecetas()).contains(receta));
	}
	
	public void actualizarGruposPropios(Grupo grupo){
		grupos.add(grupo);
	}
	
	public Set <Receta> filtrarConStrategy(Set <Receta> recetasRecibidas)
	{
		Set<Receta> recetasFiltradas = new HashSet<Receta>();
		recetasFiltradas = recetasRecibidas.stream().filter(r -> cumpleConFiltros(r)).collect(Collectors.toSet());
		return recetasFiltradas;
	}	
		
	public Collection<Receta> resultarConStrategy(Collection<Receta>recetas)
	{
	  ArrayList<Resultado>resultados = new ArrayList<>(this.resultados);
	  for (int i= 0;i<resultados.size();i++)
	  {
		  recetas = resultados.get(i).resultarStrategy(recetas);
	  }
	  return recetas;
	}
	
	public boolean esSedentario(){
		return rutina.equals(TipoRutina.LEVE) ||
			   rutina.equals(TipoRutina.NADA) ||
			   rutina.equals(TipoRutina.MEDIANO);
	}
	
	@Override
	public boolean puedeSugerir(Receta receta){
		return puedeVerOModificar(receta) && !esInadecuada(receta) && !incluyeIngredienteQueDisgusta(receta);
	}
	
	public Set <Receta> getRecetasGrupo()
	{
		Set<Receta> recetasGrupo = new HashSet<Receta>();
		grupos.stream().forEach(g -> recetasGrupo.addAll(g.getRecetas()));
		return recetasGrupo;
	}
	
	public Set <Receta> getRecetasTotales()
	{
		Set<Receta> recetasTotales = new HashSet<Receta>();
		recetasTotales.addAll(getRecetasGrupo());
		recetasTotales.addAll(Receta.RecetasPublicas);
		recetasTotales.addAll(recetas);
		return recetasTotales;
	}
	
    private boolean esDisgusto(String ing) {
		return palabrasDisgustan.stream().anyMatch(dis -> dis.equalsIgnoreCase(ing));
	}

	private boolean cumpleConFiltros(Receta r) {
		return filtros.stream().allMatch(f -> f.filtrarStrategy(r, this));
	}

	private boolean esValidoPorCampos() {
		return  nombre != null && 
				peso != null && 
				altura != null && 
				fechaNacimiento != null && 
				rutina != null &&
				esValidoPorNombre() &&
				esValidoPorFecha();
	}

	private boolean esValidoPorNombre(){
		return nombre.length() > 4;
	}

	private boolean esValidoPorFecha(){
		return LocalDate.now().isAfter(fechaNacimiento);
	}

	public String toString()
    {
    	return nombre;
    }
	
	/*--------------------GETTERS Y SETTERS----------------------*/
	
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
	
	public static Collection <Condicion> GetCondicionesExistentes()
	{
		return CondicionesExistentes;
	}

	public static void SetCondicionesExistentes()
	{
		CondicionesExistentes.add(new Celiaco());
		CondicionesExistentes.add(new Hipertenso());
		CondicionesExistentes.add(new Vegano());
		CondicionesExistentes.add(new Diabetico());
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
	
	public void addDisgusto(String palabrasDisgustan) 
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

	public Collection <Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Collection <Grupo> grupos) {
		this.grupos = grupos;
	}

	public void addGrupo(Grupo grupo)
	{
		grupos.add(grupo);
	}

	public Collection <Filtro> getFiltros()
	{
		return filtros;
	}

	public void setFiltros(Collection <Filtro> filtros)
	{
		this.filtros = filtros;
	}

	public void addFiltro(Filtro filtro) 
	{	
		this.filtros.add(filtro);
	}

	public Collection <Resultado> getResultados()
	{
		return resultados;
	}

	public void setResultados(Collection <Resultado> resultados)
	{
		this.resultados = resultados;
	}

	public void addResultado(Resultado resultado) 
	{	
		this.resultados.add(resultado);
	}

	public Collection <Receta> getRecetasFavoritas()
	{
		return recetasFavoritas;
	}

	public void setRecetasFavoritas(Collection <Receta> recetasFavoritas)
	{
		this.recetasFavoritas= recetasFavoritas;
	}
	
	public void addFavorita(Receta receta){
		recetasFavoritas.add(receta);
	}
	
}