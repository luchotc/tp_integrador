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
	
	private String rutina;		// ------ es String?? ------ <----<----<----<---- Revisar
	
	/*
	protected Double altura; //PARA LA IMPLEMENTACION DEL MOCK, DESPUES CAMBIAR
	protected Double peso;
	(Le tienen que explicar a nico luis como es el tema del mock)
	*/
	
	private Double altura;
	private Double peso;
	
	public Usuario()
	{super();}
	
	public Usuario (String nombre, Double peso, Double altura, LocalDate fechaNacimiento, String sexo, Collection<Condicion>condiciones){
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.condiciones = condiciones;
		/* elimine a this.preferenciasAlimenticias = preferenciasAlimentacias del constructor
		 elimine a this.palabrasDisgustan = palabrasDisgustan del constructor
		 => demasiados campos (creo que condiciones y sexo tambien deberian setearse fuera del contructor y rutina dentro)
		 Modifique los campos para que tengan el orden que se pide en el enunciado */
	}
	
	public Double imc ()
	 {
	  Double cuadradoAltura = Math.pow(altura, 2);
	  return peso/cuadradoAltura;
	  /* hace falta hacer Double cuadradoAltura? no seria mejor:
	   public Double imc () { return peso/Math.pow(altura, 2) } ?
	   o es mejor la expresividad de cuadradoAltura? */
	 }
	
	
	/*	IMPLEMENTACION ANTERIOR POR LUCHO
	
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
	*/
	
	//  NUEVA IMPLEMENTACION
	public boolean esValidoPorNombre(){
		return this.nombre.length() > 4;
	}
	
	public boolean esValidoPorFecha(){
		return LocalDate.now().isAfter(this.fechaNacimiento);
	}
	
	/* esValidoPorNombre() y esValidoPorFecha() las hice solo por expresividad
	pero se podria incluir directamente el valor de retorno dentro
	del return de esValidoPorCampos() */

	public boolean esValidoPorCampos() {
		return (this.nombre != null && 
				this.peso != null && 
				this.altura != null && 
				this.fechaNacimiento != null && 
				this.rutina != null &&
				esValidoPorNombre() &&
				esValidoPorFecha() );
	}
	
	public boolean esValido() {
		return (esValidoPorCampos());
		/* Para probar los test quedo asi, pero deberia ser algo como: 
		 return (esValidoPorCampos() && esValidoPorCondicion());
		 donde esValidoPorCondicion() iria en cada clase condicion (hipertenso, diabetico, etc) */
	}
	
	
	
	
	public Collection <String> getPreferenciasAlimenticias() {
		return this.preferenciasAlimenticias;
		// cambie return preferenciasAlimenticias por return this.preferenciasAlimenticias;
	}

	public void setPreferenciasAlimenticias(Collection <String> preferenciasAlimenticias) {
		this.preferenciasAlimenticias = preferenciasAlimenticias;
	}

	public Collection <String> getPalabrasDisgustan() {
		return this.palabrasDisgustan;
		// cambie return palabrasDisgustan por return this.palabrasDisgustan;
	}

	public void setPalabrasDisgustan(Collection <String> palabrasDisgustan) {
		this.palabrasDisgustan = palabrasDisgustan;
	}
	
	public String getRutina() {
		return this.rutina;
	}

	public void setRutina(String rutina) {
		this.rutina = rutina;
	}
}
