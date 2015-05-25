package ar.com.ddsutn.resultados;

import java.util.ArrayList;
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
		Collection<Receta> recetasDiez = new ArrayList<>();
		ArrayList<Receta> recetasTotales = new ArrayList<>(recetas);
		for (int i=0;i<10;i++)
		{
			recetasDiez.add(recetasTotales.get(i));
		}
		return resultado.resultar(recetasDiez);
	}

}
