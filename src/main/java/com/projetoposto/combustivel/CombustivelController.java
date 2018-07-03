package com.projetoposto.combustivel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.projetoposto.posto.Posto;
import com.projetoposto.posto.PostoRepository;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CombustivelController {
	
	@Autowired
	private CombustivelService combustivelService;
																																																																																																													
    @RequestMapping(method=RequestMethod.GET, value="posto/{id}/combustiveis")
	public List<Combustivel> getCombustiveis(@PathVariable(value="id") Long idPosto){
    	System.out.println("ID DO POSTO:" + idPosto);
        System.out.println("Executando a lógica com Spring MVC");
		return combustivelService.findAll(idPosto);
	}
	
    @RequestMapping(method=RequestMethod.GET, value="/combustivel/{id}")
	public Combustivel getCombustivel(@RequestParam("idPosto") Long idPosto, @PathVariable("id") Long id){
		return combustivelService.findById(idPosto, id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="posto/{id}/combustivel")
	public Combustivel cadastroCombustivel(@PathVariable(value="id") Long idPosto, @RequestBody Combustivel combustivel){
    	System.out.println("ID DO POSTO:" + idPosto);
    	System.out.println(combustivel.getNome());
    	return combustivelService.save(idPosto, combustivel);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/combustivel/{id}")
    public void	deletarCombustivel(@RequestParam("idPosto") Long idPosto, @PathVariable("id") Long id){
    	combustivelService.delete(idPosto, id);
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="/combustivel/{id}")
	public Combustivel updateCombustivel(@RequestParam("idPosto") Long idPosto,  @RequestBody Combustivel combustivel){
		return combustivelService.save(idPosto,combustivel);
	}
	
}
