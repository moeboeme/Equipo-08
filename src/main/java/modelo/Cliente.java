package modelo;
import java.util.ArrayList;

/**
*@Author Gastón Di Filippo
*Apr 16, 2018 9:56:46 AM 
*
*/
import java.util.List;



public class Cliente extends Usuario 
{
	private String nombre ;
	private String apellido ;
	private String nombreDeUsuario ;
	private Categoria categoria;
	private List<Dispositivo> dispositivos;
	private int dni;
	private long telefono;
	private String tipoDocumento;

	public Cliente (String myNombre, String myApellido, String myNombreDeUsuario, 
			Categoria myCategoria,List<Dispositivo> myDispositivos,
			int myDni, long myTelefono, String tipoDni)
	{
		this.categoria = myCategoria;
		this.dispositivos = myDispositivos;
		this.dni = myDni;
		this.telefono = myTelefono;
		this.tipoDocumento = tipoDni;
		
	}
	
	public void showClienteDetails()
	{
		System.out.println("Nombre Cliente: "+this.getNombre());
		System.out.println("Apellido cliente: "+this.getApellido());
		System.out.println("Nombre de usuario: "+ this.getNombreDeUsuario());
		System.out.println("Categoría: "+ this.getCategoria());
		System.out.println("Dispositivos: "+ this.getDispositivos());
		System.out.println("Indentificador unico"+ this.getIdentificadorUnico());
		System.out.println("Passowrd: "+ this.getPassword());
		System.out.println();
	}
	
	public int dispositivosApagados(){
		return (int) this.dispositivos.stream().filter(d -> !d.estaEncendido()).count();
	}

	public int dispositivosEncendidos(){
		return (int) dispositivos.stream().filter(d -> d.estaEncendido()).count();
	}

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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


	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}


	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}


	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public boolean existeDispositivoEncendido(){
		return dispositivos.stream().anyMatch(d->d.estaEncendido());
	}

	public int totalDispostivos(){
		return dispositivos.size();
	}
	

}//end Cliente