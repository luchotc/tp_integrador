package filtros;

import ar.com.ddsutn.integrador.*;

public class FiltroGeneral {
	Filtro filtro;
 
	public FiltroGeneral( Filtro filtro )
	{
		this.filtro = filtro;
	}
 
	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}
 
	public boolean filtrar(Receta receta, Usuario usuario)
	{
		return filtro.filtrarStrategy(receta, usuario);
	}
}
