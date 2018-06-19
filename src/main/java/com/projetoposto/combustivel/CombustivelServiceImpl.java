package com.projetoposto.combustivel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoposto.cliente.Cliente;

@Service(value = "combustivelService")
public class CombustivelServiceImpl implements CombustivelService{

	@Autowired
	private CombustivelRepository combustivelRepository;
	
//	@Override
//	public Combustivel findByUsername(String username) {
//		return combustivelRepository.findByUsername(username);
//
//	}

	@Override
	public Combustivel save(Combustivel combustivel) {
		return combustivelRepository.save(combustivel);

	}

	@Override
	public List<Combustivel> findAll() {
		List<Combustivel> list = new ArrayList<>();
		combustivelRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Optional<Combustivel> findById(Long id) {
		return combustivelRepository.findById(id);

	}

	@Override
	public void delete(Combustivel combustivel) {
		combustivelRepository.delete(combustivel);
		
	}

}
