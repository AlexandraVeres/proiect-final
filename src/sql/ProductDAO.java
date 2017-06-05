package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Product;

public class ProductDAO {
	@Resource(name = "jdbc/bijuterii")
	private static DataSource ds;

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
	public void addProduct(Product product) {
		String sql = "INSERT INTO Product VALUES('" + product.getID() + "','" + product.getName() + "','"
				+ product.getMaterial() + "','" + product.getWeight() + "','" + product.getProducer() + "','"
				+ product.getStock() + "','" + product.getPrice() + "')";
		System.out.println("s-a introdus nou product");
		executeModifyQuery(sql);

	}

	// read
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM Product";
		ResultSet rs = executeFetchQuery(sql);
		try {
			while (rs.next()) {
				Product product = new Product();
				int id = product.getID();
				product.setID(id);
				product.setName(rs.getString("name"));

				list.add(product);

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	// update
	public void updateProduct(Product product, String nume) {
		String sql = "UPDATE Product SET name='" + product.getName() + "',material='" + product.getMaterial()
				+ "',producer='" + product.getProducer() + "',weight='" + product.getWeight() + "',stock='"
				+ product.getStock() + "',price='" + product.getPrice() + "'Where name= '" + nume + "'";
		executeModifyQuery(sql);
	}

	// delete
	public void deleteProduct(String numeProdusSters) {
		String sql = "DELETE FROM Product WHERE name='" + numeProdusSters + "'";
		executeModifyQuery(sql);

	}

	public String deleteProduct2(String numeProdusSters) {
		String sql = "DELETE FROM Product WHERE name='" + numeProdusSters + "'";
		executeModifyQuery(sql);
		return numeProdusSters;

	}

	public void updateStock(int stock, String name) {

		String sql = "UPDATE Product SET stock='" + stock + "'Where name= '" + name + "'";

		executeModifyQuery(sql);

	}
}
