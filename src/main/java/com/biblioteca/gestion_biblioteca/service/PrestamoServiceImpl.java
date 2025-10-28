package com.biblioteca.gestion_biblioteca.service.impl;

import com.biblioteca.gestion_biblioteca.dto.PrestamoDto;
import com.biblioteca.gestion_biblioteca.dto.UsuarioDto;
import com.biblioteca.gestion_biblioteca.model.Libro;
import com.biblioteca.gestion_biblioteca.model.Prestamo;
import com.biblioteca.gestion_biblioteca.model.Usuario;
import com.biblioteca.gestion_biblioteca.repository.LibroRepository;
import com.biblioteca.gestion_biblioteca.repository.PrestamoRepository;
import com.biblioteca.gestion_biblioteca.repository.UsuarioRepository;
import com.biblioteca.gestion_biblioteca.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LibroRepository libroRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository,
                               UsuarioRepository usuarioRepository,
                               LibroRepository libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;
    }

    @Override
    public List<PrestamoDto> listarPrestamos() {
        return prestamoRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public PrestamoDto guardarPrestamo(PrestamoDto dto) {
        // Validar existencia de usuario y libro
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libro libro = libroRepository.findById(dto.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // Validaciones de negocio
        // 1) no más de 5 préstamos activos (Consulta directa a BD)
        long activos = prestamoRepository.countByUsuarioIdAndEstado(usuario.getId(), "activo");
        if (activos >= 5) {
            throw new RuntimeException("El usuario ya tiene 5 préstamos activos.");
        }

        // 2) si tiene atrasados, no puede pedir otro (Consulta directa a BD)
        boolean tieneAtrasado = prestamoRepository.existsByUsuarioIdAndEstado(usuario.getId(), "atrasado");
        if (tieneAtrasado) {
            throw new RuntimeException("El usuario tiene préstamos atrasados, no puede pedir más.");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setId(dto.getId());
        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setFechaDevolucion(dto.getFechaDevolucion());
        prestamo.setEstado(dto.getEstado());

        Prestamo guardado = prestamoRepository.save(prestamo);
        return toDto(guardado);
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDto> listarUsuariosMorosos() {
        //  consulta optimizada que trae solo los usuarios únicos
        List<Usuario> morosos = prestamoRepository.findDistinctUsuariosByEstado("atrasado");

        //  mapear la lista de Usuario a UsuarioDto
        return morosos.stream()
                .map(u -> new UsuarioDto(u.getId(), u.getNombre(),
                        u.getCorreo(), u.getTipo(), u.getEstado()))
                .toList();
    }

    private PrestamoDto toDto(Prestamo prestamo) {
        return new PrestamoDto(
                prestamo.getId(),
                prestamo.getUsuario().getId(),
                prestamo.getLibro().getId(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion(),
                prestamo.getEstado()
        );
    }
}
