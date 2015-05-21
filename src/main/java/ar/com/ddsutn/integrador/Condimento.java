package ar.com.ddsutn.integrador;

public class Condimento extends Ingrediente {

	
	public Condimento(String nombre, String cantidad){
		super(nombre);
		if (cantidad.equals("C/N"))
		setCantidad(0.0);
		//si no es C/N lanzariamos una excepcion
	}

}
