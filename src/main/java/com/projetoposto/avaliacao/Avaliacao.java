package com.projetoposto.avaliacao;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetoposto.cliente.Cliente;
import com.projetoposto.combustivel.Combustivel;

@Entity
@Table(name="TB_AVALIACAO")
public class Avaliacao {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column
	private String comentario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "combustivel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Combustivel combustivel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore 
	private Cliente cliente;
	
	public Avaliacao(String comentario) {
		this.comentario = comentario;
	}
	
	public Avaliacao() {
	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
