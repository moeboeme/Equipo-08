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
	private double numeroDocumento;
	private double telefono;
	private String tipoDocumento;
	public Dispositivo m_Dispositivo;
	public Categoria m_Categoria;

	public Cliente(Categoria _categoria,List<Dispositivo> _dispositivos, double _numeroDocumento, double _telefono, String _tipoDocumento){
		this.categoria = _categoria;
		this.dispositivos = _dispositivos;
		this.numeroDocumento = _numeroDocumento;
		this.telefono = _telefono;
		this.tipoDocumento = _tipoDocumento;
		
	}

	public void finalize() throws Throwable {
		super.finalize();
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