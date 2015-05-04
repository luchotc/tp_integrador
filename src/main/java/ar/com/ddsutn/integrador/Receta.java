package ar.com.ddsutn.integrador;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Receta {
	private String nombre;
	private int totalCalorias;
	private Collection <Comida> ingredientes = new HashSet<Comida>();
	protected Collection <Comida> condimentos = new HashSet<Comida>();
	private Collection <String> explicacion = new HashSet<String>();
	private Usuario usuarioQueLaCargo;
	
	public Receta(String nombre, int totalCalorias, Usuario usuarioQueLaCargo){
		this.nombre = nombre;
		this.totalCalorias = totalCalorias;
		this.usuarioQueLaCargo = usuarioQueLaCargo;
	}
	
	public boolean esValida(){
		return !this.ingredientes.isEmpty() &&
				this.totalCalorias > 10 &&
				this.totalCalorias < 5000 ;
	}
	
	public boolean inadecuadoPara(){
		return usuarioQueLaCargo.esInadecuada(this);
	}
	
	/*	setters y getters	*/
	public void addIngrediente(Comida ingrediente)
	{	this.ingredientes.add(ingrediente);		}
	public void addExplicacion(String explicacion)
	{	this.explicacion.add(explicacion);		}
	public void addCondimentos(Comida condimento)
	{	this.condimentos.add(condimento);		}
	public Collection <Comida> getCondimentos()
	{	return this.condimentos;		}
	public Collection <Comida> getIngredientes()
	{	return this.ingredientes;		}
	public Collection<String> getNombreCondimentos() 
	{	return this.getCondimentos().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());	}
	public Collection<String> getNombreIngredientes() 
	{	return this.getIngredientes().stream().map( condimento -> condimento.getNombre()).collect(Collectors.toList());	}
	
}
