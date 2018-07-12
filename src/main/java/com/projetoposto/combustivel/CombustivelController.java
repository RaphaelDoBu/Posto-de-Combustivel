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
	
    @RequestMapping(method=RequestMethod.GET, value="/combustivel/{id}")
	public Combustivel getCombustivel(@PathVariable(value="id") Long idPosto, @PathVariable("id") Long id){
		return combustivelService.findById(idPosto, id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="posto/{id}/combustivel")
	public Combustivel cadastroCombustivel(@PathVariable(value="id") Long idPosto, @RequestBody Combustivel combustivel){
    	return combustivelService.save(idPosto, combustivel);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/combustivel/{id}")
    public void	deletarCombustivel(@PathVariable(value="id") Long idPosto, @PathVariable("id") Long id){
    	combustivelService.delete(idPosto, id);
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="/combustivel/{id}")
	public Combustivel updateCombustivel(@PathVariable(value="id") Long idPosto,  @RequestBody Combustivel combustivel){
		return combustivelService.save(idPosto,combustivel);
	}
	
}
