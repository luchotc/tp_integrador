package ar.com.ddsutn.integrador;

import java.util.Collection;

public class Vegano extends Usuario implements Condicion{

	public Vegano(){}
	
	public boolean tieneComidaNoDeseada(Collection<?> coleccion){
		return  coleccion.contains("pollo") ||
				coleccion.contains("carne") ||
				coleccion.contains("chivito") ||
				coleccion.contains("chori");
	}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
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
		return !this.tieneComidaNoDeseada( receta.getCondimentos().stream().map( condimento -> condimento.getNombre() ) );
	}

	
}
