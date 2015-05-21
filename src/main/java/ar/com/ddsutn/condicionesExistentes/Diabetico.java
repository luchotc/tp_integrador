package ar.com.ddsutn.condicionesExistentes;


import ar.com.ddsutn.integrador.Condimento;
import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

import java.util.stream.Stream;

public class Diabetico implements Condicion{

	public Diabetico(){}
	
	@Override
	public boolean validar(Usuario usuario)
	{
		return  usuario.getSexo() != null &&
				!usuario.getPreferenciasAlimenticias().isEmpty() ;
	}
	

	@Override
	public boolean lograSubsanar(Usuario usuario) 
	{
		return !usuario.esSedentario() || usuario.getPeso() <= 70;
	}
	
	@Override
	public boolean esAdecuada(Receta receta) 
	{
		return  getAzucar(receta).mapToDouble( condimento -> condimento.getCantidad()).sum() <100;
	}
	
	public Stream<Condimento> getAzucar(Receta receta) 
	{
		return receta.getCondimentos().stream().filter( condimento -> condimento.getNombre().equals("Azucar"));
	}
	
}
