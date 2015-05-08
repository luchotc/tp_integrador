package ar.com.ddsutn.integrador;

public class Comida {

	private String nombre;
	private Double cantidad;
	
	public Comida(String nombre, String cantidad){
		this.nombre = nombre;
		if (cantidad.equals("C/N"))
		setCantidad(0.0);
		//si no es C/N lanzariamos una excepcion
	}
	
	public Comida(String nombre,Double cantidad)
	{
		this.nombre = nombre;
		this.setCantidad(cantidad);
	}
	
	public Comida(String nombre)
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
