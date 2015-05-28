package filtros;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public interface Filtro {
	public boolean filtrar(Receta receta,Usuario usuario);
	public boolean filtrarStrategy(Receta receta,Usuario usuario);
}
