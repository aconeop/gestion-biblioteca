package com.biblioteca.gestion_biblioteca.repository;

import com.biblioteca.gestion_biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Si quieres filtrar por estado sin paginación:
    List<Usuario> findByEstadoIgnoreCase(String estado);

    // Si más adelante agregas paginación, podrás añadir:
    // Page<Usuario> findByEstadoIgnoreCase(String estado, Pageable pageable);
}
