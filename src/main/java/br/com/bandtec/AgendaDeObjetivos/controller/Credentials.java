package br.com.bandtec.AgendaDeObjetivos.controller;

public class Credentials {

	private String login;
	private String senha;

	public Credentials(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}

}
