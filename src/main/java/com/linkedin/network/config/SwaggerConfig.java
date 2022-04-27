package com.linkedin.network.config;

import org.springdoc.core.*;
import org.springframework.context.annotation.*;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.security.*;

/**
 * The Class SwaggerConfig.
 */

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI().components(
				new Components().addSecuritySchemes("OAuth", new SecurityScheme().type(SecurityScheme.Type.APIKEY)
						.scheme("bearer").bearerFormat("jwt").in(SecurityScheme.In.HEADER).name("Authorization")));
	}

	@Bean
	public GroupedOpenApi authorisedApi() {
		return GroupedOpenApi.builder().group("ProfessionalNetworking").pathsToMatch("/**").build();
	}

}