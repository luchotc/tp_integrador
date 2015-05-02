package ar.com.ddsutn.integrador;


public class Vegano extends Usuario implements Condicion{

	public Vegano(){}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return  !(usuario.preferenciasAlimenticias.contains("pollo") ||
				usuario.preferenciasAlimenticias.contains("carne") ||
				usuario.preferenciasAlimenticias.contains("chivito") ||
				usuario.preferenciasAlimenticias.contains("chori") );
	}
	
	@Override
	public void validarRutinaSaludable(Usuario usuario)
	{
		//
	}
	
}
