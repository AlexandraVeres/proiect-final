package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Client;

public class ClientDAO {
	@Resource(name = "jdbc/bijuterii")
	private DataSource ds;

	public void executeModifyQuery(String sql) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:D:\\faculta\\an III\\An3Facultate\\FACULTA\\PS\\workspace\\PROIECT_CLIENT_SERVER\\bijuterii.sqlite");
			conn.createStatement().execute(sql);
			conn.close();
		}

		catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public ResultSet executeFetchQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:D:\\faculta\\an III\\An3Facultate\\FACULTA\\PS\\workspace\\PROIECT_CLIENT_SERVER\\bijuterii.sqlite");
			rs = conn.createStatement().executeQuery(sql);
			conn.close();
		}

		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return rs;
	}

	// create
	public void addClient(Client client) {
		String sql = "INSERT INTO CLIENT VALUES('" + client.getID() + "','" + client.getName() + "','"
				+ client.getUsername() + "','" + client.getPassword() + "')";
		System.out.println("s-a introdus nou client");
		executeModifyQuery(sql);

	}

	// read
	public ArrayList<Client> getAllClients() {
		ArrayList<Client> list = new ArrayList<Client>();
		String sql = "SELECT * FROM CLIENT";
		ResultSet rs = executeFetchQuery(sql);
		try {
			while (rs.next()) {
				Client client = new Client();
				int id = client.getID();
				client.setID(id);
				client.setName(rs.getString("Name"));
				client.setUsername(rs.getString("Username"));
				client.setPassword(rs.getString("Password"));

				list.add(client);

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	
	public void updateClient(Client client, String nume) {
		String sql = "UPDATE CLIENT SET name='" + client.getName() + "',username='" + client.getUsername()
				+ "',password='" + client.getPassword() + "'Where name= '" + nume + "'";
		executeModifyQuery(sql);
	}

	// delete
	public void deleteClient(String numeClient) {
		String sql = "DELETE FROM CLIENT WHERE name='" + numeClient + "'";
		executeModifyQuery(sql);

	}

	public String deleteClient2(String numeClient) {
		String sql = "DELETE FROM CLIENT WHERE name='" + numeClient + "'";
		executeModifyQuery(sql);
		return numeClient;

	}
}
