package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.dto.PrestamoDto;
import com.biblioteca.gestion_biblioteca.dto.UsuarioDto;

import java.util.List;

public interface PrestamoService {
    List<PrestamoDto> listarPrestamos();
    PrestamoDto guardarPrestamo(PrestamoDto prestamoDto);
    void eliminarPrestamo(Long id);
    List<UsuarioDto> listarUsuariosMorosos();
}
