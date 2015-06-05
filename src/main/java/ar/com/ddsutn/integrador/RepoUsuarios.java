package ar.com.ddsutn.integrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.*;

public class RepoUsuarios {
	
	private Collection <Usuario> usuarios;

	
	public RepoUsuarios ()
	{
	
	}
	
	public void update(Usuario usuario)
	{
		
	}
	
	/*public Optional<Usuario> get(Usuario usuario)
	{
		Optional<Usuario> usuarioRetorno = usuarios.stream().filter(u -> (u.getNombre()).equals(usuario.getNombre())).findFirst();
		return usuarioRetorno;
	}*/
	//No sé si anda esto, pero con tipo Usuario no anda el findFirst. Puede que lo esté pensando mal, pero es lo que se me ocurrió.
	//Capaz se tiene que usar otra cosa, pero findFirst devuelve un Optional (Optional<T> devuelve un Null si no encuentra nada, y el objeto de tipo T si encuentra).
	
	public Collection<Usuario> list (Usuario usuario)
	{
		Collection<Usuario> retorno = new ArrayList<Usuario>();
		retorno = usuarios.stream().filter(u -> (u.getNombre()).contains(usuario.getNombre())).collect(Collectors.toList()); //Filtra por nombre, buscando los que cumplen
		/*if(tieneCondPreexistentes)
		{
			retorno = retorno.stream().filter(u-> u.cumpleCondPreexistentes(condPreexistentes));
		}*/ 
		//Pseudocódigo medio ladrón, si tiene condiciones preexistentes (no sé dónde) filtra de nuevo, ahora buscando usuarios que tengan la condición puesta.
		// Ver cumpleCondPreexistentes en Usuario
		return retorno;
	}
	
}
