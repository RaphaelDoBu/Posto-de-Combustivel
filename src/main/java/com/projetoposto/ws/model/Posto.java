package com.projetoposto.ws.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
public class Posto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String endereco;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String cnpj;
	@Column
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Posto> listaDePostos;
	
	
	public Posto(){
		
	}
	
	public Posto( String nome, String endereco, String username, String password, String cnpj) {
		this.nome = nome;
		this.endereco = endereco;
		this.username = username;
		this.password = password;
		this.cnpj = cnpj;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public String getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Posto> getListaDePostos() {
		return listaDePostos;
	}
	public void setListaDePostos(List<Posto> listaDePostos) {
		this.listaDePostos = listaDePostos;
	}
}
