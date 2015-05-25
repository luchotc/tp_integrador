package ar.com.ddsutn.resultados;

import java.util.Collection;

import java.util.Comparator;

import ar.com.ddsutn.integrador.Receta;

public interface Resultado {
	public Collection <Receta> resultar(Collection<Receta> recetas);

}
