package br.com.bandtec.AgendaDeObjetivos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.AgendaDeObjetivos.model.User;
import br.com.bandtec.AgendaDeObjetivos.service.Credentials;

@Repository
public interface AllUser extends JpaRepository<User, Long> {

	@Query("select u from User u where u.credentials = :credentials")
	public User validaLoginESenha(@Param("credentials") Credentials credentials);

	@Query("from User where name = :name")
	public List<User> findByName(@Param("name")String nome);

}