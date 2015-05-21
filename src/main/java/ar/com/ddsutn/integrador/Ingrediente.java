package ar.com.ddsutn.integrador;

public class Ingrediente {

	private String nombre;
	private Double cantidad;
	

	
	public Ingrediente(String nombre,Double cantidad)
	{
		this.nombre = nombre;
		this.setCantidad(cantidad);
	}
	
	public Ingrediente(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{	
		return nombre;		
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
}
