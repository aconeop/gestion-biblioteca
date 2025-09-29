package com.biblioteca.gestion_biblioteca.repository;

import com.biblioteca.gestion_biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Aquí puedes definir métodos personalizados, por ejemplo:
    // List<Libro> findByAutor(String autor);
}
