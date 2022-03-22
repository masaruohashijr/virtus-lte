package br.gov.previc.virtus.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String name;
    private int role_id;	
    private int author_id;
    private Timestamp criado_em;

    public User() {
		super();
    }
    
    public User(String username, String password, String email, String mobile, String name, int role_id, int author_id, Timestamp criado_em) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.role_id = role_id;	
        this.author_id = author_id;
        this.criado_em = criado_em;

    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
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

}


//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('1', '3', '2022-03-16 21:10:15.048000', 'gilbertogil@gmail.com.br', '+5561999999999', 'Gilberto Gil', '12345678', '5', 'gilberto_gil');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('2', '3', '2022-03-16 21:10:15.048000', 'caetanoveloso@gmail.com.br', '+5561999999999', 'Caetano Veloso', '12345678', '5', 'caetano_veloso');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('3', '3', '2022-03-16 21:10:15.048000', 'chicobuarque@gmail.com.br', '+5561999999999', 'Chico Buarque', '12345678', '5', 'chico_buarque');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('4', '3', '2022-03-16 21:10:15.048000', 'jorgebenjor@gmail.com.br', '+5561999999999', 'Jorge Ben Jor', '12345678', '5', 'jorge_ben_jor');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('5', '3', '2022-03-16 21:10:15.048000', 'tomjobim@gmail.com.br', '+5561999999999', 'Tom Jobim', '12345678', '5', 'tom_jobim');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('6', '3', '2022-03-16 21:10:15.048000', 'miltonnascimento@gmail.com.br', '+5561999999999', 'Milton Nascimento', '12345678', '5', 'milton_nascimento');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('7', '3', '2022-03-16 21:10:15.048000', 'elisregina@gmail.com.br', '+5561999999999', 'Elis Regina', '12345678', '5', 'elis_regina');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('8', '3', '2022-03-16 21:10:15.048000', 'joaogilberto@gmail.com.br', '+5561999999999', 'João Gilberto', '12345678', '5', 'joao_gilberto');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('9', '3', '2022-03-16 21:10:15.048000', 'toquinho@gmail.com.br', '+5561999999999', 'Toquinho', '12345678', '5', 'toquinho');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('10', '3', '2022-03-16 21:10:15.048000', 'viniciusmoraes@gmail.com.br', '+5561999999999', 'Vinícius de Moraes', '12345678', '5', 'vinícius_de_moraes');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('11', '3', '2022-03-16 21:10:15.048000', 'robertocarlos@gmail.com.br', '+5561999999999', 'Roberto Carlos', '12345678', '5', 'roberto_carlos');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('12', '3', '2022-03-16 21:10:15.048000', 'naraleao@gmail.com.br', '+5561999999999', 'Nara Leão', '12345678', '5', 'nara_leao');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('13', '3', '2022-03-16 21:10:15.048000', 'djavan@gmail.com.br', '+5561999999999', 'Djavan', '12345678', '5', 'djavan');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('14', '3', '2022-03-16 21:10:15.048000', 'taiguara@gmail.com.br', '+5561999999999', 'Taiguara', '12345678', '5', 'taiguara');
//INSERT INTO `virtus`.`user` (`id`, `author_id`, `criado_em`, `email`, `mobile`, `name`, `password`, `role_id`, `username`) VALUES ('15', '3', '2022-03-16 21:10:15.048000', 'zeramalho@gmail.com.br', '+5561999999999', 'Zé Ramalho', '12345678', '5', 'ze_ramalho');
