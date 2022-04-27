package com.linkedin.network.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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