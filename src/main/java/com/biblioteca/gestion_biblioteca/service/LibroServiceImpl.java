package com.biblioteca.gestion_biblioteca.service.impl;

import com.biblioteca.gestion_biblioteca.dto.LibroDto;
import com.biblioteca.gestion_biblioteca.model.Libro;
import com.biblioteca.gestion_biblioteca.repository.LibroRepository;
import com.biblioteca.gestion_biblioteca.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<LibroDto> listarLibros() {
        return libroRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public LibroDto guardarLibro(LibroDto libroDto) {
        Libro libro = toEntity(libroDto);
        Libro guardado = libroRepository.save(libro);
        return toDto(guardado);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    // Convertir entidad → DTO
    private LibroDto toDto(Libro libro) {
        return new LibroDto(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion(),
                libro.getCategoria(),
                libro.getEstado()
        );
    }

    // Convertir DTO → entidad
    private Libro toEntity(LibroDto dto) {
        Libro libro = new Libro();
        libro.setId(dto.getId());
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setAnioPublicacion(
                dto.getAnioPublicacion() == null ? 0 : dto.getAnioPublicacion()
        );
        libro.setCategoria(dto.getCategoria());
        libro.setEstado(dto.getEstado());
        return libro;
    }
}
