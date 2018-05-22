package com.projetoposto.model;

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
	
	@OneToMany(mappedBy = "posto", cascade = CascadeType.ALL)
	private List<Combustivel> listaDeCombustiveis;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "posto_cliente",
            joinColumns = { @JoinColumn(name = "posto_id") },
            inverseJoinColumns = { @JoinColumn(name = "cliente_id") })
	private List<Cliente> listaDeClientes;

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
//
//	public List<Posto> getListaDePostos() {
//		return listaDePostos;
//	}
//	public void setListaDePostos(List<Posto> listaDePostos) {
//		this.listaDePostos = listaDePostos;
//	}
//
//	public List<Combustivel> getListaDeCombustiveis() {
//		return listaDeCombustiveis;
//	}
//	public void setListaDeCombustiveis(List<Combustivel> listaDeCombustiveis) {
//		this.listaDeCombustiveis = listaDeCombustiveis;
//	}
}
