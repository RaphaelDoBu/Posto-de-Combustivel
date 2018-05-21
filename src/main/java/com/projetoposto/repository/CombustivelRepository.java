package com.projetoposto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoposto.model.Combustivel;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Long>{

}
