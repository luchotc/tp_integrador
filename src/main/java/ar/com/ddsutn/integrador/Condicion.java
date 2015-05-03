package ar.com.ddsutn.integrador;

public interface Condicion {
	
	public boolean esValidoPorCondicion(Usuario usuario);
	public boolean lograSubsanar(Usuario usuario);
	public boolean esAdecuada(Usuario usuario, Receta receta);

}
