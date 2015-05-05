package condicionesExistentes;

import java.util.stream.Stream;

import ar.com.ddsutn.integrador.Comida;
import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

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
		return this.getAzucar(usuario, receta).allMatch(condimento -> condimento.getCantidad() <= 100);
	}
	
	public Stream<Comida> getAzucar(Usuario usuario, Receta receta) 
	{
		return receta.getCondimentos().stream().filter( condimento -> condimento.getNombre().equals("Azucar"));
	}

	}

	
	

