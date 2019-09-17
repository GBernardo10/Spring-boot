package br.com.bandtec.AgendaDeObjetivos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty
	private String login;
	@JsonProperty
	private String password;
	@JsonProperty
	private String name;
	@JsonProperty
	private Integer age;

	// construtor
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [age=" + age + ", id=" + id + ", name=" + name + "]";
	}

}
