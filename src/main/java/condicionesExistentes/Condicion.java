package condicionesExistentes;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public interface Condicion {
	
	public boolean esValidoPorCondicion(Usuario usuario);
	public boolean lograSubsanar(Usuario usuario);
	public boolean esAdecuada(Usuario usuario, Receta receta);
	

}
