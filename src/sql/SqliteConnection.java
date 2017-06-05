package sql;

import java.sql.*;

import javax.swing.*;

public class SqliteConnection {
	Connection conn = null;

	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:D:\\faculta\\an III\\An3Facultate\\FACULTA\\PS\\workspace\\PROIECT_CLIENT_SERVER\\bijuterii.sqlite");
			JOptionPane.showMessageDialog(null, "Succes!");

			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.out.println("Eroare");
			return null;
		}
	}
}
