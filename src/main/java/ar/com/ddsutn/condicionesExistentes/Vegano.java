package ar.com.ddsutn.condicionesExistentes;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

import java.util.Collection;


public class Vegano extends Usuario implements Condicion{

	public Vegano(){}
	
	public boolean tieneComidaNoDeseada(Collection<String> coleccion){
		return  coleccion.contains("pollo") ||
				coleccion.contains("carne") ||
				coleccion.contains("chivito") ||
				coleccion.contains("chori");
	}
	
	@Override
	public boolean validar(Usuario usuario)
	{
		return  !this.tieneComidaNoDeseada(usuario.getPreferenciasAlimenticias());
	}
	
	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return usuario.getPreferenciasAlimenticias().contains("frutas");
	}
	
	@Override
	public boolean esAdecuada(Receta receta) 
	{
		return !tieneComidaNoDeseada((Collection<String>)receta.getNombreIngredientes());
		
	}


	
}

