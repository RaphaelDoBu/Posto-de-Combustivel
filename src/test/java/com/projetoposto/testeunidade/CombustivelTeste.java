package com.projetoposto.testeunidade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetoposto.avaliacao.Avaliacao;
import com.projetoposto.cliente.Cliente;
import com.projetoposto.combustivel.Combustivel;
import com.projetoposto.posto.Posto;
import com.projetoposto.projetoPosto.ProjetoPostoApplicationTests;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = { ProjetoPostoApplicationTests.class})
public class CombustivelTeste {
	
	@Test
	public void criarCombustivel() {
		Combustivel combustivel1 = new Combustivel("Alcool", 3.2F, 0F, null, null);
		Posto posto = new Posto("Posto Ipiranga", "Rua Floriano Peixoto", "06:30", "22:00", "22112212");
		List<Avaliacao> avaliacoes = new ArrayList<>();
		Avaliacao avaliacao1 = new Avaliacao("Esse combustivel esta aumentando toda semana");
		avaliacoes.add(avaliacao1); 
		
		combustivel1.setPosto(posto);
		combustivel1.setAvaliacoes(avaliacoes);
		
		assertEquals(combustivel1.getNome(), "Alcool");
		assertEquals(combustivel1.getAvaliacoes().get(0).getComentario(), "Esse combustivel esta aumentando toda semana");

	}
	
	
}