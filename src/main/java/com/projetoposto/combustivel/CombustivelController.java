package com.projetoposto.combustivel;

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
public class CombustivelController {
	
	@Autowired
	private CombustivelService combustivelService;
																																																																																																													
    @RequestMapping(method=RequestMethod.GET, value="posto/{id}/combustiveis")
	public List<Combustivel> getCombustiveis(@PathVariable(value="id") Long idPosto){
		return combustivelService.findAll(idPosto);
	}
	
    @RequestMapping(method=RequestMethod.GET, value="posto/{idPosto}/combustivel/{id}")
	public Combustivel getCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable("id") Long id){
		return combustivelService.findById(idPosto, id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="posto/{idPosto}/combustivel")
	public Combustivel cadastroCombustivel(@PathVariable(value="idPosto") Long idPosto, @RequestBody Combustivel combustivel){
    	return combustivelService.save(idPosto, combustivel);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="posto/{idPosto}/combustivel/{id}")
    public void	deletarCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable("id") Long id){
    	combustivelService.delete(idPosto, id);
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="posto/{idPosto}/combustivel/{id}")
	public Combustivel updateCombustivel(@PathVariable(value="idPosto") Long idPosto, @PathVariable(value="id") Long idCombustivel,
											@RequestBody Combustivel combustivel){
		return combustivelService.update(idPosto,idCombustivel, combustivel);
	}
	
}
