package entrega_0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.*;
import modelo.Dispositivo;

/**
* Author: Gastón Di Filippo
* Apr 15, 2018, 10:51:00 PM
*/

public class TestJsonDispositivos {
	
	private ArrayList<Dispositivo> dispositivos ;
	private Repositorio repo ;
	private String filePath ;
	private DAOJson dao ;
	
	@Before
	public void init()
	{
		Dispositivo dispositivoDummy= new Dispositivo() ;
		FilePath path = FilePath.getInstance() ;
		this.filePath = path.getJsonPath(dispositivoDummy) ;
		this.dao = new DAOJson(dispositivoDummy) ;
		repo = Repositorio.getInstance(this.dao) ;
	}
	
	@Test
	public void archivosJsonEstanEnActualSistema()
	{
		File currentDir = new File (filePath) ;
		Assert.assertTrue(currentDir.exists());
	}
	
	@Test
	public void escriboDispositivosDummy()
	{
		
		List<Dispositivo> dispositivos = TestJsonDispositivos.createDummyDispositivos();
		try {
			//el DAOJsonDispositivo se encarga de persistir las dispositivos en arch json
			//este no es trabajo del repo, es coherente delegárselo al dao
			dao.listaDeDispositivosToJsonFile(dispositivos);
			//
			List<Dispositivo> dispositivosQueMeDioElRepo = repo.getAllDispositivos();
			TestJsonDispositivos.showDispositivoObjects(dispositivosQueMeDioElRepo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//SOLO MUESTRA TODOS LOS OBJETOS
	public static void showDispositivoObjects(List<Dispositivo> dispositivos)
	{
		dispositivos.forEach(e -> e.showDispositivoDetails());
	}
	
	public static List<Dispositivo> createDummyDispositivos()
	{
		
		ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>() ;
		
		Dispositivo samsungGalaxy = new Dispositivo("Samsung Galaxy XX", false, 3.5, 1);
		Dispositivo iPhoneZ = new Dispositivo("iPhoneZ", true, 5.1, 2);
		Dispositivo sonyVaio = new Dispositivo("sonyVaio", true, 6.0, 3);
		
		dispositivos.add( samsungGalaxy ) ;
		dispositivos.add( iPhoneZ ) ;
		dispositivos.add( sonyVaio ) ;
		
		return dispositivos ;
	}
	
	
	@Test
	public void leoDispositivosYNombresSonCorresctos()
	{
		try{
			this.dispositivos = repo.getAllDispositivos() ;
			Assert.assertEquals("Samsung Galaxy XX", dispositivos.get(0).getNombre());
			Assert.assertEquals("iPhoneZ", dispositivos.get(1).getNombre());
			Assert.assertEquals("sonyVaio", dispositivos.get(2).getNombre());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
			
	
}
