package com.projetoposto.testeunidade;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetoposto.posto.Posto;
import com.projetoposto.projetoPosto.ProjetoPostoApplicationTests;


@RunWith(SpringRunner.class)
@SpringBootTest (classes = { ProjetoPostoApplicationTests.class})
public class PostoTeste {
	
	@Test
	public void criarPosto() {
		Posto posto = new Posto("Posto Ipiranga", "Rua Floriano Peixoto", "06:30", "22:00", "22112212");
		posto.setUsername("postouser");
		posto.setPassword("postouser");
		
		assertEquals(posto.getNome(), "Posto Ipiranga");
		
	}
}