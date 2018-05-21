package com.projetoposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetoposto.model.Posto;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Long>{

}
