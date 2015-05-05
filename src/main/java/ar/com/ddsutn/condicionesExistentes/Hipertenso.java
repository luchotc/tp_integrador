package ar.com.ddsutn.condicionesExistentes;

import java.util.Collection;

import ar.com.ddsutn.integrador.Comida;
import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;


public class Hipertenso implements Condicion{

	public Hipertenso(){}
	
	@Override
	public boolean validar(Usuario usuario)
	{
		return !usuario.getPreferenciasAlimenticias().isEmpty();
	}
	
	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return usuario.getRutina().equals("INTENSIVO");
	}

	public boolean tieneCondimentoNoDeseado(Collection<String> coleccion){
		return  coleccion.contains("Sal") ||
				coleccion.contains("Caldo") ;
	}
	
	@Override
	public boolean esAdecuada(Receta receta) {
		return !tieneCondimentoNoDeseado((Collection<String>)receta.getNombreCondimentos());
	}


	
}
