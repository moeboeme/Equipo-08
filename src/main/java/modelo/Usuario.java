package modelo;


import java.util.Date;

/**
*@Author Gastón Di Filippo
*Apr 16, 2018 10:02:59 AM 
*
*/
public class Usuario {

	protected String domicilio;
	protected Date fechaDeAlta;
	protected int identificadorUnico;
	protected String nombre;
	protected String apellido ;
	protected String nombreDeUsuario;
	protected String password;
	public Usuario()
	{
		
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public int getIdentificadorUnico() {
		return identificadorUnico;
	}
	public void setIdentificadorUnico(int identificadorUnico) {
		this.identificadorUnico = identificadorUnico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public void setNombreDeUsuario(String nombreUsuario) {
		this.nombreDeUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	



}//end Usuarios