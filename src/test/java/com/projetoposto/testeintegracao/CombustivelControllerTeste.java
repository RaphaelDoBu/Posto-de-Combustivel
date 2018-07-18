package com.projetoposto.testeintegracao;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.TestSecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetoposto.authentication.LoginUser;
import com.projetoposto.combustivel.Combustivel;
import com.projetoposto.config.JwtTokenUtil;
import com.projetoposto.posto.Posto;
import com.projetoposto.projetoPosto.ProjetoPostoApplicationTests;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = { ProjetoPostoApplicationTests.class})
public class CombustivelControllerTeste {

	@Test
	public void postoCriaCombustivel() {
		Posto posto = new Posto("Posto Ipiranga", "Rua Floriano Peixoto", "06:30", "22:00", "22112212");
		posto.setUsername("postouser");
		posto.setPassword("postouser");
		
		LoginUser login = new LoginUser();
		login.setPassword("postouser");
		login.setUsername("postouser");
//		TestSecurityContextHolder
//	     .getContext()
//	     .setAuthentication( new JwtTokenUtil(login, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
		
//		Combustivel combustivel1 = new Combustivel("Alcool", 3.2F, 0F, null, posto);
//		
//		posto.getListaDeCombustiveis().add(combustivel1);
//				
//		assertEquals(posto.getListaDeCombustiveis().get(0).getNome(), "Alcool");
		
	}


	
}
