package com.projetoposto.combustivel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.posto.Posto;
import com.projetoposto.posto.PostoRepository;

@Service(value = "combustivelService")
public class CombustivelServiceImpl implements CombustivelService{

	@Autowired
	private CombustivelRepository combustivelRepository;
	
	@Autowired
	private PostoRepository postoRepository;
	

	@Override
	public Combustivel save(Long idPosto,Combustivel combustivel) {
		System.out.println("Entrou no service" + combustivel.getNome());
		System.out.println("id do posto " + idPosto);

		Posto posto = postoRepository.findById(idPosto).get();
		Combustivel novoCombustivel = new Combustivel();
		novoCombustivel.setNome(combustivel.getNome());
		novoCombustivel.setPreco(combustivel.getPreco());
		System.out.println("nome do posto " + posto.getUsername());
    	posto.getListaDeCombustiveis().add(novoCombustivel);

		novoCombustivel.setPosto(posto);
		
		
    	Combustivel combustivelSalvo = combustivelRepository.save(novoCombustivel);
    	
		return novoCombustivel;

	}

	@Override
	public List<Combustivel> findAll(Long idPosto) {
		List<Combustivel> list = new ArrayList<>();
		Posto posto = postoRepository.findById(idPosto).get();
		posto.getListaDeCombustiveis().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Combustivel findById(Long idPosto, Long id) {
		Combustivel combustivel = combustivelRepository.findById(id).get();
		
		return combustivel;

	}

	@Override
	public void delete(Long idPosto, Long id) {
		List<Combustivel> combustiveis = findAll(idPosto);
		Combustivel c= combustivelRepository.findById(id).get();
		
		combustiveis.remove(c);
		combustivelRepository.deleteById(id);
		
	}


}
