package com.projetoposto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoposto.repository.ClienteRepository;
import com.projetoposto.repository.PostoRepository;
import com.projetoposto.model.Cliente;
import com.projetoposto.model.Posto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
																																																																																																													
    @RequestMapping(method=RequestMethod.GET, value="/clientes")
	public List<Cliente> getClientes(){
        System.out.println("Executando a lógica com Spring MVC");
		return clienteRepository.findAll();
	}
	
    @RequestMapping(method=RequestMethod.GET, value="/cliente/{id}")
	public Optional<Cliente> getPosto(@PathVariable("id") Long id){
		return clienteRepository.findById(id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/cliente")
	public Cliente cadastroPosto(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/cliente/{id}")
    public void	deletarPosto(Cliente cliente){
		clienteRepository.delete(cliente);
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="/cliente/{id}")
	public Cliente updateCliente(Cliente cliente){
		return clienteRepository.save(cliente);
	}

}
