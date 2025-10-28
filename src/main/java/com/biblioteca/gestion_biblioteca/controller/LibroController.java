package com.biblioteca.gestion_biblioteca.controller;

import com.biblioteca.gestion_biblioteca.dto.LibroDto;
import com.biblioteca.gestion_biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@Tag(name = "Libros", description = "Operaciones CRUD de libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    @Operation(summary = "Listar libros")
    public List<LibroDto> listarLibros() {
        return libroService.listarLibros();
    }

    @PostMapping
    @Operation(summary = "Crear libro")
    public LibroDto agregarLibro(@RequestBody LibroDto libroDto) {
        return libroService.guardarLibro(libroDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar libro por ID")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}
