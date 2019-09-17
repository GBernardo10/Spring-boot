package br.com.bandtec.AgendaDeObjetivos.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

//	@Query("select u from Usuario u where u.login =:login and u.senha =:senha")
//	public boolean existe(@Param("login") String login, @Param("senha") String senha);
	
	@Query("select u from Usuario u where u.login =:login and u.senha =:senha")
	public Usuario existe(@Param("login") String login, @Param("senha") String senha);
//	
}
