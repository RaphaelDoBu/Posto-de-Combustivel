package com.projetoposto.testeunidade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.combustivel.Combustivel;
import com.projetoposto.projetoPosto.ProjetoPostoApplicationTests;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = { ProjetoPostoApplicationTests.class})
public class CombustivelTeste {
	
	@Test
	public void criarCombustivel() {
		Combustivel combustivel1 = new Combustivel("Alcool", 3.2F, 0F, null, null);

		assertEquals(combustivel1.getNome(), "Alcool");

	}
}