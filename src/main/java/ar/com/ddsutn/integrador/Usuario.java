package ar.com.ddsutn.integrador;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class Usuario {

	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private Collection <String> preferenciasAlimenticias = new HashSet<String>();
	private Collection <String> palabrasDisgustan = new HashSet<String>();
	protected Collection <Condicion> condiciones = new HashSet<Condicion>();	// Revisar si es correcto el uso de HashSet<String>(), o si hay otra forma
	private Double altura;
	private Double peso;
	private String rutina;		// ------ es String?? ------ <----<----<----<---- Revisar
	
	public Usuario()
	{super();}
	
	public Usuario (String nombre, Double peso, Double altura, LocalDate fechaNacimiento, String rutina, String sexo){
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.rutina = rutina;
	}
	
	public Double imc ()
	 {
	  return peso/Math.pow(altura, 2);
	  /* habia un Double cuadradoAltura = Math.pow(altura, 2);
	     return peso/cuadradoAltura (el ayudante ya habia tirado que declarar una variable solo para esto no esta bien) */
	 }
	
	
	public boolean esValido() {
		return esValidoPorCampos() && this.condiciones.stream().allMatch(usuario -> usuario.esValidoPorCondicion(this));
	}

	public boolean esValidoPorCampos() {
		return  this.nombre != null && 
				this.peso != null && 
				this.altura != null && 
				this.fechaNacimiento != null && 
				this.rutina != null &&
				esValidoPorNombre() &&
				esValidoPorFecha();
	}
	
	public boolean esValidoPorNombre(){
		return this.nombre.length() > 4;
	}
	
	public boolean esValidoPorFecha(){
		return LocalDate.now().isAfter(this.fechaNacimiento);
	}
	
	/* esValidoPorNombre() y esValidoPorFecha() las hice solo por expresividad
	pero se podria incluir directamente el valor de retorno dentro
	del return de esValidoPorCampos() 
	return  this.nombre != null && ... && this.nombre.length() > 4 && LocalDate.now().isAfter(this.fechaNacimiento);
	decidan cual prefieren*/
	
	public boolean sigueRutinaSaludable(){
		return  18 < this.imc() && 
				this.imc() < 30 &&
				this.condiciones.stream().allMatch(usuario -> usuario.lograSubsanar(this));
	}
	

	
	
	/*	setters y getters	*/
	
	public Collection <String> getPreferenciasAlimenticias() {
		return this.preferenciasAlimenticias;
	}
	public void setPreferenciasAlimenticias(Collection <String> preferenciasAlimenticias) {
		this.preferenciasAlimenticias = preferenciasAlimenticias;
	}
	public void aniadirPreferencia(String preferenciasAlimenticias){
		this.preferenciasAlimenticias.add(preferenciasAlimenticias);
	}

	public Collection <String> getPalabrasDisgustan() {
		return this.palabrasDisgustan;
	}
	public void setPalabrasDisgustan(Collection <String> palabrasDisgustan) {
		this.palabrasDisgustan = palabrasDisgustan;
	}
	public void aniadirPalabrasDisgustan(String palabrasDisgustan) {
		this.palabrasDisgustan.add(palabrasDisgustan);
	}
	
	public Double getPeso(){
		return this.peso;
	}
	public String getSexo(){
		return this.sexo;
	}
	public String getRutina(){
		return this.rutina;
	}
	
	public boolean rutinaSedentaria(){
		return this.rutina.equals("LEVE") ||
			   this.rutina.equals("NADA") ||
			   this.rutina.equals("MEDIANO");
	}
	
}

