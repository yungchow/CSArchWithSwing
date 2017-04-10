package com.yc.login;

public class Start {
	public static void main(String[] args) {
		try {
			Client client = new Client();
			LoginDig login = LoginDig.getInstance(client);
			client.setLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
