package com.projetoposto.posto;

import java.util.List;
import java.util.Optional;

public interface PostoService {

	 Posto findByUsername(String username);
	 
	 Posto save(Posto user);
	 List<Posto> findAll();
	 Optional<Posto> findById(Long id);
}
