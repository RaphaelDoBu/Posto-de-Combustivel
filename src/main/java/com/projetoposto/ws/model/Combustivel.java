package com.projetoposto.ws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Combustivel {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)	private Long id;
	@Column
	private String nome;
	@Column
	private float preco;
	@Column
	private float aumento;
	@OneToMany(mappedBy = "combustivel", cascade = CascadeType.ALL)
	private List<Avaliacao> avaliacoes;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "postos_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Posto posto;
	
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
	public Posto getPosto() {
		return posto;
	}
	public void setPosto(Posto posto) {
		this.posto = posto;
	}	
	
	
	

}
