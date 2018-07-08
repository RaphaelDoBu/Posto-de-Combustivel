package com.projetoposto.posto;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.combustivel.Combustivel;
import com.projetoposto.user.User;

@Entity
public class Posto extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@Column
	private String horarioAberto;
	
	@Column
	private String horarioFechado;
	
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Combustivel> getListaDeCombustiveis() {
		return listaDeCombustiveis;
	}

	public void setListaDeCombustiveis(List<Combustivel> listaDeCombustiveis) {
		this.listaDeCombustiveis = listaDeCombustiveis;
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}

	public String getHorarioAberto() {
		return horarioAberto;
	}

	public void setHorarioAberto(String horarioAberto) {
		this.horarioAberto = horarioAberto;
	}

	public String getHorarioFechado() {
		return horarioFechado;
	}

	public void setHorarioFechado(String horarioFechado) {
		this.horarioFechado = horarioFechado;
	}
	public Combustivel buscarCombustivel(Combustivel combustivel, List<Combustivel> lista){
		Combustivel combustivelEncontrado = null;
		for (Combustivel c: lista){
			if (c.getNome().equals(combustivel.getNome())){
				combustivelEncontrado = c;
			}
		}
		return combustivelEncontrado;
		
	}


}
