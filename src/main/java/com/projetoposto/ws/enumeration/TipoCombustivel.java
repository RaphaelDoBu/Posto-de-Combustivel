package com.projetoposto.ws.enumeration;

public enum TipoCombustivel {
	
	GASOLINA_COMUM("Gasolina comum"), GASOLINA_ADITIVADA("Gasolina aditivada"), DIESEL("Diesel"), ALCOOL("Alcool");
	
	private String descricao;
	
	TipoCombustivel(String nome) {
		this.descricao = nome;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
