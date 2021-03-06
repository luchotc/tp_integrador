package ar.com.ddsutn.integrador;

import java.util.ArrayList;

public class BaseGrupos {

	private Grupo suricatas;

	public BaseGrupos()
	{
		crearSuricatas();
	}
	
	private void crearSuricatas() {
		suricatas = new Grupo("Suricatas 2.0");
		iniciarVariables(suricatas);
	}

	private void iniciarVariables(Grupo grupo) {
		grupo.setUsuarios(new ArrayList<>());
		grupo.setPreferenciasAlimenticias(new ArrayList<>());
	}

	public Grupo getSuricatas() {
		return suricatas;
	}

}
