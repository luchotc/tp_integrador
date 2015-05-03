package ar.com.ddsutn.integrador;

import java.util.Collection;
import java.util.HashSet;

public class Receta {
	private String nombre;
	private int totalCalorias;
	private Collection <String> ingredientes = new HashSet<String>();
	protected Collection <Condimento> condimentos = new HashSet<Condimento>();
	private Collection <String> explicacion = new HashSet<String>();
	private Usuario usuarioQueLaCargo;
	
	public Receta(String nombre, int totalCalorias, Usuario usuarioQueLaCargo){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
		this.usuarioQueLaCargo = usuarioQueLaCargo;
	}
	
	public boolean recetaValida(){
		return !this.ingredientes.isEmpty() &&
				this.totalCalorias > 10 &&
				this.totalCalorias < 5000 ;
	}
	
	public boolean inadecuadoPara(){
		return usuarioQueLaCargo.esInadecuada(this);
	}
	
	
	/*	setters y getters	*/
	public void addIngrediente(String ingrediente)
	{	this.ingredientes.add(ingrediente);		}
	public void addExplicacion(String explicacion)
	{	this.explicacion.add(explicacion);		}
	public Collection <Condimento> getCondimentos()
	{	return this.condimentos;		}
}
