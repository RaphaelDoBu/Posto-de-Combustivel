package com.projetoposto.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
