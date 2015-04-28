package ar.com.ddsutn.integrador;

public class Usuario {

	private Double altura;
	private Double peso;
	
	public Usuario (Double altura, Double peso){
	this.altura = altura;
	this.peso = peso;
	}
	
	public Double imc ()
	 {
	  Double cuadrado = Math.pow(altura, 2);
	  return peso/cuadrado;
	 }
}
