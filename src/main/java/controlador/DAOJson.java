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

import modelo.Cliente;
import modelo.Dispositivo;

public class DAOJson implements DAO{
	
	private Gson gson ;
	private String filePath ;
	private BufferedReader bufferedReader ;
	private BufferedWriter bufferedWriter ;
	
	public DAOJson ( Object tipoDeObjeto )
	{
		FilePath filePath = FilePath.getInstance() ;
		String myFilePath = filePath.getJsonPath(tipoDeObjeto.toString()) ;
		this.filePath = myFilePath ;
		this.gson = new Gson();
	}
	
	public void setFilePath(String myFilePath)
	{
		this.filePath = myFilePath;
	}
	
	@Override
	public void add(Cliente cliente) throws IOException {
		List<Cliente> clientes = this.getAllClientes() ;
		clientes.add(cliente) ;
		this.listaDeClientesToJsonFile(clientes);
	}
	@Override
	public void add(Dispositivo dispositivo) throws IOException {
		List<Dispositivo> dispositivos = this.getAllDispositivos() ;
		dispositivos.add(dispositivo) ;
		this.listaDeDispositivosToJsonFile(dispositivos);
	}
	
	@Override
	public void delete(Cliente cliente) {
		
		try {
			List<Cliente>clientes = getAllClientes();
			List<Cliente> clientesMenosClienteAEliminar = 
					clientes.stream()
						.filter(e -> !cliente.getNombre().equals(e.getNombre()))
						.collect(Collectors.toList()) ;
			this.listaDeClientesToJsonFile(clientesMenosClienteAEliminar);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(Dispositivo dispositivo) {
		
		try {
			List<Dispositivo>dispositivos = getAllDispositivos();
			List<Dispositivo> dispositivosMenosDispositivoAEliminar = 
					dispositivos.stream()
						.filter(e -> !dispositivo.getNombre().equals(e.getNombre()))
						.collect(Collectors.toList()) ;
			this.listaDeDispositivosToJsonFile(dispositivosMenosDispositivoAEliminar);
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
	
	@Override
	public ArrayList<Cliente> getAllClientes() throws IOException {
		FileReader reader = new FileReader(this.filePath);
		this.bufferedReader = new BufferedReader(reader);
		ArrayList<Cliente> clientes = this.gson
				.fromJson(getJson(), new TypeToken<ArrayList<Cliente>>(){}.getType());
		return clientes;
	}
	
	public void listaDeDispositivosToJsonFile(List<Dispositivo> dispositivos)
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
	
	public void listaDeClientesToJsonFile(List<Cliente> clientes)
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(this.filePath))
		{
			gson.toJson(clientes,writer);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getJson() throws IOException
	{
		StringBuilder clienteSerializada = new StringBuilder();
		String linea ;
		while( ( linea = this.bufferedReader.readLine()) != null ) 
		{
			clienteSerializada.append( linea ) ;
		}
		this.bufferedReader.close();
		return clienteSerializada.toString() ;
	}
	@Override
	public int findCliente (String nombreDeCliente) throws IOException
	{
		List<Cliente> clientes;
		try {
			clientes = this.getAllClientes();
			List<String> nombresDeClientes = new ArrayList<>() ;
			clientes.forEach(e -> nombresDeClientes.add(e.getNombre()));
			int index = nombresDeClientes.indexOf(nombreDeCliente) ;
			return index ;
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1 ;
		}
	}
	@Override
	public int findDispositivo (String nombreDeDispositivo) throws IOException
	{
		List<Dispositivo> dispositivos;
		try {
			dispositivos = this.getAllDispositivos();
			List<String> nombresDeDispositivos = new ArrayList<>() ;
			dispositivos.forEach(e -> nombresDeDispositivos.add(e.getNombre()));
			int index = nombresDeDispositivos.indexOf(nombreDeDispositivo) ;
			return index ;
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1 ;
		}
	}
	
	@Override
	public void update(Cliente cliente) {
		
		try {
			ArrayList<Cliente> clientes = this.getAllClientes();
			int index = this.findCliente(cliente.getNombre()) ;
			clientes.set(index, cliente) ;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void update(Dispositivo dispositivo) {
		try {
			ArrayList<Dispositivo> dispositivos = this.getAllDispositivos();
			int index = this.findCliente(dispositivo.getNombre()) ;
			dispositivos.set(index, dispositivo) ;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}
	
	
}
