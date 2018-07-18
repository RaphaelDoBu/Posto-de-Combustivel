package com.projetoposto.testeunidade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.posto.Posto;
import com.projetoposto.projetoPosto.ProjetoPostoApplicationTests;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = { ProjetoPostoApplicationTests.class})
public class ClienteTeste {
	
	@Test
	public void criarCliente() {
		Cliente cliente = new Cliente("Jose da Silva", "jose@gmail.com");
		cliente.setUsername("postouser");
		cliente.setPassword("postouser");
		
		assertEquals(cliente.getNome(), "Jose da Silva");
		assertEquals(cliente.getEmail(), "jose@gmail.com");

	}
}