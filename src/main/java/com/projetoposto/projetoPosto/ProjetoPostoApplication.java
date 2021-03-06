package com.projetoposto.projetoPosto;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@EntityScan({"com.projetoposto"})
@EnableJpaRepositories({"com.projetoposto"})
@ComponentScan(basePackages = {"com.projetoposto"})
@SpringBootApplication(scanBasePackages = "com.projetoposto")
public class ProjetoPostoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPostoApplication.class, args);
		
	}
	
	 @Bean
	 @SuppressWarnings("unchecked")
	 public FilterRegistrationBean simpleCorsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.setAllowedOrigins(Collections.singletonList("https://de-olho-nos-postos.herokuapp.com"));
	        config.setAllowedMethods(Collections.singletonList("*"));
	        config.setAllowedHeaders(Collections.singletonList("*"));
	        source.registerCorsConfiguration("/**", config);
	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	        return bean;
	}
}
