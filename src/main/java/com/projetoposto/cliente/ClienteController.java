package com.projetoposto.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.cliente.ClienteRepository;

import ch.qos.logback.core.net.server.Client;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
																																																																																																													
    @RequestMapping(method=RequestMethod.GET, value="/clientes")
	public List<Cliente> getClientes(){
        System.out.println("Executando a lógica com Spring MVC");
		return clienteService.findAll();
	}
	
    @RequestMapping(method=RequestMethod.GET, value="/cliente/{id}")
	public Optional<Cliente> getPosto(@PathVariable("id") Long id){
		return clienteService.findById(id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/cliente")
	public Cliente cadastroPosto(@RequestBody Cliente cliente){
		return clienteService.save(cliente);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/cliente/{id}")
    public void	deletarPosto(Cliente cliente){
		clienteService.delete(cliente);
	}
	
    @RequestMapping(method=RequestMethod.PUT, value="/cliente/{id}")
	public Cliente updateCliente(Cliente cliente){
		return clienteService.save(cliente);
	}

}
