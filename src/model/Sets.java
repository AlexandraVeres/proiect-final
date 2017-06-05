package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Sets {
	private HashSet<Product> oferta = new HashSet<>();

	public Sets(ArrayList<Product> bijuterii) {
		this.oferta = new HashSet(bijuterii);
	}

	public HashSet<Product> getOferta() {
		return oferta;
	}

	public void setOferta(HashSet<Product> oferta) {
		this.oferta = oferta;
	}

	public HashSet<Product> configSet(ArrayList<Product> bijuterii) {
		// HashSet<Product> oferta=new HashSet<>();
		for (int i = 0; i < bijuterii.size(); i++) {
			// for(int j=1;j<bijuterii.size();j++)
			if (bijuterii.get(i).equals("cercei")) {
				oferta.add(bijuterii.get(i));
				// oferta.add(bijuterii.get(j));
			}
		}
		return oferta;
	}
}
