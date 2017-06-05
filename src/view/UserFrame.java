package view;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JLabel;
import javax.swing.JTextField;

import server.WriteFile;
import sql.ProductDAO;
import sql.SqliteConnection;
import model.Product;
import model.Sets;

public class UserFrame {

	public JFrame frame;
	// JComboBox box=new JComboBox();
	private JTextField textField;
	static Connection connection = null;
	// static JComboBox comboBox1;

	ArrayList<Product> bijuteriiComandate = new ArrayList<Product>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserFrame() {
		connection = SqliteConnection.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	static ArrayList<Product> getBij() {
		ArrayList<Product> bijuterii = new ArrayList<Product>();

		try {
			// ArrayList<Product> bijuterii= new ArrayList<Product>();
			String sql = "SELECT * FROM Product";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				// JComboBox comboBox1=null;
				// comboBox1.addItem(rs.getString("Name"));
				Product product = new Product();
				int id = product.getID();
				product.setID(id);
				product.setName(rs.getString("name"));
				product.setMaterial(rs.getString("material"));
				product.setProducer(rs.getString("producer"));
				product.setWeight(Integer.parseInt(rs.getString("weight")));
				product.setStock(Integer.parseInt(rs.getString("stock")));
				product.setPrice(Integer.parseInt(rs.getString("price")));

				bijuterii.add(product);

			}

			for (int i = 0; i < bijuterii.size(); i++) {
				System.out.println(bijuterii.get(i).getName());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return bijuterii;
	}

	private void initialize() {
		frame = new JFrame("Customer");
		frame.setBounds(100, 100, 568, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFrame lf = new LoginFrame();
				lf.frame.setVisible(true);
			}
		});

		JComboBox comboBoxCos = new JComboBox();
		comboBoxCos.setBounds(21, 213, 110, 29);
		frame.getContentPane().add(comboBoxCos);

		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(203, 23, 136, 29);
		frame.getContentPane().add(comboBox1);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JButton btnVizualizeazaBijuterii = new JButton("Vizualizeaza bijuterii");
		btnVizualizeazaBijuterii.setBounds(10, 23, 158, 23);
		frame.getContentPane().add(btnVizualizeazaBijuterii);

		btnVizualizeazaBijuterii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getBij(); // am incarcat intr-o lista toate datele
				// JComboBox comboBox1 = null;
				try {
					ArrayList<Product> bijuterii = new ArrayList<Product>();
					String sql = "SELECT * FROM Product";
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						comboBox1.addItem(rs.getString("Name"));

					}

				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}

		});

		JButton btnOferte = new JButton("Vizualizeaza oferte");
		btnOferte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HashSet<Product> oferta = new HashSet<>();
				ArrayList<Product> bijuterii = new ArrayList<Product>();
				bijuterii = getBij();
				Sets seturi = new Sets(bijuterii);
				oferta = seturi.configSet(bijuterii);
				for (Product p : oferta) {
					System.out.println(oferta.size());
				}
			}
		});
		btnOferte.setBounds(10, 57, 158, 23);
		// frame.getContentPane().add(btnOferte);

		JLabel lblNrBucati = new JLabel("Nr bucati");
		lblNrBucati.setBounds(373, 34, 72, 23);
		frame.getContentPane().add(lblNrBucati);

		JButton btnComanda = new JButton("Comanda");
		btnComanda.setBounds(356, 80, 89, 23);
		frame.getContentPane().add(btnComanda);
		btnComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nr = Integer.parseInt(textField.getText());
				ArrayList<Product> bijuterii = new ArrayList<Product>();

				bijuterii = getBij();
				int stocNou;
				// ia stocul din array
				String den = comboBox1.getSelectedItem().toString();
				for (Product p : bijuterii) {
					if (p.getName().equals(den)) {
						stocNou = p.getStock() - nr;
						if (stocNou < 0)
							JOptionPane.showMessageDialog(null, "Nu exista atatatea bucati in stoc");
						else {
							// Product pnew=new
							// Product(id,denumire,material,greutate,producator,stoc,pret);
							ProductDAO productDAO = new ProductDAO();
							productDAO.updateStock(stocNou, den);
						}
						System.out.println(stocNou);
						bijuteriiComandate.add(p);
					}
				}

				for (Product pp : bijuteriiComandate) {
					System.out.println("Comandat:" + pp.getName());
				}

			}
		});

		JButton btnCosulMeu = new JButton("Co\u0219 de cumparaturi");
		btnCosulMeu.setBounds(21, 179, 213, 23);
		btnCosulMeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					for (int i = 0; i < bijuteriiComandate.size(); i++) {
						comboBoxCos.addItem(bijuteriiComandate.get(i).getName());
						System.out.println("face ceva?");

					}

				} catch (Exception e2) {
					System.err.println(e2.getMessage());
				}

			}
		});
		frame.getContentPane().add(btnCosulMeu);

		JButton btnFactura = new JButton("Factura");
		btnFactura.setBounds(356, 114, 89, 23);
		frame.getContentPane().add(btnFactura);
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				WriteFile writeText = new WriteFile();
				writeText.write(bijuteriiComandate);
			}
		});

		textField = new JTextField();
		textField.setBounds(437, 34, 89, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(333, 184, 193, 113);
		frame.getContentPane().add(textPane);

		JButton btnVeziPret = new JButton("Vezi pretul comenzii");
		btnVeziPret.setBounds(356, 148, 170, 23);
		frame.getContentPane().add(btnVeziPret);
		btnVeziPret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String rez = "";
				// Operatii o = new Operatii();
				int pretTotal = 0;
				for (Product pp : bijuteriiComandate) {

					rez += "Produs:" + pp.getName();
					rez += "-->";
					pretTotal += pp.getPrice();

					rez += "Price:" + pp.getPrice() + "\n";

				}
				rez += "Pret total:-->" + pretTotal;

				textPane.setText(rez);

			}
		});

		JButton btnDate = new JButton("Date produs");
		btnDate.setBounds(10, 91, 158, 23);
		frame.getContentPane().add(btnDate);

		JButton btnInapoi_1 = new JButton("Inapoi");
		btnInapoi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lf = new LoginFrame();
				lf.frame.setVisible(true);
			}
		});
		btnInapoi_1.setBounds(437, 321, 89, 23);
		frame.getContentPane().add(btnInapoi_1);

		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String den = comboBox1.getSelectedItem().toString();

				ArrayList<Product> bijuterii = new ArrayList<>();
				bijuterii = getBij();
				String rez = "";
				for (Product pp : bijuterii) {
					String t = pp.getName();
					if (pp.getName().equals(den)) {
						rez += "Nume:" + den;
						rez += "\n";
						rez += "Material:" + pp.getMaterial();
						rez += "\n";
						rez += "Producer:" + pp.getProducer();
						rez += "\n";
						rez += "Weight:" + pp.getWeight() + "\n";
						rez += "Stock:" + pp.getStock() + "\n";
						rez += "Price:" + pp.getPrice() + "\n";
					}
				}
				textPane.setText(rez);
			}

		});
	}

}
