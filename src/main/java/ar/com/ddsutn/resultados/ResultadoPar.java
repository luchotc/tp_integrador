package ar.com.ddsutn.resultados;

import java.util.ArrayList;
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
		
		Collection<Receta> recetasPares = new ArrayList<>();
		
		ArrayList<Receta> recetasTotales = (ArrayList<Receta>) recetas;
		
		for (int i=0;i<recetasTotales.size();i=i+2)
		{
			recetasPares.add(recetasTotales.get(i));
		
		}
		
		return resultado.resultar(recetasPares);
	}

}
