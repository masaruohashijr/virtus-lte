package br.gov.previc.virtus.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private int origin_status_id;
    private int destination_status_id;
    private boolean other_than;
    private String description;
    private int author_id;
    private Timestamp created_at;
    private int id_versao_origem;
    private int status_id;

    public Action() {
		super();
    }

	public Action(int id, String name, int origin_status_id, int destination_status_id, boolean other_than,
			String description, int author_id, Timestamp created_at, int id_versao_origem, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.origin_status_id = origin_status_id;
		this.destination_status_id = destination_status_id;
		this.other_than = other_than;
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

	public int getOrigin_status_id() {
		return origin_status_id;
	}

	public void setOrigin_status_id(int origin_status_id) {
		this.origin_status_id = origin_status_id;
	}

	public int getDestination_status_id() {
		return destination_status_id;
	}

	public void setDestination_status_id(int destination_status_id) {
		this.destination_status_id = destination_status_id;
	}

	public boolean isOther_than() {
		return other_than;
	}

	public void setOther_than(boolean other_than) {
		this.other_than = other_than;
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
