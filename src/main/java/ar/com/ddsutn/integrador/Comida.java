package ar.com.ddsutn.integrador;

public class Comida {

	private String nombre;
	private Double cantidad;
	
	public Comida(String nombre, Double cantidad){
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public String getNombre()
	{	
		return nombre;		
	}
	
	public Double getCantidad()
	{	
		return cantidad;	
	}

}
