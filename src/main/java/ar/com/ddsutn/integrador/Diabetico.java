package ar.com.ddsutn.integrador;

public class Diabetico implements Condicion{

	public Diabetico(){}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return  usuario.sexo != null &&
				!usuario.preferenciasAlimenticias.isEmpty() ;
	}
	

	@Override
	public void validarRutinaSaludable(Usuario usuario)
	{
		//
	}

	
	
}
