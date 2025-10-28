package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.dto.LibroDto;

import java.util.List;

public interface LibroService {
    List<LibroDto> listarLibros();
    LibroDto guardarLibro(LibroDto libroDto);
    void eliminarLibro(Long id);
}
