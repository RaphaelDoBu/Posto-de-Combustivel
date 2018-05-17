package com.projetoposto.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoposto.ws.model.Cliente;

public interface CombustivelRepository extends JpaRepository<Cliente, Long>{

}
