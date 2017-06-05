package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JOptionPane;

import view.AdminFrame;
import view.UserFrame;
import model.*;

public class ClientHandler {

	private Socket clientSocket;

	private ObjectOutputStream output;
	private ObjectInputStream input;

	private String host;
	private int port;

	public ClientHandler(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public ClientHandler() {
	}

	public void login(String username, String password) {

		String msg = username + "_" + password;
		String raspuns;
		try {
			clientSocket = new Socket("127.0.0.1", 11001);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			out.println(msg);
			// Asteptam raspunsul de la server
			raspuns = in.readLine();
			System.out.println(raspuns);
			if (raspuns.equals("yes")) {
				UserFrame userFrame = new UserFrame();
				userFrame.frame.setVisible(true);
			} else if (raspuns.equals("admin")) {
				AdminFrame adminFrame = new AdminFrame();
				adminFrame.frame.setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Introduceti corect username-ul si password !");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void factura(String msg) {

		String raspuns;
		try {
			clientSocket = new Socket("127.0.0.1", 11001);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			out.println(msg);
			// Asteptam raspunsul de la server
			raspuns = in.readLine();
			System.out.println(raspuns);
			if (raspuns.equals("factura")) {
				System.out.println("factura a fost tiparita");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void vizualizClienti(String msg) {
		String raspuns;
		try {
			clientSocket = new Socket("127.0.0.1", 11001);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			out.println(msg);
			// Asteptam raspunsul de la server
			raspuns = in.readLine();
			System.out.println(raspuns);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
