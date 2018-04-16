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

//	private DAOEmpresa daoEmpresa ;
	private static RepositorioDeClientes instance = null ;
	
	private RepositorioDeClientes(
//				DAOEmpresa dao
			)
	{
//		this.daoEmpresa = dao ;
	}
	
	public static RepositorioDeClientes getInstance(
//				DAOEmpresa dao
			)
	{
		
		if ( instance == null )
		{
			instance = new RepositorioDeClientes(
//						dao
							) ;
		}
		return instance ;
	}
	
	public void add(Cliente cliente) throws IOException
	{
//		this.daoEmpresa.add(empresa);
	}
	
	public void delete(Cliente cliente)
	{
//		this.daoEmpresa.delete(empresa);
	}
	
//	public ArrayList<Cliente> getAllEmpresas() throws IOException
//	{
//		return this.daoEmpresa.getAllEmpresas();
//	}
	
	public void update(Cliente cliente)
	{
//		this.daoEmpresa.update(empresa);
	}
	
}
