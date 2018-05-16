package com.projetoposto.ws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoposto.ws.model.Cliente;
import com.projetoposto.ws.model.Posto;
import com.projetoposto.ws.repository.ClienteRepository;
import com.projetoposto.ws.repository.PostoRepository;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping(path={"/{id}"})
	public Optional<Cliente> getPosto(@PathVariable("id") Long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping
	public Cliente cadastroPosto(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void	deletarPosto(Cliente cliente){
		clienteRepository.delete(cliente);
	}
	
	@PutMapping
	public Cliente updateCliente(Cliente cliente){
		return clienteRepository.save(cliente);
	}

}
