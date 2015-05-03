package ar.com.ddsutn.integrador;


public class Vegano extends Usuario implements Condicion{

	public Vegano(){}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return  !(usuario.getPreferenciasAlimenticias().contains("pollo") ||
				usuario.getPreferenciasAlimenticias().contains("carne") ||
				usuario.getPreferenciasAlimenticias().contains("chivito") ||
				usuario.getPreferenciasAlimenticias().contains("chori") );
	}
	
	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return usuario.getPreferenciasAlimenticias().contains("frutas");
	}
	
}
