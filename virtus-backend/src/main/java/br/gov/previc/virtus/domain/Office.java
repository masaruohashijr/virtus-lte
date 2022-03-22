package br.gov.previc.virtus.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nome;
	private String abreviatura;
	private String descricao;
	private int chefe_id;
	private int author_id;
	private Timestamp criado_em;
	private int id_versao_origem;
	private int status_id;

	public Office() {
		super();
	}

	public Office(int id, String nome, String abreviatura, String descricao, int chefe_id, int author_id,
			Timestamp criado_em, int id_versao_origem, int status_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.abreviatura = abreviatura;
		this.descricao = descricao;
		this.chefe_id = chefe_id;
		this.author_id = author_id;
		this.criado_em = criado_em;
		this.id_versao_origem = id_versao_origem;
		this.status_id = status_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getChefe_id() {
		return chefe_id;
	}

	public void setChefe_id(int chefe_id) {
		this.chefe_id = chefe_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public Timestamp getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Timestamp criado_em) {
		this.criado_em = criado_em;
	}

	public int getId_versao_origem() {
		return id_versao_origem;
	}

	public void setId_versao_origem(int id_versao_origem) {
		this.id_versao_origem = id_versao_origem;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
}