

/**
 * @author Lautaro
 * @version 1.0
 * @created 11-abr-2018 08:08:41 p.m.
 */
public class Dispositivo {

	private double consumoPorHora;
	private boolean estaEncendido;
	private String nombre;

	public Dispositivo(double _consumoPorHora, boolean _estaEncendido, String _nombre){
		this.consumoPorHora = _consumoPorHora;
		this.estaEncendido = _estaEncendido;
		this.nombre = _nombre;

	}

	public void finalize() throws Throwable {

	}
	public double consumoPorHora(){
		return consumoPorHora;
	}

	public boolean estaEncendido(){
		return estaEncendido;
	}

	public String nombre(){
		return nombre;
	}
}//end Dispositivo