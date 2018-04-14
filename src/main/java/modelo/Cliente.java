package modelo;


/**
 * @author Lautaro
 * @version 1.0
 * @created 11-abr-2018 06:55:57 p.m.
 */
import java.util.ArrayList;
import java.util.List;



public class Cliente extends Usuario 
{
	private Categoria categoria;
	private List<Dispositivo> dispositivos;
	private int dni;
	private long telefono;
	private String tipoDocumento;
	private int numeroDocumento;

	public Cliente (Categoria myCategoria,List<Dispositivo> myDispositivos, 
			int myDni, long myTelefono, String tipoDni)
	{
		this.categoria = myCategoria;
		this.dispositivos = myDispositivos;
		this.dni = myDni;
		this.telefono = myTelefono;
		this.tipoDocumento = tipoDni;
		
	}
	
	
	public int dispositivosApagados(){
		return (int) this.dispositivos.stream().filter(d -> !d.estaEncendido()).count();
	}

	public int dispositivosEncendidos(){
		return (int) dispositivos.stream().filter(d -> d.estaEncendido()).count();
	}

	public boolean existeDispositivoEncendido(){
		return dispositivos.stream().anyMatch(d->d.estaEncendido());
	}

	public int totalDispostivos(){
		return dispositivos.size();
	}
	

}//end Cliente