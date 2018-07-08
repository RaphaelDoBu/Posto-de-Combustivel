package com.projetoposto.posto;

import java.util.List;
import java.util.Optional;

public interface PostoService {

	 Posto findByUsername(String username);
	 
	 List<Posto> findAll();
	 Optional<Posto> findById(Long id);

	 void delete(Posto posto);

}
