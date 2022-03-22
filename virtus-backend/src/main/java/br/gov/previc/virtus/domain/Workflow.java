package br.gov.previc.virtus.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workflow {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	private String name;
	private String description;
	private String entity_type;
	private Timestamp start_at;
	private Timestamp end_at;
	private int author_id;
	private Timestamp created_at;
	private int id_versao_origem;
	private int status_id;
	
	public Workflow() {
		super();
	}

	public Workflow(int id, String name, String description, String entity_type, Timestamp start_at, Timestamp end_at,
			int author_id, Timestamp created_at, int id_versao_origem, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.entity_type = entity_type;
		this.start_at = start_at;
		this.end_at = end_at;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntity_type() {
		return entity_type;
	}

	public void setEntity_type(String entity_type) {
		this.entity_type = entity_type;
	}

	public Timestamp getStart_at() {
		return start_at;
	}

	public void setStart_at(Timestamp start_at) {
		this.start_at = start_at;
	}

	public Timestamp getEnd_at() {
		return end_at;
	}

	public void setEnd_at(Timestamp end_at) {
		this.end_at = end_at;
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
