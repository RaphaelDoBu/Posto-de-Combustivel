package com.projetoposto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.projetoposto.repository.CombustivelRepository;
import com.projetoposto.repository.PostoRepository;
import com.projetoposto.model.Cliente;
import com.projetoposto.model.Posto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PostoController {
	
	@Autowired
	private PostoRepository postoRepository;

	
	@Autowired
	private CombustivelRepository combustivelRepository;
	
    @RequestMapping(method=RequestMethod.GET, value="/postos")
	public List<Posto> getPostos(){
		return postoRepository.findAll();
	}
								
    @RequestMapping(method=RequestMethod.GET, value="/posto/{id}")
	public Optional<Posto> getPosto(@PathVariable Long id){
		return postoRepository.findById(id);
	}
	
    @RequestMapping(method=RequestMethod.POST, value="/posto")
	public Posto cadastroPosto(@RequestBody Posto posto){
    	System.out.println(posto.getNome());
		return postoRepository.save(posto);
	}
	
    @RequestMapping(method=RequestMethod.DELETE, value="/posto/{id}")
	public void	deletarPosto(Posto posto){
		postoRepository.delete(posto);
	}
    
    @RequestMapping(method=RequestMethod.PUT, value="/posto/{id}")
	public Posto updateCliente(Posto posto){
		return postoRepository.save(posto);
	}
	

    public PostoController(PostoRepository applicationUserRepository) {
        this.postoRepository = applicationUserRepository;
    }

//    @PostMapping("/users/sign-up")
//    public void signUp(@RequestBody Posto user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        postoRepository.save(user);
//    }

}
