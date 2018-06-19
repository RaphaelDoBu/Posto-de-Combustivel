package com.projetoposto.combustivel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CombustivelRepository extends JpaRepository<Combustivel, Long>{

	 
	Combustivel save(Combustivel combustivel);
	 List<Combustivel> findAll();
	 Optional<Combustivel> findById(Long id);
}
