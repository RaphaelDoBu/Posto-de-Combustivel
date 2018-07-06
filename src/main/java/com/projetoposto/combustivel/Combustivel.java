package com.projetoposto.combustivel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetoposto.avaliacao.Avaliacao;
import com.projetoposto.posto.Posto;

@Entity
public class Combustivel {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column
	private String nome;
	
	@Column
	private float preco;
	
	@Column
	private float aumento;
	
	@OneToMany(mappedBy = "combustivel", cascade = CascadeType.ALL)
	private List<Avaliacao> avaliacoes;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore 
	private Posto posto;
	
	public Combustivel(){
		
	}
	
	public Combustivel(String nome, float preco, float aumento, List<Avaliacao> avaliacoes, Posto posto) {
		this.nome = nome;
		this.preco = preco;
		this.aumento = aumento;
		this.avaliacoes = avaliacoes;
		this.posto = posto;
	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}	
	
	
	

}
