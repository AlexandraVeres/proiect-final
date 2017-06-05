package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.*;

import javax.swing.JComboBox;

import model.Client;
import sql.SqliteConnection;
import view.LoginFrame;

public class Server {

	static Connection connection = null;
	static ArrayList<Client> clientii = new ArrayList<>();

	public String handleMessageFromClient(String msg) {

		String[] msgVector = msg.split("_");
		String usernameMsg = msgVector[0];
		String passwordMsg = msgVector[1];

		clientii = getAllClients();
		for (Client c : clientii) {
			if (usernameMsg.equals(c.getUsername()) && passwordMsg.equals(c.getPassword())) {
				return "yes";
			}

		}
		if (usernameMsg.equals("admin") && passwordMsg.equals("admin"))
			return "admin";

		return "no";
	}

	public ResultSet executeFetchQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:D:\\faculta\\an III\\An3Facultate\\FACULTA\\PS\\workspace\\PROIECT_CLIENT_SERVER\\bijuterii.sqlite");
			rs = conn.createStatement().executeQuery(sql);
			// conn.close();
		}

		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return rs;
	}

	public void vizualizClienti(JComboBox comboBox) {
		try {
			String sql = "SELECT * FROM Client";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			comboBox.removeAllItems();
			while (rs.next()) {

				comboBox.addItem(rs.getString("Name"));

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

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

	public void seeClients(ArrayList<Client> lista) {
		for (Client c : lista) {
			System.out.println(c.getUsername() + " , " + c.getPassword() + "\n");
		}

	}

	public String handleMessageFromClientFactura(String msgFactura) {

		clientii = getAllClients();

		return "factura";
	}

}
