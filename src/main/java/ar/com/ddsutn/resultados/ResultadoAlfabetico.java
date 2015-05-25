package ar.com.ddsutn.resultados;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import ar.com.ddsutn.integrador.*;

public class ResultadoAlfabetico implements Resultado  {
	private Resultado resultado;
	
	public ResultadoAlfabetico(Resultado resultado)
	{
		this.resultado = resultado;
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return recetas.stream().sorted((x,y)-> x.getNombre().compareTo(y.getNombre())).collect(Collectors.toList());
	}
	
	@SuppressWarnings("hiding")
	class comparadorAlfabetico <Receta> implements Comparator<Receta>
	{
		@Override
		public int compare(Receta r1, Receta r2) {
			return ((ar.com.ddsutn.integrador.Receta) r1).getNombre().compareTo(((ar.com.ddsutn.integrador.Receta) r2).getNombre());
		}

	}

}
