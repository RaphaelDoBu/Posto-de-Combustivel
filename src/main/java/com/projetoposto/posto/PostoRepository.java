package com.projetoposto.posto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PostoRepository extends JpaRepository<Posto, Long>{
	 Posto findByUsername(String username);
	 
	 Posto save(Posto user);
	 List<Posto> findAll();
	 Optional<Posto> findById(Long id);
}
