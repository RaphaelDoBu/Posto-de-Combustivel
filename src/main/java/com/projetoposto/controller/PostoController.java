package com.projetoposto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoposto.repository.CombustivelRepository;
import com.projetoposto.repository.PostoRepository;
import com.projetoposto.model.Cliente;
import com.projetoposto.model.Posto;

@RestController
@RequestMapping("/posto")
public class PostoController {
	
	@Autowired
	private PostoRepository postoRepository;
	
	@Autowired
	private CombustivelRepository combustivelRepository;
	
	@GetMapping("/postos")
	public List<Posto> getPostos(){
		return postoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Posto> getPosto(@PathVariable Long id){
		return postoRepository.findById(id);
	}
	
	@PostMapping
	public Posto cadastroPosto(Posto posto){
		return postoRepository.save(posto);
	}
	
	@DeleteMapping
	public void	deletarPosto(Posto posto){
		postoRepository.delete(posto);
	}
	

}
