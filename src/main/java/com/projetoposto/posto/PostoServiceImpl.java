package com.projetoposto.posto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "postoService")
public class PostoServiceImpl implements PostoService {
	
    @Autowired
	private PostoRepository userDao;

	public List<Posto> findAll() {
		List<Posto> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	public void delete(Posto posto) {
		userDao.delete(posto);
	}

	@Override
	public Optional<Posto> findById(Long id) {
		return userDao.findById(id);
	}


	@Override
	public Posto findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
