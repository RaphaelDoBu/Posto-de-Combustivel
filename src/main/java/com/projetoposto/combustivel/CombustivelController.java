package com.projetoposto.combustivel;

import java.util.List;
import java.util.Optional;

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
	private CombustivelRepository combustivelRepository;
	
	@Autowired
	private CombustivelService combustivelService;
																																																																																																													
    @RequestMapping(method=RequestMethod.GET, value="/combustiveis")
	public List<Combustivel> getCombustiveis(){
        System.out.println("Executando a lógica com Spring MVC");
		return combustivelService.findAll();
	}
	
    @RequestMapping(method=RequestMethod.GET, value="/combustivel/{id}")
	public Optional<Combustivel> getCombustivel(@PathVariable("id") Long id){
		return combustivelService.findById(id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/combustivel")
	public Combustivel cadastroCombustivel(@RequestBody Combustivel combustivel){
		return combustivelService.save(combustivel);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/combustivel/{id}")
    public void	deletarCombustivel(Combustivel combustivel){
    	combustivelService.delete(combustivel);
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="/combustivel/{id}")
	public Combustivel updateCombustivel(Combustivel combustivel){
		return combustivelService.save(combustivel);
	}

	
}
