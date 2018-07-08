package com.projetoposto.combustivel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		Posto posto = postoRepository.findById(idPosto).get();
		Combustivel novoCombustivel = new Combustivel();
		novoCombustivel.setNome(combustivel.getNome());
		novoCombustivel.setPreco(combustivel.getPreco());
		    	
		posto.getListaDeCombustiveis().add(novoCombustivel);

		novoCombustivel.setPosto(posto);
		
    	Combustivel combustivelSalvo = combustivelRepository.save(novoCombustivel);
    	
		return combustivelSalvo;

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
		Posto posto = postoRepository.findById(idPosto).get();
		Combustivel combustivel = combustivelRepository.findById(id).get();
		
		Combustivel combustivelEncontrado = posto.buscarCombustivel(combustivel, posto.getListaDeCombustiveis());
		
		return combustivelEncontrado;

	}

	@Override
	public void delete(Long idPosto, Long idCombustivel) {
		List<Combustivel> combustiveis = findAll(idPosto);
		Combustivel c= combustivelRepository.findById(idCombustivel).get();
		
		combustiveis.remove(c);
		combustivelRepository.delete(c);
		
	}


}
