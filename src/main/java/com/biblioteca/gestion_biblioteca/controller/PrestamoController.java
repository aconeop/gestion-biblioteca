package com.biblioteca.gestion_biblioteca.controller;

import com.biblioteca.gestion_biblioteca.model.Prestamo;
import com.biblioteca.gestion_biblioteca.model.Usuario;
import com.biblioteca.gestion_biblioteca.service.PrestamoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
    }

    @GetMapping("/morosos")
    public List<Usuario> listarMorosos() {
        return prestamoService.listarUsuariosMorosos();
    }

    @PostMapping
    public ResponseEntity<?> crearPrestamo(@RequestBody Prestamo prestamo) {
        try {
            Prestamo nuevo = prestamoService.guardarPrestamo(prestamo);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

