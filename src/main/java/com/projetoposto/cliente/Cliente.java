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
import com.projetoposto.user.User;

@Entity
public class Cliente extends User{
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column
	private String nome;
	
	@Column
	private String email;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Avaliacao> listaDeAvaliacoes;
	
	public Cliente(){
		
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

	public List<Avaliacao> getListaDeAvaliacoes() {
		return listaDeAvaliacoes;
	}

	public void setListaDeAvaliacoes(List<Avaliacao> listaDeAvaliacoes) {
		this.listaDeAvaliacoes = listaDeAvaliacoes;
	}
	
	
	
}
