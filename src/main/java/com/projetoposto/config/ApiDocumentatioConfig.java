package com.projetoposto.config;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;


@SwaggerDefinition(
		info = @Info(
				title = "De Olho nos Postos - Server - Swagger API", 
				description = "De Olho nos Postos - Server - Swagger API", 
				version = "0.0.1", 
				contact = @Contact(
						name = "Jose Raphael Santos do Bu", 
						email = "jose.bu@ccc.ufcg.edu.br", 
						url = "https://github.com/RaphaelDoBu"
				), 
				license = @License(
						name = "License", 
						url = "http://www.license.url"
				)
		),
		consumes = { "application/json", "application/xml" },
		produces = { "application/json", "application/xml" },
		schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
		externalDocs = @ExternalDocs(value = "Read This", url = "https://github.com/RaphaelDoBu/Posto-de-Combustivel")
)
public class ApiDocumentatioConfig {

}