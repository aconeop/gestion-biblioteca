package com.biblioteca.gestion_biblioteca.repository;

import com.biblioteca.gestion_biblioteca.model.Prestamo;
import com.biblioteca.gestion_biblioteca.model.Usuario; // <-- IMPORTE NUEVO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // <-- IMPORTE NUEVO
import org.springframework.stereotype.Repository;

import java.util.List; // <-- IMPORTE NUEVO

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // --- AGREGA ESTOS 3 MÉTODOS AQUÍ DENTRO ---

    /**
     * Cuenta préstamos por usuario y estado (en la BD).
     */
    long countByUsuarioIdAndEstado(Long usuarioId, String estado);

    /**
     * Verifica si existe un préstamo por usuario y estado (en la BD).
     */
    boolean existsByUsuarioIdAndEstado(Long usuarioId, String estado);

    /**
     * Busca los usuarios únicos que tienen préstamos con un estado específico (en la BD).
     */
    @Query("SELECT DISTINCT p.usuario FROM Prestamo p WHERE p.estado = ?1")
    List<Usuario> findDistinctUsuariosByEstado(String estado);

}
