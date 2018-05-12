package com.projetoposto.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.projetoposto.ws.model.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long>{

}
