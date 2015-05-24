package filtros;

import ar.com.ddsutn.integrador.Receta;
import ar.com.ddsutn.integrador.Usuario;

public class FiltroCalorias implements Filtro{
	private Filtro filtro;
	
	public FiltroCalorias(Filtro filtro)
	{
		this.filtro = filtro;
	}

	@Override
	public boolean filtrar(Receta receta, Usuario usuario) {
		//no entendi bien como es lo de sobrepeso, falta esa parte
		return filtro.filtrar(receta, usuario);
	}

}
