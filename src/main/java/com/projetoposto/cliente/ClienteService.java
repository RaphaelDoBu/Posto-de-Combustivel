package com.projetoposto.cliente;

import java.util.List;
import java.util.Optional;


public interface ClienteService {
	
//	Cliente findByUsername(String username);
	 
	 Cliente save(Cliente user);
	 List<Cliente> findAll();
	 Optional<Cliente> findById(Long id);
	 
	 void delete(Cliente cliente);

}
