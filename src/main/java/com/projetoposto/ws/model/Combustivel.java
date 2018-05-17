package com.projetoposto.ws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Combustivel {
	
	@Id @GeneratedValue
	private String nome;
	@Column
	private float preco;
	@Column
	private float aumento;
	@Column
	@OneToMany(mappedBy = "combustivel", cascade = CascadeType.ALL)
	private List<Avaliacao> avaliacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getAumento() {
		return aumento;
	}
	public void setAumento(float aumento) {
		this.aumento = aumento;
	}
	
	
	

}
