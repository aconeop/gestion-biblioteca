package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.dto.UsuarioDto;
import com.biblioteca.gestion_biblioteca.model.Usuario;
import com.biblioteca.gestion_biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional
    public UsuarioDto crearUsuario(UsuarioDto dto) {
        Usuario u = toEntity(dto);
        u.setId(null); // fuerza INSERT
        Usuario guardado = usuarioRepository.save(u);
        return toDto(guardado);
    }

    @Override
    @Transactional
    public void actualizarUsuario(Long id, UsuarioDto dto) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + id));

        // copiar campos
        u.setNombre(dto.getNombre());
        u.setCorreo(dto.getCorreo());
        u.setTipo(dto.getTipo());
        u.setEstado(dto.getEstado());

        usuarioRepository.save(u); // persistimos cambios
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // ====== Mapeos ======
    private UsuarioDto toDto(Usuario u) {
        // Usa el no-args y setters (o el all-args si prefieres)
        UsuarioDto dto = new UsuarioDto();
        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setCorreo(u.getCorreo());
        dto.setTipo(u.getTipo());
        dto.setEstado(u.getEstado());
        return dto;
    }

    private Usuario toEntity(UsuarioDto dto) {
        Usuario u = new Usuario();
        u.setId(dto.getId());
        u.setNombre(dto.getNombre());
        u.setCorreo(dto.getCorreo());
        u.setTipo(dto.getTipo());
        u.setEstado(dto.getEstado());
        return u;
    }
}
