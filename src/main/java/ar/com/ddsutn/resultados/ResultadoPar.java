package ar.com.ddsutn.resultados;

import java.util.Collection;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoPar implements Resultado  {

	private Resultado resultado;
	
	public ResultadoPar(Resultado resultado)
	{
		this.resultado = resultado;
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return null;
	}

}