package com.biblioteca.gestion_biblioteca;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestión Biblioteca API",
                version = "v1",
                description = "API para gestionar usuarios, libros y préstamos del sistema de biblioteca"
        ),
        servers = {
                @Server(url = "http://localhost:8085", description = "Servidor de desarrollo (Dev)")
        }
)
@SpringBootApplication
public class GestionBibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBibliotecaApplication.class, args);
    }
}
