package condicionesExistentes;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class Celiaco implements Condicion {

	public Celiaco(){};
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario) 
	{
		return true;
	}

	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return true;
	}

	@Override
	public boolean esAdecuada(Usuario usuario, Receta receta) 
	{
		return true;
	}

	@Override
	public void validar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}


}
