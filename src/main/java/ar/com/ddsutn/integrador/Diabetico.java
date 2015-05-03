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
	
	@Override
	public boolean esAdecuada(Usuario usuario, Receta receta) 
	{
		return true;
	}
	
	public Stream<Condimento> getAzucar(Usuario usuario, Receta receta) 
	{
		return receta.getCondimentos().stream().filter( condimento -> condimento.getNombre().equals("Azucar"));
	}

	
	
}
