package com.projetoposto.avaliacao;

import java.util.List;



public interface AvaliacaoService {
	
	 Avaliacao save(Long idPosto,Long idCombustivel, Long idCliente, Avaliacao avaliacao);
	 List<Avaliacao> findAll(Long idPosto, Long idCombustivel);
	 void delete(Long idPosto, Long idCombustivel, Long idCliente, Long idAvaliacao);
}
