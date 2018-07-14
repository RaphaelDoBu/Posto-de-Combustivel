package com.projetoposto.avaliacao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/posto/{idPosto}/combustivel/{idCombustivel}/avaliacoes")
    @ApiOperation(value = "Listagem de todas as avaliações")
	public List<Avaliacao> getAvaliacoes(@PathVariable(value="idPosto") Long idPosto, 
												@PathVariable(value="idCombustivel") Long idCombustivel){
		return avaliacaoService.findAll(idPosto, idCombustivel);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="cliente/{idCliente}/posto/{idPosto}/combustivel/{idCombustivel}/avaliacao")
    @ApiOperation(value = "Cadastro de uma avaliação por combustivel de um posto feito pelo cliente")
	public Avaliacao cadastroAvalicaoCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCliente") Long idCliente, 
			@PathVariable(value="idCombustivel") Long idCombustivel, @RequestBody Avaliacao avaliacao){
    	return avaliacaoService.save(idPosto, idCombustivel, idCliente, avaliacao);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="cliente/{idCliente}/posto/{idPosto}/combustivel/{idCombustivel}/avaliacao/{idAvaliacao}")
    @ApiOperation(value = "Remover uma avaliação por combustivel de um posto feito pelo cliente")
	public void deletarAvaliacaoCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCliente") Long idCliente, 
			@PathVariable(value="idCombustivel") Long idCombustivel, @PathVariable(value="idAvaliacao") Long idAvaliacao){
    	avaliacaoService.delete(idPosto, idCombustivel, idCliente, idAvaliacao);
	}

}
