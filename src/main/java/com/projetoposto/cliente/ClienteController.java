package com.projetoposto.cliente;

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

import com.projetoposto.cliente.Cliente;
import com.projetoposto.user.UserService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private UserService userService;
				
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="/clientes")
    @ApiOperation(value = "Listagem de todos os clientes")
	public ResponseEntity<Collection<Cliente>> getClientes(){
    	Collection<Cliente> data = this.clienteService.findAll();
    	return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET, value="/cliente/{id}")
    @ApiOperation(value = "Exibir um cliente")
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id){
    	Cliente data = this.clienteService.findById(id).get();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/cliente")
    @ApiOperation(value = "Criação de um cliente")
	public ResponseEntity<Cliente> cadastroCliente(@RequestBody Cliente cliente){
		if (cliente.getUsername()!= null && cliente.getPassword()!= null){
			Cliente data = this.userService.save(cliente);
			return new ResponseEntity<>(data, HttpStatus.CREATED);
    	}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE, value="/cliente/{id}")
    @ApiOperation(value = "Remove um cliente")
    public void	deletarCliente(@RequestBody Cliente cliente){
		clienteService.delete(cliente);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.PUT, value="/cliente/{id}")
    @ApiOperation(value = "Atualização dos dados de um cliente")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
    	Cliente data = this.userService.save(cliente);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
