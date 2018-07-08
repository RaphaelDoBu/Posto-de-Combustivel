package com.projetoposto.user;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.posto.Posto;

public interface UserService {
	User findByUsername(String username);
	 
	 Cliente save(Cliente user);
	 Posto save(Posto user);
}
