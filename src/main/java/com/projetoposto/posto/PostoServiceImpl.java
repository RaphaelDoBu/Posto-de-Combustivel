package com.projetoposto.posto;

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
		
		System.out.println(user.getNome());
		System.out.println(user.getEndereco());
		System.out.println(user.getPassword());
		System.out.println(user.getHorarioAberto());

		
		
		Posto newUser = new Posto();
		newUser.setNome(user.getNome());
		newUser.setEndereco(user.getEndereco());
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    newUser.setHorarioAberto(user.getHorarioAberto());
	    newUser.setHorarioFechado(user.getHorarioFechado());
		newUser.setCnpj(user.getCnpj());
		
		
		System.out.println("AQUI VAI NO NEWUSER");

		System.out.println(newUser.getNome());
		System.out.println(newUser.getPassword());

        return userDao.save(newUser);
	}

	@Override
	public Posto findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
