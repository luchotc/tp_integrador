package ar.com.ddsutn.resultados;

import java.util.Collection;

import ar.com.ddsutn.integrador.Receta;

public interface Resultado {
	public Collection <Receta> resultar(Collection<Receta> recetas);

}
