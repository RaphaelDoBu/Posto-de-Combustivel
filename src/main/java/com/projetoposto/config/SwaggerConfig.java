package com.projetoposto.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * (non-Javadoc)
 * 
 * @see https://github.com/springfox/springfox/issues/2194#issuecomment-364392707
 * @author Jose Raphael
 */
@Configuration
@ComponentScan(basePackages = {"com.projetoposto"})
@EnableSwagger2
public class SwaggerConfig {

	@Value("${security.oauth2.client.clientId}")
	private String clientId;

	@Value("${security.oauth2.client.clientSecret}")
	private String clientSecret;


	public static final Contact DEFAULT_CONTACT = new Contact(
			"Jose Raphael Santos do Bu", 
			"https://github.com/RaphaelDoBu",
			"jose.bu@ccc.ufcg.edu.br" );

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
			.title("De Olho nos Postos - Server - Swagger API")
			.description("De Olho nos Postos - Server - Swagger API")
			.version("0.0.1")
			.termsOfServiceUrl("http://www.termsofservice.url")
			.contact(DEFAULT_CONTACT)
			.license("License")
			.licenseUrl("http://www.license.url")
			.build();

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	private static final ApiKey apiKey() {
        return new ApiKey("AUTHORIZATION", "api_key", "header");
    }

	private static final List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("AUTHORIZATION", authorizationScopes));
    }

	private static final SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.ignoredParameterTypes(ApiIgnore.class)
				.select()
					.apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any())
					.build()
				.pathMapping("/")
				.securitySchemes(Arrays.asList(apiKey()))
				.securityContexts(Arrays.asList(securityContext()))
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.apiInfo(DEFAULT_API_INFO);
	}
	
	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
				.clientId(clientId)
				.clientSecret(clientSecret)
				.realm("realm")
				.appName("opi-server")
				.scopeSeparator(",")
				.additionalQueryStringParams(null)
				.useBasicAuthenticationWithAccessCodeGrant(false)
				.build();
	}


}