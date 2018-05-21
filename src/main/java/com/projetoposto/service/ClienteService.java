package com.projetoposto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoposto.repository.ClienteRepository;
import com.projetoposto.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
    private ClienteRepository clienteRepository ;
	
	
//	public Cliente delete(Long id) {
//		Cliente cliente = clienteRepository.findById(id);
//	    if(cliente != null){
//	    	clienteRepository.delete(cliente);
//	    }
//	    return user;
//	}
}
