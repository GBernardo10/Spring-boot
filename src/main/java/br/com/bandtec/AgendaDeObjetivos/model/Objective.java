package br.com.bandtec.AgendaDeObjetivos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonProperty
	@Column(name = "DATA_MAXIMA_PARA_EXECUCAO")
	private LocalDate dataMaximaParaExecucao;

	public Objective() {
	}

	public Objective(String titulo, String descricao, LocalDate dataMaximaParaExecucao) {
		this.titulo = titulo;
		this.descricao = descricao;
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
