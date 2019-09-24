package br.com.bandtec.AgendaDeObjetivos.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.bandtec.AgendaDeObjetivos.service.Credentials;

@Entity
public class User {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	@JsonProperty
	private Credentials credentials; 
	
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
