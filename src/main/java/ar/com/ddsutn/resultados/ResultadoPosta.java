package ar.com.ddsutn.resultados;

import java.util.Collection;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoPosta implements Resultado{

	public ResultadoPosta()
	{
		
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return recetas;
	}

}
