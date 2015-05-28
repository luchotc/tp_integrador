package ar.com.ddsutn.resultados;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoOrdenamiento implements Resultado {
	
	private Resultado resultado;
	private Comparator<Receta> comparador;
	
	public ResultadoOrdenamiento() {}
	
	public ResultadoOrdenamiento(Comparator<Receta> comparador)
	{
		this.comparador = comparador;
	}
	
	public ResultadoOrdenamiento(Resultado resultado, Comparator<Receta> comparador)
	{
		this.resultado = resultado;
		this.comparador = comparador;
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return resultado.resultar(recetas.stream().sorted(comparador).collect(Collectors.toList()));
	}
	
	@Override
	public Collection<Receta> resultarStrategy(Collection<Receta> recetas) {
		return recetas.stream().sorted(comparador).collect(Collectors.toList());
	}

	@Override
	public void setResultado(Resultado resultado){
		this.resultado = resultado;
	}
	
	@Override
	public void setResultado(Resultado resultado, Comparator<Receta> comparador){
		this.resultado = resultado;
		this.comparador = comparador;
	}

}
