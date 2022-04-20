package br.gov.previc.virtus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String description;
	private String stereotype;

	
	public Status() {
		super();
	}


	public Status(int id, String name, String description, int status_id, String stereotype) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.stereotype = stereotype;
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


	public String getStereotype() {
		return stereotype;
	}


	public void setStereotype(String stereotype) {
		this.stereotype = stereotype;
	}

}
