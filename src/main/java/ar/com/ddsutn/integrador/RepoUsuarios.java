package ar.com.ddsutn.integrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.*;

public class RepoUsuarios {
	
	private Collection <Usuario> usuarios;

	
	public RepoUsuarios ()
	{
	
	}
	
	public void update(Usuario usuario)
	{
		
	}
	
	/*public Usuario get(Usuario usuario)//Debería encontrar el primero que cumpla con el nombre ese, pero no estaría andando
	{
		Usuario usuarioRetorno = usuarios.stream().findFirst(u -> (u.getNombre()).equals(usuario.getNombre()));
		return usuarioRetorno;
	}*/
	
	public Collection<Usuario> list (Usuario usuario)
	{
		Collection<Usuario> retorno = new ArrayList<Usuario>();
		retorno = usuarios.stream().filter(u -> (u.getNombre()).equals(usuario.getNombre())).collect(Collectors.toList()); //Filtra por nombre, buscando los que cumplen
		/*if(tieneCondPreexistentes)
		{
			retorno = retorno.stream().filter(u-> u.cumpleCondPreexistentes(condPreexistentes));
		}*/ 
		//Pseudocódigo medio ladrón, si tiene condiciones preexistentes (no sé dónde) filtra de nuevo, ahora buscando usuarios que tengan la condición puesta.
		// Ver cumpleCondPreexistentes en Usuario
		return retorno;
	}
	
}
