package client;

import view.LoginFrame;



public class ClientMain {

	//private static ClientController controllerClient;
	
	public static void main(String [] args){
		String host = "localhost";
		int port = 11001;
		
		
		LoginFrame login = new LoginFrame();
		login.frame.setVisible(true);
		
	}
}

