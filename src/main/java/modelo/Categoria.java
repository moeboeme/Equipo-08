package modelo;


/**
 * @author Lautaro
 * @version 1.0
 * @created 11-abr-2018 08:09:01 p.m.
 */
public class Categoria {

	private String nombre;
	private double cargoFijo;
	private double cargoVariable;
	private int consumoMaximo;
	private int consumoMinimo;

	public Categoria(String myNombre, double myCargoFijo, 
			double myCargoVariable, int myConsumoMax, int myConsumoMin)
	{
		this.nombre = myNombre ;
		this.cargoFijo = myCargoFijo ;
		this.cargoVariable = myCargoVariable ;
		this.consumoMaximo = myConsumoMax ;
		this.consumoMinimo = myConsumoMin ;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public double getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(double cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	public int getConsumoMaximo() {
		return consumoMaximo;
	}

	public void setConsumoMaximo(int consumoMaximo) {
		this.consumoMaximo = consumoMaximo;
	}

	public int getConsumoMinimo() {
		return consumoMinimo;
	}

	public void setConsumoMinimo(int consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public double cargoMensual(){
		return 0;
	}
}//end Categoria