package ar.com.ddsutn.integrador;

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
	private BaseUsuarios usuarios;
	private BaseRecetas recetas;
	
	@Before
	public void setUp() {
		
		lasSuris = new Grupo("Suricatas 2.0");

		iniciarBases();
		crearUsuarios();
		crearRecetas();
		agregarUsuarios();
	
		Receta.RecetasPublicas = new ArrayList<Receta>();	
	}

	private void iniciarBases() {
		usuarios = new BaseUsuarios();
		recetas = new BaseRecetas();		
	}

	private void crearUsuarios() {
		lucho = usuarios.getLucho();
		fede = usuarios.getFede();
		nicoLuis = usuarios.getNicoLuis();
		rama = usuarios.getRama();
	}

	private void crearRecetas() {
		bifes = recetas.getBifes();
	}

	private void agregarUsuarios() {
		lasSuris.setUsuarios(new ArrayList<Usuario>());
		lasSuris.agregarUsuario(fede);
		lasSuris.agregarUsuario(lucho);
		lasSuris.agregarUsuario(nicoLuis);
		lasSuris.agregarUsuario(rama);
	}

	@Test
	public void elGrupoTieneLaRecetaDeUnMiembro()
	{
		nicoLuis.addReceta(bifes);
		boolean retorno = (lasSuris.getRecetasGrupo()).stream().anyMatch(r -> r.equals(bifes));
		assertEquals(true, retorno);
	}
	
	@Test
	public void unUsuarioDeGrupoPuedeVerOModificarRecetaDeOtroMiembroDeGrupo()
	{
		nicoLuis.addReceta(bifes);
		assertEquals(true, fede.puedeVerOModificar(bifes));
	}
	
}
