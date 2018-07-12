package com.projetoposto.posto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "postoService")
public class PostoServiceImpl implements PostoService {
	
    @Autowired
	private PostoRepository postoRepository;

	public List<Posto> findAll() {
		List<Posto> list = new ArrayList<>();
		postoRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	public void delete(Posto posto) {
		postoRepository.delete(posto);
	}

	@Override
	public Posto findById(Long id) {
		return postoRepository.findById(id).get();
	}


	@Override
	public Posto findByUsername(String username) {
		return postoRepository.findByUsername(username);
	}

}
