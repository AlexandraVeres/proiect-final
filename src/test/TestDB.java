



/////////////////////////
// OBSERVATII //




/*package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.activation.DataSource;

import model.Client;
import model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import businessLogic.Operatii;

public class TestDB{



	@Test
	public void testMockDB()  throws SQLException{
		SqliteConnection connect=mock(SqliteConnection.class);
		Connection con=mock(Connection.class);

		verify(connect).dbConnector();
	}


	@Test
	public void testAddNewClient(){
		Client client=new Client();
		ClientDAO cd=new ClientDAO();
		IClientDAO interf=mock(IClientDAO.class);

		//when(interf.addClient(client)).thenReturn();

		verify(interf, never()).addClient(client);	
	}

	@Test
	public void testGetAllClients(){
		Client client=new Client();
		ClientDAO cd=new ClientDAO();
		IClientDAO interf=mock(IClientDAO.class);

		ArrayList<Client> list= new ArrayList<Client>();

		when(interf.getAllClients()).thenReturn(list);

		verify(interf, never()).getAllClients();
	}


	@Test
	public void testRemoveClient(){
		Client client=new Client();
		ClientDAO cd=new ClientDAO();
		IClientDAO interf=mock(IClientDAO.class);
		String nume="Anca";


		when(interf.deleteClient2(nume)).thenReturn(nume);

		verify(interf, never()).deleteClient2(nume);
	}

	@Test
	public void testAddNewProduct(){
		Product product=new Product();
		ProductDAO pd=new ProductDAO();
		IProductDAO interf=mock(IProductDAO.class);

		//when(interf.addClient(client)).thenReturn();

		verify(interf, never()).addProduct(product);	
	}

	@Test
	public void testGetAllProducts(){
		Product product=new Product();
		ProductDAO pd=new ProductDAO();
		IProductDAO interf=mock(IProductDAO.class);

		ArrayList<Product> bijuterii= new ArrayList<Product>();

		when(interf.getAllProducts()).thenReturn(bijuterii);

		verify(interf, times(1)).getAllProducts();
	}


	@Test
	public void testRemoveProduct(){
		Product product=new Product();
		ProductDAO pd=new ProductDAO();
		IProductDAO interf=mock(IProductDAO.class);
		String nume="Anca";


		when(interf.deleteProduct2(nume)).thenReturn(nume);

		verify(interf, never()).deleteProduct2(nume);
	}
	
	
	@Test
	public void testUpdateStock(){
		int stock=19;
		int cantDorita=9;
		
		Operatii op=new Operatii();
		int stocNou=op.modificaStoc(stock, cantDorita);
		
		Product product=new Product();
		String nume="Anca";
		IProductDAO interf=mock(IProductDAO.class);
		
		verify(interf, never()).updateStock(product);
		
		
	}
	

}

*/





