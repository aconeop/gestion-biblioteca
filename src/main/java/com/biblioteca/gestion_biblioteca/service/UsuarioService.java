package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> listarUsuarios();
    UsuarioDto crearUsuario(UsuarioDto dto);
    void actualizarUsuario(Long id, UsuarioDto dto); // tu controller espera void
    void eliminarUsuario(Long id);
}
