package ar.com.ddsutn.integrador;

public class Diabetico implements Condicion{

	public Diabetico(){}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return  usuario.getSexo() != null &&
				!usuario.getPreferenciasAlimenticias().isEmpty() ;
	}
	

	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return !usuario.rutinaSedentaria() || usuario.getPeso() <= 70;
	}

	
	
}
