package com.projetoposto.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "https://de-olho-nos-postos.herokuapp.com")
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User save(User user);
}
