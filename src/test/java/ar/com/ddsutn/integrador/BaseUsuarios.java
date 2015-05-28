package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.com.ddsutn.condicionesExistentes.Condicion;

public class BaseUsuarios {
	private Usuario rama;
	private Usuario fede;
	private Usuario nicoLuis;
	private Usuario lucho;
	
	public BaseUsuarios()
	{
		crearUsuarios();
		Usuario.SetCondicionesExistentes();
	}

	private void crearUsuarios() {
		crearRama();
		crearFede();
		crearNicoLuis();
		crearLucho();
	}

	private void crearRama() {
		rama = new Usuario("rama", 60.0, 2.00, LocalDate.of(1994,03,29), TipoRutina.LEVE, null);
		iniciarVariables(rama);
	}

	private void crearFede() {
		fede = new Usuario("federico", 72.0, 1.20, LocalDate.of(1995,1,18), TipoRutina.LEVE, "Masculino");
		iniciarVariables(fede);
}

	private void crearNicoLuis() {
		nicoLuis = new Usuario("nicoLuis", 57.8 , 1.70, LocalDate.of(1995,6,24) ,TipoRutina.NADA, null);
		iniciarVariables(nicoLuis);
	}

	private void crearLucho() {
		lucho = new Usuario("lucho",  81.0, 1.80, LocalDate.of(1995,3,20), TipoRutina.INTENSIVO, null);
		iniciarVariables(lucho);
	}
	
	private void iniciarVariables(Usuario usuario)
	{
		usuario.setCondiciones(new ArrayList<Condicion>());
		usuario.setPreferenciasAlimenticias(new ArrayList<String>());
		usuario.setPalabrasDisgustan(new ArrayList<String>());
		usuario.setRecetas(new ArrayList<Receta>());
		usuario.setGrupos(new ArrayList<Grupo>());
		usuario.setRecetasFavoritas(new ArrayList<Receta>());
	}
	
	public Usuario crearUsuarioTemporal()
	{
		Usuario carlitos = new Usuario("carlitos",  81.0, 1.80, LocalDate.of(1995,3,20), TipoRutina.INTENSIVO, null);
		iniciarVariables(carlitos);
		return carlitos;
	}
	
	public Usuario getRama() {
		return rama;
	}

	public void setRama(Usuario rama) {
		this.rama = rama;
	}

	public Usuario getFede() {
		return fede;
	}

	public void setFede(Usuario fede) {
		this.fede = fede;
	}

	public Usuario getNicoLuis() {
		return nicoLuis;
	}

	public void setNicoLuis(Usuario nicoLuis) {
		this.nicoLuis = nicoLuis;
	}

	public Usuario getLucho() {
		return lucho;
	}

	public void setLucho(Usuario lucho) {
		this.lucho = lucho;
	}
}
