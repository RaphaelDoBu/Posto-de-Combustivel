package com.projetoposto.combustivel;

import java.util.List;
import java.util.Optional;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.posto.Posto;

public interface CombustivelService {

	 
	 Combustivel save(Combustivel combustivel);
	 List<Combustivel> findAll();
	 Optional<Combustivel> findById(Long id);
	 void delete(Combustivel combustivel);

}
