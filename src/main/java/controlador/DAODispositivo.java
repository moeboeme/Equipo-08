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
	 * Éste método va a recibir una dispositivo que va a ser
	 * diferente o en el peor de los casos igual a una dispositivo
	 * que tiene el mismo nombre que una dispositivo que ya estï¿½ en
	 * el repositorio de dispositivos, ï¿½cï¿½mo lo sï¿½? well... antes de
	 * hacer un update voy a hacer un getAllEmpersas(), y voy a modificar
	 * una de las dispositivos que estoy modificando. Sino, simplmente
	 * hago add(Dispositivo dispositivo)
	 * 
	 */
	public void update(Dispositivo dispositivo) ;
	
}
