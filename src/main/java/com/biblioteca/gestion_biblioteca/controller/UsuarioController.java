package com.biblioteca.gestion_biblioteca.controller;

import com.biblioteca.gestion_biblioteca.dto.UsuarioDto;
import com.biblioteca.gestion_biblioteca.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Listar usuarios")
    public List<UsuarioDto> listar() {
        // Si luego agregas paginación, cambia la firma a Page<UsuarioDto> y usa params
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    @Operation(
            summary = "Crear usuario",
            description = "Crea un usuario nuevo. No envíe 'id' en el body.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Creado",
                            content = @Content(schema = @Schema(implementation = UsuarioDto.class))),
                    @ApiResponse(responseCode = "400", description = "Validación fallida")
            }
    )
    public ResponseEntity<UsuarioDto> crear(@Valid @RequestBody UsuarioDto dto,
                                            UriComponentsBuilder uriBuilder) {
        dto.setId(null); // Forzamos INSERT
        UsuarioDto creado = usuarioService.crearUsuario(dto);
        URI location = uriBuilder.path("/api/v1/usuarios/{id}")
                .buildAndExpand(creado.getId())
                .toUri();
        return ResponseEntity.created(location).body(creado); // 201 + Location
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario")
    public ResponseEntity<Void> actualizar(@PathVariable Long id,
                                           @Valid @RequestBody UsuarioDto dto) {
        usuarioService.actualizarUsuario(id, dto);
        return ResponseEntity.noContent().build(); // 204
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
