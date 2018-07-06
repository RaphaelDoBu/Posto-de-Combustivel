package com.projetoposto.cliente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.projetoposto.avaliacao.Avaliacao;

@Entity
public class Cliente {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Avaliacao> listaDeAvaliacoes;
	
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

	public List<Avaliacao> getListaDeAvaliacoes() {
		return listaDeAvaliacoes;
	}

	public void setListaDeAvaliacoes(List<Avaliacao> listaDeAvaliacoes) {
		this.listaDeAvaliacoes = listaDeAvaliacoes;
	}
	
	
	
}
