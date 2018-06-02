package com.projetoposto.security;

import java.util.Collection;
import java.util.Collections;

import javax.sql.DataSource;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired    
    private JwtAuthenticationProvider authenticationProvider;
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
    @Bean
    public AuthenticationManager authenticationManager(){
    	return new ProviderManager(Collections.singletonList(authenticationProvider));
    }
    
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().antMatchers("**/rest/**").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();

    }
	  
//	@Autowired
//	private ImplementsUserDetailsService userDetailsService;
//
//	@Autowired
//	public WebSecurityConfig(ImplementsUserDetailsService userDetailsService){
//		this.userDetailsService= userDetailsService;
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.cors().and().csrf().disable().authorizeRequests()
//			.antMatchers(HttpMethod.GET, "/").permitAll()
//			.antMatchers(HttpMethod.POST, "/login").permitAll()
//				.antMatchers("/postos").hasAnyRole("USER,ADMIN")
//				.antMatchers("/posto").hasRole("ADMIN")
//				.and()
//				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
//				.addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService));
//	}
//
//	 @Override
//	    protected void configure(AuthenticationManagerBuilder auth)
//	      throws Exception {
//	  
//	        auth.inMemoryAuthentication()
//	          .withUser("temporary").password("temporary").roles("ADMIN")
//	          .and()
//	          .withUser("user").password("userPass").roles("USER");
//	    }

	 
}