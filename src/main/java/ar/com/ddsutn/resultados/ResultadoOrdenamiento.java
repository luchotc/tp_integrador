package ar.com.ddsutn.resultados;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoOrdenamiento implements Resultado {
	
	private Resultado resultado;
	private Comparator<Receta> comparador;
	
	public ResultadoOrdenamiento(Resultado resultado, Comparator<Receta> comparador)
	{
		this.resultado = resultado;
		this.comparador = comparador;
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return resultado.resultar(recetas.stream().sorted(comparador).collect(Collectors.toList()));
	}


}
