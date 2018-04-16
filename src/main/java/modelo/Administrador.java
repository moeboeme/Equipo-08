package modelo;
import java.util.Date;

/**
*@Author Gastón Di Filippo
*Apr 16, 2018 2:12:35 PM 
*
*/
public class Administrador extends Usuario {

	private String nombre ; 
	private String apellido ;
	private String domicilio ;
	private Date fechaDeAlta ;
	private int identificadorUnico ;
	private String nombreDeUsuario ;
	private String password ;
	
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

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrador(){
		
	}

	public int antiguedadEnDias(){
		return 0;
	}
}//end Administrador