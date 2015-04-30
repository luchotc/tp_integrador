package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.Collection;

public class Usuario {

	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private Collection <String> preferenciasAlimenticias;
	private Collection <String> palabrasDisgustan;
	
	private Double altura;
	private Double peso;
	
	public Usuario()
	{super();}
	
	public Usuario (String nombre,String sexo, LocalDate fechaNacimiento, Double altura, Double peso,Collection<String> preferenciasAlimentacias,Collection<String>palabrasDisgustan){
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.peso = peso;
		this.preferenciasAlimenticias = preferenciasAlimentacias;
		this.palabrasDisgustan = palabrasDisgustan;
	}
	
	public void validarSexo()
	{
		if(sexo == null )
		{//funcionQuePideQueSeIngreseSexo;
			
		}
	}
	
	public void validarPreferencia()
	{
		if(sexo == null )
		{//funcionQuePideQueSeIngreseSexo;
			
		}
	}  //VER DE HACER ESTOS METODOS POLIMORFICOS A FUTURO
	
	public Double imc ()
	 {
	  Double cuadradoAltura = Math.pow(altura, 2);
	  return peso/cuadradoAltura;
	 }

	public Collection <String> getPreferenciasAlimenticias() {
		return preferenciasAlimenticias;
	}

	public void setPreferenciasAlimenticias(Collection <String> preferenciasAlimenticias) {
		this.preferenciasAlimenticias = preferenciasAlimenticias;
	}

	public Collection <String> getPalabrasDisgustan() {
		return palabrasDisgustan;
	}

	public void setPalabrasDisgustan(Collection <String> palabrasDisgustan) {
		this.palabrasDisgustan = palabrasDisgustan;
	}
}
