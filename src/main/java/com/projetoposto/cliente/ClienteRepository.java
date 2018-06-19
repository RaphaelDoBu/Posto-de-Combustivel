package com.projetoposto.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetoposto.posto.Posto;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
		 
	 Cliente save(Cliente user);
	 List<Cliente> findAll();
	 Optional<Cliente> findById(Long id);
	

}
