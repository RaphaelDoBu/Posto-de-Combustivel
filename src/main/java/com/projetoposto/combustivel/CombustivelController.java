package com.projetoposto.combustivel;

import java.util.Collection;
import java.util.List;

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

import com.projetoposto.avaliacao.Avaliacao;
import com.projetoposto.posto.Posto;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
public class CombustivelController {
	
	@Autowired
	private CombustivelService combustivelService;
										
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="posto/{id}/combustiveis")
    @ApiOperation(value = "Listagem de todos os combustiveis de um posto")
    public ResponseEntity<Collection<Combustivel>> getCombustiveis(@PathVariable(value="id") Long idPosto){
    	Collection<Combustivel> data = this.combustivelService.findAll(idPosto);
    	return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="posto/{idPosto}/combustivel/{id}")
    @ApiOperation(value = "Exibir um combustivel de um posto")
    public ResponseEntity<Combustivel> getCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable("id") Long id){
    	Combustivel data = this.combustivelService.findById(idPosto, id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.POST, value="posto/{idPosto}/combustivel")
    @ApiOperation(value = "Cadastro de um combustivel de um posto feito pelo dono do posto")
    public ResponseEntity<Combustivel> cadastroCombustivel(@PathVariable(value="idPosto") Long idPosto, @RequestBody Combustivel combustivel){
    	if (combustivel.getNome() != null){
	    	Combustivel data = this.combustivelService.save(idPosto, combustivel);
			return new ResponseEntity<>(data, HttpStatus.CREATED);
    	}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE, value="posto/{idPosto}/combustivel/{id}")
    @ApiOperation(value = "Exclusão de um combustivel de um posto feito pelo dono do posto")
    public void	deletarCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable("id") Long id){
    	combustivelService.delete(idPosto, id);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.PUT, value="posto/{idPosto}/combustivel/{id}")
    @ApiOperation(value = "Atualização dos dados de um combustivel de um posto feito pelo dono do posto")
    public ResponseEntity<Combustivel> updateCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="id") Long idCombustivel,
											@RequestBody Combustivel combustivel){
    	Combustivel data = this.combustivelService.save(idPosto, combustivel);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
}
