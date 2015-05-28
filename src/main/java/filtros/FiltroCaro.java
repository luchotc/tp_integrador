package filtros;

import ar.com.ddsutn.integrador.*;

public class FiltroCaro implements Filtro {
	private Filtro filtro;
	
	public FiltroCaro(){}
	
	public FiltroCaro(Filtro filtro)
	{
		this.filtro = filtro;
	}

	@Override
	public boolean filtrar(Receta receta, Usuario usuario) {
		if(!receta.esCara())
		{
			return filtro.filtrar(receta, usuario);
		}
		return false;
	}
	
	@Override
	public boolean filtrarStrategy(Receta receta, Usuario usuario) {
		return !receta.esCara();
	}
	
}
