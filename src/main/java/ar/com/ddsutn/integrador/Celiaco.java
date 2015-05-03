package ar.com.ddsutn.integrador;

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

}
