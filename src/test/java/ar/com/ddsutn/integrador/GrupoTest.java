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
	private Grupo suricatas;
	private Receta bifes;
	private BaseUsuarios usuarios;
	private BaseRecetas recetas;
	private BaseGrupos grupos;
	
	@Before
	public void setUp() {

		iniciarBases();
		crearUsuarios();
		crearRecetas();
		crearGrupos();
		agregarUsuarios();
	
		Receta.RecetasPublicas = new ArrayList<Receta>();	
	}

	private void iniciarBases() {
		usuarios = new BaseUsuarios();
		recetas = new BaseRecetas();	
		grupos = new BaseGrupos();
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
	
	private void crearGrupos() {
		suricatas = grupos.getSuricatas();
	}

	private void agregarUsuarios() {
		suricatas.agregarUsuario(fede);
		suricatas.agregarUsuario(lucho);
		suricatas.agregarUsuario(nicoLuis);
		suricatas.agregarUsuario(rama);
	}

	@Test
	public void elGrupoTieneLaRecetaDeUnMiembro()
	{
		nicoLuis.addReceta(bifes);
		boolean retorno = (suricatas.getRecetasGrupo()).stream().anyMatch(r -> r.equals(bifes));
		assertEquals(true, retorno);
	}
	
	@Test
	public void unUsuarioDeGrupoPuedeVerOModificarRecetaDeOtroMiembroDeGrupo()
	{
		nicoLuis.addReceta(bifes);
		assertEquals(true, fede.puedeVerOModificar(bifes));
	}
	
}
