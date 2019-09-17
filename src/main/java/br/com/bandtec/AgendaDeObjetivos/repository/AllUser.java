package br.com.bandtec.AgendaDeObjetivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.AgendaDeObjetivos.model.User;

@Repository
public interface AllUser extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.login =:login and u.password =:password")
	public User validaLoginESenha(@Param("login") String login, @Param("password") String password);

}
