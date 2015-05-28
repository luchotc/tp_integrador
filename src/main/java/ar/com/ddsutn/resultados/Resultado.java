package ar.com.ddsutn.resultados;

import java.util.Collection;



import java.util.Comparator;

import ar.com.ddsutn.integrador.Receta;

public interface Resultado {
	public Collection <Receta> resultar(Collection<Receta> recetas);
	public Collection<Receta> resultarStrategy(Collection<Receta> recetas);
	public void setResultado(Resultado resultado);
	public void setResultado(Resultado resultado, Comparator<Receta> comparador);
}
