package controlador;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Dispositivo;

public class Repositorio {
	
	private DAO dao ;
	private static Repositorio instance = null ;
	
	private Repositorio (DAO myDao)
	{
		this.dao = myDao ;
	}
	
	public static Repositorio getInstance( DAO dao)
	{
		if ( instance == null )
		{
			instance = new Repositorio ( dao ) ;
		}
		return instance ;
	}
	
	public void add (Cliente cliente ) throws IOException
	{
		this.dao.add(cliente);
	}
	
	public void add (Dispositivo dispositivo ) throws IOException
	{
		this.dao.add(dispositivo);
	}
	
	public void delete(Cliente cliente)
	{
		this.dao.delete(cliente);
	}
	
	public void delete(Dispositivo dispositivo)
	{
		this.dao.delete(dispositivo);
	}
	
	public ArrayList<Dispositivo> getAllDispositivos() throws IOException
	{
		return this.dao.getAllDispositivos () ;
	}
	
	public ArrayList<Cliente> getAllClientes () throws IOException
	{
		return this.dao.getAllClientes () ;
	}
	
	public void update(Cliente cliente)
	{
		this.dao.update(cliente);
	}
	
	public void update(Dispositivo dispositivo)
	{
		this.dao.update(dispositivo);
	}
	
}
