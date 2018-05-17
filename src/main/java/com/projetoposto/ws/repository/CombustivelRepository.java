package com.projetoposto.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoposto.ws.model.Cliente;
import com.projetoposto.ws.model.Combustivel;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long>{

}
