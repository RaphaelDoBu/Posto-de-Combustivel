package com.projetoposto.combustivel;

import java.util.List;


public interface CombustivelService {

	 
	 Combustivel save(Long id, Combustivel combustivel);
	 List<Combustivel> findAll(Long idPosto);
	 Combustivel findById(Long idPosto, Long id);
	 void delete(Long idPosto, Long id);

}
