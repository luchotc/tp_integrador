package ar.com.ddsutn.condicionesExistentes;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;


public interface Condicion {
	
	public boolean validar(Usuario usuario);
	public boolean lograSubsanar(Usuario usuario);
	public boolean esAdecuada(Receta receta);

}
