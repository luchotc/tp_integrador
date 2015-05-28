package ar.com.ddsutn.resultados;

import java.util.Collection;
import java.util.Comparator;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoPosta implements Resultado{

	public ResultadoPosta() {}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return recetas;
	}
	
	@Override
	public Collection<Receta> resultarStrategy(Collection<Receta> recetas) {
		return recetas;
	}


	@Override
	public void setResultado(Resultado resultado, Comparator<Receta> comparador) {}
	
	@Override
	public void setResultado(Resultado resultado) {}
}
