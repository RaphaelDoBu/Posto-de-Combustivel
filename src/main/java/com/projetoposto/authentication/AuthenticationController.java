package com.projetoposto.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.projetoposto.authentication.AuthToken;
import com.projetoposto.authentication.LoginUser;
import com.projetoposto.config.JwtTokenUtil;
import com.projetoposto.user.User;
import com.projetoposto.user.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "https://de-olho-nos-postos.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired(required=true)
    private UserService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    @ApiOperation(value = "Geração do token para autenticação de usuário(cliente ou posto)")
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	
    	System.out.println(loginUser.getUsername());
    	System.out.println(loginUser.getPassword());
    	
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findByUsername(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token));
    }
    
    @RequestMapping(value = "/usuario-autenticado", method = RequestMethod.POST)
    @ApiOperation(value = "Retorno do usuário(cliente ou posto) autenticado no momento")
    public User buscaAutenticado(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	
    	System.out.println(loginUser.getUsername());
    	System.out.println(loginUser.getPassword());
    	
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findByUsername(loginUser.getUsername());
        return user;
    }
    
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}