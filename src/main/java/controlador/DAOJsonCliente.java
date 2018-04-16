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

public class DAOJsonCliente implements DAOCliente{
	
	Gson gson ;
	String filePath ;
	BufferedReader bufferedReader ;
	BufferedWriter bufferedWriter ;
	
	public DAOJsonCliente()
	{
		FilePath filePath = FilePath.getInstance() ;
		String myFilePath = filePath.getClientesJsonPath() ;
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
		this.clientesToJsonFile(clientes);
	}
	
	@Override
	public void delete(Cliente cliente) {
		
		try {
			List<Cliente>clientes = getAllClientes();
			List<Cliente> clientesMenosClienteAEliminar = 
					clientes.stream()
						.filter(e -> !cliente.getNombre().equals(e.getNombre()))
						.collect(Collectors.toList()) ;
			this.clientesToJsonFile(clientesMenosClienteAEliminar);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	@Override
	public ArrayList<Cliente> getAllClientes() throws IOException {
		FileReader reader = new FileReader(this.filePath);
		this.bufferedReader = new BufferedReader(reader);
		ArrayList<Cliente> clientes = this.gson
				.fromJson(getJson(), new TypeToken<ArrayList<Cliente>>(){}.getType());
		return clientes;
	}
	
	public void clientesToJsonFile(List<Cliente> clientes)
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
	
	public int find(String nombreCliente) throws IOException
	{
		List<Cliente> clientes;
		try {
			clientes = this.getAllClientes();
			List<String> nombresDeClientes = new ArrayList<>() ;
			clientes.forEach(e -> nombresDeClientes.add(e.getNombre()));
			int index = nombresDeClientes.indexOf(nombreCliente) ;
			return index ;
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1 ;
		}
	}
	
	@Override
	public void update(Cliente cliente) {
		/*
		 * acerca de update:
		 * �ste m�todo va a recibir una cliente que va a ser
		 * diferente o en el peor de los casos igual a una cliente
		 * que tiene el mismo nombre que una cliente que ya est� en
		 * el repositorio de clientes, �c�mo lo s�? well... antes de
		 * hacer un update voy a hacer un getAllEmpersas(), y voy a modificar
		 * una de las clientes que estoy modificando. Si quisiera agregar, 
		 * simplmente hago add(Cliente cliente), y no estar�a usando �ste m�todo
		 * 
		 * En otras palabras, �ste m�todo pisa una cliente que tiene el mismo
		 * nombre y que indefectiblemente est� en la lista de todas las clientes
		 * que devuelve getAllClientes()
		 */
		try {
			ArrayList<Cliente> clientes = this.getAllClientes();
			int index = this.find(cliente.getNombre()) ;
			clientes.set(index, cliente) ;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
