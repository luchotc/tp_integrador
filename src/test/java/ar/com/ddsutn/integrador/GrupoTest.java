package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;

import ar.com.ddsutn.condicionesExistentes.Condicion;

public class GrupoTest {

	private Usuario lucho;
	private Usuario fede;
	private Usuario rama;
	private Usuario nicoLuis;
	private Grupo lasSuris;

	@Before
	
	public void setUp() {
	
	lasSuris = new Grupo("Suricatas 2.0");	
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,3,20), TipoRutina.INTENSIVO, null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), TipoRutina.LEVE, "Masculino");
	rama = new Usuario("nico", 60.0, 2.00, LocalDate.of(1994,03,29), TipoRutina.LEVE, null);
	nicoLuis = new Usuario("nicoLuis", 57.8 , 1.70, LocalDate.of(1995,6,24) ,TipoRutina.NADA, null);
	nicoLuis.setCondiciones(new ArrayList<Condicion>());
	nicoLuis.setPreferenciasAlimenticias(new ArrayList<String>());
	lasSuris.agregarUsuario (fede);
	lasSuris.agregarUsuario (lucho);
	lasSuris.agregarUsuario (nicoLuis);
	lasSuris.agregarUsuario (rama);
	
	
	
	}
}
