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
	private static Repositorio repo ;
	private String filePath ;
	private DAOJson dao ;
	
	@Before
	public void init()
	{
		FilePath path = FilePath.getInstance() ;
		Cliente clienteDummy = new Cliente() ;
		this.filePath = path.getJsonPath(clienteDummy) ;
		this.dao = new DAOJson(clienteDummy) ;
		repo = Repositorio.getInstance(this.dao) ;
	}
	
	@Test
	public void archivosJsonEstanEnActualSistema() throws IOException
	{
		File currentDir = new File (filePath) ;
		currentDir.createNewFile();
		Assert.assertTrue(currentDir.exists());
	}
	
	@Test
	public void escriboClientesDummy() throws IOException
	{
		List<Cliente> clientes = TestJsonClientes.createDummyClientes();
		try {
			//el DAOJsonCliente se encarga de persistir las clientes en arch json
			//este no es trabajo del repo, es coherente delegárselo al dao
			dao.listaDeClientesToJsonFile(clientes);
			List<Cliente> clientesQueMeDioElRepo = repo.getAllClientes();
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
		List<Dispositivo> listaDispositivosUsuarioGaston = TestJsonClientes.repo.getAllDispositivos() ;

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
			this.clientes = TestJsonClientes.repo.getAllClientes() ;
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
