package controlador;

import modelo.Cliente;
import modelo.Dispositivo; 

import java.io.IOException;
import java.util.ArrayList;

public interface DAO {

	public void add (Cliente cliente) throws IOException ;
	public void add (Dispositivo dispositivo) throws IOException ;
	public void delete (Cliente cliente) ;
	public void delete (Dispositivo dispositivo) ;
	public ArrayList<Cliente> getAllClientes() throws IOException ; 
	public ArrayList<Dispositivo> getAllDispositivos () throws IOException ;
	public void update(Cliente cliente) ;
	public void update(Dispositivo dispositivo) ;
	
}
