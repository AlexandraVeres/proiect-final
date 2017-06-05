package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.sql.*;

import javax.swing.*;

import client.ClientHandler;
import model.Client;
import sql.SqliteConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNume = new JLabel("Username");
		lblNume.setBounds(10, 48, 64, 14);
		frame.getContentPane().add(lblNume);

		JLabel lblParola = new JLabel("Password");
		lblParola.setBounds(10, 108, 64, 14);
		frame.getContentPane().add(lblParola);

		textUsername = new JTextField();
		textUsername.setBounds(81, 45, 129, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);

		JButton btnOk = new JButton("Login");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientHandler client = new ClientHandler();
				String username = textUsername.getText();
				String password = passwordField.getText();
				client.login(username, password);

			}
		});
		btnOk.setBounds(57, 187, 110, 23);
		frame.getContentPane().add(btnOk);

		passwordField = new JPasswordField();
		passwordField.setBounds(81, 105, 129, 20);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel = new JLabel("BINE A\u021AI VENIT !");
		lblNewLabel.setBounds(31, 11, 179, 14);
		frame.getContentPane().add(lblNewLabel);
	}

	public String getUsername() {
		return textUsername.getText();
	}

	public String getPassword() {
		return passwordField.getText();
	}
}
