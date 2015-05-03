package ar.com.ddsutn.integrador;

public class Hipertenso implements Condicion{

	public Hipertenso(){}
	
	@Override
	public boolean esValidoPorCondicion(Usuario usuario)
	{
		return !usuario.getPreferenciasAlimenticias().isEmpty();
	}
	
	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return usuario.getRutina().equals("INTENSIVO");
	}

	@Override
	public boolean esAdecuada(Usuario usuario, Receta receta) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
