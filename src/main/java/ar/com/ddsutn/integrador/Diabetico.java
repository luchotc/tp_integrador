package ar.com.ddsutn.integrador;

public class Diabetico implements Condiciones{

	public void validar(Usuario usuario)
	{usuario.validarSexo();
	 usuario.validarPreferencia();
	}
	
	
}
