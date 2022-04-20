package br.gov.previc.virtus.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nome;
	private String abreviatura;
	private String descricao;
	private int chefe_id;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "office")
    private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUser(List<User> users) {
		this.users = users;
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

}