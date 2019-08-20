package br.com.bandtec.AgendaDeObjetivos.controller;

public class User {
	// atributos
	private String name;
	private Integer age;

	// construtor
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	// metodo getter
	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

}
