package ar.com.ddsutn.resultados;

import java.util.Collection;

import ar.com.ddsutn.integrador.Receta;

public class ResultadoPrimeros10 implements Resultado  {

	private Resultado resultado;
	
	public ResultadoPrimeros10(Resultado resultado)
	{
		this.resultado = resultado;
	}
	
	@Override
	public Collection<Receta> resultar(Collection<Receta> recetas) {
		return null;
	}

}
