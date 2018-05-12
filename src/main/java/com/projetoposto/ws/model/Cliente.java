package com.projetoposto.ws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id @GeneratedValue
	private Long id;
	@Column
	private String nome;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Posto> posto;


	public Cliente(){
		
	}
	

	public Cliente(Long id, String nome, String username, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public List<Posto> getPosto() {
		return posto;
	}
	public void setPosto(List<Posto> posto) {
		this.posto = posto;
	}	
	
}
