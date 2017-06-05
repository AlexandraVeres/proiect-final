package view;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Client;
import model.Product;
import sql.ClientDAO;
import sql.ProductDAO;
import sql.SqliteConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminFrame {

	public JFrame frame;
	private JTextField textID;
	private JTextField textNume;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textIDP;
	private JTextField textDenumire, textMaterial;
	private JTextField textIBAN;

	static Connection connection = null;
	private JTextField textProducator;
	private JTextField textGreutate;
	private JTextField textStoc;
	private JTextField textPret;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AdminFrame() {
		connection = SqliteConnection.dbConnector();
		initialize();
	}

	static void getCustomers() {

		try {

			String sql = "SELECT * FROM Client";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Client client = new Client();
				int id = client.getID();
				client.setID(id);
				client.setName(rs.getString("name"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getString("password"));

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMINISTRATOR");
		lblNewLabel.setBounds(25, 11, 140, 14);
		frame.getContentPane().add(lblNewLabel);

		textID = new JTextField();
		textID.setBounds(118, 36, 106, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);

		JLabel lblIdClient = new JLabel("ID client");
		lblIdClient.setBounds(10, 39, 46, 14);
		frame.getContentPane().add(lblIdClient);

		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(10, 61, 49, 14);
		frame.getContentPane().add(lblNume);

		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(10, 86, 102, 14);
		frame.getContentPane().add(lblUsername_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 111, 82, 14);
		frame.getContentPane().add(lblPassword);

		JLabel lblIDP = new JLabel("ID produs");
		lblIDP.setBounds(260, 39, 75, 14);
		frame.getContentPane().add(lblIDP);

		JLabel lblDenumire = new JLabel("Denumire");
		lblDenumire.setBounds(257, 61, 46, 14);
		frame.getContentPane().add(lblDenumire);

		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(260, 86, 69, 14);
		frame.getContentPane().add(lblMaterial);

		textNume = new JTextField();
		textNume.setBounds(118, 58, 106, 20);
		frame.getContentPane().add(textNume);
		textNume.setColumns(10);

		textUsername = new JTextField();
		textUsername.setBounds(118, 83, 106, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JTextField();
		textPassword.setBounds(118, 108, 106, 20);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);

		textIDP = new JTextField();
		textIDP.setBounds(345, 37, 106, 17);
		frame.getContentPane().add(textIDP);
		textIDP.setColumns(10);

		textDenumire = new JTextField();
		textDenumire.setBounds(345, 58, 106, 20);
		frame.getContentPane().add(textDenumire);
		textDenumire.setColumns(10);

		textMaterial = new JTextField();
		textMaterial.setBounds(345, 83, 106, 20);
		frame.getContentPane().add(textMaterial);
		textMaterial.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(41, 305, 164, 23);
		frame.getContentPane().add(comboBox);

		JComboBox comboBoxProduse = new JComboBox();
		comboBoxProduse.setBounds(345, 306, 164, 23);
		frame.getContentPane().add(comboBoxProduse);

		JButton btnCreeaza = new JButton("Creeaz\u0103 cont client");
		btnCreeaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idd = textID.getText();
				int id = Integer.parseInt(idd);
				String name = textNume.getText();
				String username = textUsername.getText();
				String password = textPassword.getText();

				Client cnew = new Client(id, name, username, password);
				ClientDAO clientDao = new ClientDAO();
				clientDao.addClient(cnew);

			}
		});
		btnCreeaza.setBounds(41, 164, 164, 23);
		frame.getContentPane().add(btnCreeaza);

		JButton btnSterge = new JButton("\u0218terge client");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numeClient = comboBox.getSelectedItem().toString();
				Client cnew = new Client(numeClient);
				ClientDAO clientDao = new ClientDAO();
				clientDao.deleteClient(numeClient);

			}
		});
		btnSterge.setBounds(41, 198, 164, 23);
		frame.getContentPane().add(btnSterge);

		JButton btnModifica = new JButton("Modific\u0103 date client");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idd = textID.getText();
				int id = Integer.parseInt(idd);

				String name = textNume.getText();
				String username = textUsername.getText();
				String password = textPassword.getText();

				String numeClient = comboBox.getSelectedItem().toString();
				Client cnew = new Client(name, username, password);
				ClientDAO clientDao = new ClientDAO();
				clientDao.updateClient(cnew, numeClient);

			}
		});
		btnModifica.setBounds(41, 232, 164, 23);
		frame.getContentPane().add(btnModifica);

		JButton btnRaport = new JButton("Raport");
		btnRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * TabelTranzactii window = new TabelTranzactii();
				 * window.frame1.setVisible(true);
				 */
			}
		});
		btnRaport.setBounds(41, 446, 89, 23);
		// frame.getContentPane().add(btnRaport);

		JButton btnInapoi = new JButton("\u00CEnapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame window = new LoginFrame();
				window.frame.setVisible(true);
			}
		});
		btnInapoi.setBounds(555, 470, 89, 23);
		frame.getContentPane().add(btnInapoi);

		JButton btnVizualiz = new JButton("Vizualizeaza clienti");
		btnVizualiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// getCustomers(); //am incarcat intr-o lista toate datele
				// JComboBox comboBox1 = null;
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

		});

		btnVizualiz.setBounds(41, 271, 164, 23);
		frame.getContentPane().add(btnVizualiz);

		JLabel lblProducator = new JLabel("Producator");
		lblProducator.setBounds(257, 111, 78, 14);
		frame.getContentPane().add(lblProducator);

		JLabel lblGreutate = new JLabel("Greutate");
		lblGreutate.setBounds(470, 39, 46, 14);
		frame.getContentPane().add(lblGreutate);

		JLabel lblStoc = new JLabel("Stoc");
		lblStoc.setBounds(470, 71, 46, 14);
		frame.getContentPane().add(lblStoc);

		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(470, 111, 46, 14);
		frame.getContentPane().add(lblPret);

		textProducator = new JTextField();
		textProducator.setBounds(345, 108, 106, 20);
		frame.getContentPane().add(textProducator);
		textProducator.setColumns(10);

		textGreutate = new JTextField();
		textGreutate.setText("");
		textGreutate.setBounds(526, 36, 86, 20);
		frame.getContentPane().add(textGreutate);
		textGreutate.setColumns(10);

		textStoc = new JTextField();
		textStoc.setText("");
		textStoc.setBounds(526, 68, 86, 20);
		frame.getContentPane().add(textStoc);
		textStoc.setColumns(10);

		textPret = new JTextField();
		textPret.setBounds(526, 108, 86, 20);
		frame.getContentPane().add(textPret);
		textPret.setColumns(10);

		JButton buttonAddProduct = new JButton("Adauga  produs");
		buttonAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String idd = textIDP.getText();
				int id = Integer.parseInt(idd);
				String denumire = textDenumire.getText();
				String material = textMaterial.getText();
				String producator = textProducator.getText();
				int greutate = Integer.parseInt(textGreutate.getText());
				int stoc = Integer.parseInt(textStoc.getText());
				int pret = Integer.parseInt(textPret.getText());

				Product pnew = new Product(id, denumire, material, greutate, producator, stoc, pret);
				ProductDAO productDAO = new ProductDAO();
				productDAO.addProduct(pnew);

			}
		});
		buttonAddProduct.setBounds(345, 164, 164, 23);
		frame.getContentPane().add(buttonAddProduct);

		JButton btnStergeProdus = new JButton("\u0218terge produs");
		btnStergeProdus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numeProdusSters = comboBoxProduse.getSelectedItem().toString();
				ProductDAO productDAO = new ProductDAO();
				productDAO.deleteProduct(numeProdusSters);

			}
		});
		btnStergeProdus.setBounds(345, 198, 164, 23);
		frame.getContentPane().add(btnStergeProdus);

		JButton btnModificaProdus = new JButton("Modific\u0103 date produs");
		btnModificaProdus.setBounds(345, 232, 164, 23);
		frame.getContentPane().add(btnModificaProdus);
		btnModificaProdus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String numeProdusModif = comboBoxProduse.getSelectedItem().toString();

				String idd = textIDP.getText();
				int id = Integer.parseInt(idd);
				String denumire = textDenumire.getText();
				String material = textMaterial.getText();
				String producator = textProducator.getText();
				int greutate = Integer.parseInt(textGreutate.getText());
				int stoc = Integer.parseInt(textStoc.getText());
				int pret = Integer.parseInt(textPret.getText());

				Product pnew = new Product(id, denumire, material, greutate, producator, stoc, pret);
				ProductDAO productDAO = new ProductDAO();
				productDAO.updateProduct(pnew, numeProdusModif);
			}
		});
		JButton btnVizualizProduse = new JButton("Vizualizeaza produse");
		btnVizualizProduse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String sql = "SELECT * FROM Product";
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					comboBoxProduse.removeAllItems();
					while (rs.next()) {

						comboBoxProduse.addItem(rs.getString("Name"));

					}

				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}

		});
		btnVizualizProduse.setBounds(345, 271, 164, 23);
		frame.getContentPane().add(btnVizualizProduse);

	}
}
