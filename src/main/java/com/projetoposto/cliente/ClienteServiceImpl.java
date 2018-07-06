package com.projetoposto.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
//	@Override
//	public Cliente findByUsername(String username) {
//		return clienteRepository.findByUsername(username);
//	}

	@Override
	public Cliente save(Cliente user) {
		return clienteRepository.save(user);
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> list = new ArrayList<>();
		clienteRepository.findAll().iterator().forEachRemaining(list::add);
		return list;

	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);

	}
	
	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
