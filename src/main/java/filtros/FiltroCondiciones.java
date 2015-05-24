package filtros;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class FiltroCondiciones implements Filtro {
	private Filtro filtro;
	
	public FiltroCondiciones(Filtro filtro)
	{
		this.filtro = filtro;
	}

	@Override
	public boolean filtrar(Receta receta, Usuario usuario) {
		if(!usuario.esInadecuada(receta))
		{
			return filtro.filtrar(receta, usuario);
		}
		return false;
	}
}
