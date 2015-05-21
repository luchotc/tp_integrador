package ar.com.ddsutn.integrador;

import java.time.LocalDate;

public class UsuarioMock extends Usuario {

	public UsuarioMock(String string, double d, double e, LocalDate of,
			TipoRutina rut, String string3) {
		super (string,d,e,of,rut,string3);
		// TODO Auto-generated constructor stub
	}

	public Receta devuelveRecetaModificada(Receta receta, Receta recetaModificada)
	{
		if(puedeVerOModificarReceta(receta))
			if (receta.esPublica())
			{
				Receta recetaAgregada = agregarAPropias(receta);
				recetaAgregada.modificarSegun(recetaModificada);
				return recetaAgregada;
				
			}
			else
			{
				receta.modificarSegun(recetaModificada);
			}
		return receta;
		
	}
	
}
