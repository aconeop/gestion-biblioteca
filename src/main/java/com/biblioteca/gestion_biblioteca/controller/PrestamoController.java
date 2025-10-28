package com.biblioteca.gestion_biblioteca.controller;

import com.biblioteca.gestion_biblioteca.dto.PrestamoDto;
import com.biblioteca.gestion_biblioteca.dto.UsuarioDto;
import com.biblioteca.gestion_biblioteca.service.PrestamoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@Tag(name = "Préstamos", description = "Operaciones CRUD de préstamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    @Operation(summary = "Listar préstamos")
    public List<PrestamoDto> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    @PostMapping
    @Operation(summary = "Crear préstamo")
    public ResponseEntity<?> crearPrestamo(@RequestBody PrestamoDto prestamoDto) {
        try {
            PrestamoDto nuevo = prestamoService.guardarPrestamo(prestamoDto);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar préstamo por ID")
    public void eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
    }

    @GetMapping("/morosos")
    @Operation(summary = "Listar usuarios con préstamos atrasados")
    public List<UsuarioDto> listarMorosos() {
        return prestamoService.listarUsuariosMorosos();
    }
}
