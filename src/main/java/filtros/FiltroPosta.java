package filtros;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class FiltroPosta implements Filtro {

	
	@Override
	public boolean filtrar(Receta receta, Usuario usuario) {
		return true;
	}	
	
	@Override
	public boolean filtrarStrategy(Receta receta, Usuario usuario) {
		return true;
	}
	
	@Override
	public void setFiltro(Filtro filtro){}
}
