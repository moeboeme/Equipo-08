package modelo;


/**
 * @author Lautaro
 * @version 1.0
 * @created 11-abr-2018 08:08:41 p.m.
 */
public class Dispositivo {

	private double consumoPorHora;
	private boolean encendido;
	private String nombre;
	private int idDispositivo ;

	public Dispositivo(String myNombre, boolean myEstaEncendido, 
				double myConsumoPorHora, int myIdDispositivo)
	{
		this.consumoPorHora = myConsumoPorHora;
		this.encendido = myEstaEncendido;
		this.nombre = myNombre;
		this.idDispositivo = myIdDispositivo ;
	}
	

	public int getIdDispositivo() {	
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public void showDispositivoDetails()
	{
		System.out.println("Consumo por hora: "+this.getConsumoPorHora());
		System.out.println("Nombre dispositivo: "+this.getNombre());
		System.out.println("Esta encendido: "+this.estaEncendido());
		System.out.println("Id de dispositivo: " + this.getIdDispositivo());
		System.out.println();
	}

	public double getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(double consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	public boolean estaEncendido() {
		return encendido;
	}

	public void setEstaEncendido(boolean estaEncendido) {
		this.encendido = estaEncendido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}//end Dispositivo