package ar.com.ddsutn.integrador;

public class Vegano implements Condicion{

	@Override
	public void validarBasico(Usuario usuario)
	{ usuario.validarVeganidad();
	}
	
	@Override
	public void validarRutinaSaludable(Usuario usuario)
	{
		//
	}
	
}
