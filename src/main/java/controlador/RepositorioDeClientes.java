package controlador;

/**
 * @author Gastón Di Filippo
 * @version 1.0
 * @created 13-Apr-2018 8:57:52 PM
 */

import modelo.Cliente;
import java.io.IOException;
import java.util.ArrayList;

public class RepositorioDeClientes {

	private DAOCliente daoCliente ;
	private static RepositorioDeClientes instance = null ;
	
	private RepositorioDeClientes(DAOCliente dao)
	{
		this.daoCliente = dao ;
	}
	
	public static RepositorioDeClientes getInstance(DAOCliente dao)
	{
		
		if ( instance == null )
		{
			instance = new RepositorioDeClientes(dao) ;
		}
		return instance ;
	}
	
	public void add(Cliente cliente) throws IOException
	{
		this.daoCliente.add(cliente);
	}
	
	public void delete(Cliente cliente)
	{
		this.daoCliente.delete(cliente);
	}
	
	public ArrayList<Cliente> getAllClientes() throws IOException
	{
		return this.daoCliente.getAllClientes();
	}
	
	public void update(Cliente cliente)
	{
		this.daoCliente.update(cliente);
	}
	
}
