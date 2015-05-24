package ar.com.ddsutn.integrador;

import java.util.ArrayList;
import java.util.Collection;

public class Grupo {
	
	private Collection <Usuario> usuarios;
	private Collection <String> preferenciasAlimenticias;
	private String nombre; 
	

	public Grupo (String nombre){
		this.setNombre(nombre);
	}

	public void agregarUsuario (Usuario usuario)
	{
		usuarios.add(usuario);
		usuario.actualizarGruposPropios(this);
	}

	public Collection <Receta> getRecetasGrupo()
	{
		Collection<Receta> recetasGrupo = new ArrayList<Receta>();
		usuarios.stream().forEach(u -> recetasGrupo.addAll(u.getRecetas()));
		return recetasGrupo;
	}

	public boolean puedeSugerir(Receta receta)
	{
		return nombreQueGusta(receta) && esApropiadaParaGrupo(receta);
	}
	
	private boolean esApropiadaParaGrupo(Receta receta) {
		return usuarios.stream().allMatch(u -> !u.esInadecuada(receta));
		//return !usuarios.stream().anyMatch(u -> u.esInadecuada(receta)); -> otra forma
	}

	public boolean nombreQueGusta(Receta receta)
	{
		String nombreReceta = (receta.getNombre()).toLowerCase();
		return preferenciasAlimenticias.stream().anyMatch(pref -> nombreReceta.contains(pref.toLowerCase()));		
	}
	
	
	/*Getters y Setters*/
	public Collection <String> getPreferenciasAlimenticias() 
	{	
		return preferenciasAlimenticias;	
	}
	
	public void setPreferenciasAlimenticias(Collection <String> preferenciasAlimenticias)
	{	
		this.preferenciasAlimenticias = preferenciasAlimenticias;
	}
	
	public void addPreferencia(String preferencia)
	{
		preferenciasAlimenticias.add(preferencia);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection <Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection <Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}