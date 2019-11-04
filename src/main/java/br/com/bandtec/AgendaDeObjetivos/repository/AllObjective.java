package br.com.bandtec.AgendaDeObjetivos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bandtec.AgendaDeObjetivos.model.Objective;

@Repository
public interface AllObjective extends JpaRepository<Objective, Long> {

	// JPQL
	@Query("select o from Objective o where o.dataMaximaParaExecucao <=:data")
	public List<Objective> ate(@Param("data") LocalDate data);

}
