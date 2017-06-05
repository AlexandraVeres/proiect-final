package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;

import model.*;
import sql.SqliteConnection;

public class MainServer {
	static ArrayList<Client> clientii = new ArrayList<>();

	static Connection connection = null;
	static Socket clientSocket;
	static ServerSocket serverSocket;

	public static void main(String[] args) {
		connection = SqliteConnection.dbConnector();

		Server server = new Server();
		clientii = server.getAllClients();
		server.seeClients(clientii);
		String msg, raspuns, msgFactura, raspunsFactura;

		try {
			serverSocket = new ServerSocket(11001);
			System.out.println("Asteapta un client...");

			while (true) {
				clientSocket = serverSocket.accept();

				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				// out e fluxul de iesire catre client
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

				// primim cerere de la client - login
				msg = in.readLine();
				// trimit raspuns clientului - login
				raspuns = server.handleMessageFromClient(msg);
				out.println(raspuns);
				out.flush();

				// primim cerere de la client - factura
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
