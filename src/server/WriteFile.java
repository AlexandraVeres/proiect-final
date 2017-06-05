package server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Product;

public class WriteFile {
	// public static void main(String[] args) {
	public static void write(ArrayList<Product> bijuteriiComandate) {
		try {
			String rez = "       FACTURA          " + "\n";
			int pretTotal = 0;
			for (Product pp : bijuteriiComandate) {

				rez += "Produs:" + pp.getName();
				rez += "-->";
				pretTotal += pp.getPrice();

				rez += "Price:" + pp.getPrice() + "\n";

			}
			rez += "Pret total:-->" + pretTotal;

			File file = new File("factura.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			// bw.write(content);
			bw.write(rez);
			bw.close();

			System.out.println("S-a tiparit factura !");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}