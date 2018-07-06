package com.projetoposto.avaliacao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/posto/{idPosto}/combustivel/{idCombustivel}/avaliacoes")
	public List<Avaliacao> getAvaliacoes(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCombustivel") Long idCombustivel){
		return avaliacaoService.findAll(idPosto, idCombustivel);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="cliente/{idCliente}/posto/{idPosto}/combustivel/{idCombustivel}/avaliacao")
	public Avaliacao cadastroAvalicaoCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCliente") Long idCliente, 
			@PathVariable(value="idCombustivel") Long idCombustivel, @RequestBody Avaliacao avaliacao){
    	return avaliacaoService.save(idPosto, idCombustivel, idCliente, avaliacao);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="cliente/{idCliente}/posto/{idPosto}/combustivel/{idCombustivel}/avaliacao/{idAvaliacao}")
	public void deletarAvaliacaoCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCliente") Long idCliente, 
			@PathVariable(value="idCombustivel") Long idCombustivel, @PathVariable(value="idAvaliacao") Long idAvaliacao){
    	avaliacaoService.delete(idPosto, idCombustivel, idCliente, idAvaliacao);
	}

}
