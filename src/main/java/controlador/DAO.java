package controlador;

import modelo.Cliente;
import modelo.Dispositivo; 

import java.io.IOException;
import java.util.List;

public interface DAO {

	public void add (Cliente cliente) throws IOException ;
	public void delete (Cliente cliente) ;
	public List<Cliente> getAllClientes() throws IOException ; 
	public List<Dispositivo> getAllDispositivos () throws IOException ;
	public void update(Cliente cliente) ;
	
}
