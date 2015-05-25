package ar.com.ddsutn.resultados;

import java.util.Collection;
import java.util.Collections;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoCalorias implements Resultado {

	private Resultado resultado;
	
	public ResultadoCalorias(Resultado resultado)
	{
		this.resultado = resultado;
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		recetas.stream().sorted((x,y)-> x.getNombre().compareTo(y.getNombre()));
		return null;
	}

}
