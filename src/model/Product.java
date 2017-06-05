package model;

public class Product {
	private int idp;
	private String name, material;
	private int weight;
	private String producer;
	private int stock;
	private int price;

	public Product() {
		super();
	}

	public Product(int idp, String name, String material, int weight, String producer, int stock, int price) {
		super();
		this.idp = idp;
		this.name = name;
		this.material = material;
		this.weight = weight;
		this.producer = producer;
		this.stock = stock;
		this.price = price;
	}

	public int getID() {
		return idp;
	}

	public void setID(int idp) {
		this.idp = idp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
