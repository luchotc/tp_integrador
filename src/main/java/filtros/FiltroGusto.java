package filtros;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class FiltroGusto implements Filtro {
	private Filtro filtro;
	
	public FiltroGusto(Filtro filtro)
	{
		this.filtro = filtro;
	}

	@Override
	public boolean filtrar(Receta receta, Usuario usuario) {
		if(!usuario.incluyeIngredienteQueDisgusta(receta))
		{
			return filtro.filtrar(receta, usuario);
		}
		return false;
	}
}
