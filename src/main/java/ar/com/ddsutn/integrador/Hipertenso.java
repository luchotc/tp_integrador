package ar.com.ddsutn.integrador;

public class Hipertenso implements Condicion{

	@Override
	public void validarBasico(Usuario usuario)
	{ usuario.validarPreferencia();
	}
	
	@Override
	public void validarRutinaSaludable(Usuario usuario)
	{
		//
	}
	
}
