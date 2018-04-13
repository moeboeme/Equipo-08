/**
 * @author Lautaro
 * @version 1.0
 * @created 11-abr-2018 06:55:57 p.m.
 */
import java.util.ArrayList;
import java.util.List;



public class Cliente extends Usuarios {
	
	private Categoria categoria;
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	private int dni;
	private long telefono;
	private String tipoDocumento;
	public Dispositivo m_Dispositivo;

	public Cliente (Categoria myCategoria,List<Dispositivo> myDispositivos, 
			int myDni, long myTelefono, String tipoDni)
	{
		this.categoria = myCategoria;
		this.dispositivos = myDispositivos;
		this.dni = myDni;
		this.telefono = myTelefono;
		this.tipoDocumento = tipoDni;
		
	}

	public long dispositivosApagados(){
		return dispositivos.stream().filter(d -> !d.estaEncendido()).count();
	}

	public long dispositivosEncendidos(){
		return dispositivos.stream().filter(d -> d.estaEncendido()).count();
	}

	public boolean hayEncendido(){
		return dispositivos.stream().anyMatch(d->d.estaEncendido());
	}

	public int totalDispostivos(){
		return dispositivos.size();
	}
}//end Cliente