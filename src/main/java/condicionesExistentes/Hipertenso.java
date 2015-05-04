package condicionesExistentes;

import java.util.Collection;
import java.util.stream.Collectors;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class Hipertenso implements Condicion{

	public Hipertenso(){}
	
	public boolean tieneComidaNoDeseada(Collection<String> coleccion){
		return  coleccion.contains("Sal") ||
				coleccion.contains("Caldo");

	}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return !usuario.getPreferenciasAlimenticias().isEmpty();
	}
	
	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return usuario.getRutina().equals("INTENSIVO");
	}

	@Override
	public boolean esAdecuada(Usuario usuario, Receta receta) {
		return !this.tieneComidaNoDeseada((Collection<String>)receta.getCondimentos().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList()) );
	}

	@Override
	public void validar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
}
