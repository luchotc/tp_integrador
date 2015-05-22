package ar.com.ddsutn.integrador;

import ar.com.ddsutn.condicionesExistentes.Condicion;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class GrupoTest {

	private Usuario lucho;
	private Usuario fede;
	private Usuario rama;
	private Usuario nicoLuis;
	private Grupo lasSuris;
	private Receta bifes;
	

	@Before
	
	public void setUp() {
	
	bifes = new Receta("Bifes a la criolla con papas y arvejas", 785, "Todas");
	lasSuris = new Grupo("Suricatas 2.0");
	lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,3,20), TipoRutina.INTENSIVO, null);
	fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), TipoRutina.LEVE, "Masculino");
	rama = new Usuario("nico", 60.0, 2.00, LocalDate.of(1994,03,29), TipoRutina.LEVE, null);
	nicoLuis = new Usuario("nicoLuis", 57.8 , 1.70, LocalDate.of(1995,6,24) ,TipoRutina.NADA, null);
	//Todo lo de receta
	bifes.setIngredientes(new ArrayList<Ingrediente>());
	bifes.setCondimentos(new ArrayList<Condimento>());
	bifes.setExplicaciones(new ArrayList<String>());
	bifes.setSubRecetas(new ArrayList<Receta>());
	bifes.setDificultad("Media");
	//Condiciones
	nicoLuis.setCondiciones(new ArrayList<Condicion>());
	rama.setCondiciones(new ArrayList<Condicion>());
	fede.setCondiciones(new ArrayList<Condicion>());
	lucho.setCondiciones(new ArrayList<Condicion>());
	//Pref. Alimenticias
	nicoLuis.setPreferenciasAlimenticias(new ArrayList<String>());
	rama.setPreferenciasAlimenticias(new ArrayList<String>());
	fede.setPreferenciasAlimenticias(new ArrayList<String>());
	lucho.setPreferenciasAlimenticias(new ArrayList<String>());
	//Usuarios del grupo
	lasSuris.setUsuarios(new ArrayList<Usuario>());
	//Grupos de cada usuario
	fede.setGrupos(new ArrayList<Grupo>());
	lucho.setGrupos(new ArrayList<Grupo>());
	rama.setGrupos(new ArrayList<Grupo>());
	nicoLuis.setGrupos(new ArrayList<Grupo>());
	//Recetas
	nicoLuis.setRecetas(new ArrayList<Receta>());
	fede.setRecetas(new ArrayList<Receta>());
	lucho.setRecetas(new ArrayList<Receta>());
	rama.setRecetas(new ArrayList<Receta>());
	//Agregar Usuarios
	lasSuris.agregarUsuario(fede);
	lasSuris.agregarUsuario(lucho);
	lasSuris.agregarUsuario(nicoLuis);
	lasSuris.agregarUsuario(rama);
	
	Receta.RecetasPublicas = new ArrayList<Receta>();
		
	}
	
	
	@Test
	public void unUsuarioDeGrupoPuedeVerOModificarRecetaDeOtroMiembroDeGrupo()
	{
		nicoLuis.addReceta(bifes);
		assertEquals(true, fede.puedeVerOModificar(bifes));
	}
	
}
