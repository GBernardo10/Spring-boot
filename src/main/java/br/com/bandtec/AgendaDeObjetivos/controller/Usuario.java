package br.com.bandtec.AgendaDeObjetivos.controller;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario() {

	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + "]";
	}	

}
