package model;

public class Client {
	private String name, username, password;
	private int id;

	public Client() {

	}

	public Client(int id) {
		super();
		this.id = id;
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	public Client(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Client(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setID(int id2) {
		// TODO Auto-generated method stub
		this.id = id2;
	}

	public void login(String username2, String password2) {
		// TODO Auto-generated method stub

	}

}
