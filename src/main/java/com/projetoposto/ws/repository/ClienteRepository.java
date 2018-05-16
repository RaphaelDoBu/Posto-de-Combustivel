package com.projetoposto.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.projetoposto.ws.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	

}
