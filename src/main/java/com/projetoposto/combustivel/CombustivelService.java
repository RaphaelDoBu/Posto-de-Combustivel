package com.projetoposto.combustivel;

import java.util.List;
import java.util.Optional;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.posto.Posto;

public interface CombustivelService {

	 
	 Combustivel save(Long id, Combustivel combustivel);
	 List<Combustivel> findAll(Long idPosto);
	 Combustivel findById(Long idPosto, Long id);
	 void delete(Long idPosto, Long id);

}
