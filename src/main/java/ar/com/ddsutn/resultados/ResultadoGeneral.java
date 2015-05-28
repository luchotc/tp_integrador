package ar.com.ddsutn.resultados;

import java.util.Collection;
import java.util.Comparator;

import ar.com.ddsutn.integrador.*;

public class ResultadoGeneral {

	Resultado resultado;
	 
		
	public ResultadoGeneral( Resultado resultado, Comparator<Receta> comparador)
	{
		this.resultado = resultado;
	}
	
	public ResultadoGeneral( Resultado resultado)
	{
		this.resultado = resultado;
	}
	 
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public void setResultado( Resultado resultado, Comparator<Receta> comparador)
	{
		this.resultado = resultado;
	}

	public Collection<Receta> resultar(Collection<Receta> recetas)
	{
		return resultado.resultarStrategy(recetas);
	}
	
}
