package ar.com.ddsutn.integrador;

public class Hipertenso implements Condicion{

	public Hipertenso(){}
	
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
