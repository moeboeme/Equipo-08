package controlador;

/**
 * @author Gastón Di Filippo
 * @version 1.0
 * @created 13-Apr-2018 8:57:52 PM
 */

import modelo.Dispositivo;
import java.io.IOException;
import java.util.ArrayList;

public class RepositorioDeDispositivos {

	private DAODispositivo daoDispositivo ;
	private static RepositorioDeDispositivos instance = null ;
	
	private RepositorioDeDispositivos(DAODispositivo dao)
	{
		this.daoDispositivo = dao ;
	}
	
	public static RepositorioDeDispositivos getInstance(DAODispositivo dao	)
	{
		
		if ( instance == null )
		{
			instance = new RepositorioDeDispositivos(dao) ;
		}
		return instance ;
	}
	
	public void add(Dispositivo dispositivo) throws IOException
	{
		this.daoDispositivo.add(dispositivo);
	}
	
	public void delete(Dispositivo dispositivo)
	{
		this.daoDispositivo.delete(dispositivo);
	}
	
	public ArrayList<Dispositivo> getAllDispositivos() throws IOException
	{
		return this.daoDispositivo.getAllDispositivos();
	}
	
	public void update(Dispositivo dispositivo)
	{
		this.daoDispositivo.update(dispositivo);
	}
	
}
