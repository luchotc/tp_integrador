package ar.com.ddsutn.integrador;

import java.util.Collection;

public class Grupo {
	
	private Collection <Usuario> usuarios;
	private Collection <String> preferenciasAlimenticias;
	private String nombre;
	
	public Grupo (String nombre){
		this.setNombre(nombre);
	}

	public Collection <String> getPreferenciasAlimenticias() 
	{	
		return preferenciasAlimenticias;	
	}
	
	public void setPreferenciasAlimenticias(Collection <String> preferenciasAlimenticias)
	{	
		this.preferenciasAlimenticias = preferenciasAlimenticias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection <Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection <Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}