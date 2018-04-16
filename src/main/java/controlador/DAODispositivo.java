package controlador;


import java.io.IOException;
import java.util.ArrayList;

import modelo.Dispositivo;

public interface DAODispositivo {
	
	public void add (Dispositivo dispositivo) throws IOException ;
	public void delete(Dispositivo dispositivo) ;
	public ArrayList<Dispositivo> getAllDispositivos() throws IOException;
	/*
	 * acerca de update:
	 * �ste m�todo va a recibir una dispositivo que va a ser
	 * diferente o en el peor de los casos igual a una dispositivo
	 * que tiene el mismo nombre que una dispositivo que ya est� en
	 * el repositorio de dispositivos, �c�mo lo s�? well... antes de
	 * hacer un update voy a hacer un getAllEmpersas(), y voy a modificar
	 * una de las dispositivos que estoy modificando. Sino, simplmente
	 * hago add(Dispositivo dispositivo)
	 * 
	 */
	public void update(Dispositivo dispositivo) ;
	
}
