package modelo;


/**
 * @author Lautaro
 * @version 1.0
 * @created 11-abr-2018 08:08:41 p.m.
 */
public class Dispositivo {

	private double consumoPorHora;
	private boolean estaEncendido;
	private String nombre;

	public Dispositivo(double myConsumoPorHora, boolean myEstaEncendido, String myNombre){
		this.consumoPorHora = myConsumoPorHora;
		this.estaEncendido = myEstaEncendido;
		this.nombre = myNombre;

	}

	public double getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(double consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	public boolean estaEncendido() {
		return estaEncendido;
	}

	public void setEstaEncendido(boolean estaEncendido) {
		this.estaEncendido = estaEncendido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}//end Dispositivo