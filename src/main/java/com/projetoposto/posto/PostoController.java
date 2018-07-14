package com.projetoposto.posto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projetoposto.user.UserService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PostoController {
	
	@Autowired
	private PostoService postoService;

	@Autowired
	private UserService userService;
	
    @RequestMapping(method=RequestMethod.GET, value="/postos")
    @ApiOperation(value = "Listagem de todos os postos")
    public List<Posto> getPostos(){
		return postoService.findAll();
	}
								
    @RequestMapping(method=RequestMethod.GET, value="/posto/{id}")
    @ApiOperation(value = "Exibição de um posto")
    public Posto getPosto(@PathVariable Long id){
		return postoService.findById(id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/signup")
    @ApiOperation(value = "Cadastro de um posto")
    public Posto cadastroPosto(@RequestBody Posto posto){
		return userService.save(posto);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/posto/{id}")
    @ApiOperation(value = "Exclusão de um posto")
    public void	deletarPosto(Posto posto){
    	postoService.delete(posto);
	}
    
    @RequestMapping(method=RequestMethod.PUT, value="/posto/{id}")
    @ApiOperation(value = "Atualização dos dados de um posto")
    public Posto updateCliente(Posto posto){
		return userService.save(posto);
	}

}
