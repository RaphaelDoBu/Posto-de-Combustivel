package com.projetoposto.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoposto.posto.Posto;

public interface ClienteService {
	
//	Cliente findByUsername(String username);
	 
	 Cliente save(Cliente user);
	 List<Cliente> findAll();
	 Optional<Cliente> findById(Long id);
	 
	 void delete(Cliente cliente);

}
