package br.gov.previc.virtus.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feature {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	private String name;
	private String code;
	private String description;
	private int author_id;
	private Timestamp created_at;
	private int id_versao_origem;
	private int status_id;
	
	public Feature() {
		super();
	}

	public Feature(int id, String name, String code, String description, int author_id, Timestamp created_at,
			int id_versao_origem, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.author_id = author_id;
		this.created_at = created_at;
		this.id_versao_origem = id_versao_origem;
		this.status_id = status_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
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
