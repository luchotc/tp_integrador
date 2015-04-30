package ar.com.ddsutn.integrador;

public class Diabetico implements Condicion{

	@Override
	public void validarBasico(Usuario usuario)
	{usuario.validarSexo();
	 usuario.validarPreferencia();
	}
	

	@Override
	public void validarRutinaSaludable(Usuario usuario)
	{
		//
	}

	
	
}
