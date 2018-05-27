package com.projetoposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetoposto.model.Posto;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PostoRepository extends JpaRepository<Posto, Long>{

}
