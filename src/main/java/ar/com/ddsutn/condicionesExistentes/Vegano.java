package ar.com.ddsutn.condicionesExistentes;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

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
	public boolean esAdecuada(Usuario usuario, Receta receta) 
	{
		return !tieneComidaNoDeseada((Collection<String>)receta.getIngredientes().stream().map(ingrediente -> ingrediente.getNombre()).collect(Collectors.toList()));
		
	}


	
}
