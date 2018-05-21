package com.projetoposto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Cliente {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)	private Long id;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@OneToMany(mappedBy = "listaDeClientes", cascade = CascadeType.ALL)
	private List<Posto> listaDePostos;


	public Cliente(){
		
	}
	

	public Cliente(String nome, String username, String password) {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

//
//	public List<Posto> getListaDePostos() {
//		return listaDePostos;
//	}
//
//
//	public void setListaDePostos(List<Posto> listaDePostos) {
//		this.listaDePostos = listaDePostos;
//	}
	
	
}
