package ar.com.ddsutn.integrador;

public class Hipertenso extends Usuario implements Condicion{

	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return !usuario.preferenciasAlimenticias.isEmpty();
	}
	
	@Override
	public void validarRutinaSaludable(Usuario usuario)
	{
		//
	}
	
}
