package com.projetoposto.posto;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="/postos")
    @ApiOperation(value = "Listagem de todos os postos")
    public ResponseEntity<Collection<Posto>> getPostos(){
    	Collection<Posto> data = postoService.findAll();
    	return new ResponseEntity<>(data, HttpStatus.OK);
	}
			
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="/posto/{id}")
    @ApiOperation(value = "Exibição de um posto")
    public ResponseEntity<Posto> getPosto(@PathVariable Long id){
    	Posto data = this.postoService.findById(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/posto")
    @ApiOperation(value = "Cadastro de um posto")
    public ResponseEntity<Posto> cadastroPosto(@RequestBody Posto posto){
    	if (posto.getUsername()!= null && posto.getPassword()!= null){
	    	Posto data = this.userService.save(posto);
			return new ResponseEntity<>(data, HttpStatus.CREATED);
    	}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE, value="/posto/{id}")
    @ApiOperation(value = "Exclusão de um posto")
    public void	deletarPosto(@RequestBody Posto posto){
    	postoService.delete(posto);
	}
    
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.PUT, value="/posto/{id}")
    @ApiOperation(value = "Atualização dos dados de um posto")
    public ResponseEntity<Posto> updateCliente(@RequestBody Posto posto){
    	Posto data = this.userService.save(posto);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
