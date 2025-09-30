package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.model.Prestamo;
import com.biblioteca.gestion_biblioteca.model.Usuario;
import com.biblioteca.gestion_biblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        // Validar que el préstamo tenga un usuario
        if (prestamo.getUsuario() == null || prestamo.getUsuario().getId() == null) {
            throw new RuntimeException("El préstamo debe tener un usuario válido.");
        }

        // Obtener todos los préstamos del usuario
        List<Prestamo> prestamosUsuario = prestamoRepository.findAll().stream()
                .filter(p -> p.getUsuario().getId().equals(prestamo.getUsuario().getId()))
                .toList();

        // Regla 1: no más de 5 préstamos activos
        long activos = prestamosUsuario.stream()
                .filter(p -> "activo".equalsIgnoreCase(p.getEstado()))
                .count();
        if (activos >= 5) {
            throw new RuntimeException("El usuario ya tiene 5 préstamos activos.");
        }

        // Regla 2: si tiene atrasados, no puede pedir otro
        boolean tieneAtrasado = prestamosUsuario.stream()
                .anyMatch(p -> "atrasado".equalsIgnoreCase(p.getEstado()));
        if (tieneAtrasado) {
            throw new RuntimeException("El usuario tiene préstamos atrasados, no puede pedir más.");
        }

        // Si pasa las validaciones, lo guardamos
        return prestamoRepository.save(prestamo);
    }

    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    public List<Usuario> listarUsuariosMorosos() {
        return prestamoRepository.findAll().stream()
                .filter(p -> "atrasado".equalsIgnoreCase(p.getEstado()))
                .map(Prestamo::getUsuario)
                .distinct()
                .collect(Collectors.toList());
    }
}

