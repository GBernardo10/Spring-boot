package br.com.bandtec.AgendaDeObjetivos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.bandtec.AgendaDeObjetivos.service.Prioridade;

@Entity
@Table(name = "TBD_OBJETIVOS")
public class Objective {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty
	private String titulo;

	@JsonProperty
	private String descricao;

	@Embedded
	@JsonProperty
	private Prioridade prioridade;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	

	@JsonProperty
	@Column(name = "DATA_MAXIMA_PARA_EXECUCAO")
	private LocalDate dataMaximaParaExecucao;

	public Objective() {
	}

	public Objective(Long id, String titulo, String descricao, Prioridade prioridade,
			LocalDate dataMaximaParaExecucao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}
}
