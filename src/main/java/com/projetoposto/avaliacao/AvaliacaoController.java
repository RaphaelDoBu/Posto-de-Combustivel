package com.projetoposto.avaliacao;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoposto.posto.Posto;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.GET, value="/posto/{idPosto}/combustivel/{idCombustivel}/avaliacoes")
    @ApiOperation(value = "Listagem de todas as avaliações")
	public ResponseEntity<Collection<Avaliacao>> getAvaliacoes(@PathVariable(value="idPosto") Long idPosto, 
												@PathVariable(value="idCombustivel") Long idCombustivel){
	   	Collection<Avaliacao> data = this.avaliacaoService.findAll(idPosto, idCombustivel);
    	return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.POST, value="cliente/{idCliente}/posto/{idPosto}/combustivel/{idCombustivel}/avaliacao")
    @ApiOperation(value = "Cadastro de uma avaliação por combustivel de um posto feito pelo cliente")
	public ResponseEntity<Avaliacao> cadastroAvalicaoCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCliente") Long idCliente, 
			@PathVariable(value="idCombustivel") Long idCombustivel, @RequestBody Avaliacao avaliacao){
		if (avaliacao.getComentario() != null){
	    	Avaliacao data = this.avaliacaoService.save(idPosto, idCombustivel, idCliente, avaliacao);
			return new ResponseEntity<>(data, HttpStatus.OK);
    	}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.POST, value="cliente/{idCliente}/posto/{idPosto}/combustivel/{idCombustivel}/avaliacao/{idAvaliacao}")
    @ApiOperation(value = "Remover uma avaliação por combustivel de um posto feito pelo cliente")
	public void deletarAvaliacaoCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="idCliente") Long idCliente, 
			@PathVariable(value="idCombustivel") Long idCombustivel, @PathVariable(value="idAvaliacao") Long idAvaliacao){
    	avaliacaoService.delete(idPosto, idCombustivel, idCliente, idAvaliacao);
	}

}
