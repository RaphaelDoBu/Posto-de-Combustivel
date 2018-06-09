package com.projetoposto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoposto.model.Posto;
import com.projetoposto.repository.PostoRepository;

@Service(value = "postoService")
public class PostoServiceImpl implements UserDetailsService, PostoService {
	
    @Autowired
	private PostoRepository userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Posto user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

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
    public Posto save(Posto user) {
    	
		Posto newUser = new Posto();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setCnpj(user.getCnpj());
		newUser.setEndereco(newUser.getEndereco());
        return userDao.save(newUser);
	}

	@Override
	public Posto findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
