package com.projetoposto.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.cliente.ClienteRepository;
import com.projetoposto.posto.Posto;
import com.projetoposto.posto.PostoRepository;


@Service(value="userService")
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository userDao;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PostoRepository postoRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	  
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
		
	public Cliente save(Cliente user){
		Cliente newUser = new Cliente();
		System.out.println("ENTROU NO SERVICE como cliente");

		newUser.setNome(user.getNome());
		newUser.setEmail(user.getEmail());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		    
		System.out.println("AQUI VAI NO NEWUSER CLIENTE");

		System.out.println(newUser.getNome());
		System.out.println(newUser.getPassword());
		
		return clienteRepository.save(newUser);
	}
		
	public Posto save(Posto user){

	    System.out.println("ENTROU NO SERVICE como posto");
		
		Posto newUser = new Posto();
		newUser.setNome(user.getNome());
		newUser.setEndereco(user.getEndereco());
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setHorarioAberto(user.getHorarioAberto());
		newUser.setHorarioFechado(user.getHorarioFechado());
		newUser.setCnpj(user.getCnpj());
			
			
		System.out.println("AQUI VAI NO NEWUSER POSTO");

		System.out.println(newUser.getNome());
		System.out.println(newUser.getPassword());
		return postoRepository.save(newUser);
	}
		
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
