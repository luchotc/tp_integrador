package condicionesExistentes;

import java.util.Collection;
import java.util.stream.Collectors;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class Vegano extends Usuario implements Condicion{

	public Vegano(){}
	
	public boolean tieneComidaNoDeseada(Collection<String> coleccion){
		return  coleccion.contains("Pollo") ||
				coleccion.contains("Carne") ||
				coleccion.contains("Chivito") ||
				coleccion.contains("Chori");
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
		return !this.tieneComidaNoDeseada(receta.getNombreIngredientes());
	}

	

	
}
