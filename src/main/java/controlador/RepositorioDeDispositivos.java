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

//	private DAOEmpresa daoEmpresa ;
	private static RepositorioDeDispositivos instance = null ;
	
	private RepositorioDeDispositivos(
//				DAOEmpresa dao
			)
	{
//		this.daoEmpresa = dao ;
	}
	
	public static RepositorioDeDispositivos getInstance(
//				DAOEmpresa dao
			)
	{
		
		if ( instance == null )
		{
			instance = new RepositorioDeDispositivos(
//						dao
							) ;
		}
		return instance ;
	}
	
	public void add(Dispositivo dispositivo) throws IOException
	{
//		this.daoEmpresa.add(empresa);
	}
	
	public void delete(Dispositivo dispositivo)
	{
//		this.daoEmpresa.delete(empresa);
	}
	
//	public ArrayList<Dispositivo> getAllEmpresas() throws IOException
//	{
//		return this.daoEmpresa.getAllEmpresas();
//	}
	
	public void update(Dispositivo dispositivo)
	{
//		this.daoEmpresa.update(empresa);
	}
	
}
