package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Usuario {

	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private Collection <String> preferenciasAlimenticias;
	private Collection <String> palabrasDisgustan;
	private Collection <Condicion> condiciones;
	
	protected Double altura; //PARA LA IMPLEMENTACION DEL MOCK, DESPUES CAMBIAR
	protected Double peso;
	
	public Usuario()
	{super();}
	
	public Usuario (String nombre,String sexo, LocalDate fechaNacimiento, Double altura, Double peso,Collection<String> preferenciasAlimentacias,Collection<String>palabrasDisgustan, Collection<Condicion>condiciones){
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.peso = peso;
		this.preferenciasAlimenticias = preferenciasAlimentacias;
		this.palabrasDisgustan = palabrasDisgustan;
		this.condiciones = condiciones;
	}
	
	public boolean esValidoElUsuario()
	{	//APLICAR LAMBDA this.condiciones.validarBasico(this);
		return true;
	}
	
	public void validarNombre()
	{if (nombre.length() > 4) 
	{//VER SI CONVIENEN QUE SEAN VOID ESTAS FUNCIONES	
	}
	}
	
	public void validarVeganidad()
	{
		if(true )
		{//funcionQueValidaQueEnLaColleccionBLABLALBA;
			
		}
	}
	
	public void validarSexo()
	{
		if(sexo == null )
		{//funcionQuePideQueSeIngreseSexo;
			
		}
	}
	
	public void validarPreferencia()
	{
		if(true)
		{//funcionQueCheckeaLasPreferencias;
			
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
