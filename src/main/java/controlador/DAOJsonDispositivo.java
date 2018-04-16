package controlador;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import modelo.Dispositivo;

public class DAOJsonDispositivo implements DAODispositivo {
	
	Gson gson ;
	String filePath ;
	BufferedReader bufferedReader ;
	BufferedWriter bufferedWriter ;
	
	public DAOJsonDispositivo()
	{
		FilePath filePath = FilePath.getInstance() ;
		String myFilePath = filePath.getDispositivosJsonPath() ;
		this.filePath = myFilePath ;
		this.gson = new Gson();
	}
	
	public void setFilePath(String myFilePath)
	{
		this.filePath = myFilePath;
	}
	
	@Override
	public void add(Dispositivo dispositivo) throws IOException {
		List<Dispositivo> dispositivos = this.getAllDispositivos() ;
		dispositivos.add(dispositivo) ;
		this.dispositivosToJsonFile(dispositivos);
	}
	
	@Override
	public void delete(Dispositivo dispositivo) {
		
		try {
			List<Dispositivo>dispositivos = getAllDispositivos();
			List<Dispositivo> dispositivosMenosDispositivoAEliminar = 
					dispositivos.stream()
						.filter(e -> !dispositivo.getNombre().equals(e.getNombre()))
						.collect(Collectors.toList()) ;
			this.dispositivosToJsonFile(dispositivosMenosDispositivoAEliminar);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	@Override
	public ArrayList<Dispositivo> getAllDispositivos() throws IOException {
		FileReader reader = new FileReader(this.filePath);
		this.bufferedReader = new BufferedReader(reader);
		ArrayList<Dispositivo> dispositivos = this.gson
				.fromJson(getJson(), new TypeToken<ArrayList<Dispositivo>>(){}.getType());
		return dispositivos;
	}
	
	public void dispositivosToJsonFile(List<Dispositivo> dispositivos)
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(this.filePath))
		{
			gson.toJson(dispositivos,writer);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getJson() throws IOException
	{
		StringBuilder dispositivoSerializada = new StringBuilder();
		String linea ;
		while( ( linea = this.bufferedReader.readLine()) != null ) 
		{
			dispositivoSerializada.append( linea ) ;
		}
		this.bufferedReader.close();
		return dispositivoSerializada.toString() ;
	}
	
	public int find(String nombreDispositivo) throws IOException
	{
		List<Dispositivo> dispositivos;
		try {
			dispositivos = this.getAllDispositivos();
			List<String> nombresDeDispositivos = new ArrayList<>() ;
			dispositivos.forEach(e -> nombresDeDispositivos.add(e.getNombre()));
			int index = nombresDeDispositivos.indexOf(nombreDispositivo) ;
			return index ;
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1 ;
		}
	}
	
	@Override
	public void update(Dispositivo dispositivo) {
		/*
		 * acerca de update:
		 * Éste método todo va a recibir una dispositivo que va a ser
		 * diferente o en el peor de los casos igual a una dispositivo
		 * que tiene el mismo nombre que una dispositivo que ya está en
		 * el repositorio de dispositivos, ¿cómo lo sé? well... antes de
		 * hacer un update voy a hacer un getAllEmpresas(), y voy a modificar
		 * una de las dispositivos que estoy modificando. Si quisiera agregar, 
		 * simplmente hago add(Dispositivo dispositivo), y no estaría usando 
		 * éste método
		 * 
		 * En otras palabras, éste método todo pisa un dispositivo que tiene el mismo
		 * nombre y que indefectiblemente está en la lista de todos los dispositivos
		 * que devuelve getAllDispositivos()
		 */
		try {
			ArrayList<Dispositivo> dispositivos = this.getAllDispositivos();
			int index = this.find(dispositivo.getNombre()) ;
			dispositivos.set(index, dispositivo) ;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
