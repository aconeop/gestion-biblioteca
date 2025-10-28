package com.biblioteca.gestion_biblioteca.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi usuariosApi() {
        return GroupedOpenApi.builder()
                .group("usuarios")
                // Soportar /api/usuarios y /api/v1/usuarios
                .pathsToMatch(
                        "/api/usuarios",
                        "/api/usuarios/**",
                        "/api/v1/usuarios",
                        "/api/v1/usuarios/**"
                )
                .build();
    }

    @Bean
    public GroupedOpenApi librosApi() {
        return GroupedOpenApi.builder()
                .group("libros")
                .pathsToMatch(
                        "/api/libros",
                        "/api/libros/**",
                        "/api/v1/libros",
                        "/api/v1/libros/**"
                )
                .build();
    }

    @Bean
    public GroupedOpenApi prestamosApi() {
        return GroupedOpenApi.builder()
                .group("prestamos")
                .pathsToMatch(
                        "/api/prestamos",
                        "/api/prestamos/**",
                        "/api/v1/prestamos",
                        "/api/v1/prestamos/**"
                )
                .build();
    }
}
