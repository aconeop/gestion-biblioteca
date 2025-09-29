package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.model.Usuario;
import com.biblioteca.gestion_biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() { return usuarioRepository.findAll(); }
    public Usuario guardarUsuario(Usuario usuario) { return usuarioRepository.save(usuario); }
    public void eliminarUsuario(Long id) { usuarioRepository.deleteById(id); }
}
