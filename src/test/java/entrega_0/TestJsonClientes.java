package entrega_0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.*;
import modelo.Categoria;
import modelo.Cliente;
import modelo.Dispositivo;

/**
* Author: Gastón Di Filippo
* Apr 15, 2018, 10:51:00 PM
*/

public class TestJsonClientes {
	
	private ArrayList<Cliente> clientes ;
	private RepositorioDeClientes repoClientes ;
	private String filePath ;
	private DAOJsonCliente dao ;
	
	@Before
	public void init()
	{
		FilePath path = FilePath.getInstance() ;
		this.filePath = path.getClientesJsonPath() ;
		dao = new DAOJsonCliente() ;
		repoClientes = RepositorioDeClientes.getInstance(dao) ;
	}
	
	@Test
	public void archivosJsonEstanEnActualSistema()
	{
		File currentDir = new File (filePath) ;
		Assert.assertTrue(currentDir.exists());
	}
	
	@Test
	public void escriboClientesDummy() throws IOException
	{
		
		List<Cliente> clientes = TestJsonClientes.createDummyClientes();
		try {
			//el DAOJsonCliente se encarga de persistir las clientes en arch json
			//este no es trabajo del repo, es coherente delegárselo al dao
			dao.clientesToJsonFile(clientes);
			//
			List<Cliente> clientesQueMeDioElRepo = repoClientes.getAllClientes();
			TestJsonClientes.showClienteObjects( clientesQueMeDioElRepo );
		} catch (IOException e) {
			e.printStackTrace() ;
		}
	}
	
	//SOLO MUESTRA TODOS LOS OBJETOS
	public static void showClienteObjects(List<Cliente> clientes)
	{
		clientes.forEach(e -> e.showClienteDetails());
	}
	
	public static List<Cliente> createDummyClientes() throws IOException
	{
		
		List<Cliente> clientes = new ArrayList<Cliente>() ;
		Categoria r1 = new Categoria( "r1", 3.2, 4.1, 2000, 1000 ) ;
		DAOJsonDispositivo dao = new DAOJsonDispositivo() ;
		RepositorioDeDispositivos repoDisp = RepositorioDeDispositivos.getInstance(dao) ;
		List<Dispositivo> listaDispositivosUsuarioGaston = repoDisp.getAllDispositivos() ;

		listaDispositivosUsuarioGaston.add( listaDispositivosUsuarioGaston.get(0) ) ;
		listaDispositivosUsuarioGaston.add( listaDispositivosUsuarioGaston.get(1) ) ;
		
		Cliente usuarioGaston = new Cliente("Gaston", "DiFi", "gdifi" ,r1, 
				listaDispositivosUsuarioGaston, 11111, 12222222, "dni", "unaPass") ;
		usuarioGaston.showClienteDetails();
		Cliente usuarioMel = new Cliente("Mel", "Biela", "MelBi" ,r1, 
				listaDispositivosUsuarioGaston, 121212, 12223333, "dni", "unaPass" ) ;

		Cliente usuarioFran = new Cliente("Fran", "Fiyi", "FranFi" ,r1, 
				listaDispositivosUsuarioGaston, 1333, 1222555, "dni", "unaPass") ;

		clientes.add( usuarioGaston ) ;
		clientes.add( usuarioMel ) ;
		clientes.add( usuarioFran ) ;
		
		return clientes ;
	}
	
	
	@Test
	public void leoClientesYNombresSonCorresctos()
	{
		try{
			this.clientes = repoClientes.getAllClientes() ;
			Assert.assertEquals("Gaston", clientes.get(0).getNombre());
			Assert.assertEquals("Mel", clientes.get(1).getNombre());
			Assert.assertEquals("Fran", clientes.get(2).getNombre());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
			
	
}
