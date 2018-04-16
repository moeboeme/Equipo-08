package controlador;


import java.io.IOException;
import java.util.ArrayList;

import modelo.Cliente;

public interface DAOCliente {
	
	public void add (Cliente cliente) throws IOException ;
	public void delete(Cliente cliente) ;
	public ArrayList<Cliente> getAllClientes() throws IOException;
	/*
	 * acerca de update:
	 * �ste m�todo va a recibir una cliente que va a ser
	 * diferente o en el peor de los casos igual a una cliente
	 * que tiene el mismo nombre que una cliente que ya est� en
	 * el repositorio de clientes, �c�mo lo s�? well... antes de
	 * hacer un update voy a hacer un getAllEmpersas(), y voy a modificar
	 * una de las clientes que estoy modificando. Sino, simplmente
	 * hago add(Cliente cliente)
	 * 
	 */
	public void update(Cliente cliente) ;
	
}
