package com.projetoposto.service;

import java.util.List;
import java.util.Optional;

import com.projetoposto.model.Posto;

public interface PostoService {

	 Posto findByUsername(String username);
	 
	 Posto save(Posto user);
	 List<Posto> findAll();
	 Optional<Posto> findById(Long id);
}
