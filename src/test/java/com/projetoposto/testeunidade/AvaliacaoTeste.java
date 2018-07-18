package com.projetoposto.testeunidade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetoposto.avaliacao.Avaliacao;
import com.projetoposto.combustivel.Combustivel;
import com.projetoposto.projetoPosto.ProjetoPostoApplicationTests;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = { ProjetoPostoApplicationTests.class})
public class AvaliacaoTeste {
	
	@Test
	public void criarAvaliacao() {
		Avaliacao avaliacao = new Avaliacao("Esse combustivel esta aumentando toda semana");
		Combustivel combustivel1 = new Combustivel("Alcool", 3.2F, 0F, null, null);

		avaliacao.setCombustivel(combustivel1);
		
		assertEquals(avaliacao.getCombustivel().getNome(), "Alcool");
		assertEquals(avaliacao.getComentario(), "Esse combustivel esta aumentando toda semana");

	}
}
